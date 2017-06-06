package de.springbootbuch.messaging_cloudstream.payment_service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Component;

/**
 * Part of springbootbuch.de.
 *
 * @author Michael J. Simons
 * @author @rotnroll666
 */
@Component
public class FilmReturnedEventReceiver {

	private static final Logger LOG = LoggerFactory
		.getLogger(FilmReturnedEventReceiver.class);

	@StreamListener(Sink.INPUT)
	public void filmReturned(FilmReturnedEvent event) {
		LOG.info(
			"Film '{}' returned, billing customer...", 
			event.title
		);
	}
}
