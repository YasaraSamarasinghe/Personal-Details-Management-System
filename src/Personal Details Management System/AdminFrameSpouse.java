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

public class AdminFrameSpouse extends JFrame {

    public static void main(String[] args) {
        AdminFrameSpouse admin = new AdminFrameSpouse();
    }

    Container c;
    JPanel p1, p2, p3, p4;
    ImageIcon img;
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15;
    JTextField t1, t2, t3, t4, t5, t6, t7;
    JButton logout, save, show, attach, next, back;
    JLabel attached;
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/information";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "mysql123";
    String s;

    AdminFrameSpouse() {
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
        p3.setBounds(0, 80, 1200, 400);

        //start pannel 3
        l2 = new JLabel("W&OP Nmber");
        l2.setBounds(20, 210, 100, 30);
        t1 = new JTextField(50);
        t1.setBounds(120, 210, 250, 30);

        l3 = new JLabel("Identity Number");
        l3.setBounds(20, 270, 100, 30);
        t2 = new JTextField(50);
        t2.setBounds(120, 270, 250, 30);

        l4 = new JLabel("Spouse ID");
        l4.setBounds(20, 330, 130, 30);
        t3 = new JTextField(50);
        t3.setBounds(120, 330, 250, 30);

        l5 = new JLabel("First Name");
        l5.setBounds(20, 390, 130, 30);
        t4 = new JTextField(50);
        t4.setBounds(120, 390, 250, 30);

        l6 = new JLabel("Middle Name");
        l6.setBounds(20, 450, 130, 30);
        t5 = new JTextField(50);
        t5.setBounds(120, 450, 250, 30);

        l7 = new JLabel("Last Name");
        l7.setBounds(20, 510, 130, 30);
        t6 = new JTextField(50);
        t6.setBounds(120, 510, 250, 30);
        
        l8 = new JLabel("Date of Birth");
        l8.setBounds(20, 570, 130, 30);
        t7 = new JTextField(50);
        t7.setBounds(120, 570, 250, 30);

        //panel 4
        p4 = new JPanel();
        p4.setLayout(null);
        p4.setBounds(0, 130, 1200, 50);
        p4.setBackground(new Color(0,51,153));
        JLabel label = new JLabel("Details Of The Spouse");
        label.setFont(new Font(label.getName(), Font.BOLD, 20));
        label.setForeground(Color.white);
        label.setBounds(20, 0, 300, 50);
        p4.add(label);
        
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

        c.add(p1);
        c.add(p2);
        c.add(p4);
        c.add(p3);
               
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
                AdminFrameChild rs = new AdminFrameChild();
                rs.setVisible(true);
                dispose();

            }
        });
    }
    
    public void back() {
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AdminFrameStaff bs = new AdminFrameStaff();
                bs.setVisible(true);
                dispose();

            }
        });
    }

    public void shows() {
        show.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            AdminIndividualSpouse ad = new AdminIndividualSpouse();
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
                        PreparedStatement ps = conn.prepareStatement("INSERT INTO spouse(form_id,identity_number,spouse_id,first_name,middle_name,"
                                + "last_name,date_of_birth)"
                                + "VALUES(?,?,?,?,?,?,?)");
                        System.out.println("ok in prepared statement");
                        //InputStream is = new FileInputStream(new File(s));
                        ps.setString(1, s1);
                        ps.setString(2, s2);
                        ps.setString(3, s3);
                        ps.setString(4, s4);
                        ps.setString(5, s5);
                        ps.setString(6, s6);
                        ps.setString(7, s7);
                        
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
