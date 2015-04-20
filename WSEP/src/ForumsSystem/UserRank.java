package ForumsSystem;

public class UserRank {

	private String _name;
	private int _minimalSeniority;
	private int _minimalLoggedInTime;
	private int _minimalPostsLastYear;
	
	public UserRank(String rankName, int minimalSeniority, int minimalLoggedInTime, int minimalPostsLastYear){
		this.setName(rankName);
		this.setMinimalSeniority(minimalSeniority);
		this.setMinimalLoggedInTime(minimalLoggedInTime);
		this.setMinimalPostsLastYear(minimalPostsLastYear);
	} // Constructor

	public String getName() {
		return _name;
	} // getName

	public void setName(String _name) {
		this._name = _name;
	} // setName
	
	public boolean equals(UserRank ur){
		return this._name.equals(ur.getName());
	} // equals

	public int getMinimalSeniority() {
		return _minimalSeniority;
	}

	public void setMinimalSeniority(int _minimalSeniority) {
		this._minimalSeniority = _minimalSeniority;
	}

	public int getMinimalLoggedInTime() {
		return _minimalLoggedInTime;
	}

	public void setMinimalLoggedInTime(int _minimalLoggedInTime) {
		this._minimalLoggedInTime = _minimalLoggedInTime;
	}

	public int getMinimalPostsLastYear() {
		return _minimalPostsLastYear;
	}

	public void setMinimalPostsLastYear(int _minimalPostsLastYear) {
		this._minimalPostsLastYear = _minimalPostsLastYear;
	}
	
} // Class userRank
