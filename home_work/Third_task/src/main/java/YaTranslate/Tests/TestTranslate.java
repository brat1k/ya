package YaTranslate.Tests;

import YaTranslate.YaTranslate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


@DisplayName("Ya translate tests")
public class TestTranslate extends YaTranslate{

    @DisplayName("Verify translate")
    @ParameterizedTest(name = "{index} {0} {1}")
    @MethodSource("testData")
    public void translateTextEngToRus(String original_text, String translate_text){
        // Вводим текст для перевода с пробелом
        page.inputText(original_text + " ");
        // Проверяем результат
        String translation = page.checkTranslate();
        assertEquals(translate_text, translation);
        // Проверяем исходный язык
        String src_lang = page.srcLanguage();
        assertEquals(src_lang, "АНГЛИЙСКИЙ");
        // Проверяем язык перевода
        String dst_lang = page.dstLanguage();
        assertEquals(dst_lang, "РУССКИЙ");
        // Очищаем поле для ввода
        page.clickClearButton();
    }

    static Stream<Arguments> testData() {
        return Stream.of(Arguments.of("hello world", "всем привет"),
                Arguments.of("Bat", "Летучая мышь"));
    }

}
