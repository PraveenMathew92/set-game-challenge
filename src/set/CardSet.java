package set;

import card.Card;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class CardSet {
    private static final int NUMBER_OF_CARDS_IF_NO_OVERLAP = 6;
    private final Collection<Card> cards;

    public CardSet(Card cardOne, Card cardTwo, Card cardThree) {
        cards = Set.of(cardOne, cardTwo, cardThree);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CardSet cardSet = (CardSet) o;

        return cards.equals(cardSet.cards);
    }

    @Override
    public int hashCode() {
        return cards.hashCode();
    }

    public boolean overlaps(CardSet cardSetTwo) {
        Collection<Card> cardsUnion = new HashSet<>();
        cardsUnion.addAll(this.cards);
        cardsUnion.addAll(cardSetTwo.cards);
        return cardsUnion.size() != NUMBER_OF_CARDS_IF_NO_OVERLAP;
    }

    @Override
    public String toString() {
        String cardSet = "";
        for(Card card: cards.toArray(new Card[0])) {
            cardSet += card + "\n";
        }
        return cardSet;
    }
}
