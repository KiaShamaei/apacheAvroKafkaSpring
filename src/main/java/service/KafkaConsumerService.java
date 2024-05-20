package service;

import model.Article;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
    @KafkaListener(topics = "students", groupId = "groupid")
    public void KafkaConsumer(@Payload Article article) {

        System.out.println("Received Article: "+ article.getTitle()+" Article is "+article.getContent());
    }
}
