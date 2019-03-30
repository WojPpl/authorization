package user;

import javax.servlet.http.HttpServletRequest;

public class User {

    private String Name;
    private String Password;
    private String Email;
    private Integer UserRole;

    public User() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Integer getUserMode() {
        return UserRole;
    }

    public void setUserMode(Integer userMode) {
        UserRole = userMode;
    }

    public User retriveUserData(HttpServletRequest request) {

        this.setName(request.getParameter("name"));
        this.setPassword(request.getParameter("password"));

        return this;
    }

}
