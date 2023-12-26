package manager;

import sql.readSql;
import sql.writeSql;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class seeComplain extends JFrame implements ActionListener {
    JLabel l5, l6;
    JButton b1;
    JCheckBox[] checkBoxes;
    JLabel[] labels;

    seeComplain() {
        this.setSize(500, 500);
        this.setLayout(null);

        readSql rSql = new readSql();
        int y = 0;

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(500, 500));
        panel.setLayout(null);

        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setBounds(0, 0, 485, 500);

        l5 = new JLabel("Hostelers Name");
        l5.setBounds(20, 40, 200, 20);
        l5.setFont(new Font("Times New Roman", Font.BOLD, 16));

        l6 = new JLabel("Complaines");
        l6.setBounds(210, 40, 200, 20);
        l6.setFont(new Font("Times New Roman", Font.BOLD, 16));

        panel.add(l5);
        panel.add(l6);

        String[][] data = rSql.readComplains();
        checkBoxes = new JCheckBox[data.length];
        labels = new JLabel[data.length];

        for (int i = 0; i < data.length; i++) {
            labels[i] = new JLabel(data[i][1]);

            JLabel l1 = new JLabel("<html>" + data[i][0] + "</html>");
            l1.setBounds(30, (y + 70), 50, 150);

            JLabel l2 = new JLabel("<html>" + data[i][1] + "</html>");
            l2.setBounds(80, (y + 70), 290, 150);

            checkBoxes[i] = new JCheckBox("Solved");
            checkBoxes[i].setBounds(380, (y + 70), 100, 150);
            checkBoxes[i].setFocusable(false);
            checkBoxes[i].addActionListener(this);

            panel.add(l1);
            panel.add(l2);
            panel.add(checkBoxes[i]);
            y += 120;
        }
        b1 = new JButton("Exit");
        b1.setBounds(50, (y + 120), 100, 30);
        b1.setFocusable(false);
        b1.addActionListener(this);

        panel.add(b1);

        this.add(scrollPane);
        this.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        writeSql wSql = new writeSql();
        for (int i = 0; i < checkBoxes.length; i++) {
            if (ae.getSource() == checkBoxes[i] && checkBoxes[i].isSelected()) {
                wSql.writeComplains(labels[i].getText().toString());
                JFrame f = new JFrame();
                JOptionPane.showMessageDialog(f, "Done");
                // System.out.println("Hosteler Name: " + labels[i].getText() + " - " +
                // checkBoxes[i].getText());
            }
        }
        if (ae.getSource() == b1) {
            dispose();
        }
    }
}

class seeRent extends JFrame implements ActionListener {
    JLabel l5, l6;
    JButton b1;
    JCheckBox[] checkBoxes;
    JLabel[] labels;

    seeRent() {
        this.setSize(500, 500);
        this.setLayout(null);

        readSql rSql = new readSql();
        int y = 0;

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(500, 500));
        panel.setLayout(null);

        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setBounds(0, 0, 485, 500);

        l5 = new JLabel("Hostelers Name");
        l5.setBounds(20, 40, 200, 20);
        l5.setFont(new Font("Times New Roman", Font.BOLD, 16));

        l6 = new JLabel("Month");
        l6.setBounds(210, 40, 200, 20);
        l6.setFont(new Font("Times New Roman", Font.BOLD, 16));

        panel.add(l5);
        panel.add(l6);

        String[][] data = filterNullValues(rSql.readRent());
        checkBoxes = new JCheckBox[data.length];
        labels = new JLabel[data.length];

