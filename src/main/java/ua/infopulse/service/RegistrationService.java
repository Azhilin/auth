package ua.infopulse.service;

/**
 * Created by Adrien on 16.02.2017.
 */
public class RegistrationService {
    public boolean registrate(String name, String login, String password){
        DAOFactory factory = DAOFactory.getDAOFactory();
        ClientDAO clientDAO = factory.getCientDAO();
        Client client = new Client();
        client.setName(name);
        client.setLogin(login);
        client.setPassword(password);

        return clientDAO.insert(client);
    }
}
