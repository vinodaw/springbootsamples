package com.example.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;



@SpringBootApplication
public class SpringBootKafkaAppApplication implements CommandLineRunner {

	 @Autowired
	  KafkaTemplate kafkaTemplate;

	  public static void main(String[] args) {
	    SpringApplication.run(SpringBootKafkaAppApplication.class, args);
	  }

	  @Override
	  public void run(String... args) throws Exception {

	    kafkaTemplate.send("general-task-topic", "taskId", new TaskStatus("taskId", "taskName", 50.0f, "RUNNING"));
	    kafkaTemplate.send("general-task-topic", "taskId", new TaskStatus("taskId", "taskName", 100.0f, "FINISHED"));
	  }

}
