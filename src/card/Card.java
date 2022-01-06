package card;

public class Card {
    private Color color;
    private Number number;
    private Symbol symbol;
    private Shading shading;

    public Card(Color color, Number number, Symbol symbol, Shading shading) {
        this.color = color;
        this.number = number;
        this.symbol = symbol;
        this.shading = shading;
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
        int result = color.hashCode();
        result = 31 * result + number.hashCode();
        result = 31 * result + symbol.hashCode();
        result = 31 * result + shading.hashCode();
        return result;
    }

}
