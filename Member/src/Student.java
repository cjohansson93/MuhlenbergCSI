import java.util.ArrayList;

public class Student extends Member{

    private ArrayList<Integer> grades;

    public Student(String name, int bergid)
    {
        super(name,bergid);
        this.grades = new ArrayList<Integer>();
    }

    public void addNewCourseCredit(int grade)
    {
        grades.add(grade);
    }

    public double getGPA()
    {
        double sum = 0;
        for(int i = 0; i < grades.size(); i++)
        {
            sum += (grades.get(i)/100.00)*4;
        }

        return sum/grades.size();
    }
}
