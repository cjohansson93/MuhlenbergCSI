//Christian Johansson

public class Doctor extends MedicalProfessional {

    private String specialtyName;
    private double baseSalary;
    private boolean acceptNewPatients;

    public Doctor(int proID, String proName, String specialtyName, double baseSalary, boolean acceptNewPatients) {
        super(proID, proName);
        this.specialtyName = specialtyName;
        this.baseSalary = baseSalary;
        this.acceptNewPatients = acceptNewPatients;
    }

    public double calcSalary() {
        return (baseSalary * 40);
    }

    public String getSpecialtyName() {
        return specialtyName;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public boolean isAcceptNewPatients() {
        return acceptNewPatients;
    }
}
