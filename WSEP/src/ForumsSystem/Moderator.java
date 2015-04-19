package ForumsSystem;

public class Moderator extends SignedMember {
	
	public Moderator(String name, String username, String password, String email) {
		super(name, username, password, email);
	}

	public boolean equals(Moderator moderator) {
		return (this._userID == moderator.getUserId());
	}

	private int getUserId() {
		return this._userID;
	}
	
}
