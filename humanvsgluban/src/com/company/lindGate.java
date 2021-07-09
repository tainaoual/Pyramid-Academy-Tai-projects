package com.company;

import java.util.Scanner;

public class lindGate {

        public String  lindGate;
        public static void lindGate(){

           // this.lindGate;
            System.out.println("\n------------------------------------------------------------------\n");
            System.out.println("You are at the gate of the town.");
            System.out.println("A guard is standing in front of you.");
            System.out.println("");
            System.out.println("What do you want to do?");
            System.out.println("");
            System.out.println("1: Talk to the guard");
            System.out.println("2: Attack the guard");
            System.out.println("3: Leave");
            System.out.println("\n------------------------------------------------------------------\n");
            Scanner inputScanner = new Scanner(System.in);

            int choice = inputScanner.nextInt();
            Scanner enterScanner = new Scanner(System.in) ;
            if(choice==1){
                String lindGate  = "nort";

            }

            else if(choice==3){
                String lindGate= "shout";
            }
            else{
                String lindGate = "est";
            }
        }

        static void ending() {
        }
        public void crossRoad(){

        }
        public lindGate() {

        }

    @Override
    public String toString() {
        return "lindGate{" +
                "lindGate='" + lindGate + '\'' +
                '}';
    }
}
