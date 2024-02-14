/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * And open the template in the editor.
 */
package io.advance.fivecarddraw.enumeration;

/**
 *
 * @author Julien Chepape
 */
public enum SuitType {

	SPADE("\u2660"), HEART("\u2663"), DIAMOND("\u2666"), CLUB("\u2663");

	private final String suit;

	private SuitType(String suit) {
		this.suit = suit;
	}

	@Override
	public String toString() {
		return this.suit;
	}
}
