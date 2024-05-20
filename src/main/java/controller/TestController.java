package controller;

import model.Article;
import org.checkerframework.checker.units.qual.C;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.KafkaProducerService;

@RestController
@RequestMapping("/api/v1")
public class TestController {
    @Autowired
    private KafkaProducerService producerService;

    @GetMapping(value = "/init")
    public void sendMessageKafkaTopic() {
        Article art=new Article();
        int value=(int)Math.ceil(Math.random()*10000);
        art.setId(value);
        art.setTitle("hamid Loan ina : "+value);
        art.setContent("avro is good serializer ....");
        producerService.sendMessage(art);
    }
}
