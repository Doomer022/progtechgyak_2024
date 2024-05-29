package program.database;

import org.junit.jupiter.api.Test;
import program.database.exceptions.CommandNotExecutedException;

import static org.junit.jupiter.api.Assertions.*;

class ListStageDataCommandTest {

    @Test
    void TestStageDataStageIdDoesNotExists(){
        Integer id = -1;
        ListStageDataCommand cmd = new ListStageDataCommand(id);
        cmd.execute();
        assertThrows(CommandNotExecutedException.class, () -> cmd.getResult());
    }
    @Test
    void TestStageDataStageIdDoesExists(){
        Integer id = 1;
        ListStageDataCommand cmd = new ListStageDataCommand(id);
        cmd.execute();
        assertDoesNotThrow(() -> cmd.getResult());
    }

}