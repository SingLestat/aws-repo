package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ReadWriteFile{
    public ReadWriteFile(){CreateFile();}

    private void CreateFile() {
        try {
            File myObj = new File("cipherText.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void writeToFile(String message, int offSet){
        try {
            FileWriter myWriter = new FileWriter("cipherText.txt");
            myWriter.write(message + "/" + offSet);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public String readFromFile(){
        Cipher cipher = new Cipher();
        try {
            File myObj = new File("cipherText.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String rawMessage = myReader.nextLine();
                String[]splitMissage = rawMessage.split("/");
                return cipher.decrypt(splitMissage[0], Integer.valueOf(splitMissage[1]));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return null;
    }
}

