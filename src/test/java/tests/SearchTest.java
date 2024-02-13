package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.DividendsSearchPage;
@Tag("search")
@DisplayName("Тесты на проверку поиска акций по наименованию с дивидендами")
public class SearchTest extends TestBase {
    DividendsSearchPage dividendsSearchPage = new DividendsSearchPage();

    @ValueSource(strings = {
            "HeadHunter",
            "Fix Price"
    })
    @ParameterizedTest(name = "Поиск по значению {0} компаний не выплачивающих дивиденды возвращает не пустую таблицу с результатом")
    void inputSearch(String searchValue) {
        dividendsSearchPage.openPage("/dividens").cleanAdvertisementOnPage().setSearchValue(searchValue);
        dividendsSearchPage.checkResultTable();
    }

    @CsvSource(value = {
            "SIBN, SIBN",
            "ROSN, ROSN"
    })
    @ParameterizedTest(name = "Поиск по тикеру {0} возвращает таблицу с тикером {1}")
    void checkSearchResultTicker(String searchValue, String tickerValue) {
        dividendsSearchPage.openPage("/dividens").cleanAdvertisementOnPage().setSearchValueClick(searchValue);
        dividendsSearchPage.checkResultTicker(tickerValue);
    }

    @CsvFileSource(resources = "/test_data/searchData.csv")
    @ParameterizedTest(name = "Поиск по значению {0} из файла возвращает таблицу с тикером {1}")
    void checkSearchResultTickerFromFile(String searchValue, String tickerValue) {
        dividendsSearchPage.openPage("/dividens").cleanAdvertisementOnPage().setSearchValue(searchValue);
        dividendsSearchPage.checkResultTicker(tickerValue);
    }
}
