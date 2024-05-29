package program.database;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import program.SQLiteConnection;
import program.database.exceptions.CommandNotExecutedException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListAllRacerNamesCommand implements CommandWithResult<Map<Integer, String>> {

    private static final Logger log = LogManager.getLogger(ListAllRacerNamesCommand.class);
    private Map<Integer, String> result = null;

    @Override
    public Map<Integer, String> getResult() throws CommandNotExecutedException {

        if (result == null) {
            throw new CommandNotExecutedException();
        };
        return result;
    }

    @Override
    public void execute() {
        try {
            Connection connection = SQLiteConnection.getConnection();
            PreparedStatement stmt;
            stmt = connection.prepareStatement("SELECT id,nev FROM versenyzok;");
            ResultSet rs = stmt.executeQuery();
            result = new HashMap<>();

            while (rs.next()) {
                result.put(rs.getInt(1), rs.getString(2));
            }
            rs.close();
            connection.close();
            log.info(String.format("Sikeres listázás. Versenyzők száma:%d", result.size()));
        }catch (SQLException e){
            log.error(e);
        }
    }

//    public static void main(String[] args) {
//        CommandWithResult<Map<Integer, String>> command = new ListAllRacerNamesCommand();
//        command.execute();
//        for (Integer key : command.getResult().keySet()){
//            System.out.println(key + ": " + command.getResult().get(key));
//        }
//    }
}
