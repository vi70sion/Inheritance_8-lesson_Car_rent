public class Car {
    private String make, model;
    private int year;
    private double dayPrice;
    public Car(String make, String model, int year, double dayPrice) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.dayPrice = dayPrice;
    }

    public String getMake() { return make;}
    public double getDayPrice() { return dayPrice;}

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return make + " " + model + " " + year + " " + dayPrice;
    }
}
