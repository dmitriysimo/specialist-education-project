package fourth_lesson.home_work.authorization;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class User {

    private static final Logger log = LoggerFactory.getLogger(User.class);
    private String userName;
    private String password;
    private Boolean isBlocked;

    public User(String userName, String password, Boolean isBlocked) {
        this.userName = userName;
        this.password = password;
        this.isBlocked = isBlocked;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getBlocked() {
        return isBlocked;
    }

    public void setBlocked(Boolean blocked) {
        isBlocked = blocked;
    }

    public String checkAuth(String login, String password) {
        System.out.println("Проверка логина и пароля " + login + " и " + password +
                " для пользователя " + this.userName + "");
        boolean authorization = login.equals(this.userName) && password.equals(this.password);

        if (isBlocked) {
            return "Blocked";
        }

        return authorization ? "Ok" : "FailedAuth";
    }

}
