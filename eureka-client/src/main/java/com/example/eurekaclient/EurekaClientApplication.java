package com.example.eurekaclient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.ServiceInstance;
import com.netflix.discovery.EurekaClient;

@SpringBootApplication
@RestController
public class EurekaClientApplication {
	
	@Autowired
    @Lazy
    private EurekaClient eurekaClient;
	
	@Autowired
	private DiscoveryClient discoveryClient;

	
	 @Value("${spring.application.name}")
	 private String appName;


	public static void main(String[] args) {
		SpringApplication.run(EurekaClientApplication.class, args);
	}
	
	@RequestMapping("/greeting")
	 public String greeting() {
	        return String.format(
	          "Hello from '%s'!", eurekaClient.getApplication(appName).getName());
	 }
	
	@RequestMapping("/service-instances/{applicationName}")
	public List<ServiceInstance> serviceInstancesByApplicationName(
			@PathVariable String applicationName) {
		return this.discoveryClient.getInstances(applicationName);
	}
	

}

