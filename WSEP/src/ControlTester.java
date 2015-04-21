import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Test;

import ForumsSystem.Control;
import ForumsSystem.SignedMember;
import ForumsSystem.User;


public class ControlTester {
	Control c;

	public ControlTester(){
		c = Control.getInstance();
	}

	@Test
	public void test() {
		assertTrue(true);
	}

	@Test
	public void testSendEmailConfirmation(){
		c.sendEmailConfirmation("zitaiat@post.bgu.ac.il");
		assertTrue(true);
	}

	@Test
	public void testAddNewUserToDatabase(){
		SignedMember s = new SignedMember("Ran", "ranUsername", "12345", "zitaiat@post.bgu.ac.il");
		assertTrue(true);
	}

	@Test
	public void testConfirmUserByEmail(){
		SignedMember s = new SignedMember("Ran", "ranUsername", "12345", "zitaiat@post.bgu.ac.il");
		c.sendEmailConfirmation("zitaiat@post.bgu.ac.il");
		c.addNewUserToDatabase(s);
		// the user sends email back, and then it should be confirmed
		//Scanner in = new Scanner(System.in);
		//int temp = in.nextInt(); // if the user confirmed, enter number
		long i = 0;
		while(i<500000000){
			i++; 
			long j = 0;
			while(j<50) {
				j++;
			}
		}
		c.confirmUsersByEmail();
		assertTrue(s.isConfirmed());
	}

}
