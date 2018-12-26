package 객체지향설계_예제.DB;

public class DBconfig {
	private String dbName, dbPass;
	
	public DBconfig() {
		this.dbName = "root";
		this.dbPass = "123456789";
	}
	
	public String getdbName() {
		return this.dbName;
	}
	
	public String getdbPass() {
		return this.dbPass;
	}
	
}