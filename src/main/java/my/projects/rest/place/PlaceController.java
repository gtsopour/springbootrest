package my.projects.rest.place;

import com.google.common.collect.Lists;
import java.util.Collection;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/places")
public class PlaceController {

  @Autowired
  private PlaceRepository placeRepository;

  @RequestMapping(method = RequestMethod.GET)
  Collection<Place> getPlaces() {
    return Lists.newArrayList(placeRepository.findAll());
  }

  @RequestMapping(method = RequestMethod.GET, value = "name/{name}")
  Collection<Place> getPlaceByName(@PathVariable String name) {
    return placeRepository.findByName(name);
  }

  @RequestMapping(method = RequestMethod.GET, value = "{id}")
  ResponseEntity getPlaceById(@PathVariable String id) {
    Optional<Place> place = placeRepository.findById(id);
    if (place.isPresent()) {
      return ResponseEntity.status(HttpStatus.OK).body(place);
    }
    return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
  }

  @RequestMapping(method = RequestMethod.POST)
  ResponseEntity addPlace(@RequestBody Place place) {
    Place newPlace = placeRepository.save(new Place(place.getName(), place.getDescription()));
    if (newPlace != null) {
      return ResponseEntity.status(HttpStatus.OK).body(newPlace);
    }
    return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
  }

  @RequestMapping(method = RequestMethod.PUT, value = "{id}")
  ResponseEntity updatePlace(@RequestBody Place place, @PathVariable String id) {
    Optional<Place> newPlace = placeRepository.findById(id);
    System.out.println(newPlace);
    if (newPlace.isPresent()) {
      if (!place.getName().isEmpty()) {
        newPlace.get().setName(place.getName());
      }
      if (!place.getDescription().isEmpty()) {
        newPlace.get().setDescription(place.getDescription());
      }
      if (placeRepository.save(newPlace.get()).getId().equals(id)) {
        return ResponseEntity.status(HttpStatus.OK).body(newPlace);
      }
    }
    return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
  }

  @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
  ResponseEntity deletePlace(@PathVariable String id) {
    try {
      placeRepository.deleteById(id);
      return new ResponseEntity<HttpStatus>(HttpStatus.ACCEPTED);
    } catch (Exception e) {
      return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
    }
  }

}
