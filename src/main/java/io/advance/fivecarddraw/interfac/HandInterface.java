package io.advance.fivecarddraw.interfac;

import java.util.List;

import io.advance.fivecarddraw.enumeration.HandStrengthRank;
import io.advance.fivecarddraw.model.Card;
import io.advance.fivecarddraw.model.Hand;



public interface HandInterface {

	List<Card> dealHand(int numberOfCards, List<Card> cardList);

	HandStrengthRank evaluateHand(Hand hand);

}
