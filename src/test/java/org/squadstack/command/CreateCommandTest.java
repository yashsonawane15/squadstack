package org.squadstack.command;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreateCommandTest {

    @Test
    void test_valid_create_command() {
        String commandString = "Create_parking_lot 6";

        CreateCommand createCommand = new CreateCommand();

        assertTrue(createCommand.parseCommandString(commandString.split(" ")));   
    }

    @Test
    void test_invalid_create_command_with_no_integer() {
        String commandString = "Create_parking_lot tr";

        CreateCommand createCommand = new CreateCommand();

        assertFalse(createCommand.parseCommandString(commandString.split(" ")));
    }

    @Test
    void test_invalid_create_command_with_negative_number() {
        String commandString = "Create_parking_lot -1";

        CreateCommand createCommand = new CreateCommand();

        assertFalse(createCommand.parseCommandString(commandString.split(" ")));
    }

    @Test
    void test_invalid_create_command_with_float_number() {
        String commandString = "Create_parking_lot -1.4";

        CreateCommand createCommand = new CreateCommand();

        assertFalse(createCommand.parseCommandString(commandString.split(" ")));
    }

}