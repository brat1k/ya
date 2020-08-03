package YaTranslate.Tests;

import YaTranslate.YaTranslate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@DisplayName("Other tests")
public class TestOther extends YaTranslate {
    @Test
    @DisplayName("Verify title")
    public void verifyTitle(){

        String title= driver.getTitle();
        assertTrue(title.contains("Яндекс.Переводчик"));
    }
}
