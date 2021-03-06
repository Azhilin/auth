package ua.infopulse.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Adrien on 16.02.2017.
 */
public class CommandFactory {
    private static CommandFactory instance = new CommandFactory();
    Map<String, Command> commands = new HashMap<>();
    public static CommandFactory getInstance(){
        return instance;
    }
    private CommandFactory(){
        commands.put("registration", new RegistrationCommand());
        commands.put("login", new LoginCommand());
        commands.put("registration_handler", new RegistrationHandlerCommand());
    }
    public Command getCommand(HttpServletRequest request){
        String [] command = request.getRequestURI().split("/");
        return commands.get(command[3]);

    }
}
