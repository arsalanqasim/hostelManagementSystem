import hosteler.*;
import manager.manager;
import sql.readSql;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class login extends JFrame implements ActionListener {
    JTextField t1, t2;
    JButton b1;
    JRadioButton r1, r2;
    JLabel label1, label2;

    login() {
        this.setDefaultCloseOperation(login.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setLayout(null);

        label1 = new JLabel();
        label1.setText("Login Page");
        label1.setFont(new Font("Times New Roman", Font.BOLD, 30));
        label1.setForeground(Color.BLACK);
        label1.setBounds(100, 10, 200, 40);

        label2 = new JLabel();
        label2.setFont(new Font("Times New Roman", Font.BOLD, 15));
        label2.setForeground(Color.BLACK);
        label2.setBounds(100, 180, 250, 40);

        t1 = new JTextField(60);
        t2 = new JPasswordField(60);

        t1.setBounds(100, 60, 200, 30);
        t2.setBounds(100, 90, 200, 30);

        r1 = new JRadioButton("Manager");
        r2 = new JRadioButton("Hosteler");
        ButtonGroup group = new ButtonGroup();
        group.add(r1);
        group.add(r2);
        r1.setBounds(100, 120, 80, 30);
        r2.setBounds(190, 120, 80, 30);
        r1.addActionListener(this);
        r2.addActionListener(this);

        b1 = new JButton("Login");
        b1.setBounds(100, 150, 200, 30);
        b1.setFocusable(false);
        b1.addActionListener(this);

        this.add(t1);
        this.add(t2);
        this.add(b1);
        this.add(r1);
        this.add(r2);
        this.add(label1);
        this.add(label2);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == b1) {
            String uname = t1.getText().toString();
            String pwd = t2.getText().toString();
            readSql rsq = new readSql();

            if (r1.isSelected()) {
                if ((!uname.isEmpty()) && (!pwd.isEmpty())) {
                    if (uname.equals("admin") && pwd.equals("admin")) {
                        manager hosteler = new manager();
                        hosteler.setTitle("Hosteler Page");
                        hosteler.setVisible(true);
                        dispose();
                    } else {
                        label2.setText("Invaild username or password");
                    }
                } else {
                    label2.setText("Username or password is empty");
                }
            } else if (r2.isSelected()) {
                if ((!uname.isEmpty()) && (!pwd.isEmpty())) {
                    if ((rsq.readlog(uname, pwd))) {
                        hosteler hosteler = new hosteler(uname);
                        hosteler.setTitle("Hosteler Page");
                        hosteler.setVisible(true);
                        dispose();
                    } else {
                        label2.setText("Invaild username or password");
                    }
                } else {
                    label2.setText("Username or password is empty");
                }
            } else {
                label2.setText("Select hosteler or manager");
            }
        }
    }

    public static void main(String[] args) {
        login login = new login();
        login.setTitle("Login Page");
        login.setVisible(true);

    }
}