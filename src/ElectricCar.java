public class ElectricCar extends Car{
    private double kwKm; // kilowatts per 100 km
    public ElectricCar(String make, String model, int year, double dayPrice, double kwKm) {
        super(make, model, year, dayPrice);
    }

    public double getKwKm() {
        return kwKm;
    }

    public void setKwKm(double kwKm) {
        this.kwKm = kwKm;
    }
}
