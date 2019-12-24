import java.util.ArrayList;

public class Friend extends Character {
    private int salary;
    Friend(String name, int salary){
        super(name);
        this.salary=salary;
    }
    public Treatment callDoctor(Ail ail, Treat doctor) throws InabilityToHelp{
        Therapy therapy = doctor.checkup(ail);
        if (therapy.getCost()>salary){
            throw new InabilityToHelp();
        }
        return therapy.getTreatment();
    }
    public class Notebook{
        ArrayList<String> numbers = new ArrayList<>();

        public ArrayList<String> getNumbers() {
            return numbers;
        }
        public void addNumber(String number){
            numbers.add(number);
        }
        public String getLast(){
            return numbers.get(numbers.size()-1);
        }
    }
}
