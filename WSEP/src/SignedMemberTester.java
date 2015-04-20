import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ForumsSystem.Comment;
import ForumsSystem.Discussion;
import ForumsSystem.Forum;
import ForumsSystem.SignedMember;
import ForumsSystem.SubForum;


public class SignedMemberTester {

	private SignedMember sm;
	private SubForum sf;
	
	@Before
	public void setUp() throws Exception {
		Forum forum = new Forum("Life");
		sm = new SignedMember("Barney Stinson", "Barney", "suitup", "suit@mclarens.com");
		sf = new SubForum("Awesomeness", forum);
	}

	@Test
	public void testPublishNewDiscussion() {		
		String subject = "Awesome", 
				  content = "When I'm sad, I stop being sad and start being awesome";
		int oldSize = sf.getSubForumDiscussion().size();
		
		sm.publishNewDiscussion(subject, content, sf);
		
		assertTrue(sf.getSubForumDiscussion().size() == (oldSize+1));
		assertTrue(sf.getSubForumDiscussion().elementAt(oldSize).getHeaderComment().getTitle().equals(subject));
		assertTrue(sf.getSubForumDiscussion().elementAt(oldSize).getHeaderComment().getContent().equals(content));
	}

	@Test
	public void testPublishNewComment() {		
		Discussion dis;
		if(sf.getSubForumDiscussion().size()>0){
			dis = sf.getSubForumDiscussion().elementAt(0);	
		}
		else{
			String subject = "Awesome", 
					  content = "When I'm sad, I stop being sad and start being awesome";
			
			sm.publishNewDiscussion(subject, content, sf);
			dis = sf.getSubForumDiscussion().elementAt(0);
		}
		
		String subject = "", 
				  content = "comment1";
		
		// comment to a header comment
		sm.publishNewComment(subject, content, dis, dis.getHeaderComment());
		
		int numberOfComments = dis.getHeaderComment().getRepliedCommentsVec().size();
		Comment addedComment = dis.getHeaderComment().getRepliedCommentsVec().elementAt(numberOfComments-1); 
		assertTrue(addedComment.getTitle().equals(subject));
		assertTrue(addedComment.getContent().equals(content));
		
		// comment to a comment
		subject = "comment1.1";
		content = "";
		
		sm.publishNewComment(subject, content, dis, addedComment);
		
		numberOfComments = addedComment.getRepliedCommentsVec().size();
		addedComment = addedComment.getRepliedCommentsVec().elementAt(numberOfComments-1); 
		assertTrue(addedComment.getTitle().equals(subject));
		assertTrue(addedComment.getContent().equals(content));
	}

}
