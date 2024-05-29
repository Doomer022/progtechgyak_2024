package program.database;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import program.SQLiteConnection;
import program.database.exceptions.CommandNotExecutedException;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class ListAllEventNamesCommand implements CommandWithResult<Map<String, String>> {

    private static final Logger log = LogManager.getLogger(ListAllEventNamesCommand.class);
    private Map<String, String> result = null;

    @Override
    public Map<String, String> getResult() throws CommandNotExecutedException {

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
            stmt = connection.prepareStatement("SELECT * FROM esemenyek;");
            ResultSet rs = stmt.executeQuery();
            result = new HashMap<>();

            while (rs.next()) {
                result.put(rs.getString("keyword"), rs.getString("nev"));
            }
            rs.close();
            connection.close();
            log.info(String.format("Sikeres listázás. Események száma:%d", result.size()));
        }catch (SQLException e){
            log.error(e);
        }
    }

//    public static void main(String[] args) {
//        CommandWithResult<Map<String, String>> command = new ListAllEventNamesCommand();
//        command.execute();
//        for (String key : command.getResult().keySet()){
//            System.out.println(key + ": " + command.getResult().get(key));
//        }
//    }
}

