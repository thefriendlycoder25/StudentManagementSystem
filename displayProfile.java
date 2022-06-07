package StudentManagementSystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


import net.proteanit.sql.*;

public class displayProfile extends JFrame implements ActionListener {
    JTable t1;
    JButton b1;
    displayProfile(){
        setBounds(50,50,1000,600);

        t1=new JTable();
        t1.setBounds(0,40,1000,400);
        add(t1);

        b1= new JButton("Display");
        b1.setBounds(350,500,80,50);
        b1.addActionListener(this);
        add(b1);

        setLayout(null);
        setVisible(true);
    }
public void actionPerformed(ActionEvent ae) {

    if (ae.getSource() == b1) {
        try {
            conn c = new conn();
            String str = "select * from studentdata";
            ResultSet rs = c.s.executeQuery(str);
            t1.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {

        }
    }
}
    public static void main(String[] args) {
        new displayProfile();
    }
}

