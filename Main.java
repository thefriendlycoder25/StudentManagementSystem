package StudentManagementSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame implements ActionListener{
    JButton j2,j1;

Main(){
    setBounds(350,150,600,450);


    ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("jproject_images/first.jpg"));
    Image i2 = i1.getImage().getScaledInstance(600,450,Image.SCALE_DEFAULT);
    JLabel l1 = new JLabel(i1); // REMEMBER - you will always need to put the imageIcon  in the frame using a label only
    l1.setBounds(0,0,600,450);
    add(l1);
    JLabel l2 = new JLabel("Moordale Secondary");
    l2.setForeground(Color.black);
    l2.setBounds(130,-110,500,300);
    l2.setFont(new Font("Serif",Font.BOLD,34));
    l1.add(l2);
    j1 = new JButton("Teacher Login");
    j1.setBounds(400,300,150,60);
    j1.setBackground(Color.white);
    j1.addActionListener(this);
    l1.add(j1);
    j2 = new JButton("Student Login");
    j2.setBounds(45,300,150,60);
    j2.setBackground(Color.white);
    j2.addActionListener(this);
    l1.add(j2);
    setLayout(null);
    setVisible(true);


}
public void actionPerformed(ActionEvent l) {
    if (l.getSource() == j1) {
        new login().setVisible(true);   //linking the login page
        this.setVisible(false);
    }
    if (l.getSource() == j2) {
        new studLogin().setVisible(true);
        this.setVisible(false);
    }
}
    public static void main(String[] args) {
	// write your code here
new Main();

    }
}
