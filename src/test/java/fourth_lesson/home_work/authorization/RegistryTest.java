package fourth_lesson.home_work.authorization;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.Arrays;
import java.util.List;

import static fourth_lesson.home_work.authorization.Users.*;


public class RegistryTest {

    List<User> anyUsersList = Arrays.asList(
            new User("user1", "pass1", false),
            new User("user2", "pass2", true)
    );

    Registry registry = new Registry(anyUsersList);

    @ParameterizedTest
    @CsvFileSource(resources = "users.csv", numLinesToSkip = 1)
    @DisplayName("Проверка авторизации для пользователей с правильными данными")
    void checkValidUser(String username, String password) {
        User expectedUser = REGISTERED_USERS.stream()
                .filter(user -> user.getUserName().equals(username))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Пользователь '" + username + "' не найден в REGISTERED_USERS. Проверьте CSV файл."));

        Registry simpleRegistry = new Registry(Arrays.asList(expectedUser));
        String result = simpleRegistry.checkAuth(username, password);
        Assertions.assertEquals("Ok", result, "Заблокированных пользователей не найдено");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "users.csv", numLinesToSkip = 1)
    @DisplayName("Проверка авторизации для заблокированных пользователей")
    void checkBlockedUser(String username, String password) {
        Registry registry = new Registry(DIFFERENT_USERS);
        String result = registry.checkAuth(username, password);

        Assertions.assertEquals("Blocked", result, "Заблокированных пользователей не найдено");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "users.csv", numLinesToSkip = 1)
    @DisplayName("Проверка авторизации для пользователей с неправильным паролем")
    void checkNonValidUser(String username, String password) {
        Registry registry = new Registry(REGISTERED_USERS);
        User expectedUser = REGISTERED_USERS.stream()
                .filter(user -> user.getUserName().equals(username))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Пользователь '" + username + "' не найден в REGISTERED_USERS. Проверьте CSV файл."));

        String result = registry.checkAuth(username, password);
        Assertions.assertEquals("FailedAuth", result, "Авторизация пройдена корретно для пользователя: " + expectedUser.getUserName());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "users.csv", numLinesToSkip = 1)
    @DisplayName("Проверка добавления пользователя")
    void checkAddUser(String username, String password) {
        registry.addUser(new User(username, password, false));

        Assertions.assertEquals(username, registry.getUser(username).getUserName());
        Assertions.assertEquals(password, registry.getUser(username).getPassword());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "users.csv", numLinesToSkip = 1)
    @DisplayName("Проверка удаления пользователя")
    void checkRemoveUser(String username) {
        Assertions.assertNull(registry.getUser(username));;
    }
}
