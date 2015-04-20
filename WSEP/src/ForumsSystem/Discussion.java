package ForumsSystem;

public class Discussion {
	
	private int _DiscussionID;
	private Comment _HeaderComment;
	private int _UserID;
	
	
	public Discussion(int userId, String title, String content) {
		this._HeaderComment = new Comment(userId, _DiscussionID, title, content, null);
	}

	public Comment getHeaderComment() {
		return _HeaderComment;
	}

	public void setHeaderComment(Comment headerComment) {
		this._HeaderComment = headerComment;
	}

	public int getUserId() {
		return _UserID;
	}

	public int getDiscussionId() {
		return _DiscussionID;
	}

	public boolean equals(Discussion discussion) {
		return (this._DiscussionID == discussion.getDiscussionId());
	}
}
