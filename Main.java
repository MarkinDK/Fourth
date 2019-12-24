import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            System.out.println("значения пациента");
            int x1 = in.nextInt();
            int x2 = in.nextInt();
            int x3 = in.nextInt();
            int x4 = in.nextInt();
            in.close();
            if (x1 == 0 && x2 == 0 && x3 == 0 && x4 == 0)
                throw new OurException();
            Doctor doctor = new Doctor("Доктор");
            Patient kozlik = new Patient("Козлик", false, x1, x2, x3, x4);
            Friend neznayka = new Friend("Незнайка", 5);
            Friend.Notebook notebook = neznayka.new Notebook();
            notebook.addNumber("88005553535");
            class Cure {
                public void cure(Patient patient, Doctor doctor) {
                    while (!kozlik.isStatement()) {
                        patient.setPrescription(doctor.prescription(patient.symptoms()));
                        Prescription prescription = patient.getPrescription();
                        ArrayList<Medicine> medicines = prescription.getMedicines();
                        while (prescription.getProgress() < prescription.getSpell()) {
                            System.out.println(prescription.getProgress() + 1 + " день.");
                            for (int i = 0; i < medicines.size(); i++) {
                                if (medicines.get(i).medicate(kozlik)) {
                                    System.out.print(patient.getName() + " принял ");
                                    System.out.print(medicines.get(i).getName() + " ");
                                    switch (medicines.get(i).getApplication()) {
                                        case INGEST:
                                            System.out.println("внутрь.");
                                            break;
                                        case INTRAMUSCULAR:
                                            System.out.println("внутримышечно.");
                                            break;
                                        case EXTERNAL:
                                            System.out.println("наружно.");
                                            break;
                                    }
                                }
                            }
                            prescription.incrementProgress();
                        }
                    }
                }
            }

            Cure cure = new Cure();
            try {
                System.out.println("Незнайка звонит по первому попавшемуся номеру в своей записной книжке, а именно: "+notebook.getLast());
                Treatment treatment = neznayka.callDoctor(kozlik, doctor);
                if (treatment == Treatment.HOSPITAL)
                    System.out.println("Козлик ложится в больницу и благополучно выздоравливает");
                else if (treatment == Treatment.HOME)
                    cure.cure(kozlik, doctor);
                else System.out.println("Козлик здоров как бык");
            } catch (InabilityToHelp e1) {
                System.out.println(neznayka.getName() + " " + e1.toString());
                try {
                    cure.cure(kozlik, doctor);
                } catch (NullPointerException e) {
                    return;
                }
            }

            return;
        } catch (OurException e2) {
            System.out.println(e2.toString());
        }
    }
}
