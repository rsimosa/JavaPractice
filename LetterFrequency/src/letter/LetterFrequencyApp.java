package letter;

import java.util.Arrays;

public class LetterFrequencyApp {

    public static void main(String[] args) {
        
        LetterFrequency lf = new  LetterFrequency();
        
        lf.checkFrequency("war-and-peace.txt");
        
        
        System.out.println(lf.toString());
        System.out.println(lf.HighestRepeatedLetter());
        System.out.println(lf.LowestRepeatedLetter());
        System.out.println(lf.TotalLetters());
        

    }

}
