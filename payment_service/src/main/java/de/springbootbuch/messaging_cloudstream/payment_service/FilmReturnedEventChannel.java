package de.springbootbuch.messaging_cloudstream.payment_service;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * Part of springbootbuch.de.
 *
 * @author Michael J. Simons
 * @author @rotnroll666
 */
public interface FilmReturnedEventChannel {
	String RETURNED_FILM_EVENTS = "returnedFilmsEvents";
	
	@Input
	SubscribableChannel returnedFilmsEvents();
}
