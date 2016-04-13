package cc.univ.data.csv;

import cc.univ.data.CountrySaver;
import cc.univ.model.Country;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public class CountrySaverCSV implements CountrySaver {
    @NotNull private StringBuilder appended;

    public CountrySaverCSV() {
        this.appended = new StringBuilder("\"Code\",\"Name\"\n");
    }

    public void add(@NotNull Country country) {
        this.appended.append("\"").append(country.getCode()).append("\"");
        this.appended.append(",");
        this.appended.append("\"").append(country.getName()).append("\"");
        this.appended.append("\n");
    }

    public void add(@NotNull Collection<Country> countries) {
        for (Country country : countries) {
            add(country);
        }
    }

    public void save() {
        System.out.println(appended.toString());
    }
}
