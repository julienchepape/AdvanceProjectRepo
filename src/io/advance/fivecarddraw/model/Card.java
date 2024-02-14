/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * And open the template in the editor.
 */
package src.io.advance.fivecarddraw.model;

import java.util.HashMap;
import java.util.Map;

import src.io.advance.fivecarddraw.enumeration.SuitType;

/**
 *
 * @author Julien Chepape
 */
public class Card implements Comparable<Card> {

	private SuitType suitType;
	private int rank;
	private static final Map<Integer, String> faceMap = new HashMap<>();

	public Card(SuitType suit, int rank) {
		if (suit == null) {
			throw new IllegalArgumentException("Suit is null");
		}
		if (rank < 1 || rank > 13) {
			throw new IllegalArgumentException(String.format("Rank %d is not a valid rank of 1 through 13", rank));
		}
		this.suitType = suit;
		this.rank = rank;
	}

	static {
		faceMap.put(1, "A"); // Ace played as low. example A-D 2-D 3-D 4-D 5-D
		faceMap.put(11, "J"); // Jack
		faceMap.put(12, "Q"); // Queen
		faceMap.put(13, "K"); // King
		faceMap.put(14, "A"); // Ace played as high. example 10-D J-D Q-D K-D A-D
	}

	public SuitType suit() {
		return suitType;
	}

	public int getRank() {
		return rank;
	}

	public boolean isAceRankLow() {
		return rank == 1;
	}

	public boolean isAceRankHigh() {
		return rank == 14;
	}

	public boolean isAce() {
		return isAceRankLow() || isAceRankHigh();
	}

	public void swapTheRankOfHowAceIsPlayed() {
		if (isAceRankLow()) {
			rank = 14;
		} else {
			rank = 1;
		}
	}

	@Override
	public String toString() {
		String face = String.valueOf(rank);
		if (faceMap.containsKey(rank)) {
			face = faceMap.get(rank);
		}
		return face + "-" + suitType;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (null == obj)
			return false;
		if (!(obj instanceof Card)) {
			return false;
		} else {
			Card other = (Card) obj;
			return other.suitType == this.suitType && other.rank == this.rank;
		}
	}

	@Override
	public int compareTo(Card card) {
		final int BEFORE = -1;
		final int EQUAL = 0;
		final int AFTER = 1;
		if (card.rank == rank)
			return EQUAL;
		if (card.rank < rank) {
			return AFTER;
		} else {
			return BEFORE;
		}
	}

}
