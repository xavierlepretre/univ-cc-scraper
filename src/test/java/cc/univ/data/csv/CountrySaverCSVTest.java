package cc.univ.data.csv;

import cc.univ.model.Country;
import cc.univ.model.auto.CountryAuto;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class CountrySaverCSVTest {
    private CountrySaverCSV countrySaverCSV;

    @Before
    public void setUp() throws Exception {
        this.countrySaverCSV = new CountrySaverCSV();
    }

    @Test
    public void testSaveOne_eyeBall() throws Exception {
        countrySaverCSV.add(CountryAuto.create("af", "Afghanistan"));
        countrySaverCSV.save();
    }

    @Test
    public void testSaveTwo_eyeBall() throws Exception {
        countrySaverCSV.add(Arrays.<Country>asList(
                CountryAuto.create("af", "Afghanistan"),
                CountryAuto.create("fr", "France")));
        countrySaverCSV.save();
    }
}