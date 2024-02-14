package src.io.advance.fivecarddraw.runner;

import java.util.List;

import src.io.advance.fivecarddraw.enumeration.HandStrengthRank;
import src.io.advance.fivecarddraw.model.Card;
import src.io.advance.fivecarddraw.model.Hand;
import src.io.advance.fivecarddraw.service.CardService;
import src.io.advance.fivecarddraw.service.HandService;

public class FiveCardDrawRunner {

	public static void main(String[] args) {
		CardService cardService = new CardService();
		HandService handService = new HandService();
		// create 52 cards
		List<Card> cardList = cardService.create52Cards();

		System.out.println("Shuffling... Shuffling... Shuffling... \n");
		// shuffle the cards
		cardService.shuffleCards(cardList);

		// Deal a single hand of 5 cards to the player.
		List<Card> ListOfSpecifiedCards = handService.dealHand(5, cardList);

		Hand hand = new Hand(ListOfSpecifiedCards);
		System.out.println("Your hand: \n" + hand);
		// evaluate hand
		HandStrengthRank handStrengthRank = handService.evaluateHand(hand);

		System.out.println("Your hand: \n" + handStrengthRank);

	}
}
