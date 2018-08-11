
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Conn {
	public static Connection MyConn() throws ClassNotFoundException {
		Connection con=null;
		Class.forName("com.mysql.jdbc.Driver");
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/DB_Aamir","root","");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

}
