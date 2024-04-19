import java.util.HashMap;
import java.util.Map;

public class Customer {
//    Sukurti klasę klientas - Vardas, Pavardė, Dabar Nuomojamas Automobilis, Paskutinis Nuomotas Automobilis,
//    bei sąrašą automobilių kuriuos ir kiek dienų klientas buvo išsinuomavęs. (Dienos INT)    Sukurti klientų sąrašą.
//    Sukurti metodą, kuriam padavus klientą ir padavus automobilį jis būtų jam priskiriamas automobilis.
//    Sukurti metodą pabaigti nuomą, kuris nuimtų Dabar naudojamą automobilį ir pakeistų jį į null. (nuomojant
//    automobili jis turi iškart atsirasti sąraše kuriuos klientas turi būti išsinuomavęs)
//    Visas šių metodų valdymas turi būti realizuotas per įvestį.
    private String nameSurname;
    private Car nowRentCar, lastRentCar;
    private int daysRent;
    private Map<Car, Integer> rentedCarList = new HashMap<>();

    public String getNameSurname() { return nameSurname; }
    public void setNameSurname(String nameSurname) { this.nameSurname = nameSurname; }
    public Car getNowRentCar() { return nowRentCar; }
    public void setNowRentCar(Car nowRentCar) { this.nowRentCar = nowRentCar; }
    public Car getLastRentCar() { return lastRentCar; }
    public void setLastRentCar(Car lastRentCar) { this.lastRentCar = lastRentCar; }
    public Map<Car, Integer> getRentedCarList() { return rentedCarList; }
    public void setRentedCarList(Map<Car, Integer> rentedCarList) { this.rentedCarList = rentedCarList; }
    public int getDaysRent() { return daysRent; }
    public void setDaysRent(int daysRent) { this.daysRent = daysRent; }

    @Override
    public String toString(){
        return nameSurname + "- dabar nuomojama: " + nowRentCar + ", paskutinė nuomota: " + lastRentCar;
    }

    public void printRentedCarList(){
        for(Map.Entry<Car, Integer> entry : rentedCarList.entrySet()){
            System.out.println(entry.getKey() + ", nuomojasi dienų: " + entry.getValue());
        }
    }
    public void printRentedCarListForReturn(){
        int i = 1;
        for(Map.Entry<Car, Integer> entry : rentedCarList.entrySet()){
            System.out.println(i + " . " + entry.getKey().getMake() + " " + entry.getKey().getModel() + " " + entry.getKey().getYear());
            i++;
        }
    }
}
