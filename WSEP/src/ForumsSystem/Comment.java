package ForumsSystem;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

public class Comment {
	
	private int userId;
	private int threadId;
	private String title;
	private String content;
	private String publishDate;
	private Comment referredToComment;
	private Vector<Comment> repliedCommentsVec;
	
	public Comment(int threadId, String title, String content, Comment referredToComment) {
		this.setUserId(Control.globalID);
		Control.globalID++;
		this.threadId = threadId;
		this.setTitle(title);
		this.setContent(content);
				
		// initializes publish date with the current date.
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		this.setPublishDate(dateFormat.format(date));
				
		this.setReferredToComment(referredToComment);
		this.setRepliedCommentsVec(new Vector<Comment>());
	}
	
	// Copy constructor
	public Comment(Comment other) {
		this.userId = other.getUserId();
		this.title = other.getTitle();
		this.content = other.getContent();
		this.publishDate = other.getPublishDate();
		this.referredToComment = new Comment(getReferredToComment());
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	public Comment getReferredToComment() {
		return referredToComment;
	}

	public void setReferredToComment(Comment referredToComment) {
		this.referredToComment = referredToComment;
	}

	public Vector<Comment> getRepliedCommentsVec() {
		return repliedCommentsVec;
	}

	public void setRepliedCommentsVec(Vector<Comment> repliedCommentsVec) {
		this.repliedCommentsVec = repliedCommentsVec;
	}
	
	public void deleteComment() {
		// Remove Comment + related comments in the GUI.
	}

	public int getThreadId() {
		return threadId;
	}

}
