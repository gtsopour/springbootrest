package my.projects.rest.place;

import javax.persistence.Entity;
import my.projects.rest.core.BaseEntity;

@Entity
public class Place extends BaseEntity {

  private String name;
  private String description;

  protected Place() {
    super();
  }

  public Place(String name) {
    this();
    this.name = name;
  }

  public Place(String name, String description) {
    this();
    this.name = name;
    this.description = description;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
