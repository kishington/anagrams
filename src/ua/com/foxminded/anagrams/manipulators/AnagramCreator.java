package ua.com.foxminded.anagrams.manipulators;

import java.util.*;

public class AnagramCreator {

    public String createAnagram(String inputText) {

        WordManipulator wordManipulator = new WordManipulator();
        List<String> words = wordManipulator.getWords(inputText);

        for (int i = 0; i < words.size(); i++) {
            String currentWord = words.get(i);
            String modifiedWord = wordManipulator.reverseLettersInWord(currentWord);
            words.set(i, modifiedWord);
        }

        StringBuilder outputText = new StringBuilder();
        int charIndex = 0;
        int wordIndex = 0;
        while (charIndex < inputText.length()) {
            char ch = inputText.charAt(charIndex);
            boolean isCurrentCharWhitespace = Character.isWhitespace(ch);
            if (!isCurrentCharWhitespace) {
                String currentWord = words.get(wordIndex);
                outputText.append(currentWord);
                charIndex += currentWord.length();
                wordIndex++;
            } else {
                outputText.append(ch);
                charIndex++;
            }
        }
        return outputText.toString();
    }
}
