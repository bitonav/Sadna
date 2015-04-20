package ForumsSystem;

import java.util.Vector;

public class SignedMember extends User {

	protected String _Name;
	protected String _Username;
	protected String _Password;
	protected String _Email;
	protected boolean _IsConfirmed;
	protected Vector<Discussion> _discussions;
	
	public SignedMember(String name, String username, String password, String email) {
		super();
		_Name = name;
		_Username = username;
		_Password = password;
		_Email = email;
		_IsConfirmed = false;
		_discussions = new Vector<Discussion>();
	}

	public void confirmUser(){
		_IsConfirmed=true;
	} // confirmUser

	public boolean isConfirmed() {
		return _IsConfirmed;
	} // isConfirmed
	
	public String getEmail() {
		return _Email;
	} // getEmail

	public String getName() {
		return _Name;
	}

	public void setName(String _Name) {
		this._Name = _Name;
	}

	public String getUsername() {
		return _Username;
	}

	public void setUsername(String _Username) {
		this._Username = _Username;
	}

	public String getPassword() {
		return _Password;
	}

	public void setPassword(String _Password) {
		this._Password = _Password;
	}

	public void publishNewDiscussion(String title, String content, SubForum sf){
		Discussion dis = new Discussion(_userID, title, content);
		sf.addSubForumDiscussion(dis);
		_discussions.add(dis);
		Control.actionsLogger.info("User: " + _userID + " published new Discussion in Sub Forum: " + sf.getName());
	}
	
	public void publishNewComment(String title, String content, Discussion dis, Comment referredToComment){
		Comment com = new Comment(_userID, dis.getDiscussionId(), title, content, referredToComment);
		referredToComment.addCommentToRepliedComments(com);
		// TODO send notification to user
		Control.actionsLogger.info("User:" + _userID + " published new Comment in Discussion: " + dis.getDiscussionId() + ", refferred to Comment: " + referredToComment.getCommentId());             
	}

}