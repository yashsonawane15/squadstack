package org.squadstack.command;

public class GetNumbersByAgeCommand implements Command {
    final int AGE_INDEX = 1;
    int queryAge;
    @Override
    public boolean parseCommandString(String[] args) {

        try {
            queryAge = Integer.parseInt(args[AGE_INDEX]);

            if(queryAge <= 0) {
                return false;
            }
        } catch(NumberFormatException nfe) {

            System.out.println("Invalid age");
            return false;
        }
        return true;
    }

    public int getQueryAge() {
        return queryAge;
    }
}
