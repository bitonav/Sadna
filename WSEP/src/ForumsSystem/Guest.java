package ForumsSystem;

public class Guest extends User{

	public Guest() {
		super();
	} // Constructor
	
	
	public boolean Register(String name, String username, String password, String email){
		if(validateRegisterationFields(name, username, password, email)){
			Control.getInstance().addNewUserToDatabase(new SignedMember(name, username, password, email));
			return true;
		} // if
		return false;
	} // Register

	private boolean validateRegisterationFields(String name, String username, String password, String email) {
		boolean ans = true;
		// TODO
		// use REGGEX to validate the fields
		if(Control.getInstance().isUsernameExist(username))
			ans = false;
		return ans;
	} // validateRegisterationFields
	
	public boolean Login(String username, String password){
		if(Control.getInstance().userAuthentication(username, password)){
			if (Control.getInstance().checkIfBanned(username)){ /**********************/
				/*TODO - BAN MESSAGE */
				return false;
			}
			else{
				Control.getInstance().loginUser(username);
			}
			return true;
		} // if
		return false;
	} // Login

}
