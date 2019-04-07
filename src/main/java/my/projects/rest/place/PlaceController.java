package my.projects.rest.place;

import com.google.common.collect.Lists;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/places")
public class PlaceController {

  @Autowired
  private PlaceRepository placeRepository;

  Collection<Place> getPlaces() {
    return Lists.newArrayList(placeRepository.findAll());
  }

  @RequestMapping(method = RequestMethod.GET, value = "name/{name}")
  Collection<Place> getPlaceByName(@PathVariable String name) {
    return placeRepository.findByName(name);
  }

  @RequestMapping(method = RequestMethod.GET, value = "id/{id}")
  ResponseEntity getPlaceById(@PathVariable Long id) {
    if (placeRepository.findById(id).isPresent()) {
      return ResponseEntity.status(HttpStatus.OK).body(placeRepository.findById(id));
    }
    return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
  }

}
