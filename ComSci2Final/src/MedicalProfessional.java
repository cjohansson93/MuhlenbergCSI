// Christian Johansson

public abstract class MedicalProfessional {
    private int proID;
    private String proName;

    public MedicalProfessional( int proID, String proName) {
        this.proID = proID;
        this.proName = proName;
    }

    public abstract double calcSalary();

    public int getProID() {
        return proID;
    }

    public String getProName() {
        return proName;
    }

}
