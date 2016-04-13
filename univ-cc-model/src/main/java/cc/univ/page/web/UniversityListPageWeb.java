package cc.univ.page.web;

import cc.univ.model.Country;
import cc.univ.model.University;
import cc.univ.model.web.UniversityFactoryWeb;
import cc.univ.page.UniversityListPage;
import html.Constants;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class UniversityListPageWeb implements UniversityListPage {
    private static final String TAG_NAME_ROOT = Constants.TAG_NAME_HTML;
    private static final String TEXT_NEXT = "[>>Next]";

    @NotNull
    private final UniversityFactoryWeb universityFactoryWeb;

    public UniversityListPageWeb(
            @NotNull UniversityFactoryWeb universityFactoryWeb) {
        this.universityFactoryWeb = universityFactoryWeb;
    }

    public boolean hasNextButton(@NotNull WebDriver driver) {
        return !driver.findElement(By.tagName(TAG_NAME_ROOT)).findElements(By.linkText(TEXT_NEXT)).isEmpty();
    }

    public void clickNextButton(@NotNull WebDriver driver) {
        driver.findElement(By.tagName(TAG_NAME_ROOT)).findElement(By.linkText(TEXT_NEXT)).click();
    }

    @NotNull
    public List<University> collectUniversities(
            @NotNull WebDriver driver,
            @NotNull Country country) {
        return universityFactoryWeb.findList(country, driver);
    }
}
