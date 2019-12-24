public class Patient extends Character implements Ail, TakeMedicine {
    private boolean statement;
    private int temperature;
    private int inflammation;
    private int pain;
    private int vita;
    private Prescription prescription;


    Patient(String name, boolean statement, int temperature, int inflammation, int pain, int vita) {
        super(name);
        this.statement = statement;
        this.temperature = temperature;
        this.inflammation = inflammation;
        this.pain = pain;
        this.vita = vita;
        Doctor.Patients.addPatient(this);
    }



    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }


    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }

    @Override
    public Anamnesis symptoms() {
        return new Anamnesis(temperature, inflammation, pain, vita);
    }

    @Override
    public void setStatement(boolean statement) {
        this.statement = statement;
    }

    public boolean isStatement() {
        return statement;
    }

    public Prescription getPrescription() {
        return prescription;
    }


    public boolean vitaCure(Vitamin vitamin) {
        if (this.vita < 90) {
            this.vita += vitamin.getDosage();
            return true;
        } else
            return false;
    }

    @Override
    public boolean inflammationCure(Antibiotic antibiotic) {
        if (this.inflammation < 90) {
            this.inflammation += antibiotic.getDosage();
            return true;
        } else
            return false;
    }

    @Override
    public boolean temperatureCure(Antipyretic antipyretic) {
        if (this.temperature < 90) {
            this.temperature += antipyretic.getDosage();
            return true;

        } else return false;
    }

    @Override
    public boolean painCure(Analgesic analgesic) {
        if (this.pain < 90) {
            this.pain += analgesic.getDosage();
            return true;
        } else return false;
    }

}
