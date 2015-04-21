package ForumsSystem;

public class Moderator extends SignedMember {
	
	public Moderator(String name, String username, String password, String email) {
		super(name, username, password, email);
	}

	public boolean equals(Moderator moderator) {
		return (this._userID == moderator._userID);
	}

	public void banMember(SignedMember sm){
		sm.changeStatus(UserStatus.BANNED);
		Control.getInstance().addBanForumMember(sm);
	}
	
	public void unBanMember(SignedMember sm){
		sm.changeStatus(UserStatus.ACTIVE);
		Control.getInstance().removeBanForumMember(sm);
	}
	
	
}
