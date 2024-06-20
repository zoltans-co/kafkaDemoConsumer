package co.zoltans.kafka.demo.kafkademoconsumer.message;

public record PublicationAnalytics(String title,
                                   String author,
                                   long titleLength,
                                   long publicationLength,
                                   long publicationWordCount) {
}
