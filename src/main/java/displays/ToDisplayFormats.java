package displays;

public class ToDisplayFormats {

    public static String formatLong(long number) {
        return addSeperator(Long.toString(number)).replace("a", ".");
    }


    private static String addSeperator(String number) {
        if (number.length() <= 3) {
            return number;
        }

        String numberBlock = number.substring(number.length() - 3);
        numberBlock = "a" + numberBlock;
        String remaining = number.substring(0, number.length() - 3);

        String resultStr = addSeperator(remaining);
        return resultStr + numberBlock;
    }
}
