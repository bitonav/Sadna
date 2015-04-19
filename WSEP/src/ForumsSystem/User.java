package ForumsSystem;

public abstract class User {

	protected int _userID;

	public User() {
		_userID = Control.globalID;
		Control.globalID++;
	}
	
	public int getUserID(){
		return _userID;
	} // getUserID


}
