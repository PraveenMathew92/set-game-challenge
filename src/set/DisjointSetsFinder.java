package set;

import java.util.*;

public class DisjointSetsFinder {
    public static final int START_INDEX = 0;
    private final Collection<CardSet> cardSets;
    private final boolean[][] adjacencyMatrix;
    private final int n;

    public DisjointSetsFinder(Collection<CardSet> cardSets) {
        this.cardSets = cardSets;
        this.n = cardSets.size();
        adjacencyMatrix = new boolean[n][n];
    }

    public Collection<CardSet> find() {
        if(cardSets == null || cardSets.size() == 0)
            return Set.of();

        CardSet[] cardSetsArray = cardSets.toArray(new CardSet[0]);
        buildCardSetGraph(cardSetsArray);

        return computeMaximalIndependentSet(cardSetsArray, START_INDEX, new HashSet<>());
    }

    private void buildCardSetGraph(CardSet[] cardSetsArray) {
        for(int i = 0; i < n - 1; i++) {
            for(int j = i + 1; j < n; j++) {
                if(!cardSetsArray[i].overlaps(cardSetsArray[j])) {
                    continue;
                }
                adjacencyMatrix[i][j] = true;
            }
        }
    }

    private Collection<CardSet> computeMaximalIndependentSet(CardSet[] cardSetsArray, int i, Collection<CardSet> visited) {
        if(i == n) {
            return new HashSet<>();
        }
        if(visited.contains(cardSetsArray[i])) {
            return computeMaximalIndependentSet(cardSetsArray, i + 1, visited);
        }
        CardSet currentCard = cardSetsArray[i];
        Collection<CardSet> cardSetsWithoutCurrentCard = computeMaximalIndependentSet(cardSetsArray, i + 1, visited);

        Collection<CardSet> neighbours = getNeighbours(i, cardSetsArray);
        Collection<CardSet> nextVisited = new HashSet<>();
        nextVisited.addAll(visited);
        nextVisited.addAll(neighbours);
        Collection<CardSet> cardSetsWithCurrentCard = computeMaximalIndependentSet(cardSetsArray, i + 1, nextVisited);

        if(cardSetsWithCurrentCard.size() + 1 < cardSetsWithoutCurrentCard.size()) {
            return cardSetsWithoutCurrentCard;
        }
        cardSetsWithCurrentCard.add(currentCard);
        return cardSetsWithCurrentCard;
    }

    private Collection<CardSet> getNeighbours(int index, CardSet[] cardSets) {
        Collection<CardSet> neighbours = new HashSet<>();
        for(int i = 0; i < index; i++) {
            if(adjacencyMatrix[i][index]) {
                neighbours.add(cardSets[i]);
            }
        }
        for(int i = index + 1; i < n; i++) {
            if(adjacencyMatrix[index][i]) {
                neighbours.add(cardSets[i]);
            }
        }
        return neighbours;
    }
}
