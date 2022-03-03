package com.maersk.service;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.validation.Valid;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.maersk.dto.Booking;
import com.maersk.repository.BookingRepo;
import com.maersk.repository.BookingTbl;

import reactor.core.publisher.Mono;

@Service
public class BookingService {

	@Autowired
	private WebClient.Builder webClientBuilder;

	@Autowired
	BookingRepo bookingRepo;

	public Mono<String> booking(@Valid Booking booking) {
		Mono<String> resp = null;
		try {
			String availableSpace = webClientBuilder.build().get().uri("http://localhost:8080/api/bookings").retrieve()
					.toString();
			JSONObject jsonObject = new JSONObject(availableSpace);
			if (!jsonObject.getBoolean("availableSpace")) {
				return Mono.just(availableSpace);
			}
			resp = webClientBuilder.build().post().uri("http://localhost:8080/api/bookingstore", booking).retrieve()
					.bodyToMono(String.class);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return resp;
	}

	

	public String availableSpace(String data) {
		int availableSpace = 0;
		try {
			JSONObject jsonObject = new JSONObject(data);
			availableSpace = jsonObject.getInt("availableSpace");
		} catch (JSONException err) {
		}
		return availableSpace == 0 ? new JSONObject().put("availableSpace", false).toString()
				: new JSONObject().put("availableSpace", true).toString();
	}

	public String addBooking(Booking bookingDto) {

		UUID uuid = UUID.randomUUID();
		BookingTbl booking = new BookingTbl();
		booking.setContainerSize(bookingDto.getContainerSize());
		booking.setContainerType(bookingDto.getContainerType().name());
		booking.setDestination(bookingDto.getDestination());
		booking.setId(uuid);
		booking.setOrigin(bookingDto.getOrigin());
		booking.setQuantity(0);
		booking.setTimestamp(LocalDateTime.now());
		bookingRepo.save(booking);
		return uuid.toString();
	}

}
