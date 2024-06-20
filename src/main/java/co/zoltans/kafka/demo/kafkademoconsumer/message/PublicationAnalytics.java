package co.zoltans.kafka.demo.kafkademoaggregator.message;

public record PublicationAnalytics(String title,
                                   String author,
                                   long titleLength,
                                   long publicationLength,
                                   long publicationWordCount) {
}
