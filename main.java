package comp3005A3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class main {
	
	//Retrieves and displays all records from the students table.
	public static void getAllStudents(Connection con) throws SQLException{
		Statement statement = con.createStatement();
	    String query = "SELECT * FROM students";
	    ResultSet rs = statement.executeQuery(query);

	    while (rs.next()) {
	        int studentId = rs.getInt("student_id");
	        String firstName = rs.getString("first_name");
	        String lastName = rs.getString("last_name");
	        String email = rs.getString("email");
	        String enrollmentDate = rs.getString("enrollment_date");

	        System.out.println("Student ID: " + studentId + ", First Name: " + firstName + ", Last Name: " + lastName + ", Email: " + email + ", Enrollment Date: " + enrollmentDate);
	    }
	}
	
	//Inserts a new student record into the students table.
	public static void addStudent(Connection con ,String first_name, String last_name, String email, String enrollment_date) throws SQLException{
		 String query = "INSERT INTO students (first_name, last_name, email, enrollment_date) VALUES " + "('" + first_name + "', '" + last_name + "', '" + email + "', '" + enrollment_date + "')";
		 Statement statement = con.createStatement();
		 statement.executeUpdate(query);
	}
	
	//Updates the email address for a student with the specified student_id.
	public static void updateStudentEmail(Connection con, int student_id, String new_email) throws SQLException {
		String query = "UPDATE students SET email = '" + new_email + "' WHERE student_id = " + student_id;
		Statement statement = con.createStatement();
		statement.executeUpdate(query);
	}
	
	
	//Deletes the record of the student with the specified student_id.
	public static void deleteStudent(Connection con, int student_id) throws SQLException {
		String query = "DELETE FROM students WHERE student_id = " + student_id;
	    Statement statement = con.createStatement();
	    statement.executeUpdate(query);
	}
	
	//function given in lecture 11
	//used help from example video in week 11
    public static void main(String[] args) {
        // JDBC & Database credentials
        String url = "jdbc:postgresql://localhost:5432/A3Q1";
        String user = "postgres";  
        String password = "postgres";  
        
        try {
            Class.forName("org.postgresql.Driver");
            // Connect to the database
            Connection con = DriverManager.getConnection(url, user, password);
            if (con != null) {
                System.out.println("Connected to PostgreSQL successfully!");
                //getAllStudents(con);
                //addStudent(con, "Bob", "Ross", "ross.bob@example.com", "2023-09-03");
                //updateStudentEmail(con, 4, "bob.ross@example.com");
                //deleteStudent(con, 4);
            } else {
                System.out.println("Failed to establish connection.");
            }
            con.close();
        } 
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}