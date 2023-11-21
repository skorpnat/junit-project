package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.collections.SizeGreaterThan;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DividendsSearchPage {
    public SelenideElement searchInput = $("#dividends_search_form input");

    public DividendsSearchPage openPage(String s) {
        open("/dividends");
        return this;
    }

    public DividendsSearchPage setSearchValue(String value) {
        searchInput.setValue(value);
        return this;
    }

    public DividendsSearchPage checkResultTable() {
        $$("table[class='simple-little-table financials dividends'] tr th a").shouldBe(new SizeGreaterThan(0));
        return this;
    }

    public DividendsSearchPage cleanAdvertisementOnPage() {
        executeJavaScript("$('.banner').remove()");
        return this;
    }

    public DividendsSearchPage checkResultTicker(String tickerValue) {
        $x("//div[@class='trades-table-wrapper'][1]//table[@class='simple-little-table financials dividends sort-table']//tr[3]//td[1]").shouldHave(text(tickerValue));
        return this;
    }
}


