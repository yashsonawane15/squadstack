package org.squadstack.command;

public class LeaveCommand implements Command {
    final int SLOT_INDEX = 1;
    int querySlot;

    @Override
    public boolean parseCommandString(String[] args) {
        try {
            querySlot = Integer.parseInt(args[SLOT_INDEX]);

            if(querySlot < 0) {
                return false;
            }
        } catch(NumberFormatException nfe) {
            System.out.println("Invalid slot number");
            return false;
        }

        return true;
    }
}
