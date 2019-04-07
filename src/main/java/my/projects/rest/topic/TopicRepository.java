package my.projects.rest.topic;

import java.util.Collection;
import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic, Long> {

  Collection<Topic> findByTopicName(String topicName);

}
