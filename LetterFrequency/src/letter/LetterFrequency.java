package letter;

import java.io.File;
import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;
import java.util.Arrays;
import java.util.Scanner;

public class LetterFrequency {

    char[] letters;
    int[] frequency;

    public LetterFrequency() {
        letters = new char[]{
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
            'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
            'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
        };

        frequency = new int[26];
        Arrays.fill(frequency, 0);
    }

    public void checkFrequency(String filename) {
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine();
                for (char c : s.toCharArray()) {
                    for (int i = 0; i < letters.length; i++) {
                        char C = Character.toUpperCase(c);
                        if (C == letters[i]) {
                            frequency[i]++;
                        }
                    }
                }
            }
        } catch (Exception e) {
        }
    }

    public int[] getFrequency() {
        return frequency;
    }

    public void setFrequency(int[] frequency) {
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        String numLetters = "";
        for (int i = 0; i < letters.length; i++) {
            numLetters += letters[i] + ": " + frequency[i] + "\n";
        }
        return numLetters;
    }

    public String TotalLetters() {
        return "Total Amount of Letters: " + Arrays.stream(frequency).sum();
    }

    public String HighestRepeatedLetter() {

        int HRL = MIN_VALUE;
        char mostRepeated = ' ';

        for (int i = 0; i < letters.length; i++) {

            if (frequency[i] > HRL) {
                HRL = frequency[i];
                mostRepeated = letters[i];
            }
        }

        return "The most repeated letter is: " + mostRepeated + " with " + HRL + " repetitions";
    }

    public String LowestRepeatedLetter() {

        int LRL = MAX_VALUE;
        char leastRepeated = ' ';

        for (int i = 0; i < letters.length; i++) {

            if (frequency[i] < LRL) {
                LRL = frequency[i];
                leastRepeated = letters[i];
            }
        }

        return "The least repeated letter is: " + leastRepeated + " with " + LRL + " repetitions";
    }
}
