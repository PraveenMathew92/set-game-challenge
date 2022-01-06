import card.*;
import card.Number;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InputParserTest {
    @Test
    void shouldReadCardFromInput() {
        Card card = InputParser.parse("blue aaa");
        Card expectedCard = new Card(Color.BLUE, Number.THREE, Symbol.A, Shading.LOWER);
        assertEquals(expectedCard, card);
    }

    @Test
    void shouldReadCardFromInput2() {
        Card card = InputParser.parse("yellow HH");
        Card expectedCard = new Card(Color.YELLOW, Number.TWO, Symbol.H, Shading.UPPER);
        assertEquals(expectedCard, card);
    }

    @Test
    void shouldReadCardFromInput3() {
        Card card = InputParser.parse("green @");
        Card expectedCard = new Card(Color.GREEN, Number.ONE, Symbol.A, Shading.SYMBOL);
        assertEquals(expectedCard, card);
    }

    @Test
    void shouldReadCardFromInput4() {
        Card card = InputParser.parse("green #");
        Card expectedCard = new Card(Color.GREEN, Number.ONE, Symbol.H, Shading.SYMBOL);
        assertEquals(expectedCard, card);
    }

    @Test
    void shouldReadCardFromInput5() {
        Card card = InputParser.parse("green $");
        Card expectedCard = new Card(Color.GREEN, Number.ONE, Symbol.S, Shading.SYMBOL);
        assertEquals(expectedCard, card);
    }
}