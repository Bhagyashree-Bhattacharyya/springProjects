package org.myworkspace.FlightService.Service;

import jakarta.transaction.Transactional;
import org.myworkspace.FlightService.DTO.FlightBookingAcknowledgement;
import org.myworkspace.FlightService.DTO.FlightBookingRequest;
import org.myworkspace.FlightService.Entity.PassengerInfo;
import org.myworkspace.FlightService.Entity.PaymentInfo;
import org.myworkspace.FlightService.Repo.PassengerInfoRepository;
import org.myworkspace.FlightService.Repo.PaymentInfoRepository;
import org.myworkspace.FlightService.Utils.PaymentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;

import java.util.UUID;

@Service
public class FlightBookingService {

    @Autowired
    private PaymentInfoRepository paymentInfoRepository;
    @Autowired
    private PassengerInfoRepository passengerInfoRepository;

    @Transactional//(readOnly=false, isolation= Isolation.READ_COMMITTED, propagation= Propagation.REQUIRED)
    public FlightBookingAcknowledgement bookTickets(FlightBookingRequest request){

        PassengerInfo passengerInfo = request.getPassengerInfo();
        passengerInfo = passengerInfoRepository.save(passengerInfo);

        PaymentInfo paymentInfo = request.getPaymentInfo();
        PaymentUtils.validateCreditLimit(paymentInfo.getAccountNo(), passengerInfo.getFare());
        paymentInfo.setPassengerId(passengerInfo.getPassengerId());
        paymentInfo.setAmount(passengerInfo.getFare());
        paymentInfoRepository.save(paymentInfo);

        return new FlightBookingAcknowledgement("Success", passengerInfo.getFare(), UUID.randomUUID().toString().split("-")[0], passengerInfo);
    }
}
