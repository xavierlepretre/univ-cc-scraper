package cc.univ.model.web;

import cc.univ.model.Country;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.net.URL;
import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;

public class CountryFactoryWebLiveTest {
    private  WebDriver driver;
    private CountryFactoryWeb countryFactoryWeb;

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        countryFactoryWeb = new CountryFactoryWeb();
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    @Test
    public void testGotCountriesFromPageWorld() throws Exception {
        URL resource = getClass().getResource("page_world.html");
        driver.get("http://univ.cc/world.php");
        List<Country> countries = countryFactoryWeb.findList(driver);

        assertThat(countries).hasSize(205);
        assertThat(countries.get(2).getCode()).isEqualTo("dz");
        assertThat(countries.get(2).getName()).isEqualTo("Algeria");
    }
}