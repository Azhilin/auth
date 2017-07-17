package ua.infopulse.service;

import ua.infopulse.command.Command;
import ua.infopulse.command.CommandFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Adrien on 16.02.2017.
 */
public class ServiceFactory {
    private static ServiceFactory instance = new ServiceFactory();
    RegistrationService registration = new RegistrationService();
    public RegistrationService getRegistrationService(){
        return registration;
    }
    public static ServiceFactory getInstance(){
        return instance;
    }


}
