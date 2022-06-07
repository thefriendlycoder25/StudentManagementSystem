package StudentManagementSystem;
import net.proteanit.sql.DbUtils;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;

public class ProfileUpdate extends JFrame implements ActionListener {
    JLabel l1,l2,l3;
    JLabel d1,d2,d3,d4,d5,d6,d7,d8;
    JTextField t1,t2;
    JComboBox c1;
    JButton submit,display;
    JTable t;
    JButton home,back;
    int y = 80;
    int lw=80;
    int lh=20;
    String list[]={"Name","Age","Address","Aadhar","Contact"};
    ProfileUpdate()
    {
        setBounds(200,20,1000,700);

        l1=new JLabel("GR Number");
        l1.setBounds(40,40,120,30);
        l1.setFont(new Font("SEGIO",Font.BOLD,15));
        l1.setForeground(Color.WHITE);
        add(l1);

        t1= new JTextField();
        t1.setBounds(175,40,150,30);
        add(t1);

        display=new JButton("Display");
        display.setBounds(350,40,100,30);
        display.addActionListener(this);
        add(display);

        t=new JTable();
        t.setBounds(30,120,950,150);
        t.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(t);

        l2= new JLabel("Choose the field");
        l2.setBounds(40,300,200,30);
        l2.setFont(new Font("SEGIO",Font.BOLD,16));
        l2.setForeground(Color.WHITE);
        add(l2);

        c1=new JComboBox(list);
        c1.setBounds(220,300,120,30);
        add(c1);

        l3=new JLabel("Enter the value");
        l3.setBounds(40,350,200,30);
        l3.setFont(new Font("SEGIO",Font.BOLD,16));
        l3.setForeground(Color.WHITE);
        add(l3);

        t2=new JTextField();
        t2.setBounds(220,350,200,30);
        add(t2);

        d1=new JLabel("Name");
        d1.setBounds(35,y,lw,lh);
        d1.setForeground(Color.WHITE);
        add(d1);

        d2=new JLabel("Gr .No");
        d2.setBounds(185,y,lw,lh);
        d2.setForeground(Color.WHITE);
        add(d2);

        d3=new JLabel("DOB");
        d3.setBounds(285,y,lw,lh);
        d3.setForeground(Color.WHITE);
        add(d3);

        d4=new JLabel("Age");
        d4.setBounds(385,y,lw,lh);
        d4.setForeground(Color.WHITE);
        add(d4);

        d5=new JLabel("Gender");
        d5.setBounds(500,y,lw,lh);
        d5.setForeground(Color.WHITE);
        add(d5);

        d6=new JLabel("Address");
        d6.setBounds(650,y,lw,lh);
        d6.setForeground(Color.WHITE);
        add(d6);

        d7=new JLabel("Aadhar");
        d7.setBounds(785,y,lw,lh);
        d7.setForeground(Color.WHITE);
        add(d7);

        d8=new JLabel("Contact");
        d8.setBounds(885,y,lw,lh);
        d8.setForeground(Color.WHITE);
        add(d8);

        submit=new JButton("Submit");
        submit.setBounds(220,400,100,30);
        submit.addActionListener(this);
        add(submit);
        //dasboard button
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("jproject_images/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(40,40, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        home=new JButton(i3);
        home.setBounds(940,5,35,30);
        home.addActionListener(this);
        add(home);

        //back button
        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("jproject_images/back.png"));
        Image i12 = i11.getImage().getScaledInstance(60,30, Image.SCALE_SMOOTH);
        ImageIcon i13 = new ImageIcon(i12);
        back=new JButton(i13);
        back.setBounds(5,5,35,35);

        back.addActionListener(this);
        add(back);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("jproject_images/b22.jpg"));
        Image i5 = i4.getImage().getScaledInstance(1000,650, Image.SCALE_SMOOTH);
        ImageIcon i6= new ImageIcon(i5);
        JLabel j1 = new JLabel(i6);
        j1.setOpaque(false);
        j1.setBounds(1,1,1000,650);
        add(j1);


        setLayout(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == display) {
            String gr = this.t1.getText();
            try {
                conn c = new conn();
                String str = "select  name, gr, dob, age, gender, address, aadhar, contact from studentdata where gr = '" + gr + "'";
                ResultSet rs = c.s.executeQuery(str);
                t.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        else if(ae.getSource()==submit){
            String choice = (String) c1.getSelectedItem();
            String gr = this.t1.getText();
            String value = t2.getText();
            switch (choice){
                case "Name" : choice = "name";
                    break;
                case  "Aadhar" : choice = "aadhar";
                    break;
                case  "Address" : choice = "address";
                    break;
                case  "Age" : choice = "age";
                    break;
                case  "Contact" : choice = "contact";
                    break;
            }
            //JOptionPane.showMessageDialog(null,choice);
            try {
                conn c = new conn();
                String str = "update studentdata set "+choice+" = '"+value+"' where gr = '"+gr+"'";
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"Profile Updated Successfully");
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        if(ae.getSource()==back){
            new operation().setVisible(true);
            this.setVisible(false);

        }
        if(ae.getSource()== home) {
            new dashboard().setVisible(true);
            this.setVisible(false);
        }

    }
    public static void main(String[] args)
    {
        new ProfileUpdate();
    }
}