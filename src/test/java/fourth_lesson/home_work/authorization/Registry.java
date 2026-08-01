package fourth_lesson.home_work.authorization;


import java.util.ArrayList;
import java.util.List;

public class Registry {

    private List<User> users;

    public Registry(List<User> users) {
        this.users = new ArrayList<>(users);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void deleteUser(User user) {
        users.remove(user);
    }

    public User getUser(String username) {
        for (User user : users) {
            if (user.getUserName().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public String checkAuth(String username, String password) {
        ArrayList<String> results = new ArrayList<>();
        for (User user : users) {
            results.add(user.checkAuth(username, password));
        }
        if (results.contains("Blocked")) {
            return "Blocked";
        }

        if (results.contains("FailedAuth")) {
            return "FailedAuth";
        }

        return "Ok";
    }

}
