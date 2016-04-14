package cc.univ.page.csv;

import cc.univ.data.csv.CountrySaverCSV;
import cc.univ.data.csv.UniversitySaverCSV;
import cc.univ.model.web.CountryFactoryWeb;
import cc.univ.model.web.UniversityFactoryWeb;
import cc.univ.page.UnivTraverserAndSaver;
import cc.univ.page.web.CountryListPageWebFactory;
import cc.univ.page.web.UnivTraverserWeb;
import cc.univ.page.web.UniversityListPageHandlerImplFactory;
import cc.univ.page.web.UniversityListPageWebFactory;
import html.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ScraperAndSaverUsaCSV {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get(Constants.BASE_URL_USA);
        UnivTraverserAndSaver traverserAndSaver = new UnivTraverserAndSaverCSV(
                new UnivTraverserWeb(
                        new CountryListPageWebFactory(new CountryFactoryWeb()),
                        new UniversityListPageHandlerImplFactory(
                                new UniversityListPageWebFactory(
                                        new UniversityFactoryWeb()))),
                new CountrySaverCSV(),
                new UniversitySaverCSV());
        traverserAndSaver.scrapeAndSave(driver);
    }
}
