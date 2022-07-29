package org.squadstack.model;

public class ParkedCar {
    String carNumber;
    int driverAge;


    public ParkedCar(String carNumber, int driverAge) {
        this.carNumber = carNumber;
        this.driverAge = driverAge;
    }

    public int getDriverAge() {
        return driverAge;
    }

    public String getCarNumber() {
        return carNumber;
    }

    @Override
    public String toString() {
        return "ParkedCar{" +
                "carNumber='" + carNumber + '\'' +
                ", driverAge=" + driverAge +
                '}';
    }
}
