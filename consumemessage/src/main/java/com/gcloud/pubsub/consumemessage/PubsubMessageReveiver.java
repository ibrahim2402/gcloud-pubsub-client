package com.gcloud.pubsub.consumemessage;

import com.google.cloud.pubsub.v1.AckReplyConsumer;
import com.google.cloud.pubsub.v1.MessageReceiver;
import com.google.pubsub.v1.PubsubMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;


@Component
public class PubsubMessageReveiver implements MessageReceiver {

   private Log log = LogFactory.getLog(PubsubMessageReveiver.class);

 @Override
 public void receiveMessage(PubsubMessage message, AckReplyConsumer consumer) {
    // Message Handler method 
    

    log.info("Message Payload... ");
    log.info(" Message ID: " + message.getMessageId());
    log.info("Data Load" + message.getData().toStringUtf8());

    //consumer.ack();
    
 }
   
}