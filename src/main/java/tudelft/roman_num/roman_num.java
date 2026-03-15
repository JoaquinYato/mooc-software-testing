package tudelft.roman_num;

public class roman_num {
     public static String num_rom(int n) {
         int[] num = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
         String[] rom = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
         String res = "";
         for (int i = 0; i < num.length; i++) {
             while (n >= num[i]){
                 res += rom[i];
                 n -= num[i];
             }
             if (n == 0){break;}
         }
         return res;
     }
}
