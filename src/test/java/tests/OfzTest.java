package tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.OfzPage;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.step;
import static org.assertj.core.api.Assertions.assertThat;
@Tag("UI")
public class OfzTest extends TestBase {
    OfzPage ofzPage = new OfzPage();

    @Test
    @Feature("ОФЗ")
    @DisplayName("Проверка заголовка на странице ОФЗ")
    void checkOfzTitleOnThePage() {
        step("Открыть форму", () ->
                open("/q/bonds/SU26243RMFS4/"));

        step("Проверить заголовок на странице", () -> {
            ofzPage.pageTitle.shouldBe(Condition.visible);
            assertThat(ofzPage.pageTitle.getText()).isEqualTo("Облигация ОФЗ 26243 (SU26243RMFS4) Доходность, Цена");
        });
    }
    @Test
    @Feature("ОФЗ")
    @DisplayName("Проверка наличия кнопок на странице с описанием ОФЗ")

    void checkButtonsOnThePage() {
        step("Открыть форму", () ->
                open("/q/bonds/SU26243RMFS4/"));

        step("Проверить присутствие кнопок", () -> {
            ofzPage.buyShares.shouldBe(Condition.visible);
            assertThat(ofzPage.buyShares.getText()).isEqualTo("Купить облигации");
            ofzPage.discussShares.shouldBe(Condition.visible);
            assertThat(ofzPage.discussShares.getText()).isEqualTo("Обсудить на форуме ОФЗ");
        });
    }

    @Test
    @Feature("ОФЗ")
    @DisplayName("Проверка блоков на странице ОФЗ")
    void checkOfzBlocksOnThePage() {
        step("Открыть форму", () ->
                open("/q/bonds/SU26243RMFS4/"));

        $(byText("Календарь выплаты купонов по облигации ОФЗ 26243 (SU26243RMFS4)")).scrollTo();

        step("Проверить присутствие блока с календарем купонов", () ->
            ofzPage.calendarTable.shouldBe(Condition.visible));

        $(byText("Изменение цены и доходности облигации ОФЗ 26243 (SU26243RMFS4)")).scrollTo();
        step("Проверить пристувие блока с схемой Изменение цены и доходности облигации ОФЗ", () ->
            ofzPage.priceScheme.shouldBe(Condition.visible)
        );

    }

}
