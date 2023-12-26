package hosteler;

import sql.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class contact extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4;
    JButton b1;
    contact(){
        this.setSize(500, 500);
        this.setLayout(null);

        l1 = new JLabel("Hostel Manager Contact Information:");
        l1.setBounds(50,60,300,30);

        l2 = new JLabel("Name: John Doe");
        l2.setBounds(50,130,200,20);

        l3 = new JLabel("Phone: +1 123-456-7890");
        l3.setBounds(50,150,200,20);

        l4 = new JLabel("Email: john.doe@example.com");
        l4.setBounds(50,170,200,20);

        b1 = new JButton("Exit");
        b1.setBounds(50,230,100,30);
        b1.setFocusable(false);
        b1.addActionListener(this);

        this.add(l1);
        this.add(l2);
        this.add(l3);
        this.add(l4);
        this.add(b1);


    }
    @Override
    public void actionPerformed(ActionEvent ae){
    if(ae.getSource() == b1){
        dispose();
    }
    }
}

class complain extends JFrame implements ActionListener {

    JTextArea textArea;
    JButton b1, b2;
    private String uname;

    complain(String uname) {
        this.uname = uname;
        this.setSize(500, 500);
        this.setLayout(null);

        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setBounds(100, 50, 200, 150);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(100, 55, 200, 150);
        textArea.setWrapStyleWord(true);
        textArea.setAutoscrolls(true);

        b1 = new JButton("Submit");
        b1.setBounds(220, 210, 80, 30);
        b1.setFocusable(false);
        b1.addActionListener(this);

        b2 = new JButton("Exit");
        b2.setBounds(100, 210, 80, 30);
        b2.setFocusable(false);
        b2.addActionListener(this);

        this.add(scrollPane);
        this.add(b1);
        this.add(b2);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            String text = textArea.getText();
            writeSql wsq = new writeSql();
            wsq.writeComplains(uname,text);
            // System.out.println("Text from JTextArea: " + text);

            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f, "Complain submitted");
            dispose();
        }
        if(ae.getSource() == b2){
            dispose();
        }

    }
}

class rent extends JFrame implements ActionListener {
    JLabel l1, l2, l3;
    JButton b1, b2;
    JComboBox<String> comboBox;
    JCheckBox checkBox;
    private String uname;

    rent(String uname) {
        this.uname = uname;
        this.setSize(500, 500);
        this.setLayout(null);

        String txt = "Dear Hostelers,\r\n" + //
                "\r\n" + //
                "Kindly pay your rent directly to our bank accounts.While paying rent match the account number and title carefully with below mentioned details.\r\n"
                + //
                "\r\n" + //
                "Bank Details:\r\n" + //
                "\r\n" + //
                "Easypasia / JazzCash: 03331390228___\r\n" + //
                "Bank(HBL) : 270009319304930___\r\n" + //
                "Account Holder: Arsalan Qasim";

        l1 = new JLabel("<html>" + txt + "</html>");
        l1.setBounds(50, 20, 400, 130);
        l1.setHorizontalAlignment(SwingConstants.CENTER);
        l1.setVerticalAlignment(SwingConstants.CENTER);
        l1.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));

        l2 = new JLabel("Select Month: ");
        l2.setBounds(50, 190, 100, 30);

        String[] months = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
                "October", "November", "December" };

        comboBox = new JComboBox<>(months);
        comboBox.setBounds(180, 190, 80, 20);

        checkBox = new JCheckBox("Select after submiting rent");
        checkBox.setBounds(50, 230, 200, 20);
        checkBox.setFocusable(false);

        b1 = new JButton("Submit");
        b2 = new JButton("Exit");

        b1.setBounds(200, 280, 100, 30);
        b1.setFocusable(false);
        b2.setBounds(50, 280, 100, 30);
        b2.setFocusable(false);

        b1.addActionListener(this);
        b2.addActionListener(this);

        l3 = new JLabel();
        l3.setBounds(50, 330, 200, 20);

        this.add(l1);
        this.add(l2);
        this.add(l3);
        this.add(comboBox);
        this.add(checkBox);
        this.add(b1);
        this.add(b2);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        writeSql wsq = new writeSql();
        if (ae.getSource() == b1) {
            if (checkBox.isSelected()) {
                wsq.writeRent(uname, (comboBox.getSelectedItem().toString()));
                JFrame f = new JFrame();
                JOptionPane.showMessageDialog(f, "Rent Payed");
                dispose();
            } else {
                l3.setText("Kindly check the checkbox");
            }
        }
        if (ae.getSource() == b2) {
            dispose();
        }
    }
}

class services extends JFrame implements ActionListener {
    JButton b1, b2, b3, b4;
    private String uname;

    services(String uname) {
        this.uname = uname;
        this.setSize(500, 500);
        this.setLayout(null);

        b1 = new JButton("Request a meal");
        b2 = new JButton("Request a washcloth");
        b3 = new JButton("Request room cleaning");
        b4 = new JButton("Exit");

        b1.setFocusable(false);
        b2.setFocusable(false);
        b3.setFocusable(false);
        b4.setFocusable(false);

        b1.setBounds(100, 60, 300, 40);
        b2.setBounds(100, 110, 300, 40);
        b3.setBounds(100, 160, 300, 40);
        b4.setBounds(190, 220, 100, 30);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);

