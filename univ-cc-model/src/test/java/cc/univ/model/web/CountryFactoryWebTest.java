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

public class CountryFactoryWebTest {
    private WebDriver driver;
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
    public void testReadOptionValues() throws Exception {
        URL resource = getClass().getResource("option_country_1.html");
        driver.get("file://" + resource.getPath());
        WebElement element = driver.findElement(By.tagName("option"));
        Country country = countryFactoryWeb.create(element);

        assertThat(country.getCode()).isEqualTo("ad");
        assertThat(country.getName()).isEqualTo("Andorra");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWrongOption() throws Exception {
        URL resource = getClass().getResource("option_country_wrong.html");
        driver.get("file://" + resource.getPath());
        WebElement element = driver.findElement(By.tagName("option"));
        countryFactoryWeb.create(element);
    }

    @Test
    public void testReadSelectValues() throws Exception {
        URL resource = getClass().getResource("select_countries_1.html");
        driver.get("file://" + resource.getPath());
        WebElement element = driver.findElement(By.tagName("select"));
        List<Country> countries = countryFactoryWeb.createList(element);

        assertThat(countries).hasSize(205);
        assertThat(countries.get(2).getCode()).isEqualTo("dz");
        assertThat(countries.get(2).getName()).isEqualTo("Algeria");
    }

    @Test
    public void testGotCountriesFromPageWorld() throws Exception {
        URL resource = getClass().getResource("page_world.html");
        driver.get("file://" + resource.getPath());
        List<Country> countries = countryFactoryWeb.findList(driver);

        assertThat(countries).hasSize(205);
        assertThat(countries.get(2).getCode()).isEqualTo("dz");
        assertThat(countries.get(2).getName()).isEqualTo("Algeria");
    }
}