package com.example.DiversWorld.Controller.Applicativo;

import com.example.DiversWorld.Bean.AccountRegistrationBean;
import com.example.DiversWorld.Bean.LogBean;
import com.example.DiversWorld.Bean.UserBean;
import com.example.DiversWorld.DAO.UserDAO;
import com.example.DiversWorld.Entity.Diver;
import com.example.DiversWorld.Exceptions.AlreadyRegisteredUserException;
import com.example.DiversWorld.Exceptions.WrongLoginCredentialException;
import com.example.DiversWorld.connection.ConnectionServer;
import com.example.DiversWorld.connection.SessionHandler;

public class LogInControllerApplicativo {
    public void register(AccountRegistrationBean newUserData) throws AlreadyRegisteredUserException {
    //verifichiamo presenza email
        UserDAO userDB = new UserDAO();
        Diver newUser = new Diver();
        newUser.setName(newUserData.getName());
        newUser.setLastname(newUserData.getLastname());
        newUser.setEmail(newUserData.getEmail());
        newUser.setPassword(newUserData.getPassword());
        newUser.setBirthDate(newUserData.getBirthDate());
        newUser.setLicense(newUser.getLicense());

        userDB.insertUser(newUser);
    }

    public void login(LogBean userData) throws WrongLoginCredentialException {
        UserDAO userDB = new UserDAO();
        Diver loggedUser = userDB.selectLoginUser(userData.getUserID());
        if (! loggedUser.getPassword().equals(userData.getPassword())){
            throw new WrongLoginCredentialException (1); }
    }
    public UserBean getUserByLoginData(LogBean loginData) {
         var bean = new UserBean();
         UserDAO userDAO = new UserDAO();

         Diver loggedUser = userDAO.selectUser(loginData.getUserID());

         bean.setName(loggedUser.getName());
         bean.setLastname(loggedUser.getLastname());
         bean.setLicense(loggedUser.getLicense());
        return null;
    }
    public void logout(UserBean loggedUser){
        SessionHandler session = new SessionHandler();
        ConnectionServer serverInstance = ConnectionServer.getInstance();
        String ip = serverInstance.getConnectionData().getIp();
    }
}