        for (int i = 0; ((i < data.length) && (data.length > i && data[i].length > 0)); i++) {
            labels[i] = new JLabel(data[i][0]);

            JLabel l1 = new JLabel(data[i][0]);
            l1.setBounds(50, (y + 70), 50, 50);

            JLabel l2 = new JLabel((data.length > i && data[i].length > 1) ? data[i][1] : "");
            l2.setBounds(190, (y + 70), 60, 50);

            JLabel l3 = new JLabel((data.length > i && data[i].length > 2) ? data[i][2] : "");
            l3.setBounds(250, (y + 70), 60, 50);

            JLabel l4 = new JLabel((data.length > i && data[i].length > 3) ? data[i][3] : "");


            l4.setBounds(310, (y + 70), 60, 50);

            checkBoxes[i] = new JCheckBox("recevied");
            checkBoxes[i].setBounds(350, (y + 70), 100, 50);
            checkBoxes[i].setFocusable(false);
            checkBoxes[i].addActionListener(this);

            panel.add(l1);
            panel.add(l2);
            panel.add(l3);
            panel.add(l4);
            panel.add(checkBoxes[i]);
            y += 50;
        }
        b1 = new JButton("Exit");
        b1.setBounds(50, (y + 100), 100, 30);
        b1.setFocusable(false);
        b1.addActionListener(this);

        panel.add(b1);

        this.add(scrollPane);
        this.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        writeSql wSql = new writeSql();
        for (int i = 0; i < checkBoxes.length; i++) {
            if (ae.getSource() == checkBoxes[i] && checkBoxes[i].isSelected()) {
                wSql.writeRent(labels[i].getText().toString());
                JFrame f = new JFrame();
                JOptionPane.showMessageDialog(f, "Done");
                // System.out.println("Hosteler Name: " + labels[i].getText() + " - " +
                // checkBoxes[i].getText());
            }
        }
        if (ae.getSource() == b1) {
            dispose();
        }
    }

    public static String[][] filterNullValues(String[][] inputArray) {
        // Create a new array with the same dimensions
        String[][] filteredArray = new String[inputArray.length][];

        for (int i = 0; i < inputArray.length; i++) {
            // Count non-null values in each row
            int count = 0;
            for (String value : inputArray[i]) {
                if (value != null) {
                    count++;
                }
            }

            // Create a new array with the determined size
            filteredArray[i] = new String[count];

            // Copy non-null values to the filtered array
            int index = 0;
            for (String value : inputArray[i]) {
                if (value != null) {
                    filteredArray[i][index++] = value;
                }
            }
        }

        return filteredArray;
    }
}

class askedServ extends JFrame implements ActionListener {
    JLabel l5, l6;
    JButton b1;
    JCheckBox[] checkBoxes;
    JLabel[] labels;

    askedServ() {
        this.setSize(500, 500);
        this.setLayout(null);

        readSql rSql = new readSql();
        int y = 0;

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(500, 500));
        panel.setLayout(null);

        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setBounds(0, 0, 485, 500);

        l5 = new JLabel("Hostelers Name");
        l5.setBounds(20, 40, 200, 20);
        l5.setFont(new Font("Times New Roman", Font.BOLD, 16));

        l6 = new JLabel("Services Asked");
        l6.setBounds(210, 40, 200, 20);
        l6.setFont(new Font("Times New Roman", Font.BOLD, 16));

        panel.add(l5);
        panel.add(l6);

        String[][] data = rSql.readServices();
        checkBoxes = new JCheckBox[data.length];
        labels = new JLabel[data.length];

        for (int i = 0; i < data.length; i++) {
            labels[i] = new JLabel(data[i][0]);

            JLabel l1 = new JLabel(data[i][0]);
            l1.setBounds(50, (y + 70), 50, 50);

            JLabel l2 = new JLabel(data[i][1]);
            l2.setBounds(190, (y + 70), 50, 50);

            JLabel l3 = new JLabel(data[i][2]);
            l3.setBounds(230, (y + 70), 50, 50);

            JLabel l4 = new JLabel(data[i][3]);
            l4.setBounds(270, (y + 70), 50, 50);

            checkBoxes[i] = new JCheckBox("Provided");
            checkBoxes[i].setBounds(340, (y + 70), 100, 50);
            checkBoxes[i].setFocusable(false);
            checkBoxes[i].addActionListener(this);

            panel.add(l1);
            panel.add(l2);
            panel.add(l3);
            panel.add(l4);
            panel.add(checkBoxes[i]);
            y += 50;
        }
        b1 = new JButton("Exit");
        b1.setBounds(50, (y + 100), 100, 30);
        b1.setFocusable(false);
        b1.addActionListener(this);

        panel.add(b1);

