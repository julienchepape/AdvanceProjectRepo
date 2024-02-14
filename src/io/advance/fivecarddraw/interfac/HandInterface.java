package src.io.advance.fivecarddraw.interfac;

import java.util.List;

import src.io.advance.fivecarddraw.enumeration.HandStrengthRank;
import src.io.advance.fivecarddraw.model.Card;
import src.io.advance.fivecarddraw.model.Hand;

public interface HandInterface {
	
	List<Card> dealHand(int numberOfCards, List<Card> cardList);
	
	HandStrengthRank evaluateHand(Hand hand);

}
