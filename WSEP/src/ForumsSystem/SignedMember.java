package ForumsSystem;

import java.util.Vector;

public class SignedMember extends User {

	private String f_Name;
	private String f_Username;
	private String f_Password;
	private boolean f_IsConfirmed;
	private Vector<Discussion> _discussions;
	
	public SignedMember(int userId) {
		super(userId);
		// TODO Auto-generated constructor stub
	}
	
	public void confirmUser(){
		f_IsConfirmed=true;
	} // confirmUser
	
	public void publishNewDiscussion(String title, String content, SubForum sf){
		Discussion dis = new Discussion(userId, title, content);
		sf.addSubForumDiscussion(dis);
		_discussions.add(dis);
		Control.actionsLogger.info("User:" + userId + " published new Discussion in Sub Forum: " + sf.getName());
	}
	
	public void publishNewComment(String title, String content, Discussion dis, Comment referredToComment){
		Comment com = new Comment(userId, dis.getDiscussionId(), title, content, referredToComment);
		referredToComment.addCommentToRepliedComments(com);
		// TODO send notification to user
		Control.actionsLogger.info("User:" + userId + " published new Comment in Discussion: " + dis.getDiscussionId() + ", refferred to Comment: " + referredToComment.getCommentId());             
	}

}