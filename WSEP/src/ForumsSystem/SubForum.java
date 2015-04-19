package ForumsSystem;

import java.util.Vector;

public class SubForum {
	
	private int subForumId;
	private String name;
	private Vector<Moderator> subForumModerators;
	private Vector<Discussion> subForumDiscussions;
	private Forum forum;
	
	
	public SubForum(String name, Forum forum) {
		this.subForumId = Control.globalID;
		Control.globalID++;
		this.name = name;
		this.forum = forum;
		subForumModerators = new Vector<Moderator>();
		subForumDiscussions = new Vector<Discussion>();
		forum.addSubForum(this);
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


	public Vector<Discussion> getSubForumDiscussion() {
		return subForumDiscussions;
	}


	public void addSubForumDiscussion(Discussion discussion) {
		subForumDiscussions.addElement(discussion);
	}
	
	public void removeSubForumDiscussion(Discussion discussion) {
		for (int i=0; i<subForumDiscussions.size(); i++) 
			if (subForumDiscussions.elementAt(i).equals(discussion))
				subForumDiscussions.removeElementAt(i);
	}
	
	public void removeSubForumModerator(Moderator moderator) {
		for (int i=0; i<subForumModerators.size(); i++) 
			if (subForumModerators.elementAt(i).equals(moderator))
				subForumModerators.removeElementAt(i);
	}

}
