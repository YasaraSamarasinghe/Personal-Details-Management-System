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

public class AdminFrameEfficiency extends JFrame {

    public static void main(String[] args) {
        AdminFrameEfficiency admin = new AdminFrameEfficiency();
    }

    Container c;
    JPanel p1, p2, p3, p4, p5;
    ImageIcon img;
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15;
    JTextField t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18;
    JButton logout, save, show, attach, next, back;
    JLabel attached;
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/information";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "mysql123";
    String s;

    AdminFrameEfficiency() {
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
        JLabel label = new JLabel("Efficiency Bar");
        label.setFont(new Font(label.getName(), Font.BOLD, 20));
        label.setForeground(Color.white);
        p4.add(label);
        label.setBounds(20, 0, 200, 50);

        //panel 5
        p5 = new JPanel();
        p5.setLayout(null);
        p5.setBackground(new Color(204,204,204));
        JLabel year = new JLabel("Year");
        year.setBounds(40, 270, 100, 30);
        year.setFont(new Font(year.getName(), Font.BOLD, 18));
        t3 = new JTextField();
        t3.setBounds(20, 320, 130, 35);
        t7 = new JTextField();
        t7.setBounds(20, 360, 130, 35);
        t11= new JTextField();
        t11.setBounds (20, 400, 130, 35);
        t15 = new JTextField();
        t15.setBounds(20, 440, 130, 35);
        p5.add(year);
        p5.add(t3);
        p5.add(t7);
        p5.add(t11);
        p5.add(t15);

        JLabel subject = new JLabel("Subject");
        subject.setBounds(300, 270, 200, 30);
        subject.setFont(new Font(subject.getName(), Font.BOLD, 18));
        t4 = new JTextField();
        t4.setBounds(230, 320, 300, 35);
        t8 = new JTextField();
        t8.setBounds(230, 360, 300, 35);
        t12 = new JTextField();
        t12.setBounds(230, 400, 300, 35);
        t16 = new JTextField();
        t16.setBounds(230, 440, 300, 35);
        p5.add(subject);
        p5.add(t4);
        p5.add(t8);
        p5.add(t12);
        p5.add(t16);

        JLabel index = new JLabel("Index");
        index.setBounds(600, 270, 200, 30);
        index.setFont(new Font(index.getName(), Font.BOLD, 18));
        t5 = new JTextField();
        t5.setBounds(570, 320, 250, 35);
        t9 = new JTextField();
        t9.setBounds(570, 360, 250, 35);
        t13 = new JTextField();
        t13.setBounds(570, 400, 250, 35);
        t17 = new JTextField();
        t17.setBounds(570, 440, 250, 35);
        p5.add(index);
        p5.add(t5);
        p5.add(t9);
        p5.add(t13);
        p5.add(t17);

        JLabel date = new JLabel("Date");
        date.setBounds(960, 270, 200, 30);
        date.setFont(new Font(date.getName(), Font.BOLD, 18));
        t6 = new JTextField();
        t6.setBounds(880, 320, 250, 35);
        t10 = new JTextField();
        t10.setBounds(880, 360, 250, 35);
        t14 = new JTextField();
        t14.setBounds(880, 400, 250, 35);
        t18 = new JTextField();
        t18.setBounds(880, 440, 250, 35);
        p5.add(date);
        p5.add(t6);
        p5.add(t10);
        p5.add(t14);
        p5.add(t18);

        //panel 5 end and start function of panel 3 body 
        l2 = new JLabel("W&OP number");
        l2.setBounds(40, 70, 90, 30);
        t1 = new JTextField(50);
        t1.setBounds(130, 70, 150, 30);

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
                AdminFramePromotion rs = new AdminFramePromotion();
                rs.setVisible(true);
                dispose();

            }
        });
    }
    
    public void back() {
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AdminFrameChild bs = new AdminFrameChild();
                bs.setVisible(true);
                dispose();
            }
        });
    }
    
    public void shows() {
        show.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            AdminIndividualEfficiency ad = new AdminIndividualEfficiency();
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
                String s14 = t14.getText();
                String s15 = t15.getText();
                String s16 = t16.getText();
                String s17 = t17.getText();
                String s18 = t18.getText();

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
                        PreparedStatement ps = conn.prepareStatement("INSERT INTO efficiency(form_id,identity_number,"
                                + "year1,subject1,index1,date1,year2,subject2,index2,date2,year3,subject3,index3,"
                                + "date3,year4,subject4,index4,date4)"
                                + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
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
                        ps.setString(11, s11);
                        ps.setString(12, s12);
                        ps.setString(13, s13);
                        ps.setString(14, s14);
                        ps.setString(15, s15);
                        ps.setString(16, s16);
                        ps.setString(17, s17);
                        ps.setString(18, s18);
                       
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
                        t14.setText("");
                        t15.setText("");
                        t16.setText("");
                        t17.setText("");
                        t18.setText("");
                        
                        
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
