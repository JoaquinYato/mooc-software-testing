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

    @ParameterizedTest(name = "input={0}, expected={1}")
    @CsvSource({
        "'',true",     
        "g,false",     
        "a,true"       
    })
    public void boundaryStringLength(String input, boolean expected) {
        Assertions.assertEquals(expected, gHappy.gHappy(input));
    }

    @ParameterizedTest(name = "input={0}, expected={1}")
    @CsvSource({
        "gxxg,false",   
        "ggxx,true",    
        "xxgg,true",    
        "gxxgg,false"   
    })
    public void gAtEdges(String input, boolean expected) {
        Assertions.assertEquals(expected, gHappy.gHappy(input));
    }

  
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