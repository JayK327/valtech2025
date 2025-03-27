package Assingment;

import java.util.*;

public class VowelSorter {
    
    private static int countVowels(String sentence) {
        int count = 0;
        String vowels = "aeiouAEIOU";
        for (char c : sentence.toCharArray()) {
            if (vowels.indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
      
        List<String> sentences = new ArrayList<>(Arrays.asList(
            "This is a test sentence.",
            "Hello World!",
            "Java programming is fun.",
            "Sorting sentences by vowels."
        ));

        
        sentences.sort(Comparator.comparingInt(VowelSorter::countVowels));

        
        System.out.println("Sentences sorted by vowel count:");
        for (String sentence : sentences) {
            System.out.println(sentence + " (Vowels: " + countVowels(sentence) + ")");
        }
    }
}
