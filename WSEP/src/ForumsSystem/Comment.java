package ForumsSystem;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

public class Comment {
	
	private int userId;
	private int commentId;
	private int discussionId;
	private String title;
	private String content;
	private String publishDate;
	private Comment referredToComment;
	private Vector<Comment> repliedCommentsVec;
	
	public Comment(int userId, int discussionId, String title, String content, Comment referredToComment) {
		this.userId = userId; 
		this.setCommentId(Control.globalID);
		Control.globalID++;
		this.discussionId = discussionId;
		this.setTitle(title);
		this.setContent(content);
				
		// initializes publish date with the current date.
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		this.setPublishDate(dateFormat.format(date));
				
		this.setReferredToComment(referredToComment);
		this.repliedCommentsVec = new Vector<Comment>();
	}
	
	private void setCommentId(int globalID) {
		commentId = globalID;
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

	public void addCommentToRepliedComments(Comment repliedComment) {
		this.repliedCommentsVec.add(repliedComment);
	}
	
	public void deleteComment() {
		// Remove Comment + related comments in the GUI.
	}

	public int getDiscussionId() {
		return discussionId;
	}
	
	public int getCommentId() {
		return commentId;
	}
}
