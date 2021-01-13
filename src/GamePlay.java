import java.security.SecureRandom;

public class GamePlay {
   public boolean play(String playerName){
       SecureRandom randomNum = new SecureRandom();
       int dice1 = randomNum.nextInt(7);
       int dice2 = randomNum.nextInt(7);
       int diceSum = dice1+dice2;
       System.out.println("dice 1 : "+dice1);
       System.out.println("dice 2 : "+dice2);
       System.out.println("dice  Sum : "+diceSum);
       if(diceSum==playerName.length() ||
       isCommonWord(wordsOf(dice1),playerName) ||
       isCommonWord(wordsOf(dice2),playerName) ||
       isCommonWord(wordsOf(diceSum),playerName))
           return true;
       return false;
   }
    public boolean isCommonWord(String number,String playerName){
        System.out.println("Number in words : "+number);
        System.out.println("Player name : "+playerName);
      char[] num = number.toCharArray();
      for(int i=0;i<num.length;i++){
          if(playerName.contains(num[i]+""))
              return true;
      }
      return false;
    }
    public String wordsOf(int number){
        char[] num = String.valueOf(number).toCharArray();
        int len = num.length;
        String word = "";
        String[] single_digits = new String[]{ "zero", "one", "two", "three", "four","five", "six", "seven", "eight", "nine"};
        String[] two_digits = new String[]{"", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen","eighteen", "nineteen"};
        String[] tens_multiple = new String[]{"", "ten", "twenty", "thirty", "forty", "fifty","sixty", "seventy", "eighty", "ninety"};
        int unit_value = number%10;
        int tens_value = number/10;
        if (len == 0 || len>2){
            System.out.println("ERROR! Empty number or three digit number is not supported.");
            return null;
        }
        if(len==2 && unit_value==0)
            word = tens_multiple[tens_value];
        if(len==2 && unit_value!=0){
            if(tens_value>1){
                word = tens_multiple[tens_value]+" ";
                word+=single_digits[unit_value];
            }
            else{
                word = two_digits[unit_value];
            }
        }
        if(len==1)
            word = single_digits[unit_value];
        return word;
    }
}
