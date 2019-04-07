package my.projects.rest.core;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import org.hibernate.annotations.GenericGenerator;

@MappedSuperclass
public class BaseEntity {

  @Id
  @GeneratedValue(generator="system-uuid")
  @GenericGenerator(name="system-uuid", strategy = "uuid2")
  private final String id;

//  @Id
//  @GeneratedValue(strategy = GenerationType.AUTO)
//  private final Long id;

  protected BaseEntity() {
    this.id = null;
  }

  public String getId() {
    return id;
  }
}
