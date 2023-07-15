package org.example.Utils;

import org.example.commands.Command;
import org.example.commands.lct.Lct;

/**
 * Provides methods for mapping commands
 */
public class CommandMapper {

    private Command command; // Command to be executed. Needs to be mapped first

    /**
     * Maps a command to an appropriate class of the command based on the name of the command passed and executes it
     * @param std_in Input stream, from which the command name and parameters will be acquired
     * @return Output of the command or "Command not found" if the command was not found
     */
    public String mapCommand(String[] std_in){

        /* Switch, where you put all available commands. Any command not present in this switch will not be found, thus cannot be executed */
        switch (std_in[1]){
            case "\0lct": command = new Lct(); return command.execute();
            default: return "Command not found";
        }
    }
}
