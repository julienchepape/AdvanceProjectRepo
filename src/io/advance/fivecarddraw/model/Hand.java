/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * And open the template in the editor.
 */
package src.io.advance.fivecarddraw.model;

import java.util.Collections;
import java.util.List;
import static java.util.stream.Collectors.joining;
import java.util.stream.IntStream;

/**
 *
 * @author Julien Chepape
 */
public class Hand {
	private List<Card> cards;
	private int[] kinds = new int[14];

	public List<Card> getCards() {
		return this.cards;
	}

	public Hand(List<Card> cards) {
		this.cards = cards;
		order();
		howManyOfAKind();
	}

	public boolean hasAces() {
		return cards.stream().anyMatch(Card::isAce);
	}

	/**
	 * All cards have the same suit (as the first card)
	 */
	public boolean isFlush() {
		return cards.stream().allMatch(card -> card.suit() == cards.get(0).suit());
	}

	public boolean isStraight() {
		for (int i = 0; i < cards.size() - 1; i++) {
			if (cards.get(i + 1).getRank() != cards.get(i).getRank() + 1) {
				return false;
			}
		}
		return true;
	}

	public boolean isStraightFlush() {
		return isStraight() && isFlush();
	}

	private void howManyOfAKind() {
		cards.stream().forEach(card -> kinds[card.getRank()] += 1);
	}

	private boolean isOfAKind(int nOfAKind) {
		return IntStream.range(0, kinds.length).anyMatch(i -> kinds[i] == nOfAKind);
	}

	private int pairCount() {
		int pairCount = 0;
		for (int i = 0; i < kinds.length; i++) {
			if (kinds[i] == 2) {
				pairCount++;
			}
		}
		return pairCount;
	}

	public boolean isFourOfAKind() {
		return isOfAKind(4);
	}

	public boolean isThreeOfAKind() {
		return isOfAKind(3);
	}

	public boolean isFullHouse() {
		return isOfAKind(3) && pairCount() == 1;
	}

	public boolean isTwoPair() {
		return pairCount() == 2;
	}

	public boolean isOnePair() {
		return pairCount() == 1;
	}

	public void order() {
		Collections.sort(cards);
	}

	@Override
	public String toString() {
		return cards.stream().map(Card::toString).collect(joining(" "));
	}
}
