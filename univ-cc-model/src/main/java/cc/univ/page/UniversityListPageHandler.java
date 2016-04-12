package cc.univ.page;

import cc.univ.model.University;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface UniversityListPageHandler {
    @NotNull
    List<University> traverseAndCollect();
}
