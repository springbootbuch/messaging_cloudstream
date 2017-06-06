package de.springbootbuch.messaging_cloudstream.film_rental;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Part of springbootbuch.de.
 *
 * @author Michael J. Simons
 * @author @rotnroll666
 */
@Entity
public class FilmInStore implements Serializable {

	private static final long serialVersionUID = 3319751565101265013L;
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String title;

	protected FilmInStore() {
	}

	public FilmInStore(String title) {
		this.title = title;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}