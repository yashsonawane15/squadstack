package org.squadstack;

import org.squadstack.model.ParkedCar;

import java.lang.reflect.Array;
import java.util.*;

public class ParkingLot {

    int lotSize;
    PriorityQueue<Integer> availableSlots;
    ArrayList<ParkedCar> slots;
    HashMap<Integer, HashSet<Integer>> ageToSlots = new HashMap<Integer, HashSet<Integer>>();
    HashMap<String, Integer> carNumberToSlot = new HashMap<>();


    public String createParkingLot(int lotSize) {
        this.lotSize = lotSize;
        availableSlots = new PriorityQueue<Integer>(lotSize);
        slots = new ArrayList<ParkedCar>(lotSize);

        for(int i = 0; i < lotSize; ++i) {
            availableSlots.add(i);
            slots.add(null);
        }

        return "Created parking of " + lotSize + " slots";
    }


    public void addCarToAgeData(Integer slot, ParkedCar car) {
        int driverAge = car.getDriverAge();

        if(ageToSlots.containsKey(driverAge)) {
            ageToSlots.get(driverAge).add(slot);
        } else {
            HashSet<Integer> set = new HashSet<Integer>();
            set.add(slot);

            ageToSlots.put(driverAge, set);
        }

    }

    public boolean addCarToCarNumberData(Integer slot, ParkedCar car) {
        String carNumber = car.getCarNumber();

        if(carNumberToSlot.containsKey(carNumber)) {
            return false;
        }

        carNumberToSlot.put(carNumber, slot);
        return true;
    }

    public String parkCar(int driverAge, String carNumber) {

        Integer closestSlot = availableSlots.poll();
        if(closestSlot == null) {
            return "Parking lot full, can't park car with registration number " + carNumber;
        }

        ParkedCar newCar = new ParkedCar(carNumber, driverAge);

        if(!addCarToCarNumberData(closestSlot, newCar)) {
            System.out.println(slots);
            return "Duplicate car number detected: " + carNumber;
        }
        addCarToAgeData(closestSlot, newCar);
        slots.set(closestSlot, newCar);

        return "Car with registration number \"" + carNumber + "\" has been parked at slot number " + (closestSlot + 1);

    }

    public void removeCarFromAgeData(int age, int slot) {
        ageToSlots.get(age).remove(slot);
    }

    public void removeCarFromCarNumberData(String carNumber) {
        carNumberToSlot.remove(carNumber);
    }

    public String leaveParkingLot(Integer slot) {
        --slot;
        ParkedCar car = slots.get(slot);

        if(car == null) {
            return "Slot already vacant";
        }

        removeCarFromAgeData(car.getDriverAge(), slot);
        removeCarFromCarNumberData(car.getCarNumber());

        slots.set(slot, null);
        availableSlots.add(slot);

        return "Slot number " + (slot+1) + " vacated, the car with registration number \"" + car.getCarNumber() + "\" left the space, the driver of the car was of age " + car.getDriverAge();
    }



    public String getSlotsByAge(int queryAge) {

        Set<Integer> slotsOfAge = ageToSlots.get(queryAge);
        if(slotsOfAge == null || slotsOfAge.size() == 0) {
            return "No car parked with a driver of age " + queryAge;
        }

        StringBuilder result = new StringBuilder();

        result.append("Slots with drivers of age " + queryAge + ": ");

        Iterator<Integer> iterator = slotsOfAge.iterator();

        String slotsString = getCommaSeparatedNumbers(iterator, slotsOfAge.size());
        result.append(slotsString);

        return result.toString();
    }



    public String getSlotByCarNumber(String queryCarNumber) {
        Integer carSlot = carNumberToSlot.get(queryCarNumber);

        if(carSlot == null) {
            return "No car with number " + queryCarNumber + " in the parking lot";
        }

        return "Car with number " + queryCarNumber + " is in slot " + (carSlot+1);
    }

    public String getCarNumbersByAge(int queryAge) {
        Set<Integer> querySlots = ageToSlots.get(queryAge);
        StringBuilder result = new StringBuilder();

        result.append("Car Numbers with drivers of age " + queryAge + ": ");

        if(querySlots == null || querySlots.size() == 0) {
            return "No cars present with a driver of age " + queryAge;
        }

        ArrayList<String> carNumbers = getCarNumbersFromSlots(querySlots);

        String carNumbersString = getCommaSeparatedStrings(carNumbers.iterator(), querySlots.size());

        result.append(carNumbersString);

        return result.toString();
    }

    private ArrayList<String> getCarNumbersFromSlots(Set<Integer> querySlots) {

        ParkedCar car;
        ArrayList<String> carNumbers = new ArrayList<String>();
        Iterator<Integer> iterator = querySlots.iterator();
        while(iterator.hasNext()) {
            Integer tmp = iterator.next();
            car = slots.get(tmp);
            carNumbers.add(car.getCarNumber());
        }

        return carNumbers;
    }

    private String getCommaSeparatedNumbers(Iterator<Integer> iterator, int size) {

        int count = 0;
        StringBuilder string = new StringBuilder();

        while(count < size - 1) {
            ++count;
            string.append(Integer.toString(iterator.next() + 1) + ", ");
        }

        string.append(Integer.toString(iterator.next() + 1));

        return string.toString();
    }

    private String getCommaSeparatedStrings(Iterator<String> iterator, int size) {

        int count = 0;
        StringBuilder string = new StringBuilder();

        while(count < size - 1) {
            ++count;
            string.append(iterator.next() + ", ");
        }

        string.append(iterator.next());

        return string.toString();
    }


}
