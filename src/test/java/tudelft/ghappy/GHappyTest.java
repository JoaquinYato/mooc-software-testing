package tudelft.ghappy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class GHappyTest {

    private GHappy gHappy;

    @BeforeEach
    public void setUp() {
        gHappy = new GHappy();
    }

    // 🔹 1. Casos básicos (funcionamiento general)
    @ParameterizedTest(name = "input={0}, expected={1}")
    @CsvSource({
        "xxggxx,true",
        "gg,true",
        "aabbcc,true",
        "gggg,true"
    })
    public void normalCases(String input, boolean expected) {
        Assertions.assertEquals(expected, gHappy.gHappy(input));
    }

    // 🔹 2. Casos donde falla (g sola)
    @ParameterizedTest(name = "input={0}, expected={1}")
    @CsvSource({
        "g,false",
        "xxgxx,false",
        "gxx,false",
        "xxg,false"
    })
    public void lonelyGShouldFail(String input, boolean expected) {
        Assertions.assertEquals(expected, gHappy.gHappy(input));
    }

    // 🔹 3. Límites del string
    @ParameterizedTest(name = "input={0}, expected={1}")
    @CsvSource({
        "'',true",     // string vacío
        "g,false",     // longitud 1 con g
        "a,true"       // longitud 1 sin g
    })
    public void boundaryStringLength(String input, boolean expected) {
        Assertions.assertEquals(expected, gHappy.gHappy(input));
    }

    // 🔹 4. g en los extremos
    @ParameterizedTest(name = "input={0}, expected={1}")
    @CsvSource({
        "gxxg,false",   // ambas solas
        "ggxx,true",    // inicio válido
        "xxgg,true",    // final válido
        "gxxgg,false"   // mezcla (una sola)
    })
    public void gAtEdges(String input, boolean expected) {
        Assertions.assertEquals(expected, gHappy.gHappy(input));
    }

    // 🔹 5. Combinaciones más complejas
    @ParameterizedTest(name = "input={0}, expected={1}")
    @CsvSource({
        "xxggyygg,true",
        "xxggyyg,false",
        "ggxgg,true",
        "ggxg,false"
    })
    public void mixedCases(String input, boolean expected) {
        Assertions.assertEquals(expected, gHappy.gHappy(input));
    }
}