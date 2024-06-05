package org.myworkspace.FlightService;

import org.myworkspace.FlightService.DTO.FlightBookingAcknowledgement;
import org.myworkspace.FlightService.DTO.FlightBookingRequest;
import org.myworkspace.FlightService.Service.FlightBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableTransactionManagement
public class FlightServiceApplication {

	@Autowired
	private FlightBookingService service;

	@PostMapping("/bookFlightTicket")
	public FlightBookingAcknowledgement bookFlightTicket(@RequestBody FlightBookingRequest request){
		return service.bookTickets(request);
	}


	public static void main(String[] args) {
		SpringApplication.run(FlightServiceApplication.class, args);
	}

}
