package program.database;

import org.junit.jupiter.api.Test;
import program.database.exceptions.CommandNotExecutedException;

import static org.junit.jupiter.api.Assertions.*;

class ListCarDataCommandTest {
    @Test
    void TestCarDataCarIdDoesNotExists(){
        Integer id = -1;
        ListCarDataCommand cmd = new ListCarDataCommand(id);
        cmd.execute();
        assertThrows(CommandNotExecutedException.class, () -> cmd.getResult());
    }
    @Test
    void TestCarDataCarIdDoesExists(){
        Integer id = 1;
        ListCarDataCommand cmd = new ListCarDataCommand(id);
        cmd.execute();
        assertDoesNotThrow(() -> cmd.getResult());
    }

}