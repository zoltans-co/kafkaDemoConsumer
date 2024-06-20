package co.zoltans.kafka.demo.kafkademoaggregator.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfiguration {
  
  @Value("${topic.name.publications}")
  private String topicNamePublications;
  
  @Value("${topic.name.analytics}")
  private String topicNameAnalytics;
  
  @Bean
  public NewTopic kafkaPublicationsTopic() {
    return TopicBuilder.name(topicNamePublications).partitions(1).replicas(1).build();
  }
  
  @Bean
  public NewTopic kafkaAnalyticsTopic() {
    return TopicBuilder.name(topicNameAnalytics).partitions(1).replicas(1).build();
  }
  
}
