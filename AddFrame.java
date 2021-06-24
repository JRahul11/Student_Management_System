import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class AddFrame extends JFrame {
	Container c;
	JLabel lblSid, lblSname, lblSub1, lblSub2, lblSub3;
	JTextField txtSid, txtSname, txtSub1, txtSub2, txtSub3;
	JButton btnSave, btnBack;

	AddFrame() {
		c = getContentPane();
		c.setLayout(new FlowLayout());

		lblSid = new JLabel("Enter Roll No: ");
		txtSid = new JTextField(24);
		lblSname = new JLabel("Enter Name: ");
		txtSname = new JTextField(24);
		lblSub1 = new JLabel("Enter Subject1 Marks: ");
		txtSub1 = new JTextField(24);
		lblSub2 = new JLabel("Enter Subject2 Marks: ");
		txtSub2 = new JTextField(24);
		lblSub3 = new JLabel("Enter Subject3 Marks: ");
		txtSub3 = new JTextField(24);
		btnSave = new JButton("Save");
		btnBack = new JButton("Back");

		c.add(lblSid);
		c.add(txtSid);
		c.add(lblSname);
		c.add(txtSname);
		c.add(lblSub1);
		c.add(txtSub1);
		c.add(lblSub2);
		c.add(txtSub2);
		c.add(lblSub3);
		c.add(txtSub3);
		c.add(btnSave);
		c.add(btnBack);

		ActionListener a1 = (ae) -> {
			MainFrame a = new MainFrame();
			dispose();
		};
		btnBack.addActionListener(a1);

		ActionListener a2 = (ae) -> {
			int sid = Integer.parseInt(txtSid.getText());
			String sname = txtSname.getText();
			int sub1 = Integer.parseInt(txtSub1.getText());
			int sub2 = Integer.parseInt(txtSub2.getText());
			int sub3 = Integer.parseInt(txtSub3.getText());
			DbHandler db = new DbHandler();
			db.addStudent(sid, sname, sub1, sub2, sub3);
		};
		btnSave.addActionListener(a2);

		setTitle("Add Student");
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}