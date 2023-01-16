package com.example.diversWorld.controller.applicativo;

import com.example.diversWorld.bean.AccountRegistrationBean;
import com.example.diversWorld.bean.LogBean;
import com.example.diversWorld.bean.UserBean;
import com.example.diversWorld.dao.UserDAO;
import com.example.diversWorld.entity.Diver;
import com.example.diversWorld.exceptions.AlreadyRegisteredUserException;
import com.example.diversWorld.exceptions.WrongLoginCredentialException;
import com.example.diversWorld.connection.ConnectionServer;
import com.example.diversWorld.connection.SessionHandler;

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
