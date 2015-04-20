import static org.junit.Assert.*;

import org.junit.Test;

import ForumsSystem.Guest;


public class GuestTester {

	Guest g;
	
	public GuestTester(){
		g = new Guest();
	}
	
	@Test
	public void test() {
		assertTrue(true);
	}
	
	@Test
	public void testRegister(){
		g.Register("Ran", "ran15", "123456789", "itamarto@post.bgu.ac.il");
		assertFalse(g.Register("Moshe", "ran15", "1234555", "itamarto@post.bgu.ac.il"));
	}
	
	@Test
	public void testRegister2(){
		g.Register("Ran", "ran17", "123456789", "itamarto@post.bgu.ac.il");
		assertTrue(g.Register("Itamar", "itamar", "123456789", "itamarto@post.bgu.ac.il"));
	}

}
