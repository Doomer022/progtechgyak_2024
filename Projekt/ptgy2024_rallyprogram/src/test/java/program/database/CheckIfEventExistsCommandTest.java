package program.database;

import org.junit.jupiter.api.Test;
import program.database.exceptions.CommandNotExecutedException;

import java.sql.SQLDataException;

import static org.junit.jupiter.api.Assertions.*;

class CheckIfEventExistsCommandTest {

    @Test
    void TestIfEventReturnsFalseOnNegativeKeyword() {
        String givenKeyword = "nincsilyen";
        CheckIfEventExistsCommand command = new CheckIfEventExistsCommand(givenKeyword);
        command.execute();
        assertTrue(!command.getResult());
    }

    @Test
    void TestIfEventThrowsErrorOnGetBeforeExecuteCommand() {
        String givenKeyword = "valami";
        CheckIfEventExistsCommand command = new CheckIfEventExistsCommand(givenKeyword);
        assertThrows(CommandNotExecutedException.class, () -> command.getResult());
    }
}