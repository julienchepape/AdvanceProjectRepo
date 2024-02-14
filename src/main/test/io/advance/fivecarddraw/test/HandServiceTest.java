package io.advance.fivecarddraw.test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import io.advance.fivecarddraw.enumeration.HandStrengthRank;
import io.advance.fivecarddraw.model.Card;
import io.advance.fivecarddraw.model.Hand;
import io.advance.fivecarddraw.service.CardService;
import io.advance.fivecarddraw.service.HandService;


public class HandServiceTest {
	
	private HandService handService=new HandService();
	private CardService cardService=new CardService();
	
	@Test
	public void testTealHand() {

		List<Card> cardList = cardService.create52Cards();

		System.out.println("Shuffling... Shuffling... Shuffling... \n");
		// shuffle the cards
		cardService.shuffleCards(cardList);

		// Deal a single hand of 5 cards to the player.
		List<Card> ListOfSpecifiedCards = handService.dealHand(5, cardList);
		int size = ListOfSpecifiedCards.size();
		assertEquals(5, size);

	}
	@Test
	public void testEvaluateHand() {

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
		
		assertNotNull(handStrengthRank);
	}

}
