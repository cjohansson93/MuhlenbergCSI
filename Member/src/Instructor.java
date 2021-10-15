import java.util.ArrayList;

public interface Instructor {
    static ArrayList<String> courses = new ArrayList<String>();

    public abstract void addNewCourse(String name);

}
