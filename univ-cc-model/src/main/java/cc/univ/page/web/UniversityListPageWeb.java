package cc.univ.page.web;

import cc.univ.page.UniversityListPage;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class UniversityListPageWeb implements UniversityListPage {
    private static final String TEXT_NEXT = "[>>Next]";

    @NotNull private final WebElement pageElement;

    public UniversityListPageWeb(@NotNull WebElement pageElement) {
        this.pageElement = pageElement;
    }

    public boolean hasNextButton() {
        return !pageElement.findElements(By.linkText(TEXT_NEXT)).isEmpty();
    }

    public void clickNextButton() {
        pageElement.findElement(By.linkText(TEXT_NEXT)).click();
    }
}
