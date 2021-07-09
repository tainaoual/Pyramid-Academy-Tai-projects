package com.company;

public class Game {




        private int playerHP;
        private int monsterHP;
        private String humanwaipen;
        private String humanName;


        public void playerSetUp() {
            this.playerHP = 10;
            this.monsterHP = 15;
            this.humanwaipen = "Knife";

        }

        public void townGate() {
        }
public static void win(){
 
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("You killed the globin!");
        System.out.println("The globin dead!");
        System.out.println("You get his  energy!\n\n");
        System.out.println("1: Go east");
    
}
    public void ending () {
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("Guard: Oh you killed that goblin!?? you get my trust!");
        System.out.println("Guard:  Welcome to our town!");
        System.out.println("\n\n           THE END                    ");
        System.out.println("\n------------------------------------------------------------------\n");
    }
    public void dead () {
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("You are dead!!!");
        System.out.println("\n\nGAME OVER");
        System.out.println("\n------------------------------------------------------------------\n");

    }
    public void crossRoad () {
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println(" the town.\n\n");
        System.out.println("1:  north");
        System.out.println("2:  east");
        System.out.println("3:  south");
        System.out.println("4:  west");
        System.out.println("\n------------------------------------------------------------------\n");


        int choice = 0;
        if (choice == 1) {
            System.out.println("north");
        } else if (choice == 2) {
            System.out.println("east");
        } else if (choice == 3) {
            new lindGate();
        } else if (choice == 4) {
            System.out.println("west");
        } else {
            System.out.println("south");
            System.out.println("\n------------------------------------------------------------------\n");
            System.out.println("Your HP: low");
            System.out.println("globin HP:high ");
            System.out.println("\n1: Attack");
            System.out.println("2: Run");
            System.out.println("\n------------------------------------------------------------------\n");

//
//    public Game () {
//                super ();
//            }
        }
    }

    @Override
    public String toString() {
        return "Game{" +
                "playerHP=" + playerHP +
                ", monsterHP=" + monsterHP +
                ", humanwaipen='" + humanwaipen + '\'' +
                ", humanName='" + humanName + '\'' +
                '}';
    }
}


