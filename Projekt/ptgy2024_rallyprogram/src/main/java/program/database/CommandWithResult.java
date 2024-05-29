package program.database;

import program.database.exceptions.CommandNotExecutedException;

public interface CommandWithResult<T> extends Command {
    public T getResult() throws CommandNotExecutedException;
}
