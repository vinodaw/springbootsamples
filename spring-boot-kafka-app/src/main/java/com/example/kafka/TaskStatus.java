package com.example.kafka;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskStatus implements Serializable {

	 private String taskId;
	  private String taskName;
	  private float percentageComplete;
	  private String status;
	  
	  

	  public TaskStatus() {
		super();
	}



	public TaskStatus(String taskId, String taskName, float percentageComplete, String status) {
		super();
		this.taskId = taskId;
		this.taskName = taskName;
		this.percentageComplete = percentageComplete;
		this.status = status;
	}



	public static enum Status {
	    SUBMITTED, STARTED, RUNNING, FINISHED, TERMINATED
	  }
}
