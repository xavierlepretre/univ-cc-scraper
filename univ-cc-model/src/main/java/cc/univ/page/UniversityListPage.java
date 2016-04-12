package cc.univ.page;

import cc.univ.model.University;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface UniversityListPage {
    boolean hasNextButton();

    void clickNextButton();

    @NotNull
    List<University> collectUniversities();
}
