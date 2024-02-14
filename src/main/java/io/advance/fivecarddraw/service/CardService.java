package io.advance.fivecarddraw.service;

import java.util.List;

import io.advance.fivecarddraw.interfaceImplentation.CardImpl;
import io.advance.fivecarddraw.model.Card;


public class CardService {

	private CardImpl cardCardImpl = new CardImpl();

	public List<Card> create52Cards() {

		return cardCardImpl.create52Cards();

	}

	public void shuffleCards(List<Card> cardList) {

		cardCardImpl.shuffleCards(cardList);

	}

}
