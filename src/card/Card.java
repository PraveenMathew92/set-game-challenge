package card;

public class Card {
    private final Color color;
    private final Number number;
    private final Symbol symbol;
    private final Shading shading;

    @Override
    public String toString() {
        String colorString = color.name().toLowerCase();
        char firstChar;
        if(shading == Shading.SYMBOL) {
            firstChar = symbol.symbolCharacter;
        } else if(shading == Shading.LOWER) {
            firstChar = Character.toLowerCase(symbol.name().charAt(0));
        } else {
            firstChar = symbol.name().charAt(0);
        }

        return colorString + " " + String.valueOf(firstChar)
                .repeat(number.ordinal() + 1);
    }

    public Card(Color color, Number number, Symbol symbol, Shading shading) {
        this.color = color;
        this.number = number;
        this.symbol = symbol;
        this.shading = shading;
    }

    public static int computeComplementaryCardHash(Card card, Card anotherCard) {
        int complementaryCardHash = 0;

        if(card.color == anotherCard.color) {
            complementaryCardHash += card.color.ordinal();
        } else {
            complementaryCardHash += 3 - (card.color.ordinal() + anotherCard.color.ordinal());
        }

        complementaryCardHash *= 3;
        if(card.number == anotherCard.number) {
            complementaryCardHash += card.number.ordinal();
        } else {
            complementaryCardHash += 3 - (card.number.ordinal() + anotherCard.number.ordinal());
        }

        complementaryCardHash *= 3;
        if(card.symbol == anotherCard.symbol) {
            complementaryCardHash += card.symbol.ordinal();
        } else {
            complementaryCardHash += 3 - (card.symbol.ordinal() + anotherCard.symbol.ordinal());
        }

        complementaryCardHash *= 3;
        if(card.shading == anotherCard.shading) {
            complementaryCardHash += card.shading.ordinal();
        } else {
            complementaryCardHash += 3 - (card.shading.ordinal() + anotherCard.shading.ordinal());
        }
        return complementaryCardHash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        if (color != card.color) return false;
        if (number != card.number) return false;
        if (symbol != card.symbol) return false;
        return shading == card.shading;
    }

    @Override
    public int hashCode() {
        int result = color.ordinal();
        result = 3 * result + number.ordinal();
        result = 3 * result + symbol.ordinal();
        result = 3 * result + shading.ordinal();
        return result;
    }

}
