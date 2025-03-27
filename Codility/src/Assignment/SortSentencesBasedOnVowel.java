package Assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class SortSentencesBasedOnVowel {
	private static int countVowels(String sentence) {
	    int count = 0;
	    Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
	    
	    for (char c : sentence.toCharArray()) {
	        if (vowels.contains(c)) {
	            count++;
	        }
	    }
	    return count;
	}

    public static void main(String[] args) {
      
        List<String> sentences = new ArrayList<>(Arrays.asList(
        		"Java is an object-oriented programming language.",
        	    "The Java Virtual Machine (JVM) allows Java to run on any platform.",
        	    "Java's syntax is similar to C++, making it easier to learn.",
        	    "Collections in Java are used to store and manipulate groups of objects.",
        	    "The 'public static void main' method is the entry point of a Java program.",
        	    "Java supports multithreading, enabling concurrent task execution.",
        	    "Garbage collection in Java helps manage memory by automatically reclaiming unused objects."
        ));

        
        sentences.sort(Comparator.comparingInt(SortSentencesBasedOnVowel::countVowels));

        
        System.out.println("Sorted sentences based on number of vowel count");
        for (String sentence : sentences) {
            System.out.println(sentence + " (Vowels: " + countVowels(sentence) + ")");
        }
    }
}
