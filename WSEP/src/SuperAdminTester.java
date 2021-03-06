import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ForumsSystem.SuperAdmin;
import ForumsSystem.Forum;



public class SuperAdminTester {

	private SuperAdmin admin;
	
	@Before
	public void initAdmin() {
		SuperAdmin.createSuperAdmin("Leo Messi", "TheKing", "penaldo", "leo@adidas.com");
		admin = SuperAdmin.getInstance();
	}

	@Test
	public void test_Add_Delete_Forum() {
		assertTrue(admin.getForums().size() == 0);
		Forum a = new Forum("Football");
		admin.addForum(a);
		assertTrue(admin.getForums().contains(a));
		Forum b = new Forum("Software");
		admin.addForum(b);
		assertTrue(admin.getForums().contains(a));
		assertTrue(admin.getForums().size() == 2);
		admin.removeForum(a);
		admin.removeForum(b);
		assertTrue(admin.getForums().size() == 0);
	}

}
