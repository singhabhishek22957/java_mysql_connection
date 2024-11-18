import java.sql.*;

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







}
