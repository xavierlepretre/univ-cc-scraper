package cc.univ.page.web;

import cc.univ.model.web.CountryFactoryWeb;
import cc.univ.page.CountryListPageFactory;
import html.Constants;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;

public class CountryListPageWebFactory implements CountryListPageFactory {
    private static final String TAG_NAME_ROOT = Constants.TAG_NAME_HTML;

    @NotNull private final CountryFactoryWeb countryFactoryWeb;

    public CountryListPageWebFactory(@NotNull CountryFactoryWeb countryFactoryWeb) {
        this.countryFactoryWeb = countryFactoryWeb;
    }

    @NotNull
    @Override
    public CountryListPageWeb create(@NotNull WebDriver webDriver) {
        return new CountryListPageWeb(
                countryFactoryWeb);
    }
}
