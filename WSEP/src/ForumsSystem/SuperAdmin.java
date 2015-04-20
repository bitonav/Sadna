package ForumsSystem;

import java.util.Vector;

public class SuperAdmin extends ForumManager {

	private Vector<Forum> _forums;

	public SuperAdmin(String name, String username, String password, String email) {
		super(name, username, password, email);
		_forums =  new Vector<Forum>();
	}

	public Vector<Forum> getForums() {
		return _forums;
	}

	public void addForum(Forum newForum) {
		if(!_forums.contains(newForum)){
			_forums.add(newForum);
			Control.actionsLogger.info("SuperAdmin: " + _userID + " created new Forum: " + newForum.getName());
		}
		Control.errorsLogger.info("SuperAdmin:" + _userID + " Failed to create Forum");	

	}

	public void removeForum(Forum forumToRemove) {
		if(_forums.contains(forumToRemove)){
			Control.actionsLogger.info("SuperAdmin: " + _userID + " deleated Forum: " + forumToRemove.getName());
			_forums.remove(forumToRemove);	
		}
		else{
			Control.errorsLogger.info("SuperAdmin:" + _userID + " Failed to Delete Forum");	
		}
	}

}
