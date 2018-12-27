package MVCpatten.model;

public class ProductDBconfig {

	// jdbc driver
	private String jdbcDriver = "com.mysql.cj.jdbc.Driver";
	private String jdbcUrl = "jdbc:mysql://localhost:3306/javadb?characterEncoding=UTF-8&serverTimezone=UTC";
	private String oldjdbcUrl = "jdbc:mysql://localhost:3306/javadb";


	// DB connection Name and Password
	private String dbName, dbPass;
	
	// 생성자
	public ProductDBconfig() {
		this.dbName = "root";
		this.dbPass = "45812qlgks!#";
	}
	
	// Getter
	public String getJdbcDriver() {
		return jdbcDriver;
	}

	public String getJdbcUrl() {
		return jdbcUrl;
	}

	public String getdbName() {
		return this.dbName;
	}
	
	public String getdbPass() {
		return this.dbPass;
	}
	
}
