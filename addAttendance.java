package StudentManagementSystem;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class addAttendance extends JFrame implements ActionListener{
  JLabel l1,l2,l3,l4,l5,l6;
  JTextField record,gr;
  JButton submit,display;
  JTable t1;
  JButton home,back;

  addAttendance()
  {
    setBounds(400,20,600,700);

    l1=new JLabel("GR Number");
    l1.setBounds(40,60,120,30);
    l1.setFont(new Font("SEGIO",Font.BOLD,15));
    l1.setForeground(Color.WHITE);
    add(l1);

    gr= new JTextField();
    gr.setBounds(175,60,180,40);
    add(gr);

    t1 = new JTable();
    t1.setBounds(40,200,500,50);
    t1.setFont(new Font("TAHOMA",Font.PLAIN,16));
    t1.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
    add(t1);


    l2=new JLabel("Add Record");
    l2.setBounds(40,400,150,30);
    l2.setFont(new Font("SEGIO",Font.BOLD,15));
    l2.setForeground(Color.WHITE);
    add(l2);

    l3=new JLabel("Name");
    l3.setBounds(50,160,100,40);
    l3.setForeground(Color.white);
    add(l3);

    l4=new JLabel("Gr No");
    l4.setBounds(180,160,100,40);
    l4.setForeground(Color.white);
    add(l4);

    l5=new JLabel("Address");
    l5.setBounds(300,160,100,40);
    l5.setForeground(Color.white);
    add(l5);

    l6=new JLabel("Attendance");
    l6.setBounds(420,160,100,40);
    l6.setForeground(Color.white);
    add(l6);

    record= new JTextField();
    record.setBounds(190,400,180,40);
    add(record);

    submit=new JButton("Submit");
    submit.setBounds(200,500,100,40);
    submit.addActionListener(this);
    add(submit);

    display = new JButton("Display");
    display.setBounds(400,40,80,40);
    display.addActionListener(this);
    add(display);
    //back button
    ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("jproject_images/back.png"));
    Image i12 = i11.getImage().getScaledInstance(60,30, Image.SCALE_SMOOTH);
    ImageIcon i13 = new ImageIcon(i12);
    back=new JButton(i13);
    back.setBounds(5,5,35,35);

    back.addActionListener(this);
    add(back);

    //dasboard button
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("jproject_images/home.jpg"));
    Image i2 = i1.getImage().getScaledInstance(40,40, Image.SCALE_SMOOTH);
    ImageIcon i3 = new ImageIcon(i2);
    home=new JButton(i3);
    home.setBounds(550,5,35,30);
    home.addActionListener(this);
    add(home);

    ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("jproject_images/b9.jpg"));
    Image i5 = i4.getImage().getScaledInstance(600,700, Image.SCALE_SMOOTH);
    ImageIcon i6= new ImageIcon(i5);
    JLabel j1 = new JLabel(i6);
    j1.setBounds(1,1,600,700);
    add(j1);
    setLayout(null);
    setVisible(true);


  }
  public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == display) {
      String gr = this.gr.getText();
      try {
        conn c = new conn();
        String str = "select name, gr, address, attendance from studentdata where gr = '"+gr+"'";
        ResultSet rs = c.s.executeQuery(str);
        t1.setModel(DbUtils.resultSetToTableModel(rs));
      } catch (Exception e) {
        System.out.println(e);
      }
    }
    else  if(ae.getSource()==submit){
      String gr = this.gr.getText();
      String at = record.getText();
      try {
        conn c = new conn();
        String str = "update studentdata set attendance = '"+at+"' where gr = '"+gr+"';";
        c.s.executeUpdate(str);
        JOptionPane.showMessageDialog(null,"Attendance Record Added Successfully");
      } catch (Exception e) {
        System.out.println(e);
      }
    }
    else if(ae.getSource()==back){
      new _attendance().setVisible(true);
      this.setVisible(false);

    }
    else if(ae.getSource()== home) {
      new dashboard().setVisible(true);
      this.setVisible(false);
    }
  }
  public static void main(String[] args)
  {
    new addAttendance();
  }
}
