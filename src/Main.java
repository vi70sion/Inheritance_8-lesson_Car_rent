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
        Rental rental = new Rental();
        String choice = "";
        do{
            System.out.println("Pasirinkite veiksmą: ");
            System.out.println("(1)- aprašyti automobilį, (2)- pridėti automobilį į sąrašą nuomai, (3)- išnuomoti automobilį, (0)- pabaiga");
            choice = scanner.nextLine();
            switch (choice){
                case "1":
                    break;
                case "2":
                    break;
                case "3":
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