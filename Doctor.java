import java.util.ArrayList;

public class Doctor extends Character implements Treat {
    @Override
    public String toString() {
        return "Doctor" + " " + getName();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public Doctor(String name) {
        super(name);
    }

    public static class Patients {
        public static ArrayList<Patient> list = new ArrayList<>();

        public static void addPatient(Patient patient) {
            list.add(patient);
        }
    }


    @Override
    public Therapy checkup(Ail patient) {
        Anamnesis anamnesis = patient.symptoms();
        if (anamnesis.getTemperature() < 30 || anamnesis.getInflammation() < 30) {
            patient.setStatement(false);
            return new Therapy(Treatment.HOSPITAL, 20);
        }
        if (anamnesis.getTemperature() >= 90 && anamnesis.getInflammation() >= 90 && anamnesis.getPain() >= 90) {
            patient.setStatement(true);
            return new Therapy(Treatment.NOT_NEED, 0);
        }
        patient.setStatement(false);
        return new Therapy(Treatment.HOME, 0);
    }


    @Override
    public Prescription prescription(Anamnesis anamnesis) {
        ArrayList<Medicine> medicines = new ArrayList<>(0);
        if (anamnesis.getVita() < 90) {
            medicines.add(new Vitamin("VitaminC", Type.VITAMIN, Application.INGEST, 3));
            medicines.add(new Vitamin("VitaminD", Type.VITAMIN, Application.INGEST, 3));
        }
        if (anamnesis.getPain() < 90) {
            medicines.add(new Analgesic("Novocain", Type.ANALGESIC, Application.INTRAMUSCULAR, 5));
        }
        if (anamnesis.getTemperature() < 90) {
            medicines.add(new Antipyretic("Pyramidon", Type.ANTIPYRETIC, Application.INGEST, 5));
        }
        if (anamnesis.getInflammation() < 90) {
            medicines.add(new Antibiotic("Sintomicine Liniment", Type.ANTIBIOTIC, Application.EXTERNAL, 2));
            medicines.add(new Antibiotic("Streptocid", Type.ANTIBIOTIC, Application.INGEST, 2));
            medicines.add(new Antibiotic("Antibiotics", Type.ANTIBIOTIC, Application.INTRAMUSCULAR, 2));
        }

        if (medicines.size() != 0) {
            MakeDosage minDosage = new MakeDosage() {
                private int minDosage;

                @Override
                public int getDosage() {
                    return minDosage;
                }

                @Override
                public int makeDosage(ArrayList<Medicine> medicines) {
                    int p, i, t, v;
                    p = v = t = i = 0;
                    for (int j = 0; j < medicines.size(); j++) {
                        switch (medicines.get(j).getType()) {
                            case ANALGESIC:
                                p -= medicines.get(j).getDosage();
                                break;
                            case ANTIBIOTIC:
                                i -= medicines.get(j).getDosage();
                                break;
                            case ANTIPYRETIC:
                                t -= medicines.get(j).getDosage();
                                break;
                            case VITAMIN:
                                v -= medicines.get(j).getDosage();
                                break;
                        }
                    }
                    minDosage = Math.abs(Math.min(Math.min(t, i), Math.min(p, v)));
                    return minDosage;
                }
            };
            int spell = 0;
            int dos = minDosage.makeDosage(medicines);
            if (dos > 0) {
                while (minDosage.getDosage() * spell < (100 - anamnesis.getMin()) / 2) {
                    spell += 7;
                }
                if (spell != 7) {
                    System.out.println("Доктор выписал целую кучу рецептов.");
                }
                if (spell == 7) {
                    System.out.println("Постельный режим не нужен!");
                }
            } else {
                System.out.println("Больной окончательно выздоровел; ему необходимо лишь получше питаться, чтоб восстановить силы.");
                return null;
            }
            return new Prescription(medicines, spell, 0);
        }
        System.out.println("Больной окончательно выздоровел; ему необходимо лишь получше питаться, чтоб восстановить силы.");
        return null;
    }
}
