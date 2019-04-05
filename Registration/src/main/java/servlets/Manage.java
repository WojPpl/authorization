package servlets;

import database.Queries;
import user.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/manage")

public class Manage extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User currentUser = new User();
        currentUser.updateUserData(request);
        try {
            Queries servletQuery = new Queries();
            servletQuery.updateUser(currentUser);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        response.getWriter().println("User " + currentUser.getName() + " updated");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("manage.jsp");
    }
}
