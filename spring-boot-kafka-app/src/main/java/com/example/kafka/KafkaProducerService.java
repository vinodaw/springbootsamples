package com.example.kafka;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.extern.java.Log;

@Service
@Log
public class KafkaProducerService {
  private final Logger LOGGER = (Logger) LoggerFactory.getLogger(KafkaProducerService.class);
  @Autowired
  KafkaTemplate<String, TaskStatus> kafkaTemplate;
  public void send(String topicName, String key, TaskStatus value) {
    var future = kafkaTemplate.send(topicName, key, value);
    future.whenComplete((sendResult, exception) -> {
      if (exception != null) {
        future.completeExceptionally(exception);
      } else {
        future.complete(sendResult);
      }
      LOGGER.info("Task status send to Kafka topic : "+ value);
    });
  }
}