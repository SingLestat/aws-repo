package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cipher cipher = new Cipher();
        ReadWriteFile readWriteFile = new ReadWriteFile();

        System.out.println("Input message to be encrypted:");
        String message = scanner.nextLine();
        System.out.println("Input the offset for encryption:");
        int offSet = scanner.nextInt();
        String encryptMessage = cipher.encrypt(message, offSet);
        System.out.println(encryptMessage);
        readWriteFile.writeToFile(encryptMessage, offSet);
        System.out.println("Decrypted message:");
        System.out.println(readWriteFile.readFromFile());
    }
}