        this.add(scrollPane);
        this.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        writeSql wSql = new writeSql();
        for (int i = 0; i < checkBoxes.length; i++) {
            if (ae.getSource() == checkBoxes[i] && checkBoxes[i].isSelected()) {
                wSql.writeServices(labels[i].getText().toString());
                JFrame f = new JFrame();
                JOptionPane.showMessageDialog(f, "Done");
                // System.out.println("Hosteler Name: " + labels[i].getText() + " - " +
                // checkBoxes[i].getText());
            }
        }
        if (ae.getSource() == b1) {
            dispose();
        }
    }
}

class add extends JFrame implements ActionListener {

    JTextField userName, age, pwd, name, contact, roomNumber, email, address;
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10;
    JButton b1, b2;
    JFrame frame;

    add() {

        // this.setDefaultCloseOperation(login.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setLayout(null);

        l1 = new JLabel("User Name: ");
        l2 = new JLabel("Password: ");
        l9 = new JLabel();

        l1.setBounds(50, 60, 100, 30);
        l2.setBounds(50, 90, 100, 30);
        l9.setBounds(50, 200, 400, 30);

        userName = new JTextField(60);
        pwd = new JTextField(60);

        userName.setBounds(170, 60, 200, 30);
        pwd.setBounds(170, 90, 200, 30);

        b1 = new JButton("Next");
        b1.setBounds(170, 150, 200, 30);
        b1.setFocusable(false);
        b1.addActionListener(this);

        this.add(l1);
        this.add(l2);
        this.add(l9);
        this.add(userName);
        this.add(pwd);
        this.add(b1);
    }

    private void addUser() {
        frame = new JFrame();
        frame.setSize(500, 500);
        frame.setBounds(200, 100, 500, 500);
        frame.setLayout(null);

        l3 = new JLabel("Name: ");
        l4 = new JLabel("Age: ");
        l5 = new JLabel("Contact Number: ");
        l6 = new JLabel("Room Number: ");
        l7 = new JLabel("Email Address: ");
        l8 = new JLabel("Address: ");
        l10 = new JLabel();

        l3.setBounds(50, 60, 100, 30);
        l4.setBounds(50, 90, 100, 30);
        l5.setBounds(50, 120, 110, 30);
        l6.setBounds(50, 150, 100, 30);
        l7.setBounds(50, 180, 100, 30);
        l8.setBounds(50, 210, 100, 30);
        l10.setBounds(50, 310, 200, 30);

        name = new JTextField(60);

        age = new JTextField();
        age.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char input = e.getKeyChar();
                if ((input < '0' || input > '9') && (input != '\b')) {
                    e.consume();
                }
            }
        });

        contact = new JTextField(60);
        contact.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char input = e.getKeyChar();
                if ((input < '0' || input > '9') && (input != '\b')) {
                    e.consume();
                }
            }
        });

        roomNumber = new JTextField(60);
        roomNumber.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char input = e.getKeyChar();
                if ((input < '0' || input > '9') && (input != '\b')) {
                    e.consume();
                }
            }
        });

        email = new JTextField(60);
        address = new JTextField(60);

        name.setBounds(170, 60, 200, 30);
        age.setBounds(170, 90, 200, 30);
        contact.setBounds(170, 120, 200, 30);
        roomNumber.setBounds(170, 150, 200, 30);
        email.setBounds(170, 180, 200, 30);
        address.setBounds(170, 210, 200, 30);

        b2 = new JButton("SignUp");
        b2.setBounds(130, 260, 200, 30);
        b2.setFocusable(false);
        b2.addActionListener(this);

        frame.add(l3);
        frame.add(l4);
        frame.add(l5);
        frame.add(l6);
        frame.add(l7);
        frame.add(l8);
        frame.add(l10);
        frame.add(name);
        frame.add(age);
        frame.add(contact);
        frame.add(roomNumber);
        frame.add(email);
        frame.add(address);
        frame.add(b2);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            readSql rq = new readSql();
            boolean avalible = rq.readlog((userName.getText().toString()));
            if ((!userName.getText().isEmpty()) && (!pwd.getText().isEmpty())) {
                if (avalible) {
                    l9.setText("Username is already taken. Try different Username ");
                } else {
                    dispose();
                    addUser();
                }
            } else {
                l9.setText("Username or Password Empty");
            }
        }

        if (ae.getSource() == b2) {

            if (!name.getText().isEmpty()) {
                if (!age.getText().isEmpty()) {
                    if (!contact.getText().isEmpty()) {
                        if (!roomNumber.getText().isEmpty()) {
                            if (!email.getText().isEmpty()) {
                                if (!address.getText().isEmpty()) {
                                    writeSql wrs = new writeSql();

                                    wrs.writeHostelerInfo(userName.getText(), name.getText(), age.getText(),
                                    contact.getText(),
                                    roomNumber.getText(), email.getText(), address.getText());

                                    wrs.writeHostelerLog(userName.getText().toString(),
                                    pwd.getText().toString());
                                } else {
                                    l10.setText("Address field is empty");
                                }
                            } else {
                                l10.setText("Email Address field is empty");
                            }
                        } else {
                            l10.setText("Room Number field is empty");
                        }
                    } else {
                        l10.setText("Contact Number field is empty");
                    }
                } else {
                    l10.setText("Age field is empty");
                }
            } else {
                l10.setText("Name field is empty");
            }
            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f, "Registration Conmpleted");

            frame.dispose();
        }
    }
}

