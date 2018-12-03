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
import java.sql.*;

public class AdminFrameChild extends JFrame {

    public static void main(String[] args) {
        AdminFrameChild admin = new AdminFrameChild();
    }

    Container c;
    JPanel p1, p2, p3, p4, p5;
    ImageIcon img;
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15;
    JTextField t1, t2, t3, t4, t5, t6, t7, t8, t9, t10;
    JButton logout, save, show, attach, next, back;
    JLabel attached;
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/information";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "mysql123";
    String s;

    AdminFrameChild() {
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
        save = new JButton("Save Record");
        save.setBounds(560, 10, 120, 40);
        p2.add(save);
        show = new JButton("show Record");
        show.setBounds(690, 10, 120, 40);
        p2.add(show);
        next = new JButton("Next");
        next.setBounds(820, 10, 120, 40);
        p2.add(next);
        back = new JButton("Back");
        back.setBounds(950, 10, 120, 40);
        p2.add(back);
        logout = new JButton("Log-Out");
        logout.setBounds(1080, 10, 110, 40);
        p2.add(logout);

        //panel 3
        p3 = new JPanel();
        p3.setLayout(null);
        p3.setBackground(new Color(204,204,204));
        p3.setBounds(0, 80, 1200, 100);

        //panel 4
        p4 = new JPanel();
        p4.setLayout(null);
        p4.setBounds(0, 200, 1200, 50);
        p4.setBackground(new Color(0,51,153));
        JLabel label = new JLabel("Details Of The Children");
        label.setFont(new Font(label.getName(), Font.BOLD, 20));
        label.setForeground(Color.white);
        p4.add(label);
        label.setBounds(20, 0, 600, 60);

        //panel 5
        p5 = new JPanel();
        p5.setLayout(null);
        p5.setBackground(new Color(204,204,204));
        JLabel slc = new JLabel("Name");
        slc.setBounds(120, 270, 100, 30);
        slc.setFont(new Font(slc.getName(), Font.BOLD, 18));
        t3 = new JTextField();
        t3.setBounds(20, 320, 300, 35);
        t5 = new JTextField();
        t5.setBounds(20, 360, 300, 35);
        p5.add(slc);
        p5.add(t3);
        p5.add(t5);
        t7 = new JTextField();
        t7.setBounds(20, 400, 300, 35);
        t9 = new JTextField();
        t9.setBounds(20, 440, 300, 35);
        p5.add(t7);
        p5.add(t9);

        JLabel name = new JLabel("Date Of Birth");
        name.setBounds(430, 270, 200, 30);
        name.setFont(new Font(name.getName(), Font.BOLD, 18));
        t4 = new JTextField();
        t4.setBounds(400, 320, 200, 35);
        t6 = new JTextField();
        t6.setBounds(400, 360, 200, 35);
        p5.add(name);
        p5.add(t4);
        p5.add(t6);
        t8 = new JTextField();
        t8.setBounds(400, 400, 200, 35);
        t10 = new JTextField();
        t10.setBounds(400, 440, 200, 35);
        p5.add(t8);
        p5.add(t10);

        //panel 5 end and start function of panel 3 body 
        l2 = new JLabel("W&OP Number");
        l2.setBounds(120, 70, 90, 30);
        t1 = new JTextField(50);
        t1.setBounds(220, 70, 150, 30);

        l3 = new JLabel("Identity Number");
        l3.setBounds(530, 70, 130, 30);
        t2 = new JTextField(50);
        t2.setBounds(630, 70, 150, 30);

        //end file /image chosing
        p1.add(l1);
        p3.add(l2);
        p3.add(t1);
        p3.add(l3);
        p3.add(t2);
        
        c.add(p1);
        c.add(p2);
        c.add(p3);
        c.add(p4);
        c.add(p5);
        //create a constructor for logout save and show button

        setSize(1200, 750);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setTitle("Seethawakapura Urban Council, Avissawella");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        shows();
        logout();
        save();
        next();
        back();
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
                AdminFrameEfficiency rs = new AdminFrameEfficiency();
                rs.setVisible(true);
                dispose();

            }
        });
    }
    
    public void back() {
        back.addActionListener(new ActionListener() {
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
            AdminIndividualChild ad =     new AdminIndividualChild();
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

                if (t2.getText().equals("")) 
                {
                       JOptionPane.showMessageDialog(save, "Please insert the identity number ");
                } 
                else {
                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        conn = DriverManager.getConnection(DB_URL, USER, PASS);
                        System.out.println("every thing is ok in connection");
                        JOptionPane.showConfirmDialog(null, "Are you sure Insert Data?", "Delete", JOptionPane.YES_NO_OPTION);
                        PreparedStatement ps = conn.prepareStatement("INSERT INTO children(form_id,identity_number,"
                                + "name1,bday1,name2,bday2,name3,bday3,name4,bday4)"
                                + "VALUES(?,?,?,?,?,?,?,?,?,?)");
                        System.out.println("ok in prepared statement");
                        
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
                        
                    } 
                    catch (SQLException se) {
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
