package StudentManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class higherSecondarySection extends JFrame implements ActionListener {
    JLabel t1;
    JButton l1,l2;
    JButton back;
    JLabel b;
    int btnFntSize=14;
    int btnW=200;
    int btnH=90;
    higherSecondarySection(){
        setBounds(300,100,700,400);
        t1 = new JLabel();
        t1.setText("Select the Standard");
        t1.setFont(new Font("SERIF",Font.BOLD,28));
        t1.setForeground(Color.WHITE);
        t1.setBounds(150,0,400,100);
        add(t1);

        l1 = new JButton();
        l1.setText("9th Standard");
        l1.setFont(new Font("SERIF",Font.BOLD,btnFntSize));
        l1.setForeground(Color.BLACK);
        l1.setBounds(150,80,btnW,btnH);
        l1.addActionListener(this);
        add(l1);

        l2 = new JButton();
        l2.setText("1Oth Standard");
        l2.setFont(new Font("SERIF",Font.BOLD,btnFntSize));
        l2.setForeground(Color.BLACK);
        l2.setBounds(150,200,btnW,btnH);
        l2.addActionListener(this);
        add(l2);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("jproject_images/back.png"));
        Image i2 = i1.getImage().getScaledInstance(90,50, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        back=new JButton(i3);
        back.setBounds(5,5,60,60);

        back.addActionListener(this);
        add(back);

        back.setLayout(null);
        back.setVisible(true);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("jproject_images/b12.jpg"));
        Image i5 = i4.getImage().getScaledInstance(690,400, Image.SCALE_SMOOTH);
        ImageIcon i6= new ImageIcon(i5);
        JLabel j1 = new JLabel(i6);
        j1.setBounds(0,0,690,400);
        add(j1);

        setLayout(null);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            new dashboard().setVisible(true);
            this.setVisible(false);

        }
        else if ((ae.getSource() == l1) || (ae.getSource() == l2)) {
            new optFields().setVisible(true);
            this.setVisible(false);
        }
    }
    public static void main(String[] args) {
        new higherSecondarySection();
    }
}


