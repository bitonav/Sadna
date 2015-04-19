package ForumsSystem;

import java.util.Vector;

public class Forum {

	private int forumID;
	private String name;
	private Vector<ForumManager> forumManagers;
	private Vector<SubForum> forumSubForums;
	private Vector<Complaint> forumComplaintsOnModerators;
	
	public Forum(String name) {
		this.setForumID(Control.globalID);
		Control.globalID++;
		this.name = name;
		this.forumManagers = new Vector<ForumManager>();
		this.forumSubForums = new Vector<SubForum>();
		this.forumComplaintsOnModerators = new Vector<Complaint>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Vector<ForumManager> getForumManagers() {
		return forumManagers;
	}

	public Vector<SubForum> getForumSubForums() {
		return forumSubForums;
	}

	public void addForumManager(ForumManager fm) {
		forumManagers.addElement(fm);
	}

	public void addSubForum(SubForum sf) {
		forumSubForums.addElement(sf);
	}
	
	public void addComplaint(Complaint c) {
		forumComplaintsOnModerators.addElement(c);
	}
	
	public void removeForumManager(ForumManager fm) {
		for (int i=0; i<forumManagers.size(); i++) 
			if (forumManagers.elementAt(i).equals(fm))
				forumManagers.removeElementAt(i);
	}
	
	public void removeSubForumModerator(SubForum sb) {
		for (int i=0; i<forumSubForums.size(); i++) 
			if (forumSubForums.elementAt(i).equals(sb))
				forumSubForums.removeElementAt(i);
	}
	
	public void removeComplaint(Complaint c) {
		for (int i=0; i<forumComplaintsOnModerators.size(); i++) 
			if (forumComplaintsOnModerators.elementAt(i).equals(c))
				forumComplaintsOnModerators.removeElementAt(i);
	}

	public int getForumID() {
		return forumID;
	}

	public void setForumID(int forumID) {
		this.forumID = forumID;
	}
	
}
