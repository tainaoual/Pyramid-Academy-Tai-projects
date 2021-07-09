package com.company;

import java.util.Scanner;

public class Main
{

        public static void main(String[] args) {


            Scanner sc = new Scanner(System.in);

            Cipher obj = new Cipher();


            System.out.println("Secret Decoder Ring:");
            System.out.println("1. Encrypt\n2. Decrypt");
            int choice1 = Integer.parseInt(sc.nextLine());


            if(choice1 == 1){


                System.out.println("Enter Encryption Type:");
            System.out.println("1. Atbash\n2. Caesar");
            int choice2 = Integer.parseInt(sc.nextLine());


            if(choice2 == 1){
                obj.atbashEncryption();
            }else{
                obj.caesarEncryption();
            }
            }

            else
            {

                System.out.println("Enter Decryption Type:");
            System.out.println("1. Atbash\n2. Caesar");
            int choice2 = Integer.parseInt(sc.nextLine());


            if(choice2 == 1){
                obj.atbashDecryption();
            }else{
                obj.caesarDecryption();
            }
            }
        }
}
