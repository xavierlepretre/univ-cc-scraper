package cc.univ.page;

import cc.univ.model.Country;
import org.jetbrains.annotations.NotNull;

public interface CountryListPage {
    void selectCountry(@NotNull Country country);

    void clickSearchButton();
}
