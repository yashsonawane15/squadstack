package org.squadstack;

import org.squadstack.command.*;

public class ParkingLotController {

    // Command Names
    final String CREATE = "Create_parking_lot";
    final String PARK = "Park";
    final String GET_SLOTS_FOR_AGE = "Slot_numbers_for_driver_of_age";
    final String GET_SLOT_BY_NUMBER = "Slot_number_for_car_with_number ";
    final String GET_NUMBERS_BY_AGE = "Vehicle_registration_number_for_driver_of_age";
    final String LEAVE = "Leave";

    // Command objects
    CreateCommand createCommand = new CreateCommand();
    ParkCommand parkCommand = new ParkCommand();
    GetSlotsByAgeCommand getSlotsByAgeCommand = new GetSlotsByAgeCommand();
    GetSlotByCarNumber getSlotByCarNumber = new GetSlotByCarNumber();
    GetNumbersByAgeCommand getNumbersByAgeCommand = new GetNumbersByAgeCommand();
    LeaveCommand leaveCommand = new LeaveCommand();


    public boolean executeCommand(String commandLine) {
        String[] components = commandLine.split(" ");
        String command = components[0];

        switch(command) {
            case CREATE:
                if(!createCommand.parseCommandString(components)) {
                    return false;
                }
                break;

            case PARK:
                if(!parkCommand.parseCommandString(components)) {
                    return false;
                }
                break;

            case GET_SLOTS_FOR_AGE:
                if(!getSlotsByAgeCommand.parseCommandString(components)) {
                    return false;
                }
                break;

            case GET_SLOT_BY_NUMBER:
                if(!getSlotByCarNumber.parseCommandString(components)) {
                    return false;
                }
                break;

            case GET_NUMBERS_BY_AGE:
                if(!getNumbersByAgeCommand.parseCommandString(components)) {
                    return false;
                }
                break;

            case LEAVE:
                if(!leaveCommand.parseCommandString(components)) {
                    return false;
                }
            default:
                return false;
        }

        return false;
    }



}
