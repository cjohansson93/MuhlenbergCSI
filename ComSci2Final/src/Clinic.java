//Christian Johansson

import java.util.Scanner;
import java.util.Stack;

public class Clinic {
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        Stack<MedicalProfessional> staff = new Stack<>();

        boolean quit = false;
        while ( !quit ) {

            System.out.println("-------------------------Menu--------------------------");
            System.out.println("Would you like to add additional clinic staff?");
            System.out.println("1. Yes ");
            System.out.println("2. No");
            System.out.println("Enter the number corresponding to what you'd like to do: ");
            int menuChoice = keyboard.nextInt();

            if (menuChoice == 1 || menuChoice == 2) {
                switch (menuChoice) {

                    case 1:
                        addStaff(staff);
                        break;
                    case 2:
                        outputStaff(staff);
                        quit = true;
                        break;
                }
            }
            else {
                System.out.println("That is an invalid entry! Try again.'" +
                        "");
            }
        }
    }

    public static void addStaff(Stack<MedicalProfessional> staff) {

        Scanner keyboard = new Scanner(System.in);

        System.out.println("-------------------------Add Staff Menu--------------------------");
        System.out.println("Would you like to add a doctor or a nurse?");
        System.out.println("1. Doctor ");
        System.out.println("2. Nurse ");
        System.out.println("Enter the number corresponding to what you'd like to do: ");
        int menuChoice = keyboard.nextInt();

        if (menuChoice == 1 || menuChoice == 2) {
            switch (menuChoice) {

                case 1:
                    System.out.println("Please enter the doctor's id: ");
                    int docID = keyboard.nextInt();
                    keyboard.nextLine();
                    System.out.println("Please enter the doctor's name: ");
                    String docName = keyboard.nextLine();
                    System.out.println("Please enter the doctor's specialty: ");
                    String docSpec = keyboard.nextLine();
                    System.out.println("Please enter the doctor's base pay: ");
                    double docPay = keyboard.nextDouble();
                    keyboard.nextLine();
                    System.out.println("Is the doctor accepting new patients (Yes/No):");
                    String docNewPat = keyboard.nextLine();

                    if (docNewPat.equals("Yes") || docNewPat.equals("yes")) {

                        Doctor doctor = new Doctor(docID,docName,docSpec,docPay,true);
                        staff.push(doctor);
                    }
                    else {
                        Doctor doctor = new Doctor(docID,docName,docSpec,docPay,false);
                        staff.push(doctor);

                    }
                    break;
                case 2:
                    System.out.println("Please enter the nurse's id: ");
                    int nurseID = keyboard.nextInt();
                    keyboard.nextLine();
                    System.out.println("Please enter the nurse's name: ");
                    String nurseName = keyboard.nextLine();
                    System.out.println("Please enter the nurse's base pay: ");
                    double nursePay = keyboard.nextDouble();
                    keyboard.nextLine();
                    System.out.println("Is the nurse a registered nurse or nurse practitioner (RN/NP): ");
                    String nurseRNorNP = keyboard.nextLine();

                    if (nurseRNorNP.equals("RN") || nurseRNorNP.equals("rn")) {
                        Nurse nurse = new Nurse(nurseID,nurseName,true,false,nursePay);
                        staff.push(nurse);

                    }
                    else {
                        Nurse nurse = new Nurse(nurseID,nurseName,false,true,nursePay);
                        staff.push(nurse);

                    }
                    break;
            }
        }
        else {
            System.out.println("That is an invalid entry! Try again.'" +
                    "");
        }
    }

    public static void outputStaff(Stack<MedicalProfessional> staff) {

        for( MedicalProfessional person : staff) {
            if (person instanceof Doctor) {
                if (((Doctor)person).isAcceptNewPatients()) {
                    System.out.println("ID: " + person.getProID() + " Name: " + person.getProName() + ", " + ((Doctor)person).getSpecialtyName() + ", Salary: $" + ((Doctor)person).calcSalary() + ", Accepting New Patients");
                }
                else {
                    System.out.println("ID: " + person.getProID() + " Name: " + person.getProName() + ", " + ((Doctor)person).getSpecialtyName() + ", Salary: $" + ((Doctor)person).calcSalary() + ", Not Accepting New Patients");
                }
            }
            else {
                if (((Nurse)person).isNurseRN()) {
                    System.out.println("ID: " + person.getProID() + " Name: " + person.getProName() + ", RN" + ", Salary: $" + ((Nurse)person).calcSalary());
                }
                else {
                    System.out.println("ID: " + person.getProID() + " Name: " + person.getProName() + ", NP" + ", Salary: $" + ((Nurse)person).calcSalary());
                }
            }
        }

    }
}
