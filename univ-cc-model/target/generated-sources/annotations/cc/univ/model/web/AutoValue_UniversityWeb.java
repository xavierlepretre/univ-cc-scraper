
package cc.univ.model.web;

import cc.univ.model.auto.UniversityAuto;
import javax.annotation.Generated;
import org.jetbrains.annotations.NotNull;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_UniversityWeb extends UniversityWeb {

  private final UniversityAuto universityAuto;

  AutoValue_UniversityWeb(
      UniversityAuto universityAuto) {
    if (universityAuto == null) {
      throw new NullPointerException("Null universityAuto");
    }
    this.universityAuto = universityAuto;
  }

  @NotNull
  @Override
  UniversityAuto getUniversityAuto() {
    return universityAuto;
  }

  @Override
  public String toString() {
    return "UniversityWeb{"
        + "universityAuto=" + universityAuto
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof UniversityWeb) {
      UniversityWeb that = (UniversityWeb) o;
      return (this.universityAuto.equals(that.getUniversityAuto()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.universityAuto.hashCode();
    return h;
  }

}
