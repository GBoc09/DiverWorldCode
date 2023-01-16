package com.example.diversworld.controller.applicativo;

import com.example.diversworld.bean.AccountRegistrationBean;
import com.example.diversworld.bean.LogBean;
import com.example.diversworld.bean.UserBean;
import com.example.diversworld.dao.UserDAO;
import com.example.diversworld.entity.Diver;
import com.example.diversworld.exceptions.AlreadyRegisteredUserException;
import com.example.diversworld.exceptions.WrongLoginCredentialException;
import com.example.diversworld.connection.ConnectionServer;
import com.example.diversworld.connection.SessionHandler;

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
