import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello you fucking shminga binga");
        System.out.println("today I will be guiding you on the resources you need adn to specific calculations");
        System.out.println("This List will be forever increasing, as you will see by the menu options");
        System.out.println("This was created on 10/16");
        System.out.println("\n");
        boolean bigshmiga = true;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String userName = scanner.nextLine();
        System.out.print("Enter in your location (2-letter state abbreviation): ");
        String userLoc = scanner.nextLine();
        System.out.println("\n");
        System.out.println("what would you like to do today?");
        while (bigshmiga == true) {
            System.out.println("1 - Currency Converter\n2 - Tax Calculator\n3 - Tic Tac Toe game");
            System.out.println("4 - Snake game\n5 - Word Doc File Saver\n6 - ATM Simulation\n7 - Document Analyzer");
            System.out.println("8 - Exit\n");
            System.out.print("Selection > ");
            int userSel = Integer.parseInt(scanner.nextLine());
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
                DocSaver.main();
            }
            if (userSel == 6) {
                AtmSim.main();
            }
            if (userSel == 7) {
                DocAnalyzer.main();
            }
            if (userSel == 8){
                bigshmiga = false;
            }
        }

    }
}