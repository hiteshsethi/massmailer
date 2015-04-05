# massmailer
												Mass Mailing Program
												Developer : Hitesh Sethi
Programming Language :Java
API Used for sending mail: Javamail
SMTP Server Tried : Sendgrid(smtp.sendgrid.net) and Gmail(smtp.gmail.com)
Preferred Sendgrid as gmail has limit of 20 mails/hour. It was also not allowing simultaneous connection.
DB Used : Java Database(DERBY CLIENT)
Table Structure : is_processed is the extra field along with the fields you mentioned. It basically carries the current status of the mail.

Description about Class's
1)createDB.java -> It contains the basic code for checking database data. Or if table exists. 
					Data will be updated automatically once you will be change database configuration
					
2)Mailthread.java -> It is thread inherited class. Responsible for making and sending mails.

3)Massmailer.java -> Main class of the project. Managing and updating database. Managing Threads.

Assumptions :
*Server can handle the load.
*It will have enough memory to have threads.
*It will allow multiple connections. (No timeout for successful delivery)

About Code:
1.I have designed my algorithm in a way that multiple process's can run the same program to send mails simultaneously.

2.Mails will be sent only once.

3.Used multithreading to send mails to speed up the process. Each thread will make connection again.

For Testing Purpose if you want to change database :
Change Line num 14,15 in createDB.java. (you may have to update/change queries accordingly if you are using another DB)
Queries are written for Derby Client.

For Change of SMTP Server:
Change Password and other things.
Change lines 33 to 42 accordingly.

First Reach to the massmailer directory then do this

1) To Compile

javac -cp "lib/derby.jar;lib/derbyclient.jar;lib/derbynet.jar;lib/javax.mail.jar" -d . *.java

2) To Run 

java -cp "lib/derby.jar;lib/derbyclient.jar;lib/derbynet.jar;lib/javax.mail.jar;." massmailer.Massmailer
