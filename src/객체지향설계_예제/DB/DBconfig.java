package 객체지향설계_예제.DB;

public class DBconfig {
	
	// jdbc driver
	private String jdbcDriver = "com.mysql.cj.jdbc.Driver";
	private String jdbcUrl = "jdbc:mysql://localhost:3306/javadb?characterEncoding=UTF-8&serverTimezone=UTC";
	
	// DB connection Name and Password
	private String dbName, dbPass;
	
	public String getJdbcDriver() {
		return jdbcDriver;
	}

	public String getJdbcUrl() {
		return jdbcUrl;
	}

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