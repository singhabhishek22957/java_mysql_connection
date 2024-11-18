import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class SqlConnections {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String url = "jdbc:mysql://localhost:3306/uscs";
        String user = "root";
        String password = "abhishek";
        String query = "insert into student (name,course,age,phone) values (?,?,?,?)";
        System.out.print("Enter your Name: ");
        String name = sc.nextLine();
        System.out.print("Enter your Course: ");
        String course = sc.next();
        System.out.print("Enter your Age: ");
        int age = sc.nextInt();
        System.out.print("Enter your Phone: ");
        String phone = sc.next();


        try {
            Connection conn = DriverManager.getConnection(url,user,password);
            PreparedStatement pstat = conn.prepareStatement(query);

            pstat.setString(1,name);
            pstat.setString(2,course);
            pstat.setInt(3,age);
            pstat.setString(4,phone);

            int rowsAffected = pstat.executeUpdate();
            System.out.println("Inserted " + rowsAffected + " row(s) into the table.");

        } catch (Exception e) {
            System.out.println("Error to connect DB:"+e);
        }
    }
}
