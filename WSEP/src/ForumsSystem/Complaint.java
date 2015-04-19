package ForumsSystem;

public class Complaint {

	private String content;
	private int moderatorID;
	private int complainantID;
	private int complaintID;
	
	public Complaint(String content, int moderatorID, int complainantID) {
		this.setComplaintID(Control.globalID);
		Control.globalID++;
		this.setContent(content);
		this.setModeratorID(moderatorID);
		this.setComplainantID(complainantID);
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getModeratorID() {
		return moderatorID;
	}

	public void setModeratorID(int moderatorID) {
		this.moderatorID = moderatorID;
	}

	public int getComplainantID() {
		return complainantID;
	}

	public void setComplainantID(int complainantID) {
		this.complainantID = complainantID;
	}

	public int getComplaintID() {
		return complaintID;
	}

	public void setComplaintID(int complaintID) {
		this.complaintID = complaintID;
	}

}
