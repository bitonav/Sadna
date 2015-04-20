package ForumsSystem;

import java.util.Vector;

public class ForumManager extends Moderator {

	protected Vector<Forum> _forums;
	
	
	public ForumManager(String name, String username, String password, String email) {
		super(name, username, password, email);
		_forums = new Vector<Forum>();
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
				Control.actionsLogger.info("ForumManager:" + _userID + " created new Sub-Forum in Forum: " + forum.getName());
				return new SubForum(subject, forum);
			}
		}
		Control.errorsLogger.info("ForumManager:" + _userID + " Failed to create a new Sub-Forum");
		return null;
	}
	
	public void deleteSubForum(SubForum sf, int forumID){
		for(Forum forum:_forums){
			if(forum.getForumID() == forumID){
				Control.actionsLogger.info("ForumManager: " + _userID + " deleted a Sub-Forum in Forum: " + forum.getName());
				forum.getForumSubForums().remove(sf);
				return;
			}
		}
		Control.errorsLogger.info("ForumManager: " + _userID + " Failed to delete a Sub-Forum");
		return;
	}

}
