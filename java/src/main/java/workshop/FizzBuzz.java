package workshop;
public class FizzBuzz {
    public static boolean isBuzz(int number)
    {
        if(number%3==0) {
            return true;
        }
        return false;
    }
    public static boolean isFizz(int number)
    {
        if(number%3==0) {
            return true;
        }
        return false;
    }
    public static String returnString(int number) {

        if (isFizz(number) && isBuzz(number)) {
            return "FizzBuzz";
        }
        else if(isFizz(number)) {
            return "Fizz";
        }
        else if(isBuzz(number)) {
            return "Buzz";
        }
        return String.valueOf(number);
    }
}