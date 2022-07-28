package org.squadstack.command;

public class CreateCommand implements Command {
    int lotSize;
    public CreateCommand() {
    }

    @Override
    public boolean parseCommandString(String[] args) {
        try {
            lotSize = Integer.parseInt(args[1]);

            if(lotSize <= 0) {
                return false;
            }
        } catch(NumberFormatException nfe) {
            return false;
        }

        return true;
    }

    public int getLotSize() {
        return lotSize;
    }

}
