import java.util.ArrayList;

public class Prescription {
    private ArrayList<Medicine> medicines;
    private int spell;
    private int progress;

    Prescription(ArrayList<Medicine> medicines, int spell, int progress) {
        this.medicines = medicines;
        this.spell = spell;
        this.progress = progress;
    }


    public int getSpell() {
        return spell;
    }

    public int getProgress() {
        return progress;
    }

    public void incrementProgress() {
        this.progress++;
    }

    public ArrayList<Medicine> getMedicines() {
        return medicines;
    }


}
