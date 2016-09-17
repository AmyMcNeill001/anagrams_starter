package com.google.engedu.anagrams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;
import android.util.Log;

public class AnagramDictionary {

    private static final int MIN_NUM_ANAGRAMS = 5;
    private static final int DEFAULT_WORD_LENGTH = 3;
    private static final int MAX_WORD_LENGTH = 7;
    private Random random = new Random();
    private ArrayList<String> wordList = new ArrayList<String>();

    public AnagramDictionary(InputStream wordListStream) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(wordListStream));
        String line;
        while((line = in.readLine()) != null) {
            String word = line.trim();
            wordList.add(word);
        }
    }

    public boolean isGoodWord(String word, String base) {
        return true;
    }

    public String sortLetters(String original) {
        char[] char_array = original.toCharArray();
        Arrays.sort(char_array);

        //make that char array a word
        String sorted = new String(char_array);
        return sorted;
    }//function sortLetters

    public ArrayList<String> getAnagrams(String targetWord) {
        ArrayList<String> result = new ArrayList<String>();
        targetWord = sortLetters(targetWord);
        for (int ii = 0; ii < wordList.size(); ii++) {
            boolean match = false;
            if (wordList.get(ii).length() != targetWord.length())
                ;
            else {
                String temp = sortLetters(wordList.get(ii));
                for(int xx = 0; xx < temp.length(); xx++)
                {
                    if (temp.charAt(xx) != targetWord.charAt(xx))
                        break;
                    else if(xx == temp.length()-1)
                        match = true;
                }
                if (match == true) {
                    result.add(wordList.get(ii));
                }
            }//else
        }//for loop

        for (int ii = 0; ii < result.size(); ii++){
            Log.d("Result list: ", result.get(ii));
        }
        return result;
    }

    public ArrayList<String> getAnagramsWithOneMoreLetter(String word) {
        ArrayList<String> result = new ArrayList<String>();
        return result;
    }

    public String pickGoodStarterWord() {
        return "stop";
    }
}
