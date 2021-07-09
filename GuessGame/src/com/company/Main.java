package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int guessNumber ;
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("Hello! What is your name?");
        String name = inputScanner.nextLine();
        System.out.println(" Well, tai, I am thinking of a number between 1 and 20.  Take a guess.");
        guessNumber = Integer.parseInt(inputScanner.nextLine());
        if(guessNumber>=10) {
            System.out.println("Your guess is too high.  Take a guess.");
            guessNumber = Integer.parseInt(inputScanner.nextLine());
        }if (guessNumber<=5) {
            System.out.println("Your guess is too low.  Take a guess.");
            guessNumber = Integer.parseInt(inputScanner.nextLine());
        }if (guessNumber>=6&&guessNumber>=11) {
            System.out.println("Good job, tai! You guessed my number in 3 guesses!  Would you like to play again? (y or n)\n"
                    );
            String no = inputScanner.nextLine();
        }
    }}