package org.squadstack;

import org.squadstack.command.*;

public class ParkingLotController {

    // Command Names
    final String CREATE = "Create_parking_lot";
    final String PARK = "Park";
    final String GET_SLOTS_FOR_AGE = "Slot_numbers_for_driver_of_age";
    final String GET_SLOT_BY_NUMBER = "Slot_number_for_car_with_number";
    final String GET_NUMBERS_BY_AGE = "Vehicle_registration_number_for_driver_of_age";
    final String LEAVE = "Leave";
    final String INVALID_COMMAND = "Command invalid";

    // Command objects
    CreateCommand createCommand = new CreateCommand();
    ParkCommand parkCommand = new ParkCommand();
    GetSlotsByAgeCommand getSlotsByAgeCommand = new GetSlotsByAgeCommand();
    GetSlotByCarNumberCommand getSlotByCarNumberCommand = new GetSlotByCarNumberCommand();
    GetNumbersByAgeCommand getNumbersByAgeCommand = new GetNumbersByAgeCommand();
    LeaveCommand leaveCommand = new LeaveCommand();

    ParkingLot parkingLot = new ParkingLot();


    public String executeCommand(String commandLine) {
        String[] components = commandLine.split(" ");
        String command = components[0];

        switch(command) {
            case CREATE:
                if(!createCommand.parseCommandString(components)) {
                    return INVALID_COMMAND;
                }

                return parkingLot.createParkingLot(createCommand.getLotSize());

            case PARK:
                if(!parkCommand.parseCommandString(components)) {
                    return INVALID_COMMAND;
                }

                return parkingLot.parkCar(parkCommand.getDriverAge(), parkCommand.getCarNumber());

            case GET_SLOTS_FOR_AGE:
                if(!getSlotsByAgeCommand.parseCommandString(components)) {
                    return INVALID_COMMAND;
                }

                return parkingLot.getSlotsByAge(getSlotsByAgeCommand.getQueryAge());

            case GET_SLOT_BY_NUMBER:
                if(!getSlotByCarNumberCommand.parseCommandString(components)) {
                    return INVALID_COMMAND;
                }

                return parkingLot.getSlotByCarNumber(getSlotByCarNumberCommand.getQueryCarNumber());

            case GET_NUMBERS_BY_AGE:
                if(!getNumbersByAgeCommand.parseCommandString(components)) {
                    return INVALID_COMMAND;
                }

                return parkingLot.getCarNumbersByAge(getNumbersByAgeCommand.getQueryAge());

            case LEAVE:
                if(!leaveCommand.parseCommandString(components)) {
                    return INVALID_COMMAND;
                }

                return parkingLot.leaveParkingLot(leaveCommand.getQuerySlot());
            default:
                return INVALID_COMMAND;
        }

    }


}
