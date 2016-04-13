package cc.univ.page;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;

public interface CountryListPageFactory {
    @NotNull
    CountryListPage create(@NotNull WebDriver webDriver);
}
