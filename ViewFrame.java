import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ViewFrame extends JFrame {
    Container c;
    TextArea taData;
    JButton btnBack;

    ViewFrame() {
        c = getContentPane();
        c.setLayout(new FlowLayout());

        taData = new TextArea(20, 30);
        btnBack = new JButton("Back");

        c.add(taData);
        c.add(btnBack);

        ActionListener a1 = (ae) -> {
            MainFrame b = new MainFrame();
            dispose();
        };
        btnBack.addActionListener(a1);

        String data = DbHandler.viewStudent();
        taData.setText(data);

        setTitle("View Student");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}