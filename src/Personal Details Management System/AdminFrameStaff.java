/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentinformationsystem;

/**
 *
 * @author Apple
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.sql.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class AdminFrameStaff extends JFrame {

    public static void main(String[] args) {
        AdminFrameStaff admin = new AdminFrameStaff();
    }

    Container c;
    JPanel p1, p2, p3, p4, p5;
    ImageIcon img;
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15, photo;
    JTextField t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13;
    JButton logout, save, show, attach, next;
    JLabel attached;
    ImageIcon image;
    
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/information";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "mysql123";
    String s;

    AdminFrameStaff() {
        c = getContentPane();
        //panel 1
        p1 = new JPanel();
        p1.setBackground(Color.blue);
        p1.setBounds(0, -5, 1200, 85);
        img = new ImageIcon(getClass().getResource("header_1.jpg"));
        l1 = new JLabel(img);

        //panel 2
        p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(0,51,153));
        p2.setBounds(0, 80, 1200, 60);
        JLabel label1 = new JLabel("Fill the Following Information");
        label1.setFont(new Font(label1.getName(), Font.BOLD, 20));
        label1.setForeground(Color.white);
        p2.add(label1);
        label1.setBounds(20, -5, 300, 50);
        
        next = new JButton("Next");
        next.setBounds(950, 10, 120, 40);
        //next.setBackground(Color.green);
        p2.add(next);
        save = new JButton("Save Record");
        save.setBounds(690, 10, 120, 40);
        //save.setBackground(Color.green);
        p2.add(save);
        show = new JButton("show Record");
        show.setBounds(820, 10, 120, 40);
        //show.setBackground(Color.green);
        p2.add(show);
        logout = new JButton("Log-Out");
        logout.setBounds(1080, 10, 110, 40);
        //logout.setBackground(Color.green);
        p2.add(logout);

        //panel 3
        p3 = new JPanel();
        p3.setLayout(null);
        p3.setBackground(new Color(204,204,204));
        p3.setBounds(0, 80, 1200, 400);

        l2 = new JLabel("W&OP Number");
        l2.setBounds(20, 160, 90, 30);
        t1 = new JTextField(50);
        t1.setBounds(110, 160, 160, 30);

        l3 = new JLabel("Identity Number");
        l3.setBounds(280, 160, 130, 30);
        t2 = new JTextField(50);
        t2.setBounds(380, 160, 160, 30);

        l4 = new JLabel("First Name");
        l4.setBounds(20, 220, 80, 30);
        t3 = new JTextField(50);
        t3.setBounds(110, 220, 160, 30);

        l5 = new JLabel("Middle Name");
        l5.setBounds(280, 220, 130, 30);
        t4 = new JTextField(50);
        t4.setBounds(380, 220, 160, 30);

        l6 = new JLabel("Last Name");
        l6.setBounds(550, 220, 130, 30);
        t5 = new JTextField(50);
        t5.setBounds(630, 220, 160, 30);

        l7 = new JLabel("Gender");
        l7.setBounds(20, 280, 80, 30);
        t6 = new JTextField(50);
        t6.setBounds(110, 280, 160, 30);

        l8 = new JLabel("Date of Birth");
        l8.setBounds(280, 280, 130, 30);
        t7 = new JTextField(50);
        t7.setBounds(380, 280, 160, 30);

        l9 = new JLabel("Designation");
        l9.setBounds(550, 280, 130, 30);
        t8 = new JTextField(50);
        t8.setBounds(630, 280, 230, 30);

        l10 = new JLabel("Grade");
        l10.setBounds(20, 340, 130, 30);
        t9 = new JTextField(50);
        t9.setBounds(110, 340, 160, 30);

        l11 = new JLabel("First Appointment Date");
        l11.setBounds(280, 340, 130, 30);
        t10 = new JTextField(50);
        t10.setBounds(430, 340, 160, 30);

        l12 = new JLabel("Civil Status");
        l12.setBounds(20, 400, 130, 30);
        t11 = new JTextField(50);
        t11.setBounds(110, 400, 160, 30);

        l13 = new JLabel("Address");
        l13.setBounds(280, 400, 130, 30);
        t12 = new JTextField(50);
        t12.setBounds(430, 400, 440, 30);

        l14 = new JLabel("Contact No");
        l14.setBounds(20, 460, 130, 30);
        t13 = new JTextField(50);
        t13.setBounds(110, 460, 160, 30);

        attach = new JButton("Attach Image");
        attach.setBounds(940, 400, 150, 40);
        p3.add(attach);
        attached = new JLabel("  Attach Image Here");
        attached.setBounds(910, 170, 200, 200);
        
        image = new ImageIcon(getClass().getResource("Person.png"));

        photo = new JLabel(image);
        photo.setBounds(910, 170, 200, 200);
        
        attached.setForeground(Color.BLACK);
        p3.add(attached);

        //working on photo chosing
        attach.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                JFileChooser file = new JFileChooser();
                file.setCurrentDirectory(new File(System.getProperty("user.home")));
                FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Image", "jpg", "JPG", "JPEG", "png");
                file.addChoosableFileFilter(filter);
                int result = file.showSaveDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {

                    File selectedFile = file.getSelectedFile();
                    String path = selectedFile.getAbsolutePath();
                    attached.setIcon(ResizeImage(path));
                    s = path;
                } else if (result == JFileChooser.CANCEL_OPTION) {
                    JOptionPane.showMessageDialog(null, "file not selected");
                }
            }
        });

        //end file /image chosing
        p1.add(l1);
        p3.add(l2);
        p3.add(t1);
        p3.add(l3);
        p3.add(t2);
        p3.add(l4);
        p3.add(t3);
        p3.add(l5);
        p3.add(t4);
        p3.add(l6);
        p3.add(t5);
        p3.add(l7);
        p3.add(t6);
        p3.add(l8);
        p3.add(t7);
        p3.add(l9);
        p3.add(t8);
        p3.add(l10);
        p3.add(t9);
        p3.add(l11);
        p3.add(t10);
        p3.add(l12);
        p3.add(t11);
        p3.add(l13);
        p3.add(t12);
        p3.add(l14);
        p3.add(t13);
        p3.add(photo);

        c.add(p1);
        c.add(p2);
        c.add(p3);
        
        //create a constructor for logout save and show button

        setSize(1200, 750);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setTitle("Seethawaka Urban Council, Avissawella");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        shows();
        logout();
        save();
        next();
    }

    //image chhose 
    public ImageIcon ResizeImage(String Imagepath) {

        ImageIcon myImage = new ImageIcon(Imagepath);
        Image img = myImage.getImage();
        Image newImage = img.getScaledInstance(attached.getWidth(), attached.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon Image = new ImageIcon(newImage);
        return Image;
    }

    //end image chose 
    public void logout() {
        logout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StaffDetails r = new StaffDetails();
                r.setVisible(true);
                dispose();

            }
        });
    }
    
    public void next() {
        next.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AdminFrameSpouse rs = new AdminFrameSpouse();
                rs.setVisible(true);
                dispose();

            }
        });
    }

    public void shows() {
        show.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            AdminIndividualStaff ad = new AdminIndividualStaff();
                ad.setVisible(true);
                dispose();
            }
        });
    }

    public void save() {
        save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Connection conn = null;
                Statement stmt = null;
                String s1 = t1.getText();
                String s2 = t2.getText();
                String s3 = t3.getText();
                String s4 = t4.getText();
                String s5 = t5.getText();
                String s6 = t6.getText();
                String s7 = t7.getText();
                String s8 = t8.getText();
                String s9 = t9.getText();
                String s10 = t10.getText();
                String s11 = t11.getText();
                String s12 = t12.getText();
                String s13 = t13.getText();
                

                if (t2.getText().equals("")) 
                {
                       JOptionPane.showMessageDialog(save, "Please insert the identity number ");
                } else {
                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        conn = DriverManager.getConnection(DB_URL, USER, PASS);
                        System.out.println("every thing is ok in connection");
                        JOptionPane.showConfirmDialog(null, "Are you sure Insert Data?", "Delete", JOptionPane.YES_NO_OPTION);
                        PreparedStatement ps = conn.prepareStatement("INSERT INTO staff(form_id,identity_number,first_name,middle_name,"
                                + "last_name,gender,dob,designation,grade,first_appointment_date,civil_status,"
                                + "address,contact,image)"
                                + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                        System.out.println("ok in prepared statement");
                        InputStream is;
                        if (s != null) {
                            is = new FileInputStream(new File(s));
                        } 
                        else {
                            URL FilePathNew =getClass().getResource("person.png");                           
                             is = Thread.currentThread().getContextClassLoader().getResourceAsStream("person.png");
                        }
                        ps.setString(1, s1);
                        ps.setString(2, s2);
                        ps.setString(3, s3);
                        ps.setString(4, s4);
                        ps.setString(5, s5);
                        ps.setString(6, s6);
                        ps.setString(7, s7);
                        ps.setString(8, s8);
                        ps.setString(9, s9);
                        ps.setString(10, s10);
                        ps.setString(11, s11);
                        ps.setString(12, s12);
                        ps.setString(13, s13);
                        ps.setBlob(14, is);
                        ps.executeUpdate();
                        System.out.println("ok while execute ");
                        JOptionPane.showMessageDialog(save, "sucessfully inserted Data");
                        t1.setText("");
                        t2.setText("");
                        t3.setText("");
                        t4.setText("");
                        t5.setText("");
                        t6.setText("");
                        t7.setText("");
                        t8.setText("");
                        t9.setText("");
                        t10.setText("");
                        t11.setText("");
                        t12.setText("");
                        t13.setText("");
                        
                        
                    } catch (SQLException se) {
                        se.printStackTrace();

                    } catch (Exception ek) {
                        ek.printStackTrace();
                    } finally {
                        try {
                            if (stmt != null) {
                                conn.close();
                            }
                        } catch (SQLException se) {
                        }
                        try {
                            if (conn != null) {
                                conn.close();
                            }
                        } catch (SQLException se) {
                            se.printStackTrace();
                        }//end finally try
                    }//end try
                    System.out.println("good bye");
                }
            }
        });
    }

    

}
