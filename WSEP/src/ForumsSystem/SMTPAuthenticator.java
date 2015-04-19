package ForumsSystem;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class SMTPAuthenticator extends Authenticator
{
	public PasswordAuthentication getPasswordAuthentication()
	{
		return new PasswordAuthentication("wsep2015@gmail.com", "WSEP@)!%");
	} // PasswordAuthentication
} // SMTPAuthenticator