package de.springbootbuch.messaging_cloudstream.film_rental;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.springbootbuch.messaging_cloudstream.film_rental.RentalController.ReturnedFilm;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.cloud.stream.test.binder.MessageCollector;
import org.springframework.http.MediaType;
import org.springframework.messaging.Message;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Part of springbootbuch.de.
 *
 * @author Michael J. Simons
 * @author @rotnroll666
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class RentalControllerTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private MessageCollector messageCollector;

	@Autowired
	private Source source;

	@Test
	public void aMessageShouldBeSend() throws Exception {
		final ReturnedFilm returnedFilm =
			new ReturnedFilm();
		returnedFilm.setTitle("test");
		final String json = 
			objectMapper.writeValueAsString(returnedFilm);
		
		mvc.perform(
			post("/returnedFilms")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json)
		).andExpect(status().isNoContent());

		Message<String> received = (Message<String>)
			messageCollector
				.forChannel(source.output())
				.poll();

		assertThat(
			objectMapper.readTree(received.getPayload())
				.get("title").asText(),
			equalTo("test")
		);
	}
}
