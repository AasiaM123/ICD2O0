/*
Student: Aasia 780273
Date: Dec 18th, 2024
Course: ICD 2O0
Assignment: Assignment 3, Rock-Paper-Scissors
Description: A code that allows the user to play Rock-Paper-Scissor with a computer
Variable Dictoniary:
- sc (Scanner) = Used for computer to read input
- numGames (int) = Variable used to count number of games
- computerWins (int) = Shows how many times the computer has won
- playerWins (int) = shows how many times the user has won
- ties (int) = How many games ended in ties
- playerchoice (char) = Player's choice of 'r' or 'p' or 's'
- computerRandomChoice = A random number between 0-2 
- computerChoice (char) = Computers choice of choosing 'r' or 'p' or 's' 


*/

import java.util.Scanner;

public class Assignment3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("How many games would you like to play? "); // ask the user the number of rounds they want to play
        int numGames = sc.nextInt();// user inputs how many times they want to play

        int playerWins = 0; // player's wins are set to 0 in the start
        int computerWins = 0; // computers's wins are set to 0 in the start
        int ties = 0; // ties are set to 0 in the start


        for (int n = 0; n < numGames; n++) {
            System.out.print("Select your move (r = rock; p = paper, and s` = scissors): ");
            char playerchoice = sc.next().toLowerCase().charAt(0); // makes uses input lowercase

            if(playerchoice != 'r' &&  playerchoice != 's' && playerchoice != 'p' ){ 
                System.out.println("Please enter (r = rock; p = paper, and s` = scissors)");// re-iterates to user to input 'r', 'p' or 's'
                
            }
            int computerRandomChoice = (int)(3 * Math.random()); // computer chooses a random number from 1-3
            char computerChoice = ' ';/

            if (computerRandomChoice == 0) {
                computerChoice = 'r'; // Rock
            } else if (computerRandomChoice == 1) {
                computerChoice = 'p'; // Paperbb
            } else {
                computerChoice = 's'; // Scissors
            }
            System.out.println("Computer chose: " + computerChoice); // outputs user's choice

            if (playerchoice == computerChoice){
                System.out.println("---It's a tie!!--- "); // outputs if user and computer have the same choice
                ties++;
            } else if ((playerchoice =='r' && computerChoice =='s') || 
                    (playerchoice =='p' && computerChoice =='r')|| 
                    (playerchoice =='s' && computerChoice =='p')) { 
                System.out.println("You win!"); // states of user wins
                playerWins++;
            }else {
                System.out.println("Computer wins!"); //states if computer wins
                computerWins++;
            }
        }
        System.out.println("\nFinal Score:");
        System.out.println("Player Wins: " + playerWins); //states players wins
        System.out.println("Computer Wins: " + computerWins); // states computers wins
        System.out.println("Ties: " + ties); // states how many ties occured

        sc.close(); // code ends
    }
}

