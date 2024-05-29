package program.database;

import org.junit.jupiter.api.Test;
import program.database.exceptions.CommandNotExecutedException;

import static org.junit.jupiter.api.Assertions.*;

class GetEventDateCommandTest {
    @Test
    void TestIfEventReturnsDataOnCorrectKeyword() {
        String givenKeyword = "eger24";
        GetEventDateCommand command = new GetEventDateCommand(givenKeyword);
        command.execute();
        assertDoesNotThrow(() -> command.getResult());
    }

    @Test
    void TestIfEventThrowsErrorOnGetBeforeExecuteCommand() {
        String givenKeyword = "valami";
        GetEventDateCommand command = new GetEventDateCommand(givenKeyword);
        assertThrows(CommandNotExecutedException.class, () -> command.getResult());
    }
}