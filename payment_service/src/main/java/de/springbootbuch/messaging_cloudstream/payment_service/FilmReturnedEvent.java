package de.springbootbuch.messaging_cloudstream.payment_service;

/**
 * Part of springbootbuch.de.
 *
 * @author Michael J. Simons
 * @author @rotnroll666
 */
public class FilmReturnedEvent {

	final String title;

	public FilmReturnedEvent(String title) {
		this.title = title;
	}
}