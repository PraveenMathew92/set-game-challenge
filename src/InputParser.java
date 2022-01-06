import card.*;
import card.Number;

import java.util.Map;

public class InputParser {
    private static final Number[] NUMBER_VALUES = Number.values();
    private static final Map<Character, Symbol> symbolLookup = Map.of('@', Symbol.A,
            '#', Symbol.H,
            '$', Symbol.S);

    private static Shading parserShading(char firstChar) {
        if(Character.isLowerCase(firstChar)) {
            return Shading.LOWER;
        } else if(Character.isUpperCase(firstChar)) {
            return Shading.UPPER;
        }
        return Shading.SYMBOL;
    }

    private static Symbol parseSymbol(char firstChar) {
        Symbol symbol = symbolLookup.get(firstChar);
        if(symbol == null) {
            String symbolValue = Character.toString(firstChar).toUpperCase();
            return Symbol.valueOf(symbolValue);
        }
        return symbol;
    }

    public static Card parse(String input) {
        String[] inputStrings= input.split(" ");
        String colorString = inputStrings[0];
        char firstChar = inputStrings[1].charAt(0);

        Color color = Color.valueOf(colorString.toUpperCase());
        Number number = NUMBER_VALUES[inputStrings[1].length() - 1];
        Symbol symbol = parseSymbol(firstChar);
        Shading shading = parserShading(firstChar);
        return new Card(color, number, symbol, shading);
    }
}