class upNoti extends JFrame implements ActionListener {

    JTextArea textArea;
    JButton b1, b2;

    upNoti() {
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
        b1.setBounds(210, 210, 80, 30);
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
            wsq.writeNofications(text);
            // System.out.println("Text from JTextArea: " + text);

            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f, "Notification Uploaded");
            dispose();
        }
        if (ae.getSource() == b2) {
            dispose();
        }

    }
}

public class manager extends JFrame implements ActionListener {
    JLabel wel;
    JButton add, upNoti, askedServ, seeRent, seeComplain;

    public manager() {
        this.setDefaultCloseOperation(manager.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setLayout(null);

        wel = new JLabel();
        wel.setText("Managers Page");
        wel.setFont(new Font("Times New Roman", Font.BOLD, 30));
        wel.setForeground(Color.BLACK);
        wel.setBounds(100, 30, 400, 80);

        add = new JButton("Add Hosteler");
        add.setBounds(100, 120, 200, 30);
        add.setFocusable(false);
        add.addActionListener(this);

        upNoti = new JButton("Upload Nofication");
        upNoti.setBounds(100, 150, 200, 30);
        upNoti.setFocusable(false);
        upNoti.addActionListener(this);

        askedServ = new JButton("Asked Services");
        askedServ.setBounds(100, 180, 200, 30);
        askedServ.setFocusable(false);
        askedServ.addActionListener(this);

        seeRent = new JButton("See Rent");
        seeRent.setBounds(100, 210, 200, 30);
        seeRent.setFocusable(false);
        seeRent.addActionListener(this);

        seeComplain = new JButton("See Complain");
        seeComplain.setBounds(100, 240, 200, 30);
        seeComplain.setFocusable(false);
        seeComplain.addActionListener(this);

        this.add(wel);
        this.add(add);
        this.add(upNoti);
        this.add(askedServ);
        this.add(seeRent);
        this.add(seeComplain);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            add info = new add();
            info.setBounds(200, 100, 500, 500);
            info.setVisible(true);
        }

        if (ae.getSource() == upNoti) {
            upNoti upNoti = new upNoti();
            upNoti.setBounds(200, 100, 500, 500);
            upNoti.setVisible(true);
        }
        if (ae.getSource() == askedServ) {
            askedServ askedServ = new askedServ();
            askedServ.setBounds(200, 100, 500, 500);
            askedServ.setVisible(true);
        }
        if (ae.getSource() == seeRent) {
            seeRent seeRent = new seeRent();
            seeRent.setBounds(200, 100, 500, 500);
            seeRent.setVisible(true);
        }
        if (ae.getSource() == seeComplain) {
            seeComplain seeComplain = new seeComplain();
            seeComplain.setBounds(200, 100, 500, 500);
            seeComplain.setVisible(true);
        }
    }

    // public static void main(String[] args) {
    //     manager hosteler = new manager();
    //     hosteler.setTitle("Hosteler Page");
    //     hosteler.setVisible(true);
    // }

}
