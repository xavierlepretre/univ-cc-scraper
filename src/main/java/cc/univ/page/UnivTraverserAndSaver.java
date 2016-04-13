package cc.univ.page;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;

public interface UnivTraverserAndSaver {
    void scrapeAndSave(@NotNull WebDriver driver);
}
