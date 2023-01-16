package com.example.diversWorld.dao;

import com.example.diversWorld.db.MyConnection;
import com.example.diversWorld.entity.Diver;
import com.example.diversWorld.exceptions.AlreadyRegisteredUserException;
import com.example.diversWorld.exceptions.WrongLoginCredentialException;
import com.example.diversWorld.query.UserQuery;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class UserDAO {
    MyConnection connection = MyConnection.getInstance();
    UserQuery userQ = new UserQuery();
    public Diver selectUser(String email) {
        Diver user = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Connection con = connection.getConnection();
            stmt = con.createStatement();
            String query = userQ.selectUser(email);
            rs = stmt.executeQuery(query);

            if (!rs.next()){
                return null;
            }
            user = new Diver(rs.getString("email"), rs.getString("name"), rs.getString("lastname"), rs.getString("password"),rs.getInt("license"));
            user.setBirthDate(rs.getDate("birthDate"));

            rs.close();
        } catch (SQLException e ){
            e.printStackTrace();
        } finally {
            try {
                if(stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user;
    }
    public Diver selectLoginUser(String email) throws WrongLoginCredentialException {
        Diver user = selectUser(email);
        if (user == null) {
            throw new WrongLoginCredentialException(1);
        } else {
            return user;
        }
    }

    public void insertUser(Diver user) throws AlreadyRegisteredUserException{
        String query = selectQuery(user, "insert");
        if (selectUser(user.getEmail())!= null) {
            throw new AlreadyRegisteredUserException(1);
        }
        try {
            writeOnUser(query);
        }catch (SQLException e){}
    }
    public void updateUser(Diver user){
        String query = selectQuery(user, "update");
        try {
            writeOnUser(query);
        }catch (SQLException e){
        }

    }

    private void writeOnUser(String query) throws SQLException{
        Statement stmt = null;
        try {
            Connection con = connection.getConnection();
            stmt = con.createStatement();
            stmt.executeUpdate(query);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public String selectQuery (Diver user, String queryType) {
        String email = user.getEmail();
        String password = user.getPassword();
        String name = user.getName();
        String lastname = user.getLastname();
        Integer license = user.getLicense();
        Date birthDate = user.getBirthDate();

        String query = null;
        if (queryType.equals("insert")) {
            query = userQ.insertUser(email, password, name, lastname, license, birthDate);
        }
        return query;
    }

    public void deleteUser(String email){
        Statement stmt = null;
        try {
            Connection con = connection.getConnection();
            stmt = con.createStatement();
            String query = userQ.deleteUser(email);
            stmt.executeUpdate(query);
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null){
                    stmt.close();
                }
            }catch (SQLException e){
                e.printStackTrace();;
            }
        }
    }


}
