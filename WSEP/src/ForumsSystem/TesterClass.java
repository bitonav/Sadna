package ForumsSystem;

public class TesterClass {
	public static void main(String[] args){
		Control c = new Control();
		SignedMember s = new SignedMember("Ran", "ranUsername", "12345", "zitaiat@post.bgu.ac.il");
		c.sendEmailConfirmation(s.getEmail());
		c.addNewUserToDatabase(s);

	}

}
