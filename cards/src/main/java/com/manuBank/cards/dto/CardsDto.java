package com.manuBank.cards.dto;

public class CardsDto {

    private String cardNumber;
    private String cardType;
    private String mobileNumber;
    private String cardNetworkType;
    private Integer cvv;
    private Integer totalLimit;
    private Integer usedAmount;
    private Integer availableLimit;

    public CardsDto() {
    }

    public CardsDto(String cardNumber, String cardType, String mobileNumber, String cardNetworkType, Integer cvv, Integer totalLimit, Integer usedAmount, Integer availableLimit) {
        this.cardNumber = cardNumber;
        this.cardType = cardType;
        this.mobileNumber = mobileNumber;
        this.cardNetworkType = cardNetworkType;
        this.cvv = cvv;
        this.totalLimit = totalLimit;
        this.usedAmount = usedAmount;
        this.availableLimit = availableLimit;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getCardNetworkType() {
        return cardNetworkType;
    }

    public void setCardNetworkType(String cardNetworkType) {
        this.cardNetworkType = cardNetworkType;
    }

    public Integer getCvv() {
        return cvv;
    }

    public void setCvv(Integer cvv) {
        this.cvv = cvv;
    }

    public Integer getTotalLimit() {
        return totalLimit;
    }

    public void setTotalLimit(Integer totalLimit) {
        this.totalLimit = totalLimit;
    }

    public Integer getUsedAmount() {
        return usedAmount;
    }

    public void setUsedAmount(Integer usedAmount) {
        this.usedAmount = usedAmount;
    }

    public Integer getAvailableLimit() {
        return availableLimit;
    }

    public void setAvailableLimit(Integer availableLimit) {
        this.availableLimit = availableLimit;
    }

    @Override
    public String toString() {
        return "CardsDto{" +
                "cardNumber='" + cardNumber + '\'' +
                ", cardType='" + cardType + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", cardNetworkType='" + cardNetworkType + '\'' +
                ", cvv=" + cvv +
                ", totalLimit=" + totalLimit +
                ", usedAmount=" + usedAmount +
                ", availableLimit=" + availableLimit +
                '}';
    }
}
