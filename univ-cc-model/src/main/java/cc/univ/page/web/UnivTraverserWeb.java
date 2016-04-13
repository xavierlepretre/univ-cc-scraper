package cc.univ.page.web;

import cc.univ.model.Country;
import cc.univ.model.ScrapedInfo;
import cc.univ.model.University;
import cc.univ.model.auto.ScrapedInfoAuto;
import cc.univ.page.*;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class UnivTraverserWeb implements UnivTraverser {
    @NotNull
    private final CountryListPageFactory countryListPageFactory;
    @NotNull
    private final UniversityListPageHandlerFactory universityListPageHandlerFactory;

    public UnivTraverserWeb(
            @NotNull CountryListPageFactory countryListPageFactory,
            @NotNull UniversityListPageHandlerFactory universityListPageHandlerFactory) {
        this.countryListPageFactory = countryListPageFactory;
        this.universityListPageHandlerFactory = universityListPageHandlerFactory;
    }

    @NotNull
    @Override
    public ScrapedInfo scrape(@NotNull WebDriver driver) {
        String startUrl = driver.getCurrentUrl();
        CountryListPage countryListPage = countryListPageFactory.create(driver);
        List<Country> countries = countryListPage.collectCountries();
        List<University> universities = new ArrayList<>();

        UniversityListPageHandler universityListPageHandler;

        for (Country country : countries) {
            countryListPage.selectCountry(country);
            countryListPage.clickSearchButton();
            universityListPageHandler = universityListPageHandlerFactory.create(driver, country);
            universities.addAll(universityListPageHandler.traverseAndCollect());
            driver.get(startUrl);
        }

        return ScrapedInfoAuto.create(countries, universities);
    }
}
