package ua.infopulse.command;

import ua.infopulse.service.RegistrationService;
import ua.infopulse.service.ServiceFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Adrien on 16.02.2017.
 */
public class RegistrationHandlerCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if(name == null || login == null || password == null){
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registration.jsp");
            request.setAttribute("error", "all fields should be filled");
            dispatcher.forward(request, response);
        }
        ServiceFactory factory = ServiceFactory.getInstance();
        RegistrationService service = factory.getRegistrationService();
        boolean isSuccess = service.registrate(name, login, password);
        if(isSuccess){
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registration.jsp");
            request.setAttribute("error", "login is not unique");
            dispatcher.forward(request, response);
        }

    }
}
