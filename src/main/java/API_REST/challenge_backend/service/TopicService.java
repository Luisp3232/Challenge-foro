package API_REST.challenge_backend.service;

import API_REST.challenge_backend.model.Topic;

import java.util.List;

public interface TopicService {

    List<Topic> getAllTopics();

    Topic getTopicById(Long id);

    Topic createTopic(Topic topic);

    Topic updateTopic(Long id, Topic topic);

    void deleteTopic(Long id);
}
