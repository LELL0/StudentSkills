import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

//Author
//Elia El Khoury
//201910274

public class DAO {
	private static Connection connection = null;

	public static Connection getConnection() {

		if (connection != null)
			return connection;

		try {
			// FOR ORACLE
			// Class.forName("oracle.jdbc.driver.OracleDriver");
			// connection =
			// DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:LELL0",
			// "SYSTEM", "password");

			// FOR MYSQL
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentSkillsDB", "root", "password");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return connection;

	}

	public static void close() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			connection = null;
		}
	}

}
