package set;

import card.Card;

import java.util.Set;

public class CardSet {
    private Set<Card> cards;

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
}
