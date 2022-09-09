package jarvis.parser;

import jarvis.JarvisException;
import jarvis.command.*;

/**
 * Parser --- parses commands entered by the user.
 */
public class Parser {
    /**
     * Parses user commands.
     *
     * @param command full command entered by user
     * @return parsed command.
     * @throws JarvisException exception for invalid commands.
     */
    public static Command parseUserCommand(String command) throws JarvisException {
        assert command != null;
        String[] arguments = command.trim().split(" ");
        switch (arguments[0]) {
        case "bye":
            return new ByeCommand(command);
        case "list":
            return new ListCommand(command);
        case "mark":
        case "unmark":
            return new MarkCommand(command);
        case "delete":
            return new DeleteCommand(command);
        case "find":
            return new FindCommand(command);
        case "sort":
            return new SortCommand(command);
        case "todo":
        case "deadline":
        case "event":
            return new AddCommand(command);
        default:
            throw new JarvisException("Unrecognised. Please enter a valid command.");
        }
    }
}
