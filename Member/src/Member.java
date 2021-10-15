public abstract class Member {
    private String name;
    private int bergid;

    public Member(String name, int bergid) {
        this.name = name;
        this.bergid = bergid;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBergid() {
        return bergid;
    }

    public abstract double getGPA();
}
