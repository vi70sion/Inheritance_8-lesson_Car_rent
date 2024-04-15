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
        String choice = "";
        String carType = "";
        int daysRent;
        do{
            System.out.println("Pasirinkite veiksmą: ");
            System.out.println("(1)- aprašyti automobilį, (2)- pridėti automobilį į sąrašą nuomai, (3)- išnuomoti automobilį,");
            System.out.println("(4)- spausdinti automobilių sąrašą, (0)- pabaiga");
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
                    System.out.println("Pasirinkite automobilį: ");
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
                case "0":
                    break;
                default:
                    System.out.println("Neteisingas pasirinkimas, bandykite dar kartą.");
            }

        } while(!choice.equals("0"));

        scanner.close();
    }
}