package database;

import java.sql.*;
import user.User;

public class Queries {

    private String query;
    private String queryResults;
    private Connection connection;

    public Queries() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/java?useSSL=false", "root", "MorbidOne12#");
        this.connection = con;
    }

    public String showAllData() throws SQLException {

        Statement stmt = this.connection.createStatement();
        ResultSet rs = stmt.executeQuery("select * from users");
        while (rs.next())
            queryResults = rs.getString(2);
        return queryResults;
    }

    public Void insertUser(User requestUser) throws  SQLException {
        Statement stmt = this.connection.createStatement();
        stmt.executeUpdate("INSERT INTO users (id, name, password, role) VALUES (NULL, '"+requestUser.getName()+"', '"+requestUser.getPassword()+"', '1')");
        return null;
    }

    public Void updateUser(User requestUser) throws SQLException {
        Statement stmt = this.connection.createStatement();
        stmt.executeUpdate("UPDATE `users` SET `role` = '"+requestUser.getUserMode()+"' WHERE `users`.`name` = '"+requestUser.getName()+"'");
        return null;
    }

    public Boolean checkUser(User requestUser) throws SQLException {
        Statement stmt = this.connection.createStatement();
        Boolean checker = false;

        ResultSet rs = stmt.executeQuery("select * from users where name='"+requestUser.getName()+"' and password='"+requestUser.getPassword()+"'");
        while (rs.next()) {
            if(requestUser.getName().equals(rs.getString(2))) {
                checker = true;
                return checker;
            }
        }
        return checker;
    }

    public String getMode(User requestUser) throws SQLException {
        Statement stmt = this.connection.createStatement();
        String mode = "";
        ResultSet rs = stmt.executeQuery("select * from users where name='"+requestUser.getName()+"' and password='"+requestUser.getPassword()+"'");
        while (rs.next()) {
            if(requestUser.getName().equals(rs.getString(2))) {
                mode = rs.getString(4);
            }
        }
        return mode;
    }
    }
