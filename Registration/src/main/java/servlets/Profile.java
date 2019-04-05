package servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/profile")

public class Profile extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        String user = (String) session.getAttribute("user");
        if (user.length() > 0) {
            response.sendRedirect("profile.jsp");
        }
        else {
            response.sendRedirect("/");
        }
    }
}
