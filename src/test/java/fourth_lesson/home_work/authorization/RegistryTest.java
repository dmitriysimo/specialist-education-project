package fourth_lesson.home_work.authorization;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;


public class RegistryTest {

    @ParameterizedTest
    @CsvFileSource(resources = "users.csv", numLinesToSkip = 1)
    void checkValidUser(String username, String password) {
        boolean okResult = true;


    }

    @ParameterizedTest
    @CsvFileSource(resources = "users.csv", numLinesToSkip = 1)
    void checkBlockedUser(String username, String password) {

    }

    @ParameterizedTest
    @CsvFileSource(resources = "users.csv", numLinesToSkip = 1)
    void checkNonValidUser(String username, String password) {

    }
}
