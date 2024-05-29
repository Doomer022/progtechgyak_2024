package program.database;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import program.SQLiteConnection;
import program.database.datastructures.RacerData;
import program.database.exceptions.CommandNotExecutedException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ListRacerDataCommand implements CommandWithResult<ArrayList<String>> {

    private static final Logger log = LogManager.getLogger(ListAllRacerNamesCommand.class);
    private ArrayList<String> result = null;
    private int racerID;

    public ListRacerDataCommand(int racerID) {
        this.racerID = racerID;
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
            stmt = connection.prepareStatement("SELECT * FROM versenyzok WHERE id = ?;");
            stmt.setInt(1, racerID);
            ResultSet rs = stmt.executeQuery();


            if (!rs.next()) {
                log.error("A " + racerID + " versenyző nem található");
                return;
            }
            result = new ArrayList<String>();
            result.add("Név:;" + rs.getString("nev"));
            result.add("Nemzetiség:;" + rs.getString("nemzetiseg"));
            result.add("Típus:;" + (rs.getInt("tipus") == 0 ? "sofőr" : "navigátor"));
//            result.id = rs.getInt("id");
//            result.nev = rs.getString("nev");
//            result.nemzetiseg = rs.getString("nemzetiseg");
//            result.tipus = rs.getInt("tipus");
            rs.close();
            connection.close();
            log.info("A versenyzők adatinak betöltése sikeres volt");

        }catch (SQLException e){
            log.error(e);
        }
    }

//    public static void main(String[] args) {
//        CommandWithResult<ArrayList<String>> command = new ListRacerDataCommand(3);
//        command.execute();
//        System.out.println(String.format("%d; %s; %s; %s", command.getResult().size(), command.getResult().get(0), command.getResult().get(1), command.getResult().get(2)));
//    }
}
