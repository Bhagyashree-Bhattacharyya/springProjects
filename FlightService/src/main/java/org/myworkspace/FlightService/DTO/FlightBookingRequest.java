package org.myworkspace.FlightService.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.myworkspace.FlightService.Entity.PassengerInfo;
import org.myworkspace.FlightService.Entity.PaymentInfo;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightBookingRequest {
    private PassengerInfo passengerInfo;
    private PaymentInfo paymentInfo;
}
