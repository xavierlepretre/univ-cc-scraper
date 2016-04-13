package cc.univ.page;

import cc.univ.model.Country;
import cc.univ.model.University;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;

import java.util.List;

public interface UniversityListPage {
    boolean hasNextButton(@NotNull WebDriver driver);

    void clickNextButton(@NotNull WebDriver driver);

    @NotNull
    List<University> collectUniversities(
            @NotNull WebDriver driver,
            @NotNull Country country);
}
