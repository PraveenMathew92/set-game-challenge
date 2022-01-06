package card;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardTest {
    @Test
    void shouldGetCardHashesForTwoCardsWithOneDifferentAttribute() {
        Card card = new Card(Color.BLUE, Number.THREE, Symbol.A, Shading.LOWER);
        Card anotherCard = new Card(Color.BLUE, Number.THREE, Symbol.A, Shading.UPPER);

        int expectedCardHash = new Card(Color.BLUE, Number.THREE, Symbol.A, Shading.SYMBOL)
                .hashCode();
        assertEquals(expectedCardHash, Card.computeComplementaryCardHash(card, anotherCard));
    }

    @Test
    void shouldGetCardHashesForTwoCardsWithTwoDifferentAttribute() {
        Card card = new Card(Color.BLUE, Number.THREE, Symbol.A, Shading.LOWER);
        Card anotherCard = new Card(Color.BLUE, Number.THREE, Symbol.S, Shading.UPPER);

        int expectedCardHash = new Card(Color.BLUE, Number.THREE, Symbol.H, Shading.SYMBOL)
                .hashCode();
        assertEquals(expectedCardHash, Card.computeComplementaryCardHash(card, anotherCard));
    }

    @Test
    void shouldGetCardHashesForTwoCardsWithThreeDifferentAttribute() {
        Card card = new Card(Color.BLUE, Number.THREE, Symbol.A, Shading.LOWER);
        Card anotherCard = new Card(Color.BLUE, Number.ONE, Symbol.S, Shading.UPPER);

        int expectedCardHash = new Card(Color.BLUE, Number.TWO, Symbol.H, Shading.SYMBOL)
                .hashCode();
        assertEquals(expectedCardHash, Card.computeComplementaryCardHash(card, anotherCard));
    }

    @Test
    void shouldGetCardHashesForTwoCardsWithFourDifferentAttribute() {
        Card card = new Card(Color.GREEN, Number.THREE, Symbol.A, Shading.LOWER);
        Card anotherCard = new Card(Color.BLUE, Number.ONE, Symbol.S, Shading.UPPER);

        int expectedCardHash = new Card(Color.YELLOW, Number.TWO, Symbol.H, Shading.SYMBOL)
                .hashCode();
        assertEquals(expectedCardHash, Card.computeComplementaryCardHash(card, anotherCard));
    }
}
