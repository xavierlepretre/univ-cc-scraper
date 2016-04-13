package cc.univ.data.csv;

import cc.univ.model.University;
import cc.univ.model.auto.CountryAuto;
import cc.univ.model.auto.UniversityAuto;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class UniversitySaverCSVTest {
    private UniversitySaverCSV universitySaver;

    @Before
    public void setUp() throws Exception {
        this.universitySaver = new UniversitySaverCSV();
    }

    @Test
    public void testSaveOne_eyeBall() throws Exception {
        universitySaver.add(UniversityAuto.create(CountryAuto.create("af", "Afghanistan"), "Uni1", "url1"));
        universitySaver.save();
    }

    @Test
    public void testSaveTwo_eyeBall() throws Exception {
        universitySaver.add(Arrays.<University>asList(
                UniversityAuto.create(CountryAuto.create("af", "Afghanistan"), "Uni1", "url1"),
                UniversityAuto.create(CountryAuto.create("fr", "France"), "Uni2", "url2")));
        universitySaver.save();
    }
}