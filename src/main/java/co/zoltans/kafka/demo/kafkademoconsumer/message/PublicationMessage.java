package co.zoltans.kafka.demo.kafkademoconsumer.message;

import java.time.LocalDateTime;

public record PublicationMessage(
		String title,
		String author,
		String content,
		String category,
		LocalDateTime created) {
}
