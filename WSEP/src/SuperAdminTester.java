import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ForumsSystem.SuperAdmin;
import ForumsSystem.Forum;



public class SuperAdminTester {

	private SuperAdmin admin;
	
	@Before
	public void initAdmin() {
		admin = new SuperAdmin("Leo Messi", "TheKing", "penaldo", "leo@adidas.com");
	}

	@Test
	public void testAddForum() {
		Forum a = new Forum("Football");
		admin.addForum(a);
		assertTrue(admin.getForums().contains(a));
		Forum b = new Forum("Software");
		admin.addForum(b);
		assertTrue(admin.getForums().contains(a));
	}

	@Test
	public void testRemoveForum() {
		Forum a = new Forum("Football");
		admin.addForum(a);
		Forum b = new Forum("Software");
		admin.addForum(b);
		assertTrue(admin.getForums().size() == 2);
		admin.removeForum(a);
		admin.removeForum(b);
		assertTrue(admin.getForums().size() == 0);
	}

}
