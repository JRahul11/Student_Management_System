import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MainFrame extends JFrame {
    Container c;
    JButton btnAdd, btnView, btnUpdate, btnDelete, btnChart;

    MainFrame() {
        c = getContentPane();
        c.setLayout(new FlowLayout());

        btnAdd = new JButton("Add");
        btnView = new JButton("View");
        btnUpdate = new JButton("Update");
        btnDelete = new JButton("Delete");
        btnChart = new JButton("Chart");

        ActionListener a1 = (ae) -> {
            AddFrame a = new AddFrame();
            dispose();
        };
        btnAdd.addActionListener(a1);

        ActionListener a2 = (ae) -> {
            ViewFrame v = new ViewFrame();
            dispose();
        };
        btnView.addActionListener(a2);

        ActionListener a3 = (ae) -> {
            UpdateFrame u = new UpdateFrame();
            dispose();
        };
        btnAdd.addActionListener(a3);

        ActionListener a4 = (ae) -> {
            DeleteFrame d = new DeleteFrame();
            dispose();
        };
        btnAdd.addActionListener(a4);

        ActionListener a5 = (ae) -> {
            ChartFrame c = new ChartFrame();
        };
        btnChart.addActionListener(a5);

        c.add(btnAdd);
        c.add(btnView);
        c.add(btnUpdate);
        c.add(btnDelete);
        c.add(btnChart);

        setTitle("S.M.S.");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}