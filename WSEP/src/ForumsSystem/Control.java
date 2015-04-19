package ForumsSystem;

import java.util.*;

import javax.mail.*;
import javax.mail.internet.*;

import java.util.HashSet;
import java.util.logging.Logger;
import java.util.logging.LogManager;



public class Control {
	

	public static final Logger actionsLogger = Logger.getLogger(Control.class.getName());
	public static final Logger errorsLogger = Logger.getLogger(Control.class.getName());
	
	/********************** How to use the logger: *************************/
	// When u want to use the logger just call the logger u need
	// errorsLog \ actionLog and type the string to print,
	// example: actionsLogger.info("Shmolik has been logged to the forum system");
	// u can adjust the logger properties in the properties folder.
	// for each message the logger will print a time stamp automatically.
	/************************************************************************/

	public static int globalID = 0; // unique ID's to users, forums, etc.
	private static HashSet<String> loggedInMembers;

	public static void main(String[] args){
		loggedInMembers = new HashSet<String>(); // HashSet of all logged in members
		sendEmailConfirmation("zitaiat@post.bgu.ac.il");

	} // main

	/*
	 * This function gets username and password and checks if there is a match in the database
	 */
	public static boolean userAuthentication(String username, String password){
		boolean ans = false;
		// check
		return ans;
	} // userAuthentication

	/*
	 * This function gets username and adds it to the data structure of the signed in members
	 */
	public static void loginUser(String username){
		loggedInMembers.add(username);
		// TODO maybe changed to DB
	} // loginUser

	/*
	 * This function gets username and adds it to the data structure of the signed in members
	 */
	public static void logoutUser(String username){
		loggedInMembers.remove(username);
		// TODO maybe changed to DB
	} // logoutUser

	/*
	 * This function gets username and checks with the DB if the username exist. For the regiteration process
	 */
	public static boolean isUsernameExist(String username){
		boolean ans=false;

		// check with DB

		return ans;
	} // isUsernameExist

	/*
	 * This function gets object of SignedMember and adds its details to the DB
	 */
	public static void addNewUserToDatabase(SignedMember sm){

		// take the fields from 'sm' and insert it to the DB

	} // addNewUserToDatabase

	/*
	 * This function sends an email confirmation to a member that tries to register
	 */
	public static void sendEmailConfirmation(String email){
		String  sourceEmail = "wsep2015@gmail.com",
				sourceEmailPassword = "WSEP@)!%",
				sourceEmailHost = "smtp.gmail.com",
				sourceEmailPort  = "465",
				name = "DefaultName",
				destEmail = email,
				mailSubject = "Welcome to WSEP152 forum!",
				mailContent = "This is an automated mail from WSEP152 forums system.\nPlease confirm your registeration by sending a mail back.\nEnjoy!";
		Properties props = new Properties();
		props.put("mail.smtp.user", sourceEmail);
		props.put("mail.smtp.host", sourceEmailHost);
		props.put("mail.smtp.port", sourceEmailPort);
		props.put("mail.smtp.starttls.enable","true");
		props.put("mail.smtp.debug", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.socketFactory.port", sourceEmailPort);
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.fallback", "false");

		SMTPAuthenticator auth = new SMTPAuthenticator();
		Session session = Session.getInstance(props, auth);
		session.setDebug(true);

		MimeMessage msg = new MimeMessage(session);
		try {
			msg.setSubject(mailSubject);
			msg.setFrom(new InternetAddress(sourceEmail));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(destEmail));
			
			Multipart mPart = new MimeMultipart();
			BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setContent(mailContent,"text/plain");
			mPart.addBodyPart(messageBodyPart);
			msg.setContent(mPart);
			msg.saveChanges();
		
			Transport transport = session.getTransport("smtps");
			transport.connect(sourceEmailHost, Integer.valueOf(sourceEmailPort), name, sourceEmailPassword);
			transport.sendMessage(msg, msg.getAllRecipients());
			transport.close();

		} catch (AddressException e) {
			e.printStackTrace();
			return;
		} catch (MessagingException e) {
			e.printStackTrace();
			return;
		}
	} // sendEmailConfirmation

} // Class Control
