package StudentManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class authProfDelete extends JFrame implements ActionListener {
    JTextField username;
    JPasswordField pass;
    JLabel l1,l2;
    JButton si,cn;
    authProfDelete(){

        username=new JTextField();
        username.setBounds(180,50,120,40);
        add(username);

        pass=new JPasswordField();
        pass.setBounds(180,120,120,40);
        add(pass);

        l1=new JLabel("Username");  //username label
        l1.setBounds(70,50,70,50);
        l1.setForeground(Color.BLACK);
        add(l1);

        l2=new JLabel("Password");  //password label
        l2.setBounds(70,120,70,50);
        l2.setForeground(Color.BLACK);
        add(l2);

        si= new JButton("Sign In");
        si.setBounds(80,250,120,40);
        si.addActionListener(this);
        add(si);

        cn = new JButton("Cancel");
        cn.setBounds(300,250,120,40);
        cn.addActionListener(this);
        add(cn);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("jproject_images/password_image.jpg"));
        Image i2 = i1.getImage().getScaledInstance(150,150, Image.SCALE_SMOOTH);
        ImageIcon i3= new ImageIcon(i2);
        JLabel j3 = new JLabel(i3);
        j3.setBounds(350,50,150,150);
        add(j3);

        getContentPane().setBackground(Color.GRAY);
        setLayout(null);
        setBounds(350,150,600,400);// setting the frame dimensions
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == si) {
            String username = this.username.getText();
            String password = String.valueOf(pass.getPassword());
            conn c = new conn();
            String str = "select * from login where username ='" + username + "'and password ='" + password + "'";
            try {
                ResultSet rs = c.s.executeQuery(str);
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Login Successful!!!");
                    new deleteProfile().setVisible(true);
                    this.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Username and Password!!!");
                }
            } catch (Exception e) {

            }
        } else if (ae.getSource() == cn) {
            new operation().setVisible(true);//going back to homepage
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new authProfDelete();
    }
}


