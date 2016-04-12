package cc.univ.page.web;

import cc.univ.model.Country;
import cc.univ.model.University;
import cc.univ.model.web.UniversityFactoryWeb;
import cc.univ.page.UniversityListPage;
import cc.univ.page.UniversityListPageHandler;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class UniversityListPageHandlerImpl implements UniversityListPageHandler {
    private static final int LOAD_TIMEOUT_SECONDS = 10;

    @NotNull
    private final WebDriver driver;
    @NotNull
    private final Country country;
    @NotNull
    private final UniversityFactoryWeb universityFactoryWeb;
    @NotNull
    private final UniversityListPageWebFactory universityListPageWebFactory;
    @NotNull
    private UniversityListPage universityListPage;

    public UniversityListPageHandlerImpl(
            @NotNull WebDriver driver,
            @NotNull Country country,
            @NotNull UniversityFactoryWeb universityFactoryWeb,
            @NotNull UniversityListPageWebFactory universityListPageWebFactory) {
        this.driver = driver;
        this.country = country;
        this.universityFactoryWeb = universityFactoryWeb;
        this.universityListPageWebFactory = universityListPageWebFactory;
        this.universityListPage = universityListPageWebFactory.create(
                driver,
                country,
                universityFactoryWeb);
    }

    @NotNull
    public List<University> traverseAndCollect() {
        List<University> collected = new ArrayList<>();
        collected.addAll(universityListPage.collectUniversities());
        while (universityListPage.hasNextButton()) {
            universityListPage.clickNextButton();
            new WebDriverWait(driver, LOAD_TIMEOUT_SECONDS).until(new ExpectedCondition<Boolean>() {
                @Override
                public Boolean apply(WebDriver wd) {
                    return ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete");
                }
            });
            universityListPage = universityListPageWebFactory.create(
                    driver,
                    country,
                    universityFactoryWeb);
            collected.addAll(universityListPage.collectUniversities());
        }
        return collected;
    }
}
