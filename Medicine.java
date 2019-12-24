import java.util.Objects;

public abstract class Medicine implements Medicate {
    private String name;
    private Type type;//Enum too? Vitamin/Antibiotic/...
    private Application application;//Enum? Inner/outer
    private int dosage;

    Medicine(String name, Type type, Application application, int dosage) {
        this.name = name;
        this.type = type;
        this.application = application;
        this.dosage = dosage;
    }

    public Type getType() {
        return type;
    }

    public Application getApplication() {
        return application;
    }

    public String getName() {
        return name;
    }

    public int getDosage() {
        return dosage;
    }

    public abstract boolean medicate(TakeMedicine patient);//Maybe enum

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medicine medicine = (Medicine) o;
        return Objects.equals(name, medicine.name) &&
                type == medicine.type &&
                application == medicine.application &&
                dosage == medicine.dosage;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, application, dosage);
    }
}