        this.add(b1);
        this.add(b2);
        this.add(b3);
        this.add(b4);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        writeSql wSql = new writeSql();
        if (ae.getSource() == b1) {
            wSql.writeServices(uname, "meal");
            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f, "Your meal will be provide soon");
        }
        if (ae.getSource() == b2) {
            wSql.writeServices(uname, "cloth");
            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f, "The laundryman is sent to your room");

        }
        if (ae.getSource() == b3) {
            wSql.writeServices(uname, "clean");
            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f, "The cleaner is sent to your room");

        }
        if (ae.getSource() == b4) {
            dispose();
        }
    }
}

class notiConstructor extends JFrame {
    JLabel l1;

    notiConstructor() {
        this.setSize(500, 500);
        this.setLayout(null);

        readSql rSql = new readSql();
        int y = 0;

        JPanel panal = new JPanel();
        panal.setPreferredSize(new Dimension(500, 1000));
        panal.setLayout(null);

        JScrollPane scrollPane = new JScrollPane(panal);
        scrollPane.setBounds(0, 0, 485, 500);

        String[] data = rSql.readNotification();

        for (String text : data) {

            l1 = new JLabel("<html>" + text + "</html>");

            l1.setBounds(50, (y + 60), 400, 130);
            l1.setHorizontalAlignment(SwingConstants.CENTER);
            l1.setVerticalAlignment(SwingConstants.CENTER);
            l1.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));

            panal.add(l1);
            y += 140;
        }

        this.add(scrollPane);
        this.setLocationRelativeTo(null);
    }
}

class info extends JFrame {
    JLabel uname, age, contact, roomNumber, email, address;

    info(String username) {
        this.setSize(500, 500);
        this.setLayout(null);
        readSql rSql = new readSql();
        String[] info = rSql.readinfo(username);

        uname = new JLabel("Name: " + info[0]);
        age = new JLabel("Age: " + info[1]);
        contact = new JLabel("Contact Number: " + info[2]);
        roomNumber = new JLabel("Room Number: " + info[3]);
        email = new JLabel("Email Address: " + info[4]);
        address = new JLabel("Address: " + info[5]);

        uname.setBounds(50, 60, 300, 30);
        age.setBounds(50, 90, 300, 30);
        contact.setBounds(50, 120, 300, 30);
        roomNumber.setBounds(50, 150, 300, 30);
        email.setBounds(50, 180, 300, 30);
        address.setBounds(50, 210, 300, 30);

        this.add(uname);
        this.add(age);
        this.add(contact);
        this.add(roomNumber);
        this.add(email);
        this.add(address);

    }

}

public class hosteler extends JFrame implements ActionListener {
    JLabel wel;
    JButton info, notification, services, rent, complain, contact;
    String uname;

    public hosteler(String userName) {
        this.uname = userName;
        this.setDefaultCloseOperation(hosteler.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setLayout(null);

        wel = new JLabel();
        wel.setText("Wellcome To My Hostel");
        wel.setFont(new Font("Times New Roman", Font.BOLD, 30));
        wel.setForeground(Color.BLACK);
        wel.setBounds(50, 30, 400, 80);

        info = new JButton("User Information");
        info.setBounds(100, 120, 200, 30);
        info.setFocusable(false);
        info.addActionListener(this);

        notification = new JButton("Nofications");
        notification.setBounds(100, 150, 200, 30);
        notification.setFocusable(false);
        notification.addActionListener(this);

        services = new JButton("Services");
        services.setBounds(100, 180, 200, 30);
        services.setFocusable(false);
        services.addActionListener(this);

        rent = new JButton("Pay Rent");
        rent.setBounds(100, 210, 200, 30);
        rent.setFocusable(false);
        rent.addActionListener(this);

        complain = new JButton("Complain");
        complain.setBounds(100, 240, 200, 30);
        complain.setFocusable(false);
        complain.addActionListener(this);

        contact = new JButton("Manager Contact");
        contact.setBounds(100, 270, 200, 30);
        contact.setFocusable(false);
        contact.addActionListener(this);

        this.add(wel);
        this.add(info);
        this.add(notification);
        this.add(services);
        this.add(rent);
        this.add(complain);
        this.add(contact);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == info) {
            info info = new info(uname);
            info.setBounds(200, 200, 500, 500);
            info.setVisible(true);
        }
        if (ae.getSource() == notification) {
            notiConstructor noti = new notiConstructor();
            noti.setBounds(200, 200, 500, 500);
            noti.setVisible(true);
        }
        if (ae.getSource() == services) {
            services services = new services(uname);
            services.setBounds(200, 50, 500, 500);
            services.setVisible(true);
        }
        if (ae.getSource() == rent) {
            rent rent = new rent(uname);
            rent.setBounds(200, 50, 500, 500);
            rent.setVisible(true);
        }

        if (ae.getSource() == complain) {
            complain complain = new complain(uname);
            complain.setBounds(200, 50, 500, 500);
            complain.setVisible(true);
        }

        if (ae.getSource() == contact) {
            contact contact = new contact();
            contact.setBounds(200, 50, 500, 500);
            contact.setVisible(true);
        }
    }

    // public static void main(String[] args) {
    //     hosteler hosteler = new hosteler("abbas");
    //     hosteler.setTitle("Hosteler Page");
    //     hosteler.setVisible(true);
    // }

}
