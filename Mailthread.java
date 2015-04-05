/*
 * Developer : Hitesh Sethi
 * This class is implemented for making threads.
 * This class is mainly responsible for sending message
 */
package massmailer;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mailthread extends Thread{
    private int id;
    private String to,from,body,subject;
    private boolean flag_problem = true;
    public Mailthread(int id,String to,String from,String subject,String body)
    {
        //assigning the variables to the local variables of the class
        this.to = to;
        this.id = id;
        this.from = from;
        this.subject = subject;
        this.body = body;
    }
    @Override
    public void run()
    {
        //implementing the overriden function
                    final String username = "hiteshsethi";//change accordingly
                    final String password = "*******";//change accordingly
                    
                    String host = "smtp.sendgrid.net";
                    //String host = "smtp.gmail.com";
                    Properties props = new Properties();
                    props.put("mail.smtp.auth", "true");
                    props.put("mail.smtp.starttls.enable", "true");
                    props.put("mail.smtp.host", host);
                    props.put("mail.smtp.port", "587");

                    // Get the Session object.
                    final Session session = Session.getInstance(props,
                    new javax.mail.Authenticator() {
                       protected PasswordAuthentication getPasswordAuthentication() {
                          return new PasswordAuthentication(username, password);
                       }
                    });
                try{
                    
                  // Create a default MimeMessage object.
                  Message message = new MimeMessage(session);
                  // Set From: header field of the header.
                  message.setFrom(new InternetAddress(from));
                  // Set To: header field of the header.
                  message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(to));

                  // Set Subject: header field
                  message.setSubject(subject);

                  // Now set the actual message
                  message.setText(body);  
                  Transport t = session.getTransport(); //initialising the Transport object

                  t.connect(); //making the connection to the DB
                  try{
                          t.sendMessage(message, message.getAllRecipients()); //sending the mail to SMTP server
                          System.out.println("Sent message successfully...."+message.getSubject()+" "+id); 
                          flag_problem = false; //no problem
                      }
                      catch(Exception e)
                      {
                          flag_problem = true;
                          System.out.println("Not able to send this message...."+message.getSubject()+" "+id+" due to error "+e);
                      }
                    t.close(); //closing the connection
                   
                }
                catch(Exception e)
                {
                    System.out.println("Problem in connection. Error :"+e);
                }
        }
    String getStatus()
    {
        if(flag_problem)
        {
            //if there was a problem to T for Tried
            return "T,"+id;
        }
        else
        {
            //success
            return "S,"+id;
        }
    }
}
