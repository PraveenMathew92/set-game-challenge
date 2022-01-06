package set;

import card.Card;
import java.util.Collection;
import java.util.HashSet;

public class CardSetMaker {
    public static final int MAXIMUM_POSSIBLE_NUMBER_OF_CARDS = 81;
    private final Card[] cardLookupTable = new Card [MAXIMUM_POSSIBLE_NUMBER_OF_CARDS];
    private final Collection<Card> cards = new HashSet<>();

    public void add(Card card) {
        int cardHash = card.hashCode();
        cardLookupTable[cardHash] = card;
        cards.add(card);
    }

    public Collection<CardSet> make() {
        Card[] cardsArray = cards.toArray(new Card[0]); // faster to get by index when using arrays

        Collection<CardSet> cardSets = new HashSet<>();
        for(int i = 0; i < cardsArray.length - 1; i++) {
            Card cardOne = cardsArray[i];
            cardLookupTable[cardOne.hashCode()] = null; // once the card has been evaluated as the CARD ONE, it no longer be considered in later iterations
            addCardSetsWithCardOne(cardOne, i, cardsArray, cardSets);
        }

        return cardSets;
    }

    private void addCardSetsWithCardOne(Card cardOne, int cardOneIndex, Card[] cardsArray,
                                        Collection<CardSet> cardSets) { // passing cardSets to skip the step of adding the cardset with CARD ONE to the final cardset
        for(int j = cardOneIndex + 1; j < cardsArray.length; j++) {
            Card cardTwo = cardsArray[j];
            Card complementCard = getComplementCard(cardOne, cardTwo);
            if(complementCard == null) {
                continue;
            }
            cardSets.add(new CardSet(cardOne, cardTwo, complementCard));
        }
    }

    private Card getComplementCard(Card cardOne, Card cardTwo) {
        int complementCardHash = Card.computeComplementaryCardHash(cardOne, cardTwo);
        return cardLookupTable[complementCardHash];
    }
}
