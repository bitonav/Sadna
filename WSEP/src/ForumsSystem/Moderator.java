package ForumsSystem;

public class Moderator extends SignedMember {
	
	public Moderator(int userId) {
		super(userId);

	}

	public boolean equals(Moderator moderator) {
		return (this.userId == moderator.getUserId());
	}

	private int getUserId() {
		return this.userId;
	}
	
}
