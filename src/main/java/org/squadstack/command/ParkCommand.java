package org.squadstack.command;

public class ParkCommand implements Command {

    String carNumber;
    int driverAge;

    final int CAR_NUMBER_INDEX = 1;
    final int AGE_INDEX = 3;

    @Override
    public boolean parseCommandString(String[] args) {
        carNumber = args[CAR_NUMBER_INDEX];

        try {
            driverAge = Integer.parseInt(args[AGE_INDEX]);

            if(driverAge <= 0) {
                return false;
            }
        } catch(NumberFormatException nfe) {
            System.out.println("Invalid number in command");
            return false;
        }
        return true;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public int getDriverAge() {
        return driverAge;
    }
}
