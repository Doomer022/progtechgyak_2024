package program.database;

import org.junit.jupiter.api.Test;
import program.database.exceptions.CommandNotExecutedException;

import static org.junit.jupiter.api.Assertions.*;

class ListRacerDataCommandTest {

    @Test
    void TestRacerDataRacerIdDoesNotExists(){
        Integer id = -1;
        ListRacerDataCommand cmd = new ListRacerDataCommand(id);
        cmd.execute();
        assertThrows(CommandNotExecutedException.class, () -> cmd.getResult());
    }
    @Test
    void TestRacerDataRacerIdDoesExists(){
        Integer id = 1;
        ListRacerDataCommand cmd = new ListRacerDataCommand(id);
        cmd.execute();
        assertDoesNotThrow(() -> cmd.getResult());
    }

}