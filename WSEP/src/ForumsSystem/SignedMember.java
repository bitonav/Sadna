package ForumsSystem;

import java.util.Vector;

public class SignedMember extends User {

	protected String _Name;
	protected String _Username;
	protected String _Password;
	protected String _Email;
	protected boolean _IsConfirmed;
	protected Vector<Discussion> _discussions;
	protected Vector<Comment> _comments;/***********************************/
	protected int _Seniority;
	protected int _LoggedInTime;
	protected int _PostsLastYear;
	protected UserStatus _status;
	protected Vector<Integer> _friends;
	protected Vector<Integer> _pendingRequestsForFriendship;
	
	public SignedMember(String name, String username, String password, String email) {
		super();
		_Name = name;
		_Username = username;
		_Password = password;
		_Email = email;
		_IsConfirmed = false;
		_discussions = new Vector<Discussion>();
		_comments = new Vector<Comment>(); /***********************************/
		_Seniority = 0;
		_LoggedInTime = 0;
		_PostsLastYear = 0;
		_status  = UserStatus.ACTIVE;
	} // Constructor

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
	} // publishNewDiscussion
	
	public void publishNewComment(String title, String content, Discussion dis, Comment referredToComment){
		Comment com = new Comment(_userID, dis.getDiscussionId(), title, content, referredToComment);
		referredToComment.addCommentToRepliedComments(com);
		// TODO send notification to user
		Control.actionsLogger.info("User:" + _userID + " published new Comment in Discussion: " + dis.getDiscussionId() + ", refferred to Comment: " + referredToComment.getCommentId());             
	} // publishNewComment
	
	public boolean Logout(String username){
			Control.getInstance().logoutUser(username);
			return true;
	} // Login

	public int getSeniority() {
		return _Seniority;
	}

	public void setSeniority(int _Seniority) {
		this._Seniority = _Seniority;
	}

	public int getLoggedInTime() {
		return _LoggedInTime;
	}

	public void setLoggedInTime(int _LoggedInTime) {
		this._LoggedInTime = _LoggedInTime;
	}

	public int getPostsLastYear() {
		return _PostsLastYear;
	}

	public void setPostsLastYear(int _PostsLastYear) {
		this._PostsLastYear = _PostsLastYear;
	}

	public void changeStatus(UserStatus status) {
			_status = status;
	}
	
	public void addFriend(int friendID){
		//check if friendID exist
		if(Control.getInstance().isUserIDExist(friendID)){
			//check if not already friends
			if(!_friends.contains(friendID)){
				//send friend request
				sendFriendRequest(friendID);
				_friends.add(friendID);
			}
			else{
				Control.errorsLogger.info("User:" + _userID + " tried to add as friend user: " + friendID + ", which already his friend.");             
			}
		}
		else{
			Control.errorsLogger.info("User:" + _userID + " tried to add as friend user: " + friendID + ", which isn't a signed member.");
		}
		
		
	}

	private void sendFriendRequest(int friendID) {
		Control.getInstance().getMemberById(friendID).addMemberToPendingRequest(this._userID);
		
	}

	private void addMemberToPendingRequest(int userID) {
		_pendingRequestsForFriendship.add(userID);
	}

	private void approveFriendRequest(int userID){
		if(_pendingRequestsForFriendship.contains(userID)){
			_pendingRequestsForFriendship.remove(userID);
			_friends.add(userID);
			Control.getInstance().getMemberById(userID)._friends.add(this._userID);
		}
		else{
			Control.errorsLogger.info("User:" + _userID + " tried to approve as friend user: " + userID + ", which isn't in his pending requests.");
		}
	}
	
	

}