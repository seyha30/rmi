import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @author sseyha
 * @date 9 តុលា 2022 9:21:37 PM
 *
 */
public class StudentRepository {
	public static int save(Student student) {

		int iRet = -1;
		try {
			Connection con = DBManager.getInstance().getConnection();
			String SQL = "INSERT INTO Student(name,dob,course) Values(?,?,?)";
			PreparedStatement preparedStatement = con.prepareStatement(SQL);
			preparedStatement.setString(1, student.getName());
			preparedStatement.setString(2, student.getDateOfBirth());
			preparedStatement.setString(3, student.getCourse());
			iRet = preparedStatement.executeUpdate();
			preparedStatement.close();
			con.close();
		} catch (SQLException se) {
			System.out.println(se);
		}

		return iRet;

	}

	public static int update(Student student) {
		int iRet = -1;
		try {
			Connection con = DBManager.getInstance().getConnection();
			String SQL = "UPDATE student SET name=?, dob=? ,course WHERE Id=?";
			PreparedStatement preparedStatement = con.prepareStatement(SQL);
			preparedStatement.setString(1, student.getName());
			preparedStatement.setString(2, student.getDateOfBirth());
			preparedStatement.setString(3, student.getCourse());

			iRet = preparedStatement.executeUpdate();

			preparedStatement.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return iRet;
	}

	public static int deleteAll() {
		int iRet = -1;
		try {
			Connection con = DBManager.getInstance().getConnection();
			String SQL = "DELETE FROM student;";
			PreparedStatement preparedStatement = con.prepareStatement(SQL);

			iRet = preparedStatement.executeUpdate();

			preparedStatement.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return iRet;
	}

	public static ArrayList<Student> findAll() {
		ArrayList<Student> students = new ArrayList<Student>();

		try {
			String QRY = "SELECT * FROM student ORDER BY Id";
			Connection con = DBManager.getInstance().getConnection();
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(QRY);

			while (resultSet.next()) {
				Student student = new Student();
				student.setId(resultSet.getInt("Id"));
				student.setDateOfBirth(resultSet.getString("dob"));
				student.setName(resultSet.getString("course"));
				students.add(student);
			}

			statement.close();
			con.close();
		} catch (SQLException se) {
			System.out.println(se);
		}
		return students;
	}

	public static ArrayList<Student> findByName(String name) {
		ArrayList<Student> students = new ArrayList<Student>();

		try {
			String QRY = "SELECT * FROM Student WHERE name LIKE(?) ORDER BY id";
			Connection con = DBManager.getInstance().getConnection();
			PreparedStatement preparedStatement = con.prepareStatement(QRY);
			preparedStatement.setString(1, "%" + name + "%");
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Student student = new Student();
				student.setId(resultSet.getInt("Id"));
				student.setName(resultSet.getString("name"));
				student.setDateOfBirth(resultSet.getString("dob"));
				student.setCourse(resultSet.getString("course"));
				students.add(student);
			}

			preparedStatement.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return students;
	}
}
