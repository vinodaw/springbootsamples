package com.example.kafka;

import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import ch.qos.logback.classic.Logger;
import lombok.extern.java.Log;


@Component
@Log
public class KafKaTopicListeners {
  private final Logger logger = (Logger) LoggerFactory.getLogger(KafKaTopicListeners.class);
  @KafkaListener(topics = {"general-task-topic"}, groupId = "task-group")
  public void consume(TaskStatus taskStatus) {
    logger.info(String.format("Task status is updated : " + taskStatus));
  }
}
