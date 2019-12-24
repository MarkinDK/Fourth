public class Analgesic extends Medicine {
    Analgesic(String name, Type type, Application application, int dosage) {
        super(name, type, application, dosage);
    }

    public boolean medicate(TakeMedicine recipient) {
        return recipient.painCure(this);
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}