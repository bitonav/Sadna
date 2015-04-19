package ForumsSystem;

public class Thread {
	
	private int threadId;
	private Comment headerComment;
	private int userId;
	private String title;
	private String content;
	
	
	public Thread(int userId, String title, String content) {
		this.headerComment = new Comment(userId, title, content, null);
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
		headerComment.setTitle(title);
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
		headerComment.setContent(content);
	}

	public int getThreadId() {
		return threadId;
	}

	public boolean equals(Thread thread) {
		return (this.threadId == thread.getThreadId());
	}
}
