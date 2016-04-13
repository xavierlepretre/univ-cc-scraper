package cc.univ.page;

import cc.univ.model.Country;
import cc.univ.model.University;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;

import java.util.List;

public interface UniversityListPageHandler {
    @NotNull
    List<University> traverseAndCollect(
            @NotNull WebDriver driver,
            @NotNull Country country);
}
