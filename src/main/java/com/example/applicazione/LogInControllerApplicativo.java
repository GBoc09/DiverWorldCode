package com.example.applicazione;

public class LogInControllerApplicativo {
    public void register(AccountRegistrationBean newUser) {//throws AlreadyRegisteredUserException {
    // verifichiamo presenza email
    // UserDAO userDB = new UserDAO();
    // User newUesr = new User();
    // newUser.setName(newUserData.getName());
    // newUser.setLastname(newUserData.getLastname());
    // newUser.setEmail(newUserData.getEmail());
    // newUser.setPassword(newUserData.getPassword());
    // newUser.setBirthDate(newUserData.getBirthDate());
    // userDB.insert(newUser);
    //
    }

    public void login(LogBean userData) {// throws WrongLoginCredentialException {
        // UserDAO userDB = new UserDAO();
        // User loggedUser = userDB.selectLoginUser(userData.getUserID());
        // if (! loggedUser.getPassword().equals(userData.getPassword())){
        // throw new WrongLoginCredentialException (1); }
        // }

    }
    public UserBean getUserByLoginData(LogBean loginData) {
        /**   var bean = new UserBean();
         UserDAO userDAO = UserDAO();
         UserProfile profileData = profileDAO.selectProfileByEmail(loginData.getUserId(), true);

         bean.setEmail(loggedUser.getUserID());
         bean.setName(loggedUser.getName());
         bean.setLastname(loggedUser.getLastname());
         bean.setProfilePicPath(profileData.getProfilePicturePath());
         */
        return null;
    }
}
