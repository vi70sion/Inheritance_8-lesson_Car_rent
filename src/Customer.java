import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    private Map<Customer,Car> rentedCarList = new HashMap<>();


}
