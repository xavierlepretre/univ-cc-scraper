package cc.univ.page.csv;

import cc.univ.data.CountrySaver;
import cc.univ.data.UniversitySaver;
import cc.univ.model.ScrapedInfo;
import cc.univ.page.UnivTraverser;
import cc.univ.page.UnivTraverserAndSaver;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;

public class UnivTraverserAndSaverCSV implements UnivTraverserAndSaver {
    @NotNull private final UnivTraverser univTraverser;
    @NotNull private final CountrySaver countrySaver;
    @NotNull private final UniversitySaver universitySaver;

    public UnivTraverserAndSaverCSV(
            @NotNull UnivTraverser univTraverser,
            @NotNull CountrySaver countrySaver,
            @NotNull UniversitySaver universitySaver) {
        this.univTraverser = univTraverser;
        this.countrySaver = countrySaver;
        this.universitySaver = universitySaver;
    }

    public void scrapeAndSave(@NotNull WebDriver driver) {
        ScrapedInfo scrapedInfo = univTraverser.scrape(driver);
        countrySaver.add(scrapedInfo.getCountries());
        countrySaver.save();
        universitySaver.add(scrapedInfo.getUniversities());
        universitySaver.save();
    }
}
