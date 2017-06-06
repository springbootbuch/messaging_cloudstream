/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package de.springbootbuch.messaging_cloudstream.film_rental;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 *
 * @author Michael J. Simons, 2017-06-06
 */
public interface FilmReturnedChannel {
	String CREDIT_APPLICATION_NUMBER_GENERATED = "creditApplicationNumberGeneratedIn";
	
	@Output
	MessageChannel returnedFilmsEvents();
}
