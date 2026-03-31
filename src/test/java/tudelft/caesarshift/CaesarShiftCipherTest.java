package tudelft.caesarshift;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CaesarShiftCipherTest {
    @ParameterizedTest(name = "message={0}, shift={1}, expected={2}")
    @CsvSource({
        "z,1,a",
        "y,2,a",
        "a,-1,z"
    })
    public void boundaryAlphabet(String message, int shift, String expected) {
        Assertions.assertEquals(expected, new CaesarShiftCipher().CaesarShiftCipher(message, shift));
    }

    @ParameterizedTest(name = "message={0}, shift={1}, expected={2}")
    @CsvSource({
        "abc,1,bcd",
        "xyz,3,abc",
        "hello,2,jgnnq"
    })
    public void normalCases(String message, int shift, String expected) {
        Assertions.assertEquals(expected, new CaesarShiftCipher().CaesarShiftCipher(message, shift));
    }

    @ParameterizedTest(name = "message={0}, shift={1}, expected={2}")
    @CsvSource({
        "abc1,1,invalid",
        "ABC,1,invalid",
        "hello!,2,invalid"
    })
    public void invalidCharacters(String message, int shift, String expected) {
        Assertions.assertEquals(expected, new CaesarShiftCipher().CaesarShiftCipher(message, shift));
    }

}
