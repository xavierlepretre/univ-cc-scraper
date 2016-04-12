package cc.univ.model.web;

import cc.univ.model.Country;
import cc.univ.model.University;
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
import static org.mockito.Mockito.mock;

public class UniversityFactoryWebTest {
    private WebDriver driver;
    private UniversityFactoryWeb universityFactoryWeb;

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        universityFactoryWeb = new UniversityFactoryWeb();
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    @Test
    public void testReadLiValues() throws Exception {
        URL resource = getClass().getResource("li_university_1.html");
        driver.get("file://" + resource.getPath());
        WebElement element = driver.findElement(By.tagName("li"));
        Country country = mock(Country.class);
        University university = universityFactoryWeb.create(country, element);

        assertThat(university.getCountry()).isSameAs(country);
        assertThat(university.getName()).isEqualTo("China Agricultural University");
        assertThat(university.getUrl()).isEqualTo("http://www.cau.edu.cn/");
    }

    @Test
    public void testReadOlValues() throws Exception {
        URL resource = getClass().getResource("ol_universities_1.html");
        driver.get("file://" + resource.getPath());
        WebElement element = driver.findElement(By.tagName("ol"));
        Country country = mock(Country.class);
        List<University> universities = universityFactoryWeb.createList(country, element);

        assertThat(universities).hasSize(50);
        assertThat(universities.get(49).getName()).isEqualTo("China Agricultural University");
        assertThat(universities.get(49).getUrl()).isEqualTo("http://www.cau.edu.cn/");
    }

    @Test
    public void testGotUniversitiesFromPageChina1Web() throws Exception {
        URL resource = getClass().getResource("page_china_1.html");
        driver.get("file://" + resource.getPath());
        Country country = mock(Country.class);
        List<University> universities = universityFactoryWeb.findList(
                country,
                driver.findElement(By.tagName("html")));

        assertThat(universities).hasSize(50);
        assertThat(universities.get(49).getName()).isEqualTo("China Agricultural University");
        assertThat(universities.get(49).getUrl()).isEqualTo("http://www.cau.edu.cn/");
    }
}