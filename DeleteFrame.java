import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class DeleteFrame extends JFrame {
    Container c;
    JLabel lblSid;
    JTextField txtSid;
    JButton btnSave, btnBack;

    DeleteFrame() {
        c = getContentPane();
        c.setLayout(new FlowLayout());

        lblSid = new JLabel("Enter Roll No to be deleted: ");
        txtSid = new JTextField(24);
        btnSave = new JButton("Save");
        btnBack = new JButton("Back");

        c.add(lblSid);
        c.add(txtSid);
        c.add(btnSave);
        c.add(btnBack);

        ActionListener a1 = (ae) -> {
            MainFrame d = new MainFrame();
            dispose();
        };
        btnBack.addActionListener(a1);

        ActionListener a2 = (ae) -> {
            int sid = Integer.parseInt(txtSid.getText());
            DbHandler db = new DbHandler();
            db.deleteStudent(sid);
        };
        btnSave.addActionListener(a2);

        setTitle("Delete Student");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
