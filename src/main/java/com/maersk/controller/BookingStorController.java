package com.maersk.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maersk.dto.Booking;
import com.maersk.service.BookingService;

@RestController
@RequestMapping("/api/bookingstore")
public class BookingStorController {

	@Autowired
	BookingService bookingService;
	
	@PutMapping
	public String bookingStore(@RequestBody Booking booking) {
		String uuid=bookingService.addBooking(booking);
		return new JSONObject().put("bookingRef", uuid).toString();
	}
	
}
