package program.database.exceptions;

public class CommandNotExecutedException extends RuntimeException {
    public CommandNotExecutedException() {
        super("A parancs nem futott le");
    }
}
