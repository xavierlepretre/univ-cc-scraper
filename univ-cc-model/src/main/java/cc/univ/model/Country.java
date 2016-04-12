package cc.univ.model;

import org.jetbrains.annotations.NotNull;

public interface Country {
    @NotNull
    String getCode();

    @NotNull
    String getName();
}
