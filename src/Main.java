import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//        Sukurkite automobilių nuomos sistemą. Jums reikės sukurti pagrindinę klasę Automobilis,
//        kuri turės šiuos atributus: marke, modelis, metai ir kaina už dieną.
//        Sukurkite reikiamus getterius ir setterius, taip pat konstruktorių, leidžiantį sukurti
//        automobilio objektą su nurodytais atributais.
//        Toliau sukurti dvi subklases, NaftosKuroAutomobilis ir ElektrinisAutomobilis.
//        Kiekviena subklasė turi papildomą atributą, pavyzdžiui, degalų suvartojimas 100 km atstumu
//        arba baterijos krovimo laikas. Taip pat, kiekviena subklasė turi turėti savo konstruktorių,
//                kuris prideda šiuos papildomus atributus, ir tinkamus getterius ir setterius.
//        Galų gale, parašykite klasę Nuoma, kurioje yra sąrašas su turimais automobiliais.
//        Sukurti metodus, kurie leistų pridėti naujus automobilius į sąrašą, pasiimti automobilį iš
//        sąrašo ir apskaičiuoti nuomos kainą už nurodytą dienų skaičių. Pridėti viso autoparko atspausdinimą.
//        Susikūrus klasę autoparkas prisidėti sąrašą automobilių.


        Scanner scanner = new Scanner(System.in);
        Car car = new Car("", "", 0, 0);
        Rental rental = new Rental();
        CarDataModifier modifier = new CarDataModifier();
        Customer customer = new Customer();
        List<Customer> customersList = new ArrayList<>();
        String choice = "";
        String carType = "";
        int daysRent;
        do{
            System.out.println("Pasirinkite veiksmą: ");
            System.out.println("(1)- aprašyti automobilį, (2)- pridėti automobilį į sąrašą nuomai, (3)- išnuomoti automobilį,");
            System.out.println("(4)- spausdinti automobilių sąrašą, (5)- pakeisti kuro parametrus, ");
            System.out.println("(6)- pridėti klientą, priskirti automobilius, (7)- grąžinti automobilį, (0)- pabaiga");
            choice = scanner.nextLine();
            switch (choice){
                case "1":
                    System.out.println("Aprašysite (1) įprastiniu kuru ar (2) elektrinį automobilį: ");
                    carType = scanner.nextLine();
                    switch (carType){
                        case "1":
                            System.out.println("Įveskite naują automobilį (markė), (modelis), (pagaminimo metai), (dienos nuomos kaina), (kuro sunaudojimas litrais/100km): ");
                            car = new GasolineCar(scanner.nextLine(), scanner.nextLine(), scanner.nextInt(), scanner.nextDouble(), scanner.nextDouble());
                            scanner.nextLine();
                            break;
                        case "2":
                            System.out.println("Įveskite naują automobilį (markė), (modelis), (pagaminimo metai), (dienos nuomos kaina), (reikiama energija kWh/100km): ");
                            car = new ElectricCar(scanner.nextLine(), scanner.nextLine(), scanner.nextInt(), scanner.nextDouble(), scanner.nextDouble());
                            scanner.nextLine();
                            break;
                        default:
                            System.out.println("Neteisingas pasirinkimas");
                            break;
                    }
                    break;
                case "2":
                    if (!car.getMake().isEmpty()) {
                        rental.addCarToList(car);
                        System.out.println("Automobilis sėkmingai pridėtas į nuomojamų sąrašą.");
                        break;
                    }
                    System.out.println("Neaprašytas joks automobilis.");
                    break;
                case "3":
                    System.out.println("Kuriam laikotarpiui (dienomis) norėtumėte nuomotis automobilį: ");
                    daysRent = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Pasirinkite automobilį (markė): ");
                    int i = 1;
                    for(Car car1 : rental.getRentalList()){
                        System.out.print("(" + i++ + ") ");
                        System.out.println(car1);
                    }
                    int carChoice = Integer.parseInt(scanner.nextLine());
                    //(GasolineCar)car1)
                    System.out.println("Automobilio nuomos kaina už " + daysRent + " dienų yra " + (rental.getRentalList().get(carChoice-1).getDayPrice() * daysRent) + " €");
                    break;
                case "4":
                    System.out.println("Jūsų automobilių parkas:");
                    for(Car car1 : rental.getRentalList()){
                        System.out.println(car1);
                        //System.out.println((GasolineCar)car1);
                    }
                    break;
                case "5":
                    System.out.println("Pakeisti automobilio kuro parametrą:");
                    for(Car car1 : rental.getRentalList()){
                        System.out.println(car1);
                        System.out.println("Įveskite naują kuro parametrą: ");
                        if(car1 instanceof GasolineCar){
                            modifier.changeParameter((GasolineCar) car1, scanner.nextDouble());
                        }
                        if(car1 instanceof ElectricCar){
                            modifier.changeParameter((ElectricCar) car1, scanner.nextDouble());
                        }
                    }
                    scanner.nextLine();
                    break;
                case "6":
                    customer = new Customer();
                    System.out.println("Įveskite klientą (vardas pavardė):");
                    customer.setNameSurname(scanner.nextLine());
                    int index = 1;
                    for(Car car1 : rental.getRentalList()){
                        System.out.print(index + ". ");
                        System.out.println(car1);
                        index++;
                    }
                    System.out.println("Įveskite paskutinį nuomotą automobilį (numeris):");
                    index = Integer.parseInt(scanner.nextLine());
                    if(index > 0 && index <= rental.getRentalList().size()){
                        customer.setLastRentCar(rental.getRentalList().get(index-1));
                    } else {System.out.println("Neteisingas įvedimas.");break;}

                    System.out.println("Įveskite kiek dienų nuomosis dabartinį automobilį: ");
                    daysRent = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Įveskite dabar nuomojamą automobilį (numeris):");
                    index = Integer.parseInt(scanner.nextLine());
                    if(index > 0 && index <= rental.getRentalList().size()){
                        customer.setNowRentCar(rental.getRentalList().get(index-1));
                        customer.setDaysRent(daysRent);
                        customer.getRentedCarList().put(rental.getRentalList().get(index-1), daysRent);  //add the rented customer and car to a new list
                        rental.getRentalList().remove(index-1);  //remove rented car from all cars list
                    } else {System.out.println("Neteisingas įvedimas.");break;}

                    customersList.add(customer);
                    for(Customer cust : customersList){  //print customer list
                        System.out.println(cust.toString());
                    }
                    System.out.println("Išnuomotų automobilių sąrašas:");
                    customer.printRentedCarList();  //print rented car list

                    break;
                case "7":
                    System.out.println("Išnuomotų automobilių sąrašas:");
                    customer.printRentedCarListForReturn();  //print rented car list
                    System.out.println("Pasirinkite, kurį automobilį grąžinsite (numeris):");
                    index = Integer.parseInt(scanner.nextLine());
                    if(index > 0 && index <= rental.getRentalList().size()){
                        rental.addCarToList(customer.getRentedCarList().get(index-1));
                    } else {System.out.println("Neteisingas įvedimas.");break;}

                    System.out.println("Išnuomotų automobilių sąrašas:");
                    customer.printRentedCarList();  //print rented car list

                    break;
                case "0":
                    break;
                default:
                    System.out.println("Neteisingas pasirinkimas, bandykite dar kartą.");
            }

        } while(!choice.equals("0"));

        scanner.close();
    }
}