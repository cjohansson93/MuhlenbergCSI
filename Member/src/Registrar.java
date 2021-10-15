import java.lang.reflect.Array;
import java.util.ArrayList;

public class Registrar {

    public static void main(String[] args) {
        Student johnDoe = new Student("John Doe", 12345);
        johnDoe.addNewCourseCredit(95);
        Faculty janeDoe = new Faculty("Jane Doe", 54421, 3.9);
        TeachingFellow juneDoe = new TeachingFellow("June Doe", 74233);
        juneDoe.addNewCourseCredit(85);

        System.out.println(johnDoe.getName() + " " + johnDoe.getBergid() + " " + johnDoe.getGPA());
        System.out.println(janeDoe.getName() + " " + janeDoe.getBergid() + " " + janeDoe.getGPA());
        System.out.println(juneDoe.getName() + " " + juneDoe.getBergid() + " " + juneDoe.getGPA());

        ArrayList<String> myInts;

        ArrayList<Member> members = new ArrayList<Member>();
        members.add(johnDoe);
        members.add(janeDoe);
        members.add(juneDoe);

        System.out.println(members.get(0).getName() + " " + members.get(0).getBergid() + " " + members.get(0).getGPA());
        System.out.println(members.get(1).getName() + " " + members.get(1).getBergid() + " " + members.get(1).getGPA());
        System.out.println(members.get(2).getName() + " " + members.get(2).getBergid() + " " + members.get(2).getGPA());

        for (int i = 0; i < members.size(); i++) {
            if (members.get(i) instanceof Student) {
                Student temp = (Student) members.get(i);
                temp.addNewCourseCredit(90);

                ((Student) members.get(i)).addNewCourseCredit(96);
            } else if (members.get(i) instanceof Faculty) {
                ((Faculty) members.get(i)).addNewCourse("Programming II");
            } else {
                ((TeachingFellow) members.get(i)).addNewCourse("Programming II");
                ((TeachingFellow) members.get(i)).addNewCourseCredit(100);
            }
        }
    }
}
