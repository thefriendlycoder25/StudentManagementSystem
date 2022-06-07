package StudentManagementSystem;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class marks extends JFrame implements ActionListener{
    JLabel l1;
    JTable t1,pass,fail;
    JButton ADD,UPDATE,calculate,back;
    JButton home;
    JLabel d1,d2,d3,d4,d5,d6,d7,d8;
    int y = 75;
    int lw=80;
    int lh=20;

    public marks() {
        setBounds(150,50,800,450);
        setBackground(Color.GRAY);

        t1=new JTable();
        t1.setBounds(280,100,450,300);
        add(t1);



        pass = new JTable();
        pass.setBounds(280,100,450,90);
        //add(pass);


        fail = new JTable();
        fail.setBounds(280,250,450,90);

        l1= new JLabel("Select the operation");
        l1.setFont(new Font("SERIF",Font.BOLD,32));
        l1.setForeground(Color.DARK_GRAY);
        l1.setBounds(220,-10,400,100);
        add(l1);



        ADD = new JButton();
        ADD.setText("ADD");
        ADD.setFont(new Font("SERIF",Font.BOLD,15));
        ADD.setForeground(Color.BLACK);
        ADD.setBounds(60,100,120,70);
        ADD.addActionListener(this);
        add(ADD);

//        UPDATE = new JButton("UPDATE");
//        UPDATE.setForeground(Color.BLACK);
//        UPDATE.setFont(new Font("SERIF",Font.BOLD,13));
//        UPDATE.setBounds(60,200,100,50);
//        add(UPDATE);

        calculate = new JButton("Pass/Fail");
        calculate.setForeground(Color.BLACK);
        calculate.setFont(new Font("SERIF",Font.BOLD,15));
        calculate.setBounds(60, 250, 120,70);
        calculate.addActionListener(this);
        add(calculate);

        d1=new JLabel("Name");
        d1.setBounds(370,y,lw,lh);
        add(d1);

        d2=new JLabel("Gr .No");
        d2.setBounds(290,y,lw,lh);
        add(d2);

        d3=new JLabel("English");
        d3.setBounds(440,y,lw,lh);
        add(d3);

        d4=new JLabel("Maths");
        d4.setBounds(500,y,lw,lh);
        add(d4);

        d5=new JLabel("Science");
        d5.setBounds(560,y,lw,lh);
        add(d5);

        d6=new JLabel("Total ");
        d6.setBounds(620,y,lw,lh);
        add(d6);

        d7=new JLabel("Passed Students");
        d7.setBounds(370,y,180,lh);

        d8=new JLabel("Failed Students");
        d8.setBounds(370,220,180,lh);



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
            String str = "select gr,name, eng, math, sci, totalmarks from studentdata ORDER BY gr ASC";
            ResultSet rs = c.s.executeQuery(str);
            t1.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            System.out.println(e);
        }
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("jproject_images/b23.jpg"));
        Image i5 = i4.getImage().getScaledInstance(800,450, Image.SCALE_SMOOTH);
        ImageIcon i6= new ImageIcon(i5);
        JLabel j1 = new JLabel(i6);
        j1.setBounds(0,0,800,450);
        add(j1);
        setLayout(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            new optFields().setVisible(true);
            this.setVisible(false);
        }
        if(ae.getSource()==ADD){
            new addMarks().setVisible(true);
            this.setVisible(false);
        }
        if(ae.getSource()==calculate){
            t1.setVisible(false);
            d1.setVisible(false);
                    d2.setVisible(false);
                    d3.setVisible(false);
                    d4.setVisible(false);
                    d5.setVisible(false);
                    d6.setVisible(false);
                    add(d7);
                    d7.setVisible(true);
            add(d8);
            d8.setVisible(true);
//            JOptionPane.showMessageDialog(null,"hello");
            try{
                String str = "select name, totalmarks from studentdata where totalmarks>'150'";
                conn c = new conn();
                ResultSet rs1 = c.s.executeQuery(str);
                pass.setModel(DbUtils.resultSetToTableModel(rs1));
                add(pass);
            }catch (Exception e){
                System.out.println(e);
            }
            try{
                String str = "select name, totalmarks from studentdata where totalmarks<'150'";
                conn c = new conn();
                ResultSet rs1 = c.s.executeQuery(str);
                fail.setModel(DbUtils.resultSetToTableModel(rs1));
                add(fail);
            }catch (Exception e){
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        new marks();
    }
}
