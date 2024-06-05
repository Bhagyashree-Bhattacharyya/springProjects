package org.myworkspace.FlightService.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "payment_info")
public class PaymentInfo {

    @Id
    @GeneratedValue(generator = "uuid2")
    @UuidGenerator
    private String paymentId;
    private String accountNo;
    private double amount;
    private String cardType;
    private long passengerId;
}
