package my.projects.rest.core;

import java.util.ArrayList;
import java.util.Arrays;
import my.projects.rest.topic.Topic;
import my.projects.rest.topic.TopicRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements ApplicationRunner {
  private TopicRepository topicRepository;

  public DatabaseLoader(TopicRepository topicRepository) {
    this.topicRepository = topicRepository;
  }

  @Override
  public void run(ApplicationArguments args) throws Exception {
    ArrayList<Topic> topics = new ArrayList<Topic>();
    String[] words = {"Multi Threading", "Inner Classes",  "Collections", "Generics", "Development", "JVM"};

    Arrays.stream(words).forEach(word -> {
      Topic topic = new Topic(word, 0);
      topics.add(topic);
    });

    topicRepository.saveAll(topics);
  }
}
