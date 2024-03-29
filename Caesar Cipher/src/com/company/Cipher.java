package com.company;

public class Cipher{

    public String encrypt(String message, int offset){
        StringBuilder result = new StringBuilder();
        for (char character : message.toLowerCase().toCharArray()) {
            if (character != ' ') {
                int originalAlphabetPosition = character - 'a';
                int newAlphabetPosition = (originalAlphabetPosition + offset) % 26;
                char newCharacter = (char) ('a' + newAlphabetPosition);
                result.append(newCharacter);
            } else {
                result.append(character);
            }
        }
        return String.valueOf(result);
    }

    public String decrypt(String message, int offset){
        return encrypt(message, 26 - (offset % 26));
    }
}
