import javax.swing.*;
import java.sql.*;

class DbHandler {
	public static void addStudent(int sid, String sname, int sub1, int sub2, int sub3) {
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "abc123");

			String sql = "insert into sms values(?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, sid);
			pst.setString(2, sname);
			pst.setInt(3, sub1);
			pst.setInt(4, sub2);
			pst.setInt(5, sub3);
			pst.executeUpdate();
			JOptionPane.showMessageDialog(new JDialog(), "Record Added");
			con.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(new JDialog(), "Issue " + e);
		}
	}

	public static String viewStudent() {
		String data = "";
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "abc123");

			String sql = "select * from sms";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				data = data + "Id: " + rs.getInt(1) + " Name: " + rs.getString(2) + "  Sub1: " + rs.getInt(3)
						+ "  Sub2: " + rs.getInt(4) + "  Sub3: " + rs.getInt(5) + "\n";
			}
			con.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(new JDialog(), "Issue " + e);
		}

		return data;
	}

	public static void updateStudent(int sid, String sname, int sub1, int sub2, int sub3) {
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "abc123");

			String sql = "update sms set sname = ?, sub1 = ?, sub2 = ?, sub3 = ? where sid = ? ";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, sname);
			pst.setInt(2, sub1);
			pst.setInt(3, sub2);
			pst.setInt(4, sub3);
			pst.setInt(5, sid);
			pst.executeUpdate();
			JOptionPane.showMessageDialog(new JDialog(), "Record Updated");
			con.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(new JDialog(), "Issue " + e);
		}
	}

	public static void deleteStudent(int sid) {
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "abc123");

			String sql = "delete from sms where sid = ? ";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, sid);
			pst.executeUpdate();
			JOptionPane.showMessageDialog(new JDialog(), "Record Deleted");
			con.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(new JDialog(), "Issue " + e);
		}
	}
}