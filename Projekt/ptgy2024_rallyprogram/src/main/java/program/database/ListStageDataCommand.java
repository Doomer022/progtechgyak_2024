package program.database;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import program.SQLiteConnection;
import program.database.exceptions.CommandNotExecutedException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ListStageDataCommand implements CommandWithResult<ArrayList<String>> {

    private static final Logger log = LogManager.getLogger(ListStageDataCommand.class);
    private ArrayList<String> result = null;
    private int stageID;

    public ListStageDataCommand(int stageID) {
        this.stageID = stageID;
    }

    @Override
    public ArrayList<String> getResult() throws CommandNotExecutedException {

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
            stmt = connection.prepareStatement("SELECT * FROM palya WHERE id = ?;");
            stmt.setInt(1, stageID);
            ResultSet rs = stmt.executeQuery();


            if (!rs.next()) {
                log.error("A " + stageID + " pálya nem található");
                return;
            }
            result = new ArrayList<String>();
            result.add("Név:;" + rs.getString("nev"));
            result.add("Helyszín:;" + rs.getString("helyszin"));
            result.add("Szakaszok száma:;" + (rs.getInt("szakaszok")));
            result.add("Teljes hossz:;" + (rs.getInt("hossz")));
            rs.close();
            connection.close();
            log.info("A pálya adatinak betöltése sikeres volt");

        }catch (SQLException e){
            log.error(e);
        }
    }

//    public static void main(String[] args) {
//        CommandWithResult<ArrayList<String>> command = new ListStageDataCommand(1);
//        command.execute();
//        System.out.println(String.format("%s; %s; %s; %s", command.getResult().get(0), command.getResult().get(1), command.getResult().get(2), command.getResult().get(3)));
//    }
}
