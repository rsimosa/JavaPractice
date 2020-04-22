package stringcount;

public class StringCountModel {

    public static String characterCount(String op) {

        return "" + op.length();
    }

    public static String vowelCount(String op) {

        int count = 0;
        for (int i = 0; i < op.length(); i++) {
            if (op.toLowerCase().charAt(i) == 'a' || op.toLowerCase().charAt(i) == 'e' || op.toLowerCase().charAt(i) == 'i'
                    || op.toLowerCase().charAt(i) == 'o' || op.toLowerCase().charAt(i) == 'u') {
                count++;
            }
        }
        return count + "";

    }

    public static String uppercaseCount(String op) {
        return "" + op.chars().filter(c -> Character.isUpperCase(c)).count();
    }

}

