package org.example.parking_lot_april2026.models;

public class Payment extends BaseModel {
    private PaymentMode paymentMode;
    private PaymentStatus paymentStatus;
    private Double amount;
    private String thirdPartyReferenceId;

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getThirdPartyReferenceId() {
        return thirdPartyReferenceId;
    }

    public void setThirdPartyReferenceId(String thirdPartyReferenceId) {
        this.thirdPartyReferenceId = thirdPartyReferenceId;
    }
}
