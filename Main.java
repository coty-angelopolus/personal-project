import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        System.out.println("Hello you fucking shminga binga");
        System.out.println("this is a collection of the various different projects i'm working on");
        System.out.println("This List will be forever increasing, as you will see by the menu options");
        System.out.println("This was created on 10/16");
        System.out.println("\n");
        boolean bigshmiga = true;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String userName = scanner.nextLine();
        if (userName.equals("amie") || userName.equals("Amie")){
            System.out.println("yoooooooo shammiiiieeeeeeeeeee is using my programmmmmmmmmmmmmmmmmmmmmmmm");
        }
        System.out.println("Welcome "+userName);
        System.out.print("Enter in your location (2-letter state abbreviation): ");
        String userLoc = scanner.nextLine();
        System.out.println("Location: "+userLoc);
        System.out.println("\n");
        System.out.println("what would you like to do today?");
        while (bigshmiga) {
            System.out.println("\n1 - Currency Converter\n2 - Tax Calculator\n3 - Tic Tac Toe game");
            System.out.println("4 - Snake game\n5 - Encryption center\n6 - ATM Simulation\n7 - Document Analyzer");
            System.out.println("8 - Bet against the Computer\n9 - Trivia\n10- Exit");
            System.out.print("Selection > ");

            String SelTemp = scanner.nextLine();
            int userSel = 0;

            try {
                userSel = Integer.parseInt(SelTemp);
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid input. Please enter a valid integer.");
            }

            if (userSel == 1) {
                CurrencyConverter.main();
            }
            if (userSel == 2) {
                TaxCalculator.main();
            }
            if (userSel == 3) {
                TicTacToe.main();
            }

            if (userSel == 4) {
                SnakeGame.main();
            }
            if (userSel == 5) {
                EncryptionCenter.main();
            }
            if (userSel == 6) {
                AtmSim.main();
            }
            if (userSel == 7) {
                DocAnalyzer.main();
            }
            if (userSel == 8){
                BetSystem.main();
            }
            if (userSel == 9){
                Trivia.main();
            }
            if (userSel == 10){
                System.out.println("Thank you for using my program!");
                System.out.println("Closing................");
                bigshmiga = false;
            }
        }

    }
}