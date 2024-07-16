package API_REST.challenge_backend.service;


import API_REST.challenge_backend.model.Topic;
import API_REST.challenge_backend.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicServiceImp implements TopicService {

    private final TopicRepository topicRepository;

    @Autowired
    public TopicServiceImp(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    @Override
    public List<Topic> getAllTopics() {
        return topicRepository.findAll();
    }

    @Override
    public Topic getTopicById(Long id) {
        Optional<Topic> optionalTopic = topicRepository.findById(id);
        return optionalTopic.orElse(null);
    }

    @Override
    public Topic createTopic(Topic topic) {
        return topicRepository.save(topic);
    }

    @Override
    public Topic updateTopic(Long id, Topic updatedTopic) {
        Optional<Topic> optionalTopic = topicRepository.findById(id);
        if (optionalTopic.isPresent()) {
            Topic existingTopic = optionalTopic.get();
            existingTopic.setTitle(updatedTopic.getTitle());
            existingTopic.setMessage(updatedTopic.getMessage());
            existingTopic.setStatus(updatedTopic.getStatus());
            existingTopic.setAuthor(updatedTopic.getAuthor());
            existingTopic.setCourse(updatedTopic.getCourse());
            return topicRepository.save(existingTopic);
        }
        return null;
    }

    @Override
    public void deleteTopic(Long id) {
        topicRepository.deleteById(id);
    }
}
