//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

//        System.out.println("List of All USCS Student :-");
        DB db = new DB();
////        db.getAllStudent();
////        db.insertStudent("Sonu Pandit","BCA",45,"1234567890");
//        db.getAllStudent();
//        System.out.println("\n\n\n\n\n MCA student list  ");
//        db.studentByCourse("BCA");

        db.getStudentById(10);
        db.updateStudent(10,null,"LLB",null,"4561237890");
        db.getStudentById(10);

    }

}