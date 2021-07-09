
package com.company;
import java.util.Random;
import java.util.Scanner;

public class Main {


    //1.	Everything must be objects: land/goblins/humans
    //2.	You must override the toString method to represent each of the object
    //3.	Create a grid for the game world
    //4.	Use UTF characters for the players and goblins and the land
    //5.	Game is turn based move: n/s/e/w
    //6.	Once a human and goblin collide combat is initiated
    //7.	Combat uses math.random

    int playerHP;
     int choice;
    int monsterHP;


    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        Scanner enterScanner = new Scanner(System.in);
        Game tai;
        tai = new Game();
         Human.playerSetUp();
       lindGate.lindGate();
        lindGate.ending();
        Game.win();

        int PlayerHP = 10;

        String humanwaipen = "Knife";

        System.out.println("Your HP: " + PlayerHP);
        System.out.println("Your Weapon: " + humanwaipen);

        System.out.println("Please enter your name:");

        String humanName = inputScanner.nextLine();

        System.out.println("Hello " + humanName + ", let's start the game!");

         //public void lindGate () {
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("You are globin town.");
        System.out.println("A globin  guard is in the front of you.");
        System.out.println("");
        System.out.println(humanName+"What do you want to do?");
        System.out.println("");
        System.out.println("1: Talk to the guard");
        System.out.println("2: Attack the guard");
        System.out.println("3: Leave");
        System.out.println("\n------------------------------------------------------------------\n");
        int choice = inputScanner.nextInt();
        if (choice == 1) {
            System.out.println("ind");
            System.out.println(humanName+"What do you want to do?");
            System.out.println("");
            System.out.println("1: Talk to the guard");
            System.out.println("2: Attack the guard");
            System.out.println("3: Leave");
        } else {
            System.out.println("Guard: So your name is " + " tai" + "?\n Sorry tai we dont let stranger enter our town.");
            System.out.println(humanName+"What do you want to do?");
            System.out.println("");
            System.out.println("1: Talk to the guard");
            System.out.println("2: Attack the guard");
            System.out.println("3: Leave");
            enterScanner.nextLine();
            new lindGate();


        }
        if (choice == 2) {
            int playerHP = -1;
            System.out.println("Guard: offf you cant be her is dongeruse.\n\nThe guard will block you you look sad .\n(You receive 1 damage)\n");
            System.out.println("Your HP: " + playerHP);
            System.out.println(humanName+"What do you want to do?");
            System.out.println("");
            System.out.println("1: Talk to the guard");
            System.out.println("2: Attack the guard");
            System.out.println("3: Leave");
            enterScanner.nextLine();
            new lindGate();
        } else if (choice == 3) {

            new crossRoad();
        } else {
            new lindGate();
        }
        System.out.println(humanName+"What do you want to do?");
        System.out.println("");
        System.out.println("1: Talk to the guard");
        System.out.println("2: Attack the guard");
        System.out.println("3: Leave");

        // public void crossRoad () {
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println(" the town.\n\n");
        System.out.println("1:  north");
        System.out.println("2:  east");
        System.out.println("3:  south");
        System.out.println("4:  west");
        System.out.println("\n------------------------------------------------------------------\n");

        choice = inputScanner.nextInt();

        if (choice == 1) {
            System.out.println("north");
        } else if (choice == 2) {
            System.out.println("east");

        } else if (choice == 4) {
            System.out.println("west");
        } else if(choice==3) {
            System.out.println ("south");
            System.out.println ("\n------------------------------------------------------------------\n");
            System.out.println ("Your HP: low");
            System.out.println ("globin HP:high ");
            System.out.println ("\n1: Attack");
            System.out.println ("2: Run");
            System.out.println ("\n------------------------------------------------------------------\n");

            choice = inputScanner.nextInt();

            if (choice == 1) {
                attack();
            } else if (choice == 2) {

                fight();
            }


            int playerDamage = 0;
//
//
//            if (humanwaipen.equals("Knife")) {
//                playerDamage = new java.util.Random().nextInt(5);
//            } else if (humanwaipen.equals("Long Sword")) {
//                playerDamage = new java.util.Random().nextInt(8);
//            }

            //System.out.println("You attacked the globin wawawawawaw " + playerDamage + " damage!");

            int monsterHP = -   playerDamage;

            System.out.println("globin HP: " + monsterHP);

            if (monsterHP <15){
                win();
            } else if (monsterHP>100 ) {
                int monsterDamage = 0;

                monsterDamage = new java.util.Random().nextInt(4);

                System.out.println("The globin attacked piiiiiiiwwwwww " + monsterDamage + " damage!");

                int playerHP = - monsterDamage;

                System.out.println("Player HP: " + playerHP);

                if (playerHP < 1) {
                    dead();
                } else if (playerHP > 0) {
                   // int playerDamage=0;
                    playerDamage = new Random ().nextInt (5);
                    fight();
                }
            }

tai.dead();
            // public void dead () {
            System.out.println("\n------------------------------------------------------------------\n");
            System.out.println("You are dead!!!");
            System.out.println("\n\nGAME OVER");
            System.out.println("\n------------------------------------------------------------------\n");

        }

            choice = inputScanner.nextInt();
            if (choice == 1) {
//            System.out.println("\n------------------------------------------------------------------\n");
//            System.out.println("You killed the globin!");
//            System.out.println("The globin dead!");
//            System.out.println("You get his  energy!\n\n");
//            System.out.println("1: Go east");
//            System.out.println("\n------------------------------------------------------------------\n");
//
               tai.win();


            }

tai.ending();
        // public void ending () {
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("Guard: Oh you killed that goblin!?? you get my trust!");
        System.out.println("Guard:  Welcome to our town!");
        System.out.println("\n\n           THE END                    ");
        System.out.println("\n------------------------------------------------------------------\n");
    }

    private static void dead() {
    }

    private static void win() {
    }

    private static void fight() {
    }

    private static void attack() {
    }
}