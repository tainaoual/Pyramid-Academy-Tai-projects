package com.company;

    // JAVA program to perform ceaser and atbash cipher Encryption and Decryption
// Assumption: provide message in uppecase letters, enter a number key for Caesar cipher
import java.util.*;
import java.io.*;

    // Cipher class definition
    class Cipher{

        // creare a static Scanner object for user input
        static Scanner sc = new Scanner(System.in);

        // private member
        private String cipher;

        // default contructor
        public Cipher(){}

        // this method performs Encryption using atbash cipher technique
        public void atbashEncryption(){

            // enter message
            System.out.print("Enter message: ");
            String message = sc.nextLine();

            // declare a String builder
            StringBuilder decoded = new StringBuilder();

            // read character from message one by one
            for(char c : message.toCharArray()){
                // if alphabet
                if(Character.isLetter(c)){

                    // rotate character
                    int newChar = ('Z' - c) + 'A';

                    // and append result
                    decoded.append((char) newChar);
                } else {

                    // otherwise, directlt append character
                    decoded.append(c);
                }
            }

            // StringBuilder to String
            String encryptedMessage = decoded.toString();

            // declare file name
            String fileName = "message.txt";

            // open file using try-catch block
            File file = new File(fileName);
            FileWriter fr = null;
            try {
                fr = new FileWriter(file);

                // write message to the file
                fr.write(encryptedMessage);
                fr.flush();
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // display message
            System.out.println("Encrypted message saved to \"message.txt\".");
            System.out.println("Encrypted Message written to the file: " + encryptedMessage);
        }

        // this method performs Decryption using atbash cipher technique
        public void atbashDecryption(){

            // read message from the file
            System.out.println("Reading encrypted message from \"message.txt\".");
            File file = new File("message.txt");

            // using BufferedReader
            BufferedReader br = null;
            try
            {
                // read file
                br = new BufferedReader(new FileReader(file));
                String message = br.readLine();

                // declare StringBuilder
                StringBuilder decoded = new StringBuilder();

                // loop to read characters one by one
                for (char c : message.toCharArray()) {

                    // if alphabet
                    if (Character.isLetter(c)) {

                        // rotate characters and append result
                        int newChar = ('Z' - c) + 'A';
                        decoded.append((char) newChar);
                    } else {
                        // otherwise, directly append
                        decoded.append(c);
                    }
                }

                // StringBuilder to String
                String decryptedMessage = decoded.toString();

                // display message
                System.out.println("Decrypted message = " + decryptedMessage);
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }

        // this method performs Decryption using Caesar cipher technique
        public void caesarEncryption(){

            // declare variables
            String message, encryptedMessage = "";
            int key;
            char ch;

            // provided message uppercase only
            System.out.print("Enter message: ");
            message = sc.nextLine();

            // provide key (Number)
            System.out.print("Enter shift value: ");
            key = sc.nextInt();

            // loop to rotate characters by key
            for(int i = 0; i < message.length(); ++i){
                ch = message.charAt(i);

                // for uppercase only
                if(ch >= 'A' && ch <= 'Z'){
                    ch = (char)(ch + key);

                    if(ch > 'Z'){
                        ch = (char)(ch - 'Z' + 'A' - 1);
                    }

                    // add rotated character to the encryptedMessage
                    encryptedMessage += ch;
                }
                else {
                    encryptedMessage += ch;
                }
            }

            // create file
            String fileName = "message.txt";

            // open file using try-catch
            File file = new File(fileName);
            FileWriter fr = null;
            try
            {
                fr = new FileWriter(file);
                // write message to file
                fr.write(encryptedMessage);
                fr.flush();
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // display message
            System.out.println("Encrypted message saved to \"message.txt\".");
            System.out.println("Encrypted Message written to the file: " + encryptedMessage);
        }

        // this method performs Decryption using Caesar cipher technique
        public void caesarDecryption(){

            // declare variables
            String message, decryptedMessage = "";
            int key;
            char ch;

            // reading message
            System.out.println("Reading encrypted message from \"message.txt\".");
            File file = new File("message.txt");

            //
            BufferedReader br = null;
            try
            {
                // open file
                br = new BufferedReader(new FileReader(file));
                message = br.readLine();

                // provide key
                System.out.print("Enter shift value: ");
                key = sc.nextInt();

                // loop to rotate characters by key
                for(int i = 0; i < message.length(); ++i){
                    ch = message.charAt(i);

                    // for uppercase
                    if(ch >= 'A' && ch <= 'Z'){
                        ch = (char)(ch - key);

                        if(ch < 'A'){
                            ch = (char)(ch + 'Z' - 'A' + 1);
                        }

                        // add character to decryptedMessage
                        decryptedMessage += ch;
                    }
                    else {
                        decryptedMessage += ch;
                    }
                }

                // display Message
                System.out.println("Decrypted Message = " + decryptedMessage);
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }





