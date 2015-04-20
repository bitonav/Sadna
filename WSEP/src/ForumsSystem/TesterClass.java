package ForumsSystem;

public class TesterClass {
	public static void main(String[] args){
//		Control c = Control.getInstance();
//		SignedMember s = new SignedMember("Ran", "ranUsername", "12345", "zitaiat@post.bgu.ac.il");
//		c.sendEmailConfirmation(s.getEmail());
//		c.addNewUserToDatabase(s);
		
		Guest g = new Guest();
		System.out.println(g.Register("Ran", "ran17", "123456789", "zitaiat@post.bgu.ac.il"));
		System.out.println(g.Register("Itamar", "itamar", "123456789", "zitaiat@post.bgu.ac.il"));

	}

}
