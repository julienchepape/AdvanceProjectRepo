package src.io.advance.fivecarddraw.service;

import java.util.List;

import src.io.advance.fivecarddraw.enumeration.HandStrengthRank;

import src.io.advance.fivecarddraw.interfaceImplentation.HandImpl;
import src.io.advance.fivecarddraw.model.Card;
import src.io.advance.fivecarddraw.model.Hand;

public class HandService {

	private HandImpl handImpl = new HandImpl();

	public List<Card> dealHand(int numberOfCards, List<Card> cardList) {

		return handImpl.dealHand(numberOfCards, cardList);
	}

	public HandStrengthRank evaluateHand(Hand hand) {

		return handImpl.evaluateHand(hand);
	}

}
