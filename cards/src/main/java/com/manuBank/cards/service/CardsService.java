package com.manuBank.cards.service;

public interface CardsService {

    public void createCard(String mobileNumber);
    public void fetchCardDetails();
    public void updateCardDetails();
    public void deleteCard();
}
