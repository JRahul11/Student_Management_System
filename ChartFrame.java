import javax.swing.*;
import org.jfree.data.category.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import java.io.*;
import java.sql.*;
import java.awt.*;

class ChartFrame extends JFrame {
    ChartFrame() {
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "abc123");

            String sql = "select * from sms";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            DefaultCategoryDataset ds = new DefaultCategoryDataset();
            while (rs.next()) {
                ds.addValue(rs.getInt(3), rs.getString(2), "Subject1");
                ds.addValue(rs.getInt(4), rs.getString(2), "Subject2");
                ds.addValue(rs.getInt(5), rs.getString(2), "Subject3");
            }

            JFreeChart ch = ChartFactory.createBarChart("Student Performance", "Subject", "Marks", ds,
                    PlotOrientation.VERTICAL, true, true, true);

            ChartPanel cp = new ChartPanel(ch);
            setContentPane(cp);

            setSize(400, 400);
            setLocationRelativeTo(null);
            setTitle("Mark Sheet");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
        } catch (SQLException e) {
            System.out.println("Issue: " + e);
        }
    }
}
