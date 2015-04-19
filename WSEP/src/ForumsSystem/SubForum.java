package ForumsSystem;

import java.util.Vector;

public class SubForum {
	
	private int subForumId;
	private String name;
	private Vector<Moderator> subForumModerators;
	private Vector<Thread> subForumThreads;
	private Forum forum;
	
	
	public SubForum(String name, Forum forum) {
		this.subForumId = Control.globalID;
		Control.globalID++;
		this.name = name;
		this.forum = forum;
		subForumModerators = new Vector<Moderator>();
		subForumThreads = new Vector<Thread>();
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getSubForumId() {
		return subForumId;
	}


	public void setSubForumId(int subForumId) {
		this.subForumId = subForumId;
	}

	public Forum getForum() {
		return forum;
	}


	public void setForum(Forum forum) {
		this.forum = forum;
	}


	public Vector<Moderator> getSubForumModerators() {
		return subForumModerators;
	}


	public void addSubForumModerator(Moderator moderator) {
		subForumModerators.addElement(moderator);
	}


	public Vector<Thread> getSubForumThreads() {
		return subForumThreads;
	}


	public void addSubForumThread(Thread thread) {
		subForumThreads.addElement(thread);
	}
	
	public void removeSubForumThread(Thread thread) {
		for (int i=0; i<subForumThreads.size(); i++) 
			if (subForumThreads.elementAt(i).equals(thread))
				subForumThreads.removeElementAt(i);
	}
	
	public void removeSubForumModerator(Moderator moderator) {
		for (int i=0; i<subForumModerators.size(); i++) 
			if (subForumModerators.elementAt(i).equals(moderator))
				subForumModerators.removeElementAt(i);
	}

}
