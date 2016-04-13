package cc.univ.page.web;

import cc.univ.model.Country;
import cc.univ.model.ScrapedInfo;
import cc.univ.model.web.CountryFactoryWeb;
import cc.univ.model.web.UniversityFactoryWeb;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.net.URL;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UnivTraverserWebTest {
    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    @Test
    public void testWorldOnlyAfghanistan_collects31() throws Exception {
        URL resource = getClass().getResource("page_world_short.html");
        driver.get("file://" + resource.getPath());
        Country country = mock(Country.class);
        when(country.getCode()).thenReturn("af");

        UnivTraverserWeb traverser = new UnivTraverserWeb(
                new CountryListPageWebFactory(
                        new CountryFactoryWeb()),
                new UniversityListPageHandlerImplFactory(
                        new UniversityListPageWebFactory(
                                new UniversityFactoryWeb())));
        ScrapedInfo scrapedInfo = traverser.scrape(driver);

        assertThat(scrapedInfo.getCountries()).hasSize(1);
        assertThat(scrapedInfo.getCountries().get(0).getCode()).isEqualTo("af");
        assertThat(scrapedInfo.getCountries().get(0).getName()).isEqualTo("Afghanistan");
        assertThat(scrapedInfo.getUniversities()).hasSize(41);
        assertThat(scrapedInfo.getUniversities().get(0).getName()).isEqualTo("Afghan University");
        assertThat(scrapedInfo.getUniversities().get(0).getUrl()).isEqualTo("http://www.afghanuniversity.edu.af/");
    }
}