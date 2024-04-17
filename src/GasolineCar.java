public class GasolineCar extends Car{

    private double litersKm;  //liters per 100 km
    public GasolineCar(String make, String model, int year, double dayPrice, double litersKm) {
        super(make, model, year, dayPrice);
        this.litersKm = litersKm;
    }

    public double getLitersKm() { return litersKm; }
    public void setLitersKm(double litersKm) { this.litersKm = litersKm; }

    @Override
    public String toString() {
        return super.toString() + " " + getLitersKm();
    }

}
