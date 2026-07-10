package first_lesson_hw;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class BrowserConfigurator {

    static ChromeOptions options = new ChromeOptions();
    static Map<String, Object> prefs = new HashMap<>();

    @BeforeAll
    static void setUp() {
        prefs.put("profile.password_manager_leak_detection", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("credentials_enable_service", false);

        options.setExperimentalOption("prefs", prefs);

        Configuration.browserCapabilities = options;
    }
}
