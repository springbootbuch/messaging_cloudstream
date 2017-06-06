package de.springbootbuch.messaging_cloudstream.film_rental;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Part of springbootbuch.de.
 *
 * @author Michael J. Simons
 * @author @rotnroll666
 */
public interface InventoryRepository extends JpaRepository<FilmInStore, Integer> {
}
