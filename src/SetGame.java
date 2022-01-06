import set.CardSet;
import set.CardSetMaker;
import set.DisjointSetsFinder;

import java.util.Collection;
import java.util.Scanner;

public class SetGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CardSetMaker cardSetMaker = new CardSetMaker();

        int n = scanner.nextInt();
        scanner.nextLine();

        for(int i = 0 ; i < n; i++) {
            String cardString = scanner.nextLine();
            cardSetMaker.add(InputParser.parse(cardString));
        }

        Collection<CardSet> cardSets = cardSetMaker.make();
        System.out.println(cardSets.size());

        DisjointSetsFinder disjointSetsFinder = new DisjointSetsFinder(cardSets);
        Collection<CardSet> disjointCardSets = disjointSetsFinder.find();

        System.out.println(disjointCardSets.size());

        disjointCardSets.forEach(cardSet -> System.out.println(cardSet.toString()));

    }
}
