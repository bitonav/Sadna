package ForumsSystem;

public class Discussion {
	
	private int discussionId;
	private Comment headerComment;
	private int userId;
	
	
	public Discussion(int userId, String title, String content) {
		this.headerComment = new Comment(userId, discussionId, title, content, null);
	}

	public Comment getHeaderComment() {
		return headerComment;
	}

	public void setHeaderComment(Comment headerComment) {
		this.headerComment = headerComment;
	}

	public int getUserId() {
		return userId;
	}

	public int getDiscussionId() {
		return discussionId;
	}

	public boolean equals(Discussion discussion) {
		return (this.discussionId == discussion.getDiscussionId());
	}
}
