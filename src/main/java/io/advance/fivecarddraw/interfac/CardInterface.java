package io.advance.fivecarddraw.interfac;

import java.util.List;

import io.advance.fivecarddraw.model.Card;


public interface CardInterface {

	List<Card> create52Cards();

	void shuffleCards(List<Card> cardList);

}
