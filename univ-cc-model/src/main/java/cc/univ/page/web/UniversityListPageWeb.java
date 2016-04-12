package cc.univ.page.web;

import cc.univ.model.Country;
import cc.univ.model.University;
import cc.univ.model.web.UniversityFactoryWeb;
import cc.univ.page.UniversityListPage;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class UniversityListPageWeb implements UniversityListPage {
    private static final String TEXT_NEXT = "[>>Next]";

    @NotNull
    private final WebElement pageElement;
    @NotNull
    private final Country country;
    @NotNull
    private final UniversityFactoryWeb universityFactoryWeb;

    public UniversityListPageWeb(
            @NotNull WebElement pageElement,
            @NotNull Country country,
            @NotNull UniversityFactoryWeb universityFactoryWeb) {
        this.pageElement = pageElement;
        this.country = country;
        this.universityFactoryWeb = universityFactoryWeb;
    }

    public boolean hasNextButton() {
        return !pageElement.findElements(By.linkText(TEXT_NEXT)).isEmpty();
    }

    public void clickNextButton() {
        pageElement.findElement(By.linkText(TEXT_NEXT)).click();
    }

    @NotNull
    public List<University> collectUniversities() {
        return universityFactoryWeb.findList(country, pageElement);
    }
}
