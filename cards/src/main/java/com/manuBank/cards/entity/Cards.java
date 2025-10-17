package com.manuBank.cards.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.stereotype.Component;

import java.util.Date;

@Entity
@Component
public class Cards extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cardId;
    private String cardNumber;
    private String cardType;
    private String cardNetwork;
    private String mobileNumber;
    private Integer cvv;
    private Date expiryDate;
    private Integer totalLimit;
    private Integer usedAmount;
    private Integer availableLimit;

    public Cards(Long cardId, String cardNumber, String cardType, String cardNetwork, String mobileNumber, Integer cvv, Date expiryDate, Integer totalLimit, Integer usedAmount, Integer availableLimit) {
        this.cardId = cardId;
        this.cardNumber = cardNumber;
        this.cardType = cardType;
        this.cardNetwork = cardNetwork;
        this.mobileNumber = mobileNumber;
        this.cvv = cvv;
        this.expiryDate = expiryDate;
        this.totalLimit = totalLimit;
        this.usedAmount = usedAmount;
        this.availableLimit = availableLimit;
    }

    public Cards() {
    }

    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
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

    public String getCardNetwork() {
        return cardNetwork;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public void setCardNetwork(String cardNetwork) {
        this.cardNetwork = cardNetwork;
    }

    public Integer getCvv() {
        return cvv;
    }

    public void setCvv(Integer cvv) {
        this.cvv = cvv;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
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
        return "Cards{" +
                "cardId=" + cardId +
                ", cardNumber='" + cardNumber + '\'' +
                ", cardType='" + cardType + '\'' +
                ", cardNetwork='" + cardNetwork + '\'' +
                ", cvv=" + cvv +
                ", expiryDate=" + expiryDate +
                ", totalLimit=" + totalLimit +
                ", usedAmount=" + usedAmount +
                ", availableLimit=" + availableLimit +
                '}';
    }
}
