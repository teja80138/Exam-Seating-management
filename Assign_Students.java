import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Assign_Students implements ActionListener {
    JFrame frame = new JFrame();
    JButton uploadCSV_button = new JButton("Upload CSV");
    JButton manualEntry_button = new JButton("Manual Entry");
    JButton back_button = new JButton("Back");
    JLabel stu_id = new JLabel("Student ID:");
    JTextField stuId_textfield = new JTextField();
    JLabel stu_name = new JLabel("Student Name:");
    JTextField stuName_textfield = new JTextField();
    JLabel stu_dept = new JLabel("Student Department:");
    JTextField stuDept_textfield = new JTextField();
    JLabel room_name = new JLabel("Room name:");
    JTextField roomName_textfield = new JTextField();
    JLabel stu_seatNo = new JLabel("Seat No:");
    JTextField stuSeatNo_textfield = new JTextField();
    JButton save = new JButton("SAVE");

    // Database connection parameters
    String dbUrl = "jdbc:mysql://localhost:3306/examseating"; // Change to your MySQL URL
    String dbUser = "root"; // Change to your MySQL username
    String dbPassword = "Manu@1315"; // Change to your MySQL password

    Assign_Students() {
        frame.setTitle("Assign Students Page");
        frame.getContentPane().setBackground(new Color(238, 238, 238));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 405);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.getRootPane().setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 7));
        frame.getRootPane().setBorder(BorderFactory.createLineBorder(Color.decode("#F9F6EE"),7));
        frame.getContentPane().setBackground(Color.decode("#87CEEB"));

        uploadCSV_button.setBounds(20, 20, 120, 30);
        uploadCSV_button.setFocusable(false);
        uploadCSV_button.setFont(new Font("ROBOTO", Font.BOLD, 16));
        uploadCSV_button.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        uploadCSV_button.addActionListener(this);

        manualEntry_button.setBounds(150, 20, 150, 30);
        manualEntry_button.setFocusable(false);
        manualEntry_button.setFont(new Font("ROBOTO", Font.BOLD, 16));
        manualEntry_button.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        manualEntry_button.addActionListener(this);

        frame.add(uploadCSV_button);
        frame.add(manualEntry_button);

        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == uploadCSV_button) {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(frame);
            if (result == JFileChooser.APPROVE_OPTION) {
                // File selected, you can do something with it if needed
                JOptionPane.showMessageDialog(frame, "File selected: " + fileChooser.getSelectedFile().getName());
            }
        } else if (e.getSource() == manualEntry_button) {
            frame.getContentPane().removeAll();
            frame.revalidate();
            frame.repaint();
            
            stu_id.setBounds(50, 20, 200, 25);
            stu_id.setFont(new Font("ROBOTO", Font.BOLD, 20));

            stuId_textfield.setBounds(320, 15, 200, 30);
            stuId_textfield.setFont(new Font("ROBOTO", Font.BOLD, 20));
            stuId_textfield.setBorder(BorderFactory.createLoweredBevelBorder());

            stu_name.setBounds(50, 70, 200, 25);
            stu_name.setFont(new Font("ROBOTO", Font.BOLD, 20));

            stuName_textfield.setBounds(320, 65, 200, 30);
            stuName_textfield.setFont(new Font("ROBOTO", Font.BOLD, 20));
            stuName_textfield.setBorder(BorderFactory.createLoweredBevelBorder());

            stu_dept.setBounds(50, 120, 200, 25);
            stu_dept.setFont(new Font("ROBOTO", Font.BOLD, 20));

            stuDept_textfield.setBounds(320, 115, 200, 30);
            stuDept_textfield.setFont(new Font("ROBOTO", Font.BOLD, 20));
            stuDept_textfield.setBorder(BorderFactory.createLoweredBevelBorder());

            room_name.setBounds(50, 170, 200, 25);
            room_name.setFont(new Font("ROBOTO", Font.BOLD, 20));

            roomName_textfield.setBounds(320, 165, 200, 30);
            roomName_textfield.setFont(new Font("ROBOTO", Font.BOLD, 20));
            roomName_textfield.setBorder(BorderFactory.createLoweredBevelBorder());

            stu_seatNo.setBounds(50, 220, 200, 25);
            stu_seatNo.setFont(new Font("ROBOTO", Font.BOLD, 20));

            stuSeatNo_textfield.setBounds(320, 215, 200, 30);
            stuSeatNo_textfield.setFont(new Font("ROBOTO", Font.BOLD, 20));
            stuSeatNo_textfield.setBorder(BorderFactory.createLoweredBevelBorder());

            back_button.setBounds(20, 290, 100, 30);
            back_button.setFocusable(false);
            back_button.setFont(new Font("ROBOTO", Font.BOLD, 16));
            back_button.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
            back_button.addActionListener(this);

            save.setBounds(140, 290, 100, 30); // Adjusted position
            save.setFocusable(false);
            save.setFont(new Font("ROBOTO", Font.BOLD, 16));
            save.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
            save.addActionListener(this);

            frame.add(stu_id);
            frame.add(stuId_textfield);
            frame.add(stu_name);
            frame.add(stuName_textfield);
            frame.add(stu_dept);
            frame.add(stuDept_textfield);
            frame.add(room_name);
            frame.add(roomName_textfield);
            frame.add(stu_seatNo);
            frame.add(stuSeatNo_textfield);
            frame.add(back_button);
            frame.add(save);
        } else if (e.getSource() == back_button) {
            frame.getContentPane().removeAll();
            frame.revalidate();
            frame.repaint();
            frame.add(uploadCSV_button);
            frame.add(manualEntry_button);
        } else if (e.getSource() == save) {
            // Implement save functionality
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Assign_Students();
        });
    }
}
