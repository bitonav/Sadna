package ForumsSystem;

import java.util.Vector;

public class ForumManager extends Moderator {

	protected Vector<Forum> _forums;
	
	
	public ForumManager(int userId) {
		super(userId);
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
				Control.actionsLogger.info("User:" + userId + " created new Sub-Forum in Forum: " + forum.getName());
				return new SubForum(subject, forum);
			}
		}
		Control.errorsLogger.info("User:" + userId + " Failed to create a new Sub-Forum");
		return null;
	}

}
