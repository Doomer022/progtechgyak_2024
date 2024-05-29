package program.database;

import org.junit.jupiter.api.Test;
import program.database.exceptions.CommandNotExecutedException;

import static org.junit.jupiter.api.Assertions.*;

class GetEventNameCommandTest {

    @Test
    void TestIfEventReturnsDataOnCorrectKeyword() {
        String givenKeyword = "eger24";
        GetEventNameCommand command = new GetEventNameCommand(givenKeyword);
        command.execute();
        assertDoesNotThrow(() -> command.getResult());
    }

    @Test
    void TestIfEventThrowsErrorOnGetBeforeExecuteCommand() {
        String givenKeyword = "valami";
        GetEventNameCommand command = new GetEventNameCommand(givenKeyword);
        assertThrows(CommandNotExecutedException.class, () -> command.getResult());
    }
}