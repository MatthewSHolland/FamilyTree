package familytree;

public class Family {
	private String FamilyName;
	private String FirstName;
	private String BirthPlace;
	private int DeathYear;
	private int BirthYear;
	
	
	public Family() {
	}
	public Family(String FamilyName, String FirstName, String BirthPlace, int BirthYear, int DeathYear) {
		this.FamilyName = FamilyName;
		this.FirstName = FirstName;
		this.BirthPlace = BirthPlace;
		this.BirthYear = BirthYear;
		this.DeathYear = DeathYear;
		
	}
	
	public void setFamilyName(String FamilyName) {
		this.FamilyName = FamilyName;
	}
	
	public void setFirstName(String FirstName) {
		this.FirstName = FirstName;
	}
	
	public void setBirthPlace(String BirthPlace) {
		this.BirthPlace = BirthPlace;
	}
	
	public void setBirthYear(int BirthYear) {
		this.BirthYear = BirthYear;
	}
	
	public void setDeathYear (int DeathYear) {
		this.DeathYear = DeathYear;
	}
	
	public String getFamilyName() {
		return FamilyName;
	}
	
	public String getFirstName() {
		return FirstName;
	}
	
	public String getBirthPlace() {
		return BirthPlace;
	}
	
	public int getBirthYear() {
		return BirthYear;
	}
	
	public int getDeathYear() {
		return DeathYear;
	}
}

