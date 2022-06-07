package StudentManagementSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class primarySection extends JFrame implements ActionListener {
    JLabel t1;
    JButton l1,l2,l3,l4;
    JButton back;
    JLabel b;
    int btnFntSize=14;
    int btnW=150;
    int btnH=40;
    primarySection(){
        setBounds(300,100,700,400);
        t1 = new JLabel();
        t1.setText("Select the Standard");
        t1.setFont(new Font("SERIF",Font.BOLD,28));
        t1.setForeground(Color.WHITE);
        t1.setBounds(150,0,400,100);
        add(t1);

        l1 = new JButton();
        l1.setText("1st Standard");
        l1.setFont(new Font("SERIF",Font.BOLD,btnFntSize));
        l1.setForeground(Color.BLACK);
        l1.addActionListener(this);
        l1.setBounds(50,120,btnW,btnH);
        add(l1); 
        
        l2 = new JButton();
        l2.setText("2nd Standard");
        l2.setFont(new Font("SERIF",Font.BOLD,btnFntSize));
        l2.setForeground(Color.BLACK);
        l2.addActionListener(this);
        l2.setBounds(250,120,btnW,btnH);
        add(l2);
        
        l3 = new JButton();
        l3.setText("3rd Standard");
        l3.setFont(new Font("SERIF",Font.BOLD,btnFntSize));
        l3.setForeground(Color.BLACK);
        l3.addActionListener(this);
        l3.setBounds(50,200,btnW,btnH);
        add(l3);
        
        l4 = new JButton();
        l4.setText("4th Standard");
        l4.setFont(new Font("SERIF",Font.BOLD,btnFntSize));
        l4.setForeground(Color.BLACK);
        l4.setBounds(250,200,btnW,btnH);
        l4.addActionListener(this);
        add(l4);

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
        else if((ae.getSource()==l1)||(ae.getSource()==l2)||(ae.getSource()==l3)||(ae.getSource()==l4)){
            new optFields().setVisible(true);
            this.setVisible(false);
        }
    }
    public static void main(String[] args) {
        new primarySection();
    }
}
