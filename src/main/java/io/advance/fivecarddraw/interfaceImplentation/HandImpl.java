package io.advance.fivecarddraw.interfaceImplentation;

import java.util.ArrayList;
import java.util.List;

import io.advance.fivecarddraw.enumeration.HandStrengthRank;
import io.advance.fivecarddraw.interfac.HandInterface;
import io.advance.fivecarddraw.model.Card;
import io.advance.fivecarddraw.model.Hand;



public class HandImpl  implements HandInterface {

	@Override
	public List<Card> dealHand(int numberOfCards, List<Card> cardList) {
		List<Card> hand = new ArrayList<>(numberOfCards);
		for (int i = 0; i < numberOfCards; i++) {
			hand.add(cardList.get(0)); // top card
			cardList.remove(0); // top card
		}
		return hand;
	}

	@Override
	public HandStrengthRank evaluateHand(Hand hand) {
		
		
		HandStrengthRank handStrengthRank = HandStrengthRank.NO_MATCH;

		if (hand.isFourOfAKind()) {
			handStrengthRank = HandStrengthRank.FOUR_OF_A_KIND;
		} else if (hand.isFullHouse()) {
			handStrengthRank = HandStrengthRank.FULL_HOUSE;
		} else if (hand.isThreeOfAKind()) {
			handStrengthRank = HandStrengthRank.THREE_OF_A_KIND;
		} else if (hand.isTwoPair()) {
			handStrengthRank = HandStrengthRank.TWO_PAIR;
		} else if (hand.isOnePair()) {
			handStrengthRank = HandStrengthRank.ONE_PAIR;
		} else {
			if (hand.isStraightFlush()) {
				handStrengthRank = HandStrengthRank.STRAIGHT_FLUSH;
			} else if (hand.isFlush()) {
				handStrengthRank = HandStrengthRank.FLUSH;
			} else if (hand.isStraight()) {
				handStrengthRank = HandStrengthRank.STRAIGHT;
			}

			if (hand.hasAces()) {
				for (Card card : hand.getCards()) {
					if (card.isAce()) {
						card.swapTheRankOfHowAceIsPlayed();
					}
				}

				hand.order();

				if (hand.isStraightFlush()) {
					handStrengthRank = HandStrengthRank.STRAIGHT_FLUSH;
				} else if (hand.isStraight()) {
					handStrengthRank = HandStrengthRank.STRAIGHT;
				}
			}
		}

		return handStrengthRank;
	}

	

	
}
