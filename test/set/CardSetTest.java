package set;

import card.*;
import card.Number;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardSetTest {
    @Test
    void shouldReturnFalseIfNoCommonCard() {
        Card card = new Card(Color.BLUE, Number.THREE, Symbol.A, Shading.LOWER);
        Card anotherCard = new Card(Color.BLUE, Number.THREE, Symbol.A, Shading.UPPER);
        Card thirdCard = new Card(Color.BLUE, Number.THREE, Symbol.A, Shading.SYMBOL);
        Card fourthCard = new Card(Color.GREEN, Number.ONE, Symbol.A, Shading.SYMBOL);
        Card fifthCard = new Card(Color.GREEN, Number.TWO, Symbol.A, Shading.SYMBOL);
        Card sixthCard = new Card(Color.GREEN, Number.THREE, Symbol.A, Shading.SYMBOL);
        CardSet cardSetOne = new CardSet(card, anotherCard, thirdCard);
        CardSet cardSetTwo = new CardSet(fourthCard, fifthCard, sixthCard);

        assertFalse(cardSetOne.overlaps(cardSetTwo));
    }

    @Test
    void shouldReturnTrueIfCommonCard() {
        Card card = new Card(Color.BLUE, Number.THREE, Symbol.A, Shading.LOWER);
        Card anotherCard = new Card(Color.BLUE, Number.THREE, Symbol.A, Shading.UPPER);
        Card thirdCard = new Card(Color.BLUE, Number.THREE, Symbol.A, Shading.SYMBOL);
        Card fourthCard = new Card(Color.GREEN, Number.ONE, Symbol.A, Shading.SYMBOL);
        Card fifthCard = new Card(Color.GREEN, Number.TWO, Symbol.A, Shading.SYMBOL);
        CardSet cardSetOne = new CardSet(card, anotherCard, thirdCard);
        CardSet cardSetTwo = new CardSet(fourthCard, fifthCard, thirdCard);

        assertTrue(cardSetOne.overlaps(cardSetTwo));
    }

}