package service;

import model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class KafkaProducerService {
    @Autowired
    private KafkaTemplate<String, Article> kafkaTemplate;

    public void sendMessage(Article article) {
        System.out.println("student"+article);
        kafkaTemplate.send("TOPIC",article.getTitle(), article);
    }
}
