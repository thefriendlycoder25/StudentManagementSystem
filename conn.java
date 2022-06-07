package StudentManagementSystem;

import java.sql.*;
    public class conn {
        Connection c;
        Statement s;
        conn(){
            String url="jdbc:mysql://localhost:3306/sms";
            String username="root";
            String password="Devesh@2512";
            try {


                c = DriverManager.getConnection(url, username, password);
                s = c.createStatement();

            }catch (Exception e){
                e.printStackTrace();
            }}

        public static void main(String[] args) {
            new conn();
        }
    }
