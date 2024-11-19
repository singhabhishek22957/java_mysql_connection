import java.sql.*;
import java.util.Scanner;

public class DB {




    private String url = "jdbc:mysql://localhost/uscs";
    private  String user = "root";
    private String dbpassword = "abhishek";

    public  void insertStudent (String s_name , String s_course , int s_age,String s_phone) {
        try {
            String query = "insert into student(name , course , age, phone) values (?,?,?,?)";

            Connection conn = DriverManager.getConnection(url,user,dbpassword);
            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setString(1,s_name);
            pstmt.setString(2,s_course);
            pstmt.setInt(3,s_age);
            pstmt.setString(4,s_phone);
            int rowsAffected = pstmt.executeUpdate();
            System.out.println("Inserted " + rowsAffected + " row(s) into the table.");


        }catch (Exception e){
            System.out.println("Error to insert student Data: "+e);
        }
    }
    public  void getStudentById (int  s_id ) {
        try {
            String query = "SELECT * FROM student WHERE id = ?;";

            Connection conn = DriverManager.getConnection(url,user,dbpassword);
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1,s_id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                System.out.println("ID: "+rs.getInt("id")+", Name: "+
                        rs.getString("name")+", Course: "+rs.getString("course")+", Age: "+
                        rs.getInt("age")+", Phone Number: "+rs.getString("phone"));
            }



        }catch (Exception e){
            System.out.println("Error to insert student Data: "+e);
        }
    }
    public  void studentByCourse (String  s_course ) {
        try {
            String query = "SELECT * FROM student WHERE course = ?;";

            Connection conn = DriverManager.getConnection(url,user,dbpassword);
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1,s_course);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                System.out.println("ID: "+rs.getInt("id")+", Name: "+
                        rs.getString("name")+", Course: "+rs.getString("course")+", Age: "+
                        rs.getInt("age")+", Phone Number: "+rs.getString("phone"));
            }



        }catch (Exception e){
            System.out.println("Error to insert student Data: "+e);
        }
    }

    public  void getAllStudent () {
        try {
            String query = "select *from student";

            Connection conn = DriverManager.getConnection(url,user,dbpassword);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()){
                System.out.println("ID: "+rs.getInt("id")+", Name: "+
                        rs.getString("name")+", Course: "+rs.getString("course")+", Age: "+
                        rs.getInt("age")+", Phone Number: "+rs.getString("phone"));
            }


        }catch (Exception e){
            System.out.println("Error to insert student Data: "+e);
        }
    }

    public  void updateStudent (int s_id,String s_name , String s_course , Integer s_age,String s_phone) {
//        Scanner sc = new Scanner(System.in);
//        int s_id = sc.nextInt();

//        System.out.println("Enter your id to update your profile ");


        try {

            String queryCheck = "select * from student where id = ? limit 1";

            Connection conn = DriverManager.getConnection(url,user,dbpassword);
            PreparedStatement pstmt = conn.prepareStatement(queryCheck);


            pstmt.setInt(1,s_id);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
            if(s_name==null){
                s_name = rs.getString("name");
            }
            if(s_age==null){
                s_age = rs.getInt("age");
            }
            if(s_course==null){
                s_course = rs.getString("course");
            }
            if(s_phone==null){
                s_phone = rs.getString("phone");
            }
            }else {
                System.out.println("student not found");
                return;
            }
            String queryUpdate = "UPDATE student SET name = ?, course = ?, age =? , phone =?  WHERE id = ? limit 1";
            PreparedStatement pstmt1 = conn.prepareStatement(queryUpdate);
//            ResultSet rs = pstmt.executeQuery(query1);
                pstmt1.setString(1,s_name);
                pstmt1.setString(2,s_course);
                pstmt1.setInt(3,s_age);
                pstmt1.setString(4,s_phone);
                pstmt1.setInt(5,s_id);
                int rowsAffected = pstmt1.executeUpdate();
                System.out.println("update " + rowsAffected + " row(s) into the table.");





            rs.close();
            pstmt1.close();
            pstmt.close();
            conn.close();

        }catch (Exception e){
            System.out.println("Error to update  student Data: "+e);
        }
    }











}
