package parttwo.homeworkthree;

import java.util.*;

public class WordsArray {

    public static void main(String[] args) {


    String[] words = {"one","two","three","four","five","six","seven","eight","nine","ten","one","one","two","five","six","six","six"};
    Set<String> uniqWords = new HashSet<>(Arrays.asList(words));
    System.out.println("Количество уникальных слов - " + uniqWords.size());

    Map<String,Integer> wordsCounter = new HashMap<>();

        for (String word : words) {
            int count = 0;
            if (wordsCounter.containsKey(word)) {
                count = wordsCounter.get(word);
                count++;
                wordsCounter.put(word, count);
            } else {
                wordsCounter.put(word, 1);
            }
        }
        System.out.println(wordsCounter);

    }
}
