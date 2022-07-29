package org.squadstack.command;

public class GetSlotByCarNumberCommand implements Command {
    String queryCarNumber;
    final int CAR_NUMBER_INDEX = 1;

    @Override
    public boolean parseCommandString(String[] args) {
        queryCarNumber = args[CAR_NUMBER_INDEX];
        return true;
    }

    public String getQueryCarNumber() {
        return queryCarNumber;
    }
}
