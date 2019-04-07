package my.projects.rest.topic;

import com.google.common.collect.Lists;
import java.util.Collection;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topics")
public class TopicController {

  private TopicRepository topicRepository;

  Collection<Topic> getTopics() {
    return Lists.newArrayList(topicRepository.findAll());
  }

}
