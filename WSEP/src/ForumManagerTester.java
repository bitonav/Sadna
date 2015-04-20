import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ForumsSystem.Forum;
import ForumsSystem.ForumManager;
import ForumsSystem.SubForum;


public class ForumManagerTester {

	private ForumManager fm;

	@Before
	public void setUp() throws Exception {
		fm = new ForumManager("Andres Iniesta", "Engineer", "8engineer8", "andres@fcb.com");
	}

	@Test
	public void testAddForum() {
		assertTrue(fm.getForums().size() == 0);

		Forum f1 = new Forum("Football");
		fm.addForum(f1);
		assertTrue(fm.getForums().size() == 1);
		assertTrue(fm.getForums().elementAt(0) == f1);

		Forum f2 = new Forum("Software");
		fm.addForum(f2);
		assertTrue(fm.getForums().size() == 2);
		assertTrue(fm.getForums().elementAt(1) == f2);
	}

	@Test
	public void test_Create_Delete_SubForum() {
		Forum f1 = new Forum("Football");
		fm.addForum(f1);

		Forum forum = fm.getForums().elementAt(0);
		assertTrue(forum.getForumSubForums().size() == 0);

		SubForum sf1 = fm.createSubForum("LA LIGA", forum.getForumID());
		assertTrue(forum.getForumSubForums().size() == 1);
		assertTrue(forum.getForumSubForums().elementAt(0) == sf1);

		SubForum sf2 = fm.createSubForum("SERIA A", forum.getForumID());
		assertTrue(forum.getForumSubForums().size() == 2);
		assertTrue(forum.getForumSubForums().elementAt(1) == sf2);


		fm.deleteSubForum(sf1, forum.getForumID());
		assertTrue(forum.getForumSubForums().size() == 1);

		fm.deleteSubForum(sf2, forum.getForumID());
		assertTrue(forum.getForumSubForums().size() == 0);
	}

}
