package ForumsSystem;

import java.util.Vector;

public class SuperAdmin extends ForumManager {

	private static SuperAdmin sa = null;
	private Vector<Forum> _forums;

	private SuperAdmin(String name, String username, String password, String email) {
		super(name, username, password, email);
		_forums =  new Vector<Forum>();
	}

	public static synchronized void createSuperAdmin(String name, String username, String password, String email) {
		if(sa == null)
			sa = new SuperAdmin(name, username, password, email);
	} // createSuperAdmin
	
	public static SuperAdmin getInstance(){
		return sa;
	} // getInstance
	
	public Vector<Forum> getForums() {
		return _forums;
	}

	public void addForum(Forum newForum) {
		if(!_forums.contains(newForum)){
			_forums.add(newForum);
			Control.actionsLogger.info("SuperAdmin: " + _userID + " created new Forum: " + newForum.getName());
		} // if
		else{
			Control.errorsLogger.info("SuperAdmin:" + _userID + " Failed to create Forum");	
		} // else
	} // addForum
	
	public void addUserRank(String rankName, int minimalSeniority, int minimalLoggedInTime, int minimalPostsLastYear){
		Control.getInstance().addUserRank(new UserRank(rankName, minimalSeniority, minimalLoggedInTime, minimalPostsLastYear));
	} // addUserRank
	
	public void removeUserRank(String rankName){
		Control.getInstance().removeUserRank(rankName);
	} // removeUserRank
	
	public int getNumOfUserRanks(){
		return Control.getInstance().getNumOfUserRanks();
	} // getNumOfUserRanks

	public void removeForum(Forum forumToRemove) {
		if(_forums.contains(forumToRemove)){
			Control.actionsLogger.info("SuperAdmin: " + _userID + " deleted Forum: " + forumToRemove.getName());
			_forums.remove(forumToRemove);	
		}
		else{
			Control.errorsLogger.info("SuperAdmin:" + _userID + " Failed to Delete Forum");	
		} // else
	} // removeForum

} // Class SuperAdmin
