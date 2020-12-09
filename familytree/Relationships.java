package familytree;

public class Relationships {

	private String Name1;
	private String FamilyName1;
	private String Name2;
	private String FamilyName2;
	private String Relationship;
	private int Year;
	
	public Relationships() {
	}
	
	public Relationships(String Name1, String FamilyName1, String Name2, String FamilyName2, String Relationship, int Year) {
		this.Name1 = Name1;
		this.FamilyName1 = FamilyName1;
		this.Name2 = Name2;
		this.FamilyName2 = FamilyName2;
		this.Relationship = Relationship;
		this.Year = Year;
	}
	
	public void setName1(String Name1) {
		this.Name1 = Name1;
	}
	
	public void setFamilyName1(String FamilyName1) {
		this.FamilyName1 = FamilyName1;
	}
	
	public void setName2(String Name2) {
		this.Name2 = Name2;
	}
	
	public void setFamilyName2(String FamilyName2) {
		this.FamilyName2 = FamilyName2;
	}
	
	public void setRelationship(String Relationship) {
		this.Relationship = Relationship;
	}
	
	public void setYear(int Year) {
		this.Year = Year;
	}
	
	public String getName1() {
		return Name1;
	}
	
	public String getFamilyName1() {
		return FamilyName1;
	}
	
	public String getName2() {
		return Name2;
	}
	
	public String getFamilyName2() {
		return FamilyName2;
	}
	
	public String getRelationship() {
		return Relationship;
	}
	
	public int getYear() {
		return Year;
	}
}
