package de.springbootbuch.messaging_cloudstream.film_rental;

import org.springframework.cloud.stream.messaging.Source;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Part of springbootbuch.de.
 *
 * @author Michael J. Simons
 * @author @rotnroll666
 */
@RestController
public class RentalController {
	
	public static class ReturnedFilm {
		private String title;

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}
	}
	
	private final InventoryRepository inventoryRepository;
	
	private final Source source;

	public RentalController(InventoryRepository inventoryRepository, Source source) {
		this.inventoryRepository = inventoryRepository;
		this.source = source;
	}

	@PostMapping("/returnedFilms")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void returnFilm(
		@RequestBody ReturnedFilm returnedFilm
	) {
		final FilmInStore filmInStore = 
			this.inventoryRepository
				.save(new FilmInStore(returnedFilm.getTitle()));

		final Message<FilmReturnedEvent> message 
			= MessageBuilder
				.withPayload(new FilmReturnedEvent(
					filmInStore.getId(), 
					filmInStore.getTitle()
			)).build();
		source.output().send(message);
	}
}
