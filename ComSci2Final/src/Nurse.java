// Christian Johansson

public class Nurse extends MedicalProfessional{

    private boolean nurseRN;
    private boolean nurseNP;
    private double baseSalary;

    public Nurse(int proID, String proName, boolean nurseRN, boolean nurseNP, double baseSalary) {
        super(proID, proName);
        this.nurseNP = nurseNP;
        this.nurseRN = nurseRN;
        this.baseSalary = baseSalary;
    }

    public boolean isNurseRN() {
        return nurseRN;
    }

    public boolean isNurseNP() {
        return nurseNP;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    @Override
    public double calcSalary() {
        if (nurseRN) {
            return (baseSalary * 40);
        }
        else {
            return (baseSalary * 1.5 * 40);
        }
    }
}
