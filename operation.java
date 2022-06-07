package StudentManagementSystem;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

class operation extends JFrame implements ActionListener {
    JLabel l1;
    JTable t1;
    JButton ADD,UPDATE,DELETE;
    JButton home,back;
    JLabel d1,d2,d3,d4,d5,d6,d7,d8;
    int y = 55;
    int lw=80;
    int lh=20;

public operation() {
    setBounds(150,50,1000,650);
    setBackground(Color.GRAY);

    t1=new JTable();
    t1.setBounds(20,80,950,300);
    add(t1);

    l1= new JLabel("Select the operation");
    l1.setFont(new Font("SERIF",Font.BOLD,32));
    l1.setForeground(Color.WHITE);
    l1.setBounds(350,375,400,100);
    add(l1);



    ADD = new JButton();
    ADD.setText("ADD");
    ADD.setFont(new Font("SERIF",Font.BOLD,14));
    ADD.setForeground(Color.BLACK);
    ADD.setBounds(100,520,150,50);
    ADD.addActionListener(this);
    add(ADD);

    UPDATE = new JButton("UPDATE");
    UPDATE.setForeground(Color.BLACK);
    UPDATE.setFont(new Font("SERIF",Font.BOLD,14));
    UPDATE.setBounds(400,520,150,50);
    UPDATE.addActionListener(this);
    add(UPDATE);

    DELETE = new JButton("DELETE");
    DELETE.setForeground(Color.BLACK);
    DELETE.setFont(new Font("SERIF",Font.BOLD,14));
    DELETE.setBounds(720, 520, 150,50);
    DELETE.addActionListener(this);
    add(DELETE);

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
    
    home.setLayout(null);
    home.setVisible(true);

    try {
        conn c = new conn();
        String str = "select name, gr, dob, age, gender, address, aadhar, contact from studentdata ORDER BY gr ASC";
        ResultSet rs = c.s.executeQuery(str);
        t1.setModel(DbUtils.resultSetToTableModel(rs));

    } catch (Exception e) {
        System.out.println(e);
    }
    ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("jproject_images/b23.jpg"));
    Image i5 = i4.getImage().getScaledInstance(1000,650, Image.SCALE_SMOOTH);
    ImageIcon i6= new ImageIcon(i5);
    JLabel j1 = new JLabel(i6);
    j1.setBounds(0,0,1000,650);
    add(j1);
    setLayout(null);
    setVisible(true);
}
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == ADD) {
            new addData().setVisible(true);
            this.setVisible(false);
        }
        if(ae.getSource()== home) {
            new dashboard().setVisible(true);
            this.setVisible(false);
        }
        if(ae.getSource()==back){
            new optFields().setVisible(true);
            this.setVisible(false);

        }
        if(ae.getSource()==UPDATE){
            new ProfileUpdate().setVisible(true);
            this.setVisible(false);
        }
        if(ae.getSource()==DELETE){
            new authProfDelete().setVisible(true);
            this.setVisible(false);
        }
    }
    public static void main(String[] args) {
        new operation();
    }

}
