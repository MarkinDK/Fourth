import java.util.Objects;

public class Anamnesis {
    private int temperature;
    private int inflammation;
    private int pain;
    private int vita;

    Anamnesis(int temperature, int inflammation, int pain, int vita) {
        this.temperature = temperature;
        this.pain = pain;
        this.inflammation = inflammation;
        this.vita = vita;
    }

    public int getInflammation() {
        return inflammation;
    }

    public int getPain() {
        return pain;
    }

    public int getTemperature() {
        return temperature;
    }

    public int getVita() {
        return vita;
    }

    public int getMin(){
        return  Math.min(Math.min(temperature,inflammation),Math.min(pain,vita));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Anamnesis anamnesis = (Anamnesis) o;
        return temperature == anamnesis.temperature &&
                inflammation == anamnesis.inflammation &&
                pain == anamnesis.pain &&
                vita == anamnesis.vita;
    }

    @Override
    public int hashCode() {
        return Objects.hash(temperature, inflammation, pain, vita);
    }
}
