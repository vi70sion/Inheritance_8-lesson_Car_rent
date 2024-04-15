import java.util.ArrayList;
public class Rental {
    private ArrayList<Car> carsForRent = new ArrayList<>();
    public void addCarToList(Car car){
        this.carsForRent.add(car);
    }
}
