/*
 * Developer : Hitesh Sethi
 * This is main class or heart of this project
 * This class is managing the DB connecions and calling threads which inturn send mails
 */
package massmailer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.mail.MessagingException;
import massmailer.*;

public class Massmailer {
   
   static int countRows(Connection con)
    {
       //This function is made to return the num of unprocessed message is DB
        int count = 0;
        try{
            Statement stmt = con.createStatement();  
            ResultSet rs = stmt.executeQuery("select count(*) from EmailQueue where IS_PROCESSED = 'UNPROCESSED'");
            while (rs.next()) {
                count = rs.getInt(1);
            }
        }
        catch(Exception e)
        {
            System.out.println("Problem"+e);
        }
        return count;
    }
   public static void main(String[] args) throws MessagingException {
      // Recipient's email ID needs to be mentioned.
        try{
         new createDB().makeDB(); //making or/and checking if table and row exists
           }
           catch(Exception e)
           {
               System.out.println("Problem while creating db "+e);
           }
      
      int count_sent=0,count_tried=0;
      ArrayList<Mailthread> thread_list = new ArrayList<Mailthread>(); //for storing threads made
      try{
      Connection con = DriverManager.getConnection(createDB.JDBC_URL); //making connection to the database
      long startTime = System.currentTimeMillis(); //starting the timer for time calculation
      while(countRows(con)>0) //will run till unprocessed mails are there in DB
      {
              if(con.isClosed())
              {
                  //reconnecting if DB connection is lost
                  con = DriverManager.getConnection(createDB.JDBC_URL);
              }
              Statement stmt = con.createStatement();
              con.setAutoCommit(false); //for making the two queries a part of single transaction
              ResultSet rs = stmt.executeQuery("select * from EmailQueue where IS_PROCESSED = 'UNPROCESSED'  FETCH FIRST ROW ONLY");
              //fetching the first unprocessed row from DB
              if(rs.next()){
                 
                  int id_mes=rs.getInt("id");
                  String from_email_address = rs.getString("from_email_address");
                  String to_email_address = rs.getString("to_email_address");
                  String subject = rs.getString("subject");
                  String body = rs.getString("body");
                  int row_affected = stmt.executeUpdate("update EmailQueue SET IS_PROCESSED = 'PENDING' where is_processed='UNPROCESSED' and id = "+id_mes);
                  con.commit(); //commiting the changes to DB transaction
                  con.setAutoCommit(true);
                  if(row_affected==0)
                  {
                    continue;
                    //some other process on another server already processed this row so pick another.
					//main purpose of doing this was to stop another process(not thread) from accessing the same row
                  }
                  Mailthread thread; //creating a thread class
                  //each message is sent in 1 thread.
                  thread = new Mailthread(id_mes,to_email_address,from_email_address,subject,body); //initializing it.
                  thread.start(); //starting this thread now.
                  thread_list.add(thread); //adding this thread to the thread_list arraylist to retreive info later
             }
      }
      for(Mailthread thread : thread_list)
      {
          thread.join(); //waiting for the thread to finish
          String ret_value = thread.getStatus(); //getting the status of the mail processes from the thread class implemented
          String[] id_status = ret_value.split(","); //the return value is of the form : S,1 or T,1 where S or T are states and 1 is id
          String processed_status = id_status[0]; // S or T
          int id_mes = Integer.parseInt(id_status[1]); // id of the mail
          if(processed_status.compareTo("T") == 0)
          {
              processed_status = "TRIED";
              count_tried++; //incrementing count of tried mails
          }
          else
          {
              processed_status = "SENT"; 
              count_sent++; //incrementing count of successfull mails
          }
          if(con.isClosed())
          {
              // reconnecting to DB if the connection is lost
              con = DriverManager.getConnection(createDB.JDBC_URL); 
          }
          Statement stmt = con.createStatement();
          stmt.executeUpdate("update EmailQueue SET IS_PROCESSED = '"+processed_status+"' where id ="+id_mes);
          //updating the status fetched to the DB back agian
      }
      long stopTime = System.currentTimeMillis(); //checking time again
      long elapsedTime = stopTime - startTime; //computing the time processed
      System.out.println("Time Taken to complete the process :"+elapsedTime);
      con.close(); //closing the DB connection
      
     }
     catch(SQLException | InterruptedException | NumberFormatException e)
     {
         System.out.println("Stopped execution some problem in main thread .Error :"+e);
     }
      
    System.out.println("___________________________________________");
    System.out.println("Program Terminated ");
    System.out.println("Successfull attempts :"+count_sent);  
    System.out.println("Un-Successfull attempts :"+count_tried);       
    System.out.println("___________________________________________");      
   }
}