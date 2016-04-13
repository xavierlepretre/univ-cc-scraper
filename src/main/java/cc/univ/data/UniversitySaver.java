package cc.univ.data;

import cc.univ.model.University;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public interface UniversitySaver {
    void add(@NotNull University university);

    void add(@NotNull Collection<University> universities);

    void save();
}

