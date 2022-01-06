package set;

import card.*;
import card.Number;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardSetMakerTest {
    @Test
    void shouldNotCreateSetComplementCardAbsent() {
        Card card = new Card(Color.BLUE, Number.THREE, Symbol.A, Shading.LOWER);
        Card anotherCard = new Card(Color.BLUE, Number.THREE, Symbol.A, Shading.UPPER);
        Card complementCard = new Card(Color.YELLOW, Number.THREE, Symbol.A, Shading.SYMBOL);

        CardSetMaker setComputer = new CardSetMaker();
        setComputer.add(card);
        setComputer.add(anotherCard);
        setComputer.add(complementCard);

        assertEquals(Set.of(), setComputer.make());
    }

    @Test
    void shouldCreateSetComplementCardPresent() {
        Card card = new Card(Color.BLUE, Number.THREE, Symbol.A, Shading.LOWER);
        Card anotherCard = new Card(Color.BLUE, Number.THREE, Symbol.A, Shading.UPPER);
        Card complementCard = new Card(Color.BLUE, Number.THREE, Symbol.A, Shading.SYMBOL);

        CardSetMaker cardSetMaker = new CardSetMaker();
        cardSetMaker.add(card);
        cardSetMaker.add(anotherCard);
        cardSetMaker.add(complementCard);

        Set<CardSet> expectedCardSet = Set.of(new CardSet(card, anotherCard, complementCard));
        assertEquals(expectedCardSet, cardSetMaker.make());
    }

    @Test
    void shouldCreateMultipleSet() {
        Card card = new Card(Color.BLUE, Number.THREE, Symbol.A, Shading.LOWER);
        Card anotherCard = new Card(Color.BLUE, Number.THREE, Symbol.A, Shading.UPPER);
        Card thirdCard = new Card(Color.BLUE, Number.THREE, Symbol.A, Shading.SYMBOL);
        Card fourthCard = new Card(Color.BLUE, Number.ONE, Symbol.A, Shading.SYMBOL);
        Card fifthCard = new Card(Color.BLUE, Number.TWO, Symbol.A, Shading.SYMBOL);

        CardSetMaker cardSetMaker = new CardSetMaker();
        cardSetMaker.add(card);
        cardSetMaker.add(anotherCard);
        cardSetMaker.add(thirdCard);
        cardSetMaker.add(fourthCard);
        cardSetMaker.add(fifthCard);

        Set<CardSet> expectedCardSets = Set.of(new CardSet(card, anotherCard, thirdCard),
                new CardSet(fourthCard, fifthCard, thirdCard));
        assertEquals(expectedCardSets, cardSetMaker.make());
    }
}
