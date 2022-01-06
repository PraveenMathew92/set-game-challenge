package card;

public enum Symbol {
    A('@'),
    S('$'),
    H('#');

    public final char symbolCharacter;

    Symbol(char symbolCharacter) {
        this.symbolCharacter = symbolCharacter;
    }
}
