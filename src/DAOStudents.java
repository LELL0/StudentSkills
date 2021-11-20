import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;

//Author
//Elia El Khoury
//201910274

public class DAOStudents {
	private static DAOStudents DAOstudent = new DAOStudents();

	Connection connection = DAO.getConnection();
	private PreparedStatement psGetallStudents = null;
	private PreparedStatement psInsertStudent = null;
	private PreparedStatement psDeleteStudent = null;
	private PreparedStatement psGetMaxId = null;
	private PreparedStatement psUpdateStudent = null;
	private PreparedStatement psLastStudentId = null;

	public static DAOStudents getDAOStudent() {
		return DAOstudent;
	}

	private DAOStudents() {

		try {
			psInsertStudent = connection.prepareStatement("insert into Student values(?,?,?,?,?,?)");
			psDeleteStudent = connection.prepareStatement("delete FROM STUDENT WHERE id = ?");
			psUpdateStudent = connection.prepareStatement(
					"Update Student SET name=? , address = ? , gender = ? , knowledge = ? , subject = ? WHERE id = ? ");
			psGetallStudents = connection.prepareStatement("Select * from Student", ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			psGetMaxId = connection.prepareStatement("SELECT MAX(id) FROM Student ORDER by id");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public int getMaxId() {
		ResultSet rs;
		int maxId = 0;
		try {
			rs = psGetMaxId.executeQuery();
			rs.next();
			maxId = rs.getInt(1);
			// System.out.println("max ID: " + maxId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return maxId;
	}

	public ArrayList<Student> getAllStudents() {
		ArrayList<Student> studentData = new ArrayList<Student>();

		try {
			ResultSet rs = psGetallStudents.executeQuery();
			while (rs.next()) {
				studentData.add(new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6)));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return studentData;
	}

	public void DeleteStudent(int id) {

		try {
			// System.out.println(id);
			psDeleteStudent.setInt(1, id);
			psDeleteStudent.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void updateStudent(Student stu) {

		try {

//			System.out.println(stu.getId());
//			System.out.println(stu.getName());
//			System.out.println(stu.getAddress());
//			System.out.println(stu.getGender());
//			System.out.println(stu.getKnowledge());
//			System.out.println(stu.getSubject());

			psUpdateStudent.setString(1, stu.getName());
			psUpdateStudent.setString(2, stu.getAddress());
			psUpdateStudent.setString(3, stu.getGender());
			psUpdateStudent.setString(4, stu.getKnowledge());
			psUpdateStudent.setString(5, stu.getSubject());
			psUpdateStudent.setInt(6, stu.getId());
			// System.out.println(psUpdateStudent);
			psUpdateStudent.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void insertStudent(Student stu) {

		try {
//			psInsertStudent.setInt(1, 0);
//			psInsertStudent.setString(2, data.get("name"));
//			psInsertStudent.setString(3, data.get("address"));
//			psInsertStudent.setString(4, data.get("gender"));
//			psInsertStudent.setString(5, data.get("knowledge"));
//			psInsertStudent.setString(6, data.get("subject"));

//			System.out.println(stu.getId());
//			System.out.println(stu.getName());
//			System.out.println(stu.getAddress());
//			System.out.println(stu.getGender());
//			System.out.println(stu.getKnowledge());
//			System.out.println(stu.getSubject());

			psInsertStudent.setInt(1, stu.getId());
			psInsertStudent.setString(2, stu.getName());
			psInsertStudent.setString(3, stu.getAddress());
			psInsertStudent.setString(4, stu.getGender());
			psInsertStudent.setString(5, stu.getKnowledge());
			psInsertStudent.setString(6, stu.getSubject());
			psInsertStudent.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
