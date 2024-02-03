package tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.MainOfzPage;
import pages.OfzPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.step;
import static org.assertj.core.api.Assertions.assertThat;

@Tag("UI")
public class OfzListTest extends TestBase {
    MainOfzPage mainOfzPage = new MainOfzPage();
    OfzPage ofzPage = new OfzPage();

    @Test
    @Feature("Список ОФЗ")
    @DisplayName("Проверка заголовка на странице котировок ОФЗ")
    void checkOfzTitleOnThePage() {
        step("Открыть форму", () ->
                open("q/ofz/"));

        step("Проверить заголовок на странице", () -> {
            mainOfzPage.pageTitle.shouldBe(Condition.visible);
            assertThat(mainOfzPage.pageTitle.getText()).isEqualTo("Котировки гособлигаций ОФЗ, Московская биржа");
        });
    }
    @Test
    @Feature("Сптсок ОФЗ")
    @DisplayName("Проверка перехода на страницу с описанием ОФЗ по клику")

    void checkLinkToOfzPage() {
        step("Открыть форму", () ->
                open("/q/ofz"));

        step("Проверить присутствие ссылки и нажать на нее", () -> {
            mainOfzPage.ofzLink.shouldBe(Condition.visible);
            mainOfzPage.ofzLink.click();
        });

        step("Проверить заголовок на открывшейся странице", () -> {
            ofzPage.pageTitle.shouldBe(Condition.visible);
            assertThat(ofzPage.pageTitle.getText()).isEqualTo("Облигация ОФЗ 26243 (SU26243RMFS4) Доходность, Цена");
        });
    }


}
