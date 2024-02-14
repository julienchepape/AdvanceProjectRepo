/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * And open the template in the editor.
 */
package src.io.advance.fivecarddraw.enumeration;

/**
 *
 * @author Julien  Chepape
 */
public enum HandStrengthRank {
    STRAIGHT_FLUSH("Straight Flush"),
    FOUR_OF_A_KIND("Four of a Kind"),
    FULL_HOUSE("Full House"),
    FLUSH("Flush"),
    STRAIGHT("Straight"),
    THREE_OF_A_KIND("Three of a Kind"),
    TWO_PAIR("Two Pair"),
    ONE_PAIR("One Pair"),
    HIGH_CARDS("High Cards"),
    NO_MATCH("No match");

	private final String rank;

	HandStrengthRank(String rank) {
		this.rank = rank;
	}

	public String getRank() {
		return this.rank;
	}
}
