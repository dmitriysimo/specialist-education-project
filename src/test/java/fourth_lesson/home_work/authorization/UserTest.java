package fourth_lesson.home_work.authorization;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static fourth_lesson.home_work.authorization.Users.ANY_USERS;
import static fourth_lesson.home_work.authorization.Users.VALID_USERS;

public class UserTest {

    @ParameterizedTest
    @MethodSource("validUserProvider")
    @DisplayName("Тест на проверку валидных значений пользователей")
    void positiveAuthorizationTest(String username, String password, User user) {
        System.out.println(user.checkAuth(username, password));
    }

    @ParameterizedTest
    @MethodSource("blockedUserProvider")
    void negativeAuthorizationTest(String username, String password, User user) {
        user.checkAuth(username, password);
    }

    static Stream<Arguments> validUserProvider() {
        return Stream.of(
                Arguments.of("user1", "password1",VALID_USERS.get(0)),
                Arguments.of("user2", "password2",VALID_USERS.get(1)),
                Arguments.of("user3", "password3",VALID_USERS.get(2)));
    }

    static Stream<Arguments> blockedUserProvider() {
        return Stream.of(
                Arguments.of("user1", "password1", ANY_USERS.get(0)),
                Arguments.of("user4", "password4", ANY_USERS.get(1)),
                Arguments.of("User3", "password3",VALID_USERS.get(2)),
                Arguments.of("user1", "password3",VALID_USERS.get(0)));
    }
}
