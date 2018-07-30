package com.wonder5.yanyigraph.service;

import com.wonder5.yanyigraph.dto.Topic;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yuhaoy
 */
@Service
public class TopicService {

    private List<Topic> topics = new ArrayList<>(Arrays.asList(
            new Topic("1", "jax-rs", "Java Rest Library"),
            new Topic("2", "spring-boot", "standalone working spring app")
    ));

    public List<Topic> getAllTopics() {
        return topics;
    }

    public Topic getTopicById(String id) {
        return topics.stream().filter(topic -> topic.getId().equals(id)).findFirst().get();
    }

    public void addTopic(Topic topic) {
        topics.add(topic);
    }

    public void updateTopic(Topic topic, String id) {
        topics.stream().forEach(t -> {
            if (t.getId().equals(id)) {
                topics.remove(t);
                topics.add(topic);
            }
        });
    }
}

