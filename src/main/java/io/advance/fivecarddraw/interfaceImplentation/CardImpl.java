package io.advance.fivecarddraw.interfaceImplentation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import io.advance.fivecarddraw.enumeration.SuitType;
import io.advance.fivecarddraw.interfac.CardInterface;
import io.advance.fivecarddraw.model.Card;


public class CardImpl implements CardInterface {

	@Override
	public List<Card> create52Cards() {
		List<Card> cardList = new ArrayList<>();
		for (SuitType suit : SuitType.values()) {
			for (int rank = 1; rank < 14; rank++) {
				Card card = new Card(suit, rank);
				cardList.add(card);
			}
		}
		return cardList;
	}

	@Override
	public void shuffleCards(List<Card> cardList) {
		
			Collections.shuffle(cardList);

		
	}



	

}
