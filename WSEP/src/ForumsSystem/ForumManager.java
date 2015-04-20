package ForumsSystem;

import java.util.Vector;

public class ForumManager extends Moderator {

	protected Vector<Forum> _forums;
	
	
	public ForumManager(String name, String username, String password, String email) {
		super(name, username, password, email);
	}
	
	public Vector<Forum> getForums() {
		return _forums;
	}

	public void addForum(Forum forum) {
		this._forums.add(forum);
	}
	
	public SubForum createSubForum(String subject, int forumID){
		for(Forum forum:_forums){
			if(forum.getForumID() == forumID){
				Control.actionsLogger.info("User:" + _userID + " created new Sub-Forum in Forum: " + forum.getName());
				return new SubForum(subject, forum);
			}
		}
		Control.errorsLogger.info("User:" + _userID + " Failed to create a new Sub-Forum");
		return null;
	}

}
