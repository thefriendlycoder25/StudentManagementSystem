package StudentManagementSystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.sql.PreparedStatement;

public class studAssignment extends JFrame implements ActionListener {

    JButton addFile;

    studAssignment() {
        setBounds(150, 50, 800, 450);
        addFile = new JButton("Upload file");
        addFile.setBounds(100, 200, 120, 50);
        addFile.addActionListener(this);
        add(addFile);


        setLayout(null);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == addFile) {
            JFileChooser add = new JFileChooser();
            int result = add.showOpenDialog(null);
            System.out.println(result); // will rteturn 0 if file is choosen successfully
            File selectedFile = add.getSelectedFile();
            String fileName = selectedFile.getName();
            //System.out.println(fileName);
            if (result == JFileChooser.APPROVE_OPTION) {
                String path = selectedFile.getAbsolutePath();
                int gr =4;

                FileInputStream fis = null;
                try {
                    conn c = new conn();
                    fis = new FileInputStream(path);
                    String str = "insert into assignmentdata (rollNo, file)  values ('4',?) ";
                    PreparedStatement pst = c.c.prepareStatement(str);
                   // c.s.executeUpdate(str);
                    pst.setBinaryStream(1,fis);
                    int record = pst.executeUpdate();
                    if (record ==1)
                    {
                        JOptionPane.showMessageDialog(null,"Successfully Uploaded the file");
                    }


                } catch (Exception e) {
                    System.out.println(e);
                }

            }
        }
    }


        public static void main (String[]args){
            new studAssignment();
        }



}

