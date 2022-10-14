import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * @author sseyha
 * @date 9 តុលា 2022
 */
public class DBManager {
	private static DBManager _instance;

	private Connection _connection;

	public DBManager() {
		_connection = getSQLiteConnection();
	}

	public static DBManager getInstance() {
		try {
			if (_instance == null) {
				_instance = new DBManager();
				System.out.println("DBManager.getInstance() is initialized");
			} else if (_instance.getConnection().isClosed()) {
				_instance = new DBManager();
			}
			return _instance;
		} catch (SQLException se) {
			System.out.println(se);
			return null;
		}
	}

	public Connection getConnection() {
		return _connection;
	}

	public static Connection getSQLServerConnection() {
		Connection con = null;

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			String URL = "jdbc:sqlserver://localhost;databaseName=test;user=sa;password=;";
			con = DriverManager.getConnection(URL);
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}

	public static Connection getMySQLConnection() {
		Connection con = null;

		try {

			String strCon = "jdbc:mysql://127.0.0.1/test?user=admin&password=admin";
			con = DriverManager.getConnection(strCon);
		} catch (SQLException se) {
			System.out.println(se);
		}
		return con;
	}

	public static Connection getMsAccessConnection() {
		Connection con = null;
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

			String filename = "D:/Working/NID_DB/";
			filename += "test.mdb";
			String URL = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=";
			URL += filename + ";}";

			con = DriverManager.getConnection(URL);

		} catch (Exception se) {
			System.out.println(se);
		}

		return con;
	}
	public static Connection getSQLiteConnection() {
		Connection con = null;
		try {
			String url = "jdbc:sqlite:province.db";
			con = DriverManager.getConnection(url);
		} catch (Exception se) {
			System.out.println(se);
		}
		return con;
	}

}
