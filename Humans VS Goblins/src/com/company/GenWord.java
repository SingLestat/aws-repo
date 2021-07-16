package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GenWord {
    public static List<String> words = new ArrayList<>();

    public static String getWord(){
        String fileName = "C:\\Test\\aws-test-repo\\Humans VS Goblins\\src\\com\\company\\GoblinNames";
        File wordList = new File(fileName);
        Scanner reader = null;

        try {
            reader = new Scanner(wordList);
        } catch (FileNotFoundException e) {
            System.out.println("file \"" + fileName + "\" not found");
            System.exit(0);
        }

        while(reader.hasNextLine()) {
            String word = reader.nextLine();
            words.add(word);
        }
        Random rand = new Random();
        String pickedWord;

        pickedWord = words.get(rand.nextInt(words.size() -1));

        return pickedWord;
    }
}
