/*
 * Developer : Hitesh Sethi
 * This Class is mainly responsible for checking db exists
 * And creating tables and dummy rows in db
 */
package massmailer;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class createDB {
  public static final String DRIVER="org.apache.derby.jdbc.ClientDriver"; //change accordingly
  public static final String JDBC_URL = "jdbc:derby://localhost:1527/massmaildb"; //change accordingly
    public void makeDB() throws Exception
    {
        Class.forName(DRIVER);
        Connection con = DriverManager.getConnection(JDBC_URL);
        DatabaseMetaData dbm = con.getMetaData(); //getting the metadata about the DB
        ResultSet rs = dbm.getTables(null, null, "EmailQueue".toUpperCase(), null); 
        if (rs.next()) {
          System.out.println("Table exists"); 
          // table and rows exists in DB 
        } else {
            //if table and rows doesnot exists in DB then create table and enter some dummy rows
            System.out.println("Table does not exist");    
            con.createStatement().execute("create table EmailQueue(id INT GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),from_email_address varchar(100),to_email_address varchar(100),subject LONG VARCHAR,body LONG VARCHAR,is_processed varchar(100),PRIMARY KEY(id))");
            con.createStatement().execute("INSERT INTO EMAILQUEUE (FROM_EMAIL_ADDRESS, TO_EMAIL_ADDRESS, SUBJECT, BODY, IS_PROCESSED) \n" +"	VALUES ('example@test.com', 'hitesh.28jan@gmail.com', 'MAIL1', 'TESTING WHETHER EVERYTHING IS FINE', 'UNPROCESSED')");
            con.createStatement().execute("INSERT INTO EMAILQUEUE (FROM_EMAIL_ADDRESS, TO_EMAIL_ADDRESS, SUBJECT, BODY, IS_PROCESSED) \n" +"	VALUES ('example@test.com', 'shanu.latest@gmail.com', 'MAIL2', 'TESTING WHETHER EVERYTHING IS FINE', 'UNPROCESSED')");
            con.createStatement().execute("INSERT INTO EMAILQUEUE (FROM_EMAIL_ADDRESS, TO_EMAIL_ADDRESS, SUBJECT, BODY, IS_PROCESSED) \n" +"	VALUES ('example@test.com', 'hitesh.28jan@gmail.com', 'MAIL3', 'TESTING WHETHER EVERYTHING IS FINE', 'UNPROCESSED')");
            con.createStatement().execute("INSERT INTO EMAILQUEUE (FROM_EMAIL_ADDRESS, TO_EMAIL_ADDRESS, SUBJECT, BODY, IS_PROCESSED) \n" +"	VALUES ('example@test.com', 'hitesh.28jan@gmail.com', 'MAIL4', 'TESTING WHETHER EVERYTHING IS FINE', 'UNPROCESSED')");
            con.createStatement().execute("INSERT INTO EMAILQUEUE (FROM_EMAIL_ADDRESS, TO_EMAIL_ADDRESS, SUBJECT, BODY, IS_PROCESSED) \n" +"	VALUES ('example@test.com', 'hitesh.28jan@gmail.com', 'MAIL5', 'TESTING WHETHER EVERYTHING IS FINE', 'UNPROCESSED')");
            con.createStatement().execute("INSERT INTO EMAILQUEUE (FROM_EMAIL_ADDRESS, TO_EMAIL_ADDRESS, SUBJECT, BODY, IS_PROCESSED) \n" +"	VALUES ('example@test.com', 'hitesh.28jan@gmail.com', 'MAIL6', 'TESTING WHETHER EVERYTHING IS FINE', 'UNPROCESSED')");
            con.createStatement().execute("INSERT INTO EMAILQUEUE (FROM_EMAIL_ADDRESS, TO_EMAIL_ADDRESS, SUBJECT, BODY, IS_PROCESSED) \n" +"	VALUES ('example@test.com', 'hitesh.28jan@gmail.com', 'MAIL7', 'TESTING WHETHER EVERYTHING IS FINE', 'UNPROCESSED')");
            con.createStatement().execute("INSERT INTO EMAILQUEUE (FROM_EMAIL_ADDRESS, TO_EMAIL_ADDRESS, SUBJECT, BODY, IS_PROCESSED) \n" +"	VALUES ('example@test.com', 'hitesh.28jan@gmail.com', 'MAIL8', 'TESTING WHETHER EVERYTHING IS FINE', 'UNPROCESSED')");
            con.createStatement().execute("INSERT INTO EMAILQUEUE (FROM_EMAIL_ADDRESS, TO_EMAIL_ADDRESS, SUBJECT, BODY, IS_PROCESSED) \n" +"	VALUES ('example@test.com', 'hitesh.28jan@gmail.com', 'MAIL9', 'TESTING WHETHER EVERYTHING IS FINE', 'UNPROCESSED')");
            con.createStatement().execute("INSERT INTO EMAILQUEUE (FROM_EMAIL_ADDRESS, TO_EMAIL_ADDRESS, SUBJECT, BODY, IS_PROCESSED) \n" +"	VALUES ('example@test.com', 'hitesh.28jan@gmail.com', 'MAIL10', 'TESTING WHETHER EVERYTHING IS FINE', 'UNPROCESSED')");


            //---
             con.createStatement().execute("INSERT INTO EMAILQUEUE (FROM_EMAIL_ADDRESS, TO_EMAIL_ADDRESS, SUBJECT, BODY, IS_PROCESSED) \n" +"	VALUES ('example@test.com', 'hitesh.28jan@gmail.com', 'MAIL11', 'TESTING WHETHER EVERYTHING IS FINE', 'UNPROCESSED')");
            con.createStatement().execute("INSERT INTO EMAILQUEUE (FROM_EMAIL_ADDRESS, TO_EMAIL_ADDRESS, SUBJECT, BODY, IS_PROCESSED) \n" +"	VALUES ('example@test.com', 'shanu.latest@gmail.com', 'MAIL12', 'TESTING WHETHER EVERYTHING IS FINE', 'UNPROCESSED')");
            con.createStatement().execute("INSERT INTO EMAILQUEUE (FROM_EMAIL_ADDRESS, TO_EMAIL_ADDRESS, SUBJECT, BODY, IS_PROCESSED) \n" +"	VALUES ('example@test.com', 'hitesh.28jan@gmail.com', 'MAIL13', 'TESTING WHETHER EVERYTHING IS FINE', 'UNPROCESSED')");
            con.createStatement().execute("INSERT INTO EMAILQUEUE (FROM_EMAIL_ADDRESS, TO_EMAIL_ADDRESS, SUBJECT, BODY, IS_PROCESSED) \n" +"	VALUES ('example@test.com', 'hitesh.28jan@gmail.com', 'MAIL14', 'TESTING WHETHER EVERYTHING IS FINE', 'UNPROCESSED')");
            con.createStatement().execute("INSERT INTO EMAILQUEUE (FROM_EMAIL_ADDRESS, TO_EMAIL_ADDRESS, SUBJECT, BODY, IS_PROCESSED) \n" +"	VALUES ('example@test.com', 'hitesh.28jan@gmail.com', 'MAIL15', 'TESTING WHETHER EVERYTHING IS FINE', 'UNPROCESSED')");
            con.createStatement().execute("INSERT INTO EMAILQUEUE (FROM_EMAIL_ADDRESS, TO_EMAIL_ADDRESS, SUBJECT, BODY, IS_PROCESSED) \n" +"	VALUES ('example@test.com', 'hitesh.28jan@gmail.com', 'MAIL16', 'TESTING WHETHER EVERYTHING IS FINE', 'UNPROCESSED')");
            con.createStatement().execute("INSERT INTO EMAILQUEUE (FROM_EMAIL_ADDRESS, TO_EMAIL_ADDRESS, SUBJECT, BODY, IS_PROCESSED) \n" +"	VALUES ('example@test.com', 'hitesh.28jan@gmail.com', 'MAIL17', 'TESTING WHETHER EVERYTHING IS FINE', 'UNPROCESSED')");
            con.createStatement().execute("INSERT INTO EMAILQUEUE (FROM_EMAIL_ADDRESS, TO_EMAIL_ADDRESS, SUBJECT, BODY, IS_PROCESSED) \n" +"	VALUES ('example@test.com', 'hitesh.28jan@gmail.com', 'MAIL18', 'TESTING WHETHER EVERYTHING IS FINE', 'UNPROCESSED')");
            con.createStatement().execute("INSERT INTO EMAILQUEUE (FROM_EMAIL_ADDRESS, TO_EMAIL_ADDRESS, SUBJECT, BODY, IS_PROCESSED) \n" +"	VALUES ('example@test.com', 'hitesh.28jan@gmail.com', 'MAIL19', 'TESTING WHETHER EVERYTHING IS FINE', 'UNPROCESSED')");
            con.createStatement().execute("INSERT INTO EMAILQUEUE (FROM_EMAIL_ADDRESS, TO_EMAIL_ADDRESS, SUBJECT, BODY, IS_PROCESSED) \n" +"	VALUES ('example@test.com', 'hitesh.28jan@gmail.com', 'MAIL20', 'TESTING WHETHER EVERYTHING IS FINE', 'UNPROCESSED')");

            //--

             con.createStatement().execute("INSERT INTO EMAILQUEUE (FROM_EMAIL_ADDRESS, TO_EMAIL_ADDRESS, SUBJECT, BODY, IS_PROCESSED) \n" +"	VALUES ('example@test.com', 'hitesh.28jan@gmail.com', 'MAIL21', 'TESTING WHETHER EVERYTHING IS FINE', 'UNPROCESSED')");
            con.createStatement().execute("INSERT INTO EMAILQUEUE (FROM_EMAIL_ADDRESS, TO_EMAIL_ADDRESS, SUBJECT, BODY, IS_PROCESSED) \n" +"	VALUES ('example@test.com', 'shanu.latest@gmail.com', 'MAIL22', 'TESTING WHETHER EVERYTHING IS FINE', 'UNPROCESSED')");
            con.createStatement().execute("INSERT INTO EMAILQUEUE (FROM_EMAIL_ADDRESS, TO_EMAIL_ADDRESS, SUBJECT, BODY, IS_PROCESSED) \n" +"	VALUES ('example@test.com', 'hitesh.28jan@gmail.com', 'MAIL23', 'TESTING WHETHER EVERYTHING IS FINE', 'UNPROCESSED')");
            con.createStatement().execute("INSERT INTO EMAILQUEUE (FROM_EMAIL_ADDRESS, TO_EMAIL_ADDRESS, SUBJECT, BODY, IS_PROCESSED) \n" +"	VALUES ('example@test.com', 'hitesh.28jan@gmail.com', 'MAIL24', 'TESTING WHETHER EVERYTHING IS FINE', 'UNPROCESSED')");
            con.createStatement().execute("INSERT INTO EMAILQUEUE (FROM_EMAIL_ADDRESS, TO_EMAIL_ADDRESS, SUBJECT, BODY, IS_PROCESSED) \n" +"	VALUES ('example@test.com', 'hitesh.28jan@gmail.com', 'MAIL25', 'TESTING WHETHER EVERYTHING IS FINE', 'UNPROCESSED')");
            con.createStatement().execute("INSERT INTO EMAILQUEUE (FROM_EMAIL_ADDRESS, TO_EMAIL_ADDRESS, SUBJECT, BODY, IS_PROCESSED) \n" +"	VALUES ('example@test.com', 'hitesh.28jan@gmail.com', 'MAIL26', 'TESTING WHETHER EVERYTHING IS FINE', 'UNPROCESSED')");
            con.createStatement().execute("INSERT INTO EMAILQUEUE (FROM_EMAIL_ADDRESS, TO_EMAIL_ADDRESS, SUBJECT, BODY, IS_PROCESSED) \n" +"	VALUES ('example@test.com', 'hitesh.28jan@gmail.com', 'MAIL27', 'TESTING WHETHER EVERYTHING IS FINE', 'UNPROCESSED')");
            con.createStatement().execute("INSERT INTO EMAILQUEUE (FROM_EMAIL_ADDRESS, TO_EMAIL_ADDRESS, SUBJECT, BODY, IS_PROCESSED) \n" +"	VALUES ('example@test.com', 'hitesh.28jan@gmail.com', 'MAIL28', 'TESTING WHETHER EVERYTHING IS FINE', 'UNPROCESSED')");
            con.createStatement().execute("INSERT INTO EMAILQUEUE (FROM_EMAIL_ADDRESS, TO_EMAIL_ADDRESS, SUBJECT, BODY, IS_PROCESSED) \n" +"	VALUES ('example@test.com', 'hitesh.28jan@gmail.com', 'MAIL29', 'TESTING WHETHER EVERYTHING IS FINE', 'UNPROCESSED')");
            con.createStatement().execute("INSERT INTO EMAILQUEUE (FROM_EMAIL_ADDRESS, TO_EMAIL_ADDRESS, SUBJECT, BODY, IS_PROCESSED) \n" +"	VALUES ('example@test.com', 'hitesh.28jan@gmail.com', 'MAIL30', 'TESTING WHETHER EVERYTHING IS FINE', 'UNPROCESSED')");


            //--


        }   

        System.out.println("DB made");
        con.close();
    }
    public static void main(String args[]) throws Exception
    {
       new createDB().makeDB();
    }
}
