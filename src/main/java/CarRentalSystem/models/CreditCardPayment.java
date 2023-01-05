package CarRentalSystem.models;

import CarRentalSystem.models.enums.PaymentType;

public class CreditCardPayment extends Payment{
    String cardNumber;

    public CreditCardPayment() {
        paymentType = PaymentType.CREDIT_CARD;
    }
}
