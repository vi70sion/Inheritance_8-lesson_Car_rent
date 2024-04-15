import java.util.ArrayList;
public class Rental {
    private ArrayList<Car> carsForRent = new ArrayList<>();

    public ArrayList<Car> getRentalList(){ return carsForRent; }

    public void addCarToList(Car car){
        this.carsForRent.add(car);
    }
}
