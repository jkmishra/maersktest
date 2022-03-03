package com.maersk.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maersk.dto.Booking;
import com.maersk.repository.Mock;
import com.maersk.service.BookingService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

	@Autowired
	BookingService bookingService;

	@PostMapping
	public Mono<String> createBookingRequest(@RequestBody @Valid Booking booking) {
		return bookingService.booking(booking);
	}

	@GetMapping
	public String getAvailableSpace() {
		return bookingService.availableSpace(Mock.getAvailableSpace());
	}

}
