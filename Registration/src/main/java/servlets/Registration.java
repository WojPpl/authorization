package servlets;

import database.Queries;
import user.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/register")
public class Registration extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User currentUser = new User();
        currentUser.retriveUserData(request);
        try {
            Queries servletQuery = new Queries();
            servletQuery.insertUser(currentUser);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        response.getWriter().println("Dziękujemy za rejestrację uzytkownika:" + currentUser.getName());

    }

}
