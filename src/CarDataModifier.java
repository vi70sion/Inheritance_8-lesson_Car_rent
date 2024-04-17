public class CarDataModifier {

//    Sukurti klasę AutomobiliųDuomenųModifikatorius kurios funkcija gali priimti     bet kokio tipo
//        automobili - jeigu automobilis yra varomas naftos kuru - jam ji     turi leisti per parametrus
//    pakeisti sanaudas, jeigu tai elektromobilis - turi leisti pakeisti jo įkrovimo laiką.
//    Sukurti papildomą parametrą rida klasėje automobilis. Klasėje AutomobiliųDuomenųModifikatorius pridėti metodą keisti ridą.

    public void changeParameter(GasolineCar car, double litersKm){
        car.setLitersKm(litersKm);
    }
    public void changeParameter(ElectricCar car, double kwKm){
        car.setKwKm(kwKm);
    }


}
