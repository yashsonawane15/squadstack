package org.squadstack;

import org.squadstack.command.CreateCommand;
import org.squadstack.command.ParkCommand;
import org.squadstack.model.ParkedCar;

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
            set.add(driverAge);

            ageToSlots.put(driverAge, set);
        }

    }

    public boolean addCarToCarNumberData(Integer slot, ParkedCar car) {
        String carNumber = car.getCarNumber();

        if(carNumberToSlot.containsKey(carNumber)) {
            return true;
        }

        carNumberToSlot.put(carNumber, slot);
        return false;
    }

    public String parkCar(int driverAge, String carNumber) {

        Integer closestSlot = availableSlots.poll();
        if(closestSlot == null) {
            return "Parking lot full, can't park car with registration number " + carNumber;
        }

        ParkedCar newCar = new ParkedCar(carNumber, driverAge);

        slots.set(closestSlot, newCar);

        addCarToAgeData(closestSlot, newCar);
        if(!addCarToCarNumberData(closestSlot, newCar)) {
            return "Duplicate car number detected: " + carNumber;
        }

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

        String slotsString = getCommaSeparatedValues(iterator, slotsOfAge.size());
        result.append(slotsString);

        return result.toString();
    }

    private String getCommaSeparatedValues(Iterator<Integer> iterator, int size) {

        int count = 0;
        StringBuilder string = new StringBuilder();

        while(count < size - 1) {
            ++count;
            string.append(Integer.toString(iterator.next() + 1) + ", ");
        }

        string.append(Integer.toString(iterator.next()));

        return string.toString();
    }
}
