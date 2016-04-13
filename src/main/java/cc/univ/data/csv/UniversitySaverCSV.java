package cc.univ.data.csv;

import cc.univ.data.UniversitySaver;
import cc.univ.model.University;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public class UniversitySaverCSV implements UniversitySaver {
    @NotNull private StringBuilder appended;

    public UniversitySaverCSV() {
        this.appended = new StringBuilder("\"Country Code\",\"Name\",\"Url\"\n");
    }

    public void add(@NotNull University university) {
        this.appended.append("\"").append(university.getCountry().getCode()).append("\"");
        this.appended.append(",");
        this.appended.append("\"").append(university.getName()).append("\"");
        this.appended.append(",");
        this.appended.append("\"").append(university.getUrl()).append("\"");
        this.appended.append("\n");
    }

    public void add(@NotNull Collection<University> universities) {
        for (University university : universities) {
            add(university);
        }
    }

    public void save() {
        System.out.println(appended.toString());
    }
}
