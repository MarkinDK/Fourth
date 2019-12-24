public class Therapy {
    private Treatment treatment;
    private int cost;
    Therapy(Treatment treatment, int cost){
        this.treatment=treatment;
        this.cost=cost;
    }

    public int getCost() {
        return cost;
    }

    public Treatment getTreatment() {
        return treatment;
    }

}
