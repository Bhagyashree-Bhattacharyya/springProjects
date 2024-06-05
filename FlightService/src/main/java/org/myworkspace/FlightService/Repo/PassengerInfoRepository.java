package org.myworkspace.FlightService.Repo;

import org.myworkspace.FlightService.Entity.PassengerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerInfoRepository extends JpaRepository<PassengerInfo, Long> {
}
