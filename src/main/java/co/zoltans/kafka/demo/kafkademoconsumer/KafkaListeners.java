package co.zoltans.kafka.demo.kafkademoconsumer;

import co.zoltans.kafka.demo.kafkademoconsumer.message.PublicationAnalytics;
import co.zoltans.kafka.demo.kafkademoconsumer.message.PublicationMessage;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {
  
  private KafkaTemplate<String, PublicationAnalytics> kafkaAnalyticsTemplate;
  
  public KafkaListeners(KafkaTemplate<String, PublicationAnalytics> kafkaAnalyticsTemplate) {
    this.kafkaAnalyticsTemplate = kafkaAnalyticsTemplate;
  }
  
  @KafkaListener(topics = "publications-topic", groupId = "consumer-group-id")
  void listenMessage(PublicationMessage publicationMessage) {
    System.out.println("Received publication topic message: " + publicationMessage);
  }
  
  @KafkaListener(topics = "analytics-topic", groupId = "consumer-group-id")
  void listenMessageAggregated(PublicationAnalytics analyticsMessage) {
    System.out.println("Received analytics topic message: " + analyticsMessage);
  }
  
}
