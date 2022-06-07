package StudentManagementSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.*;
public class dashboard extends JFrame implements ActionListener {
    JMenuBar mb;
    JMenuItem i1,i2,i3;
    JButton primary, secondary,Higher_secondary, cancel;
    JLabel noticeBoard;
   public dashboard(){
        setBounds(300,100,700,600);
        mb = new JMenuBar();
        mb.setBackground(Color.getColor("gray",40));
        mb.setBounds(0,0,150,600);
//       mb.setMargin(new Insets(50, 50, 50, 50));

        mb.setLayout(new GridLayout(5,1,0,20));
        add(mb);

        primary= new JButton("Primary");
        primary.setBackground(Color.white);
//        primary.setBounds(100,-200,60,20);
        primary.setVerticalAlignment(SwingConstants.CENTER);
       primary.setBounds(1,1 , 80, 20);
       primary.addActionListener(this);
       mb.add(primary);

        secondary= new JButton("secondary");
        secondary.setBackground(Color.white);
        secondary.setBounds(100,-200,60,20);
        secondary.setHorizontalAlignment(SwingConstants.CENTER);
       secondary.addActionListener(this);
        mb.add(secondary);

        Higher_secondary= new JButton("<html>Higher<br>secondary</html>");
        Higher_secondary.setBackground(Color.white);
//        Higher_secondary.setBounds(100,-200,60,20);
        Higher_secondary.setHorizontalAlignment(SwingConstants.CENTER);
       Higher_secondary.addActionListener(this);
        mb.add(Higher_secondary);

        cancel = new JButton("Logout");
       cancel.addActionListener(this);
        mb.add(cancel);


       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("jproject_images/b18.jpg"));
       Image i2 = i1.getImage().getScaledInstance(540,550, Image.SCALE_SMOOTH);
       ImageIcon i3= new ImageIcon(i2);
       JLabel j3 = new JLabel(i3);
       j3.setBounds(150,10,540,550);
       add(j3);

        setLayout(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
       if(ae.getSource()==primary){
           new primarySection().setVisible(true);
           this.setVisible(false);
       }
       else if(ae.getSource()==secondary){
           new secondarySection().setVisible(true);
           this.setVisible(false);
       }
       else if(ae.getSource()==Higher_secondary){
           new higherSecondarySection().setVisible(true);
           this.setVisible(false);

       }
       else if(ae.getSource()==cancel){
           new Main().setVisible(true);
           this.setVisible(false);
       }

    }

    public static void main(String[] args) {
        new dashboard();
    }
}
