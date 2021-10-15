import java.util.ArrayList;

public class Faculty extends Member implements Instructor{

    private double gpa;
    public Faculty(String name, int bergid, double gpa)
    {
        super(name,bergid);
        this.gpa = gpa;
    }

    public void addNewCourse(String name)
    {

        courses.add(name);
    }

    public double getGPA()
    {
        return this.gpa;
    }
}
