package fourth_lesson.home_work.authorization;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Users {

    static User validUser0 = new User("user1", "password1", false);
    static User validUser1 = new User("user2", "password2", false);
    static User validUser2 = new User("user3", "password3", false);

    public static final List<User> VALID_USERS = Arrays.asList(validUser0, validUser1, validUser2);

    static User validUser3 = new User("user3", "password3", true);
    static User validUser4 = new User("user4", "password4", true);

    public static final List<User> ANY_USERS = Arrays.asList(validUser3, validUser4);

    public static final List<User> BLOCKED_USERS = Arrays.asList(validUser0, validUser1, validUser3, validUser4);

    static User validUser5 = new User("Ivan", "flex123", false);
    static User validUser6 = new User("Egor", "qwerty123", false);
    static User validUser7 = new User("Oleg", "password1", false);

    public static final List<User> REGISTERED_USERS = new ArrayList<>(Arrays.asList(validUser5, validUser6, validUser7));
}
