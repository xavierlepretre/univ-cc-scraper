package cc.univ.page.web;

import cc.univ.model.Country;
import cc.univ.model.University;
import cc.univ.page.UniversityListPage;
import cc.univ.page.UniversityListPageFactory;
import cc.univ.page.UniversityListPageHandler;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class UniversityListPageHandlerImpl implements UniversityListPageHandler {
    @NotNull
    private final UniversityListPageFactory universityListPageFactory;

    public UniversityListPageHandlerImpl(
            @NotNull UniversityListPageFactory universityListPageFactory) {
        this.universityListPageFactory = universityListPageFactory;
    }

    @NotNull
    public List<University> traverseAndCollect(
            @NotNull WebDriver driver,
            @NotNull Country country) {
        List<University> collected = new ArrayList<>();
        UniversityListPage universityListPage = universityListPageFactory.create(driver, country);
        collected.addAll(universityListPage.collectUniversities(driver, country));
        while (universityListPage.hasNextButton(driver)) {
            universityListPage.clickNextButton(driver);
            universityListPage = universityListPageFactory.create(
                    driver,
                    country);
            collected.addAll(universityListPage.collectUniversities(driver, country));
        }
        return collected;
    }
}
