/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentinformationsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StaffDetails extends JFrame {

    public static void main(String[] args) {
        StaffDetails sis = new StaffDetails();
    }

    JFrame f1;
    JPanel p1;
    JLabel l1, l2, l3, l4, l5;
    JTextField t1;
    JPasswordField pass;
    JButton b1, b2;
    ImageIcon img;

    StaffDetails() {

        p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(0,102,0));

        img = new ImageIcon(getClass().getResource("apple.png"));

        l1 = new JLabel(img);
        l1.setBounds(0, 0, 215, 360);

        l2 = new JLabel("Username");
        l2.setBounds(230, 60, 90, 40);
        l2.setFont(new Font("Serif", Font.BOLD, 20));
        l2.setForeground(Color.white);

        l3 = new JLabel("Password");
        l3.setBounds(230, 140, 100, 40);
        l3.setFont(new Font("Serif", Font.BOLD, 20));
        l3.setForeground(Color.white);

        t1 = new JTextField(30);
        t1.setBounds(320, 60, 230, 35);

        pass = new JPasswordField(10);
        pass.setBounds(320, 140, 230, 35);

        b1 = new JButton("User-Login");
        b1.setBounds(250, 250, 100, 50);
        //b1.setBackground(new Color(0,0,0));
        b1.setForeground(Color.black);

        b2 = new JButton("Administrator-Login");
        b2.setBounds(390, 250, 150, 50);
        //b2.setBackground(new Color(0,0,0));
        b2.setForeground(Color.black);
        
        l4 = new JLabel("© T.Y.Samarasinghe An Undergraduate of Bsc.(Physical Science),");
        l4.setBounds(260, 310, 400,50);
        l4.setFont(new Font("Serif", Font.PLAIN, 10));
        l4.setForeground(Color.white);
        
        l5 = new JLabel("University Of Kelaniya");
        l5.setBounds(340, 320, 400,50);
        l5.setFont(new Font("Serif", Font.PLAIN, 10));
        l5.setForeground(Color.white);

        p1.add(l1);
        p1.add(l2);
        p1.add(l3);
        p1.add(t1);
        p1.add(pass);
        p1.add(b1);
        p1.add(b2);
        p1.add(l4);
        p1.add(l5);

        add(p1);
        setSize(580, 390);
        setVisible(true);
        setResizable(false);
        setLocation(370, 50);
        setTitle("Seethawakapura Urban Council, Avissawella");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        userlogin();
        adminlogin();
    }

    public void userlogin() {
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String puname = t1.getText();
                String ppaswd = pass.getText();
                if (puname.equals("user") && ppaswd.equals("user")) {
                    UserIndividualStaff re = new UserIndividualStaff();
                    re.setVisible(true);
                    dispose();
                } else {

                    JOptionPane.showMessageDialog(null, "Wrong Password / Username");
                    t1.setText("");
                    pass.setText("");
                    t1.requestFocus();
                }
            }
        });
    }

    public void adminlogin() {
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String puname = t1.getText();
                String ppaswd = pass.getText();
                if (puname.equals("admin") && ppaswd.equals("admin")) {
                    AdminFrameStaff re = new AdminFrameStaff();
                    re.setVisible(true);
                    dispose();
                } else {

                    JOptionPane.showMessageDialog(null, "Wrong Password / Username");
                    t1.setText("");
                    pass.setText("");
                    t1.requestFocus();
                }
            }
        });
    }

}
