package program.database;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import program.SQLiteConnection;
import program.database.exceptions.CommandNotExecutedException;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class GetEventNameCommand implements CommandWithResult<String> {

    private static final Logger log = LogManager.getLogger(GetEventNameCommand.class);
    private String result = null;
    public String storedKeyword;

    public GetEventNameCommand(String _storedKeyword) { storedKeyword = _storedKeyword; }

    @Override
    public String getResult() throws CommandNotExecutedException {

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
            stmt = connection.prepareStatement("SELECT * FROM esemenyek WHERE keyword = ?;");
            stmt.setString(1, storedKeyword);
            ResultSet rs = stmt.executeQuery();

            if(!rs.next()) { log.error("Nincs ilyen keyword-el rendelkező esemény!"); return; }
            result = rs.getString("nev");

            rs.close();
            connection.close();
            log.info(String.format("Sikeres lekérdezés!"));
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

