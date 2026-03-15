package tudelft.roman_num;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class roman_num_test {
    @Test
    public void num945() {
        String result = new roman_num().num_rom(945);
        System.out.print(result);
        Assertions.assertEquals("CMXLV",result);
    }
}
