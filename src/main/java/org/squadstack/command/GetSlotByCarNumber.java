package org.squadstack.command;

public class GetSlotByCarNumber implements Command {
    String carNumber;
    final int CAR_NUMBER_INDEX = 1;

    @Override
    public boolean parseCommandString(String[] args) {
        carNumber = args[CAR_NUMBER_INDEX];
        return true;
    }
}
