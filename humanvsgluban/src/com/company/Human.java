package com.company;
import java.util.Scanner;
public class Human {



        public static int playerHP;
         public static int monsterHP;
        public static String humanwaipen;
        public static String humanName;

    public static void playerSetUp() {
         playerHP = 10;
        monsterHP = 15;
        humanwaipen = humanwaipen;
        humanName = humanName;
    }

    public void Human(){
            this.playerHP=100;
            this.humanName="tai";
            this.humanwaipen = "nife";
            int playerHP = 10;
            int monsterHP = 15;
            String humanwaipen = "Knife";

            System.out.println("Your HP: "+ playerHP);
            System.out.println("Your Weapon: "+ humanwaipen);

            System.out.println("Please enter your name:");

            Scanner inputScanner= new Scanner(System.in);
            String humanName = inputScanner.nextLine();

            System.out.println("Hello " + humanName + ", let's start the game!");
        }



    public void playerSetUp(int playerHP, int monsterHP, String humanwaipen, String humanName) {

       // int PlayerHP = 10;


//
//        public Human() {
//            super();
//        }


    }
}

