package set;

import card.*;
import card.Number;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class DisjointSetsFinderTest {
    @Test
    void shouldReturnEmptySetIfNoCardSets() {
        Collection<CardSet> cardSets = Set.of();
        DisjointSetsFinder disjointSetsFinder = new DisjointSetsFinder(cardSets);
        assertEquals(Set.of(), disjointSetsFinder.find());
    }

    @Test
    void shouldReturnCardSetIfOnlyOneCardSets() {
        Card card = new Card(Color.BLUE, Number.THREE, Symbol.A, Shading.LOWER);
        Card anotherCard = new Card(Color.BLUE, Number.THREE, Symbol.A, Shading.UPPER);
        Card complementCard = new Card(Color.BLUE, Number.THREE, Symbol.A, Shading.SYMBOL);
        Collection<CardSet> cardSets = Set.of(new CardSet(card, anotherCard, complementCard));

        DisjointSetsFinder disjointSetsFinder = new DisjointSetsFinder(cardSets);
        assertEquals(cardSets, disjointSetsFinder.find());
    }

    @Test
    void shouldReturnOneCardSetIfTwoOverlappingCardSets() {
        Card card = new Card(Color.BLUE, Number.THREE, Symbol.A, Shading.LOWER);
        Card anotherCard = new Card(Color.BLUE, Number.THREE, Symbol.A, Shading.UPPER);
        Card thirdCard = new Card(Color.BLUE, Number.THREE, Symbol.A, Shading.SYMBOL);
        Card fourthCard = new Card(Color.BLUE, Number.ONE, Symbol.A, Shading.SYMBOL);
        Card fifthCard = new Card(Color.BLUE, Number.TWO, Symbol.A, Shading.SYMBOL);

        CardSet cardSet = new CardSet(card, anotherCard, thirdCard);
        CardSet overlappingCardSet = new CardSet(fourthCard, fifthCard, thirdCard);
        Set<CardSet> cardSets = Set.of(cardSet,
                overlappingCardSet);
        DisjointSetsFinder disjointSetsFinder = new DisjointSetsFinder(cardSets);

        Collection<CardSet> disjointSet = disjointSetsFinder.find();
        boolean isOneOfCardSets = disjointSet.size() == 1 && cardSets.containsAll(disjointSet);
        assertTrue(isOneOfCardSets);
    }

    @Test
    void shouldReturnMaximumDisjointSet() {
        Card card = new Card(Color.BLUE, Number.THREE, Symbol.A, Shading.LOWER);
        Card anotherCard = new Card(Color.BLUE, Number.THREE, Symbol.A, Shading.UPPER);
        Card thirdCard = new Card(Color.BLUE, Number.THREE, Symbol.A, Shading.SYMBOL);
        Card fourthCard = new Card(Color.BLUE, Number.ONE, Symbol.A, Shading.SYMBOL);
        Card fifthCard = new Card(Color.BLUE, Number.TWO, Symbol.A, Shading.SYMBOL);
        Card sixthCard = new Card(Color.GREEN, Number.THREE, Symbol.A, Shading.SYMBOL);
        Card seventhCard = new Card(Color.YELLOW, Number.THREE, Symbol.A, Shading.SYMBOL);

        CardSet cardSet = new CardSet(card, anotherCard, thirdCard);
        CardSet overlappingCardSet = new CardSet(fourthCard, fifthCard, thirdCard);
        CardSet disjointCardSet = new CardSet(fifthCard, sixthCard, seventhCard);
        Set<CardSet> cardSets = Set.of(cardSet, overlappingCardSet, disjointCardSet);
        DisjointSetsFinder disjointSetsFinder = new DisjointSetsFinder(cardSets);

        Collection<CardSet> disjointSet = disjointSetsFinder.find();
        assertEquals(Set.of(cardSet, disjointCardSet), disjointSet);
    }
}