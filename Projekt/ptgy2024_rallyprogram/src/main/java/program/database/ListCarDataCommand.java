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


public class ListCarDataCommand implements CommandWithResult<ArrayList<String>> {

    private static final Logger log = LogManager.getLogger(ListAllCarNamesCommand.class);
    private ArrayList<String> result = null;
    private int carID;

    public ListCarDataCommand(int carID) {
        this.carID = carID;
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
            stmt = connection.prepareStatement("SELECT auto.nev,auto.osztaly,sofor.nev,navigator.nev FROM auto " +
                    "INNER JOIN versenyzok AS sofor ON auto.sofor = sofor.id " +
                    "INNER JOIN versenyzok AS navigator ON auto.navigator = navigator.id WHERE auto.id = ?;");
            stmt.setInt(1, carID);
            ResultSet rs = stmt.executeQuery();


            if (!rs.next()) {
                log.error("Az " + carID + " autó nem található");
                return;
            }
            result = new ArrayList<String>();
            result.add("Név:;" + rs.getString(1));
            result.add("Osztály:;" + rs.getString(2));
            result.add("Sofőr:;" + rs.getString(3));
            result.add("Navigátor:;" + rs.getString(4));
            rs.close();
            connection.close();
            log.info("Az autók adatinak betöltése sikeres volt");

        }catch (SQLException e){
            log.error(e);
        }
    }

//    public static void main(String[] args) {
//        CommandWithResult<ArrayList<String>> command = new ListCarDataCommand(1);
//        command.execute();
//        System.out.println(String.format("%s, %s, %s, %s", command.getResult().get(0), command.getResult().get(1), command.getResult().get(2), command.getResult().get(3)));
//    }
}
