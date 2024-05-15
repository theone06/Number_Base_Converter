package converter;


import java.math.BigInteger;
import java.util.HashMap;

public class AltConverterClass {
    char [] alphabetArray = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    HashMap<Character, Integer> alphabetToNumber = new HashMap<>();
    int ddNum = 10;

    public AltConverterClass() {
        for(Character letter : alphabetArray) {
            alphabetToNumber.put(letter, ddNum++);
        }
    }

    //converts a source base to a target base
    public String radConvertor(String num, int source, int target) {
        int temp = convert2Base10(num, source); //converts num from {source} to base 10
        return decimal2RadConverter(temp,target) + "";
    }
    //converts a source base to decimal
   public int convert2Base10(String num, int source) {
       int dec = 0;
       int base = source;
       int temp = 0;
       int exp = 0;
       for (int i = num.length()-1; i >= 0; i--) {
           temp = convFromAlpha(num.charAt(i));
           dec += temp * Math.pow(base, exp++);
       }
       return dec;
   }

   //converts a decimal to a target base
    public String decimal2RadConverter(int num, int target) {
        StringBuilder radStr = new StringBuilder();
        int  q = num/target;
        radStr.append(conv2Aplha(num%target));

        while(q > 0) {
            radStr.append(conv2Aplha(q%target));
            q/=target;
        }
        return radStr.reverse().toString();
    }

   public String conv2Aplha(int num) {
        String result = "";
        if (num >= 10 ) {
            //give char equivalent for base
            for (Character key: alphabetToNumber.keySet())
            {
                if (num == alphabetToNumber.get(key)) {
                    result = "" + key;
                }
            }

        } else {
            result = num + "";
        }
        return result;
   }

   public int convFromAlpha(char digit) {
        //if alpha
       int result;
        if (alphabetToNumber.containsKey(digit)) {
            result = alphabetToNumber.get(digit);
        } else {
            result = Character.getNumericValue(digit);
        }
        return result;
   }

}
