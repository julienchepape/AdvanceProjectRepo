package io.advance.fivecarddraw.test;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import io.advance.fivecarddraw.model.Card;
import io.advance.fivecarddraw.service.CardService;

public class CardServiceTest {
	
	private CardService cardService = new CardService();

	@Test
	public void testCreate52Cards() {

		List<Card> cardList = cardService.create52Cards();
		assertNotNull(cardList);

	}

}
