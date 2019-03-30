package servlets;

import database.Queries;
import user.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/login")
public class Login extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User currentUser = new User();
        currentUser.retriveUserData(request);
        try {
            Queries servletQuery = new Queries();
            if(servletQuery.checkUser(currentUser)) {
                response.sendRedirect("wrongdata.jsp");
            }
            else {
                response.sendRedirect("wrongdata.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("login.jsp");
    }
}
