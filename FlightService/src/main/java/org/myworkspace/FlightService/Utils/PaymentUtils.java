package org.myworkspace.FlightService.Utils;

import org.myworkspace.FlightService.Exception.InsufficientBalanceException;

import java.util.HashMap;
import java.util.Map;

public class PaymentUtils {
    private static Map<String, Double> paymentMap = new HashMap<>(); // a/c No - amount
    static {
        paymentMap.put("acc1", 8000.00);
        paymentMap.put("acc2", 10000.00);
        paymentMap.put("acc3", 4500.00);
        paymentMap.put("acc4", 12000.00);
    }
    public static boolean validateCreditLimit(String accNo, double paidAmount) {
        if(paidAmount > paymentMap.get(accNo)){
            throw new InsufficientBalanceException("payment Failed due to insufficient account balance");
        } else {
            return true;
        }
    }
}
