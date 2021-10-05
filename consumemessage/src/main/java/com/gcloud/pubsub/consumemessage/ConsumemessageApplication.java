package com.gcloud.pubsub.consumemessage;

import com.google.cloud.ServiceOptions;
import com.google.cloud.pubsub.v1.Subscriber;
import com.google.pubsub.v1.ProjectSubscriptionName;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ConsumemessageApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumemessageApplication.class, args);
	}

	@Bean
	public CommandLineRunner getCommandLineRunner(){
		return (args) -> {
          String Project_ID = ServiceOptions.getDefaultProjectId();
		  String Subscription_ID = "s-sensordata";

		  ProjectSubscriptionName subscriptionName = ProjectSubscriptionName.of
		  (Project_ID, Subscription_ID);
 
		  //preemed project id and subscription id
		 Log log = LogFactory.getLog(ConsumemessageApplication.class);
		 log.info(String.format("Project: %s", Project_ID));

		  Subscriber subscriber = null;

		  try {
			  subscriber = Subscriber.newBuilder(subscriptionName, new PubsubMessageReveiver()).build();

			  subscriber.startAsync().awaitRunning();
			  subscriber.awaitTerminated();

		  } catch (IllegalStateException IllegalStateException) {
			  IllegalStateException.printStackTrace();
		  }
		};
	}

}
