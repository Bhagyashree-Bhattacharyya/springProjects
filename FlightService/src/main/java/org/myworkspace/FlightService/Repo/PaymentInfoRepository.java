package org.myworkspace.FlightService.Repo;

import org.myworkspace.FlightService.Entity.PaymentInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentInfoRepository extends JpaRepository<PaymentInfo, String> {
}
