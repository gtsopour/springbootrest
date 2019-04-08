package my.projects.rest.core;

import java.util.ArrayList;
import java.util.Arrays;
import my.projects.rest.place.Place;
import my.projects.rest.place.PlaceRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements ApplicationRunner {
  private PlaceRepository placeRepository;

  public DatabaseLoader(PlaceRepository placeRepository) {
    this.placeRepository = placeRepository;
  }

  @Override
  public void run(ApplicationArguments args) throws Exception {
    ArrayList<Place> places = new ArrayList<Place>();
    String[] placeNames = {"Zurich", "St. Gallen", "Bern", "Lucern", "Basel"};

    Arrays.stream(placeNames).forEach(name -> {
      Place place = new Place(name, name + " description");
      places.add(place);
    });

    placeRepository.saveAll(places);
  }
}
