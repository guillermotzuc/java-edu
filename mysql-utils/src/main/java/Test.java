import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {

	public static void main(String[] args) {

		String sqlSelectAllPersons = "SELECT '';";
		String connectionUrl = "jdbc:mysql://localhost:3306/demo";

		try (Connection conn = DriverManager.getConnection(connectionUrl, "root", "12345678"); 
		        PreparedStatement ps = conn.prepareStatement(sqlSelectAllPersons); 
		        ResultSet rs = ps.executeQuery()) {
//
			System.out.println("..........");
//		        while (rs.next()) {
//		            long id = rs.getLong("ID");
//		            String name = rs.getString("FIRST_NAME");
//		            String lastName = rs.getString("LAST_NAME");
//
//		            // do something with the extracted data...
//		        }
		} catch (SQLException e) {
		    // handle the exception
			e.printStackTrace();
		}
	}
}
