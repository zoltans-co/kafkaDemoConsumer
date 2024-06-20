package co.zoltans.kafka.demo.kafkademoaggregator;

import co.zoltans.kafka.demo.kafkademoaggregator.message.PublicationAnalytics;
import co.zoltans.kafka.demo.kafkademoaggregator.message.PublicationMessage;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {
  
  private KafkaTemplate<String, PublicationAnalytics> kafkaAnalyticsTemplate;
  
  public KafkaListeners(KafkaTemplate<String, PublicationAnalytics> kafkaAnalyticsTemplate) {
    this.kafkaAnalyticsTemplate = kafkaAnalyticsTemplate;
  }
  
  @KafkaListener(topics = "publications-topic", groupId = "publications-aggregator-group-id")
  void listenMessage(PublicationMessage publicationMessage) {
    System.out.println("Received publication topic message: " + publicationMessage);
    kafkaAnalyticsTemplate.send("analytics-topic", new PublicationAnalytics(
            publicationMessage.title(),
            publicationMessage.author(),
            publicationMessage.title().length(),
            publicationMessage.content().length(),
            wordCount(publicationMessage.content())
    ));
  }
  
  @KafkaListener(topics = "analytics-topic", groupId = "analytics-aggregator-group-id")
  void listenMessageAggregated(PublicationAnalytics analyticsMessage) {
    System.out.println("Received analytics topic message: " + analyticsMessage);
  }
  
  public static int wordCount(String str) {
    if (str == null || str.isEmpty()) {
      return 0;
    }
    String[] words = str.split("\\s+");
    return words.length;
  }
  
}
