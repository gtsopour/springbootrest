package my.projects.rest.place;

import java.util.Collection;
import org.springframework.data.repository.CrudRepository;

public interface PlaceRepository extends CrudRepository<Place, Long> {

  Collection<Place> findByName(String name);

}
