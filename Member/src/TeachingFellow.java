public class TeachingFellow extends Student implements Instructor{

    public TeachingFellow(String name, int bergid)
    {

        super(name,bergid);
    }

    public void addNewCourse(String name)
    {
        courses.add(name);
    };
}
