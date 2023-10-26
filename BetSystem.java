import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class BetSystem {
    static String userName;
    static String userPass;
    static int userTotal;
    static String faceValue;
    static String numValue;
    static int BJValue;
    static int UserTotalBJV;
    static int DealerTotalBJV;

    public static void main() throws IOException {
        System.out.println("Welcome to the Clam Betting Arena\nThis will have things continually being added\n");
        System.out.println("Sign up or Login in\n\n1 - Create a account\n2 - Login ");
        System.out.print("> ");
        Scanner scanner = new Scanner(System.in);
        int BetSel = Integer.parseInt(scanner.nextLine());
        boolean loggedIn = false;
        String filePath = "BetLogins.txt";
        if (BetSel == 1) {
            System.out.println("Account creation:\nEnter in your username");
            System.out.print("> ");
            userName = scanner.nextLine();
            System.out.println("Enter in your password");
            System.out.print("> ");
            userPass = scanner.nextLine();
            System.out.print("Enter initial deposit: $");
            userTotal = Integer.parseInt(scanner.nextLine());
            System.out.println("Account Created!");
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true));
            writer.write(userName);
            writer.newLine();
            writer.write(userPass);
            writer.newLine();
            writer.write(userTotal);
            writer.newLine();
            writer.close();
        }
        if (BetSel == 2) {
            System.out.print("Enter username: ");
            String userFind = scanner.nextLine();
            String fileName = "BetLogins.txt";
            String line;

            try {
                FileReader fileReader = new FileReader(fileName);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                boolean reader = false;
                while (reader == false) {
                    line = bufferedReader.readLine();
                    if (line.equals(userFind)) {
                        reader = true;
                        System.out.println("Account found!");
                        String Tuserpass = bufferedReader.readLine();
                        String TuservalueA = bufferedReader.readLine();
                        userTotal = Integer.parseInt(TuservalueA);
                        System.out.print("Enter in password: ");
                        String Tpass = scanner.nextLine();
                        if (Tpass.equals(Tuserpass)) {
                            System.out.println("Account login successful!");
                            System.out.println("Current account value: " + userTotal);
                            loggedIn = true;
                        }
                    }
                }
            } catch (IOException ignored) {

            }

        }
        boolean bettingOver = false;
        while (bettingOver == false) {
            if (loggedIn == true) {
                int totalamount = userTotal;
                int betAmount = 0;
                System.out.println("\nLoading content.......................");
                System.out.println("What would you like to play?");
                System.out.println("1 - Blackjack\n2 - Poker\n3 - war\n4 - Number Guesser");
                int betSelect = Integer.parseInt(scanner.nextLine());
                if (betSelect == 1) {
                    int[] userHands = new int[4];
                    int[] dealerHands = new int[3];
                    System.out.println("Welcome to Black Jack");
                    System.out.println("Enter bet amount: ");
                    betAmount = Integer.parseInt(scanner.nextLine());
                    System.out.println("bet amount: " + betAmount);
                    System.out.println("user total: " + totalamount);

                    if (betAmount > userTotal) {
                        System.out.println(userTotal);
                        System.out.println("you shminga\nyou absolute shminga\nyou don't have the funds\nDeleting system 32...........................");
                        bettingOver = true;
                        break;
                    }
                    System.out.println("Bet amount: "+betAmount);
                    System.out.println("best of luck\n");
                    System.out.println("Dealer handing out cards........");
                    Random random = new Random();

                    String greenColor = "\u001B[32m";
                    String resetColor = "\u001B[0m";

                    int randomNumber = random.nextInt(52) + 1;
                    userHands[0] = (randomNumber);
                    NumToCard(randomNumber);
                    System.out.println("User card 1: "+ greenColor + numValue + " of " + faceValue + resetColor);
                    UserTotalBJV = BJValue;

                    int randomNumber2;
                    do{
                        randomNumber2 = random.nextInt(52) + 1;
                    } while (randomNumber2 == randomNumber);
                    userHands[1] = (randomNumber2);
                    NumToCard(randomNumber2);
                    System.out.println("User card 2: " + greenColor + numValue + " of " + faceValue + resetColor);
                    UserTotalBJV = UserTotalBJV + BJValue;

                    int randomNumber3;
                    do{
                        randomNumber3 = random.nextInt(52) + 1;
                    }while ((randomNumber3 == randomNumber2)||(randomNumber3 == randomNumber));
                    dealerHands[0] = (randomNumber3);
                    NumToCard(randomNumber3);
                    System.out.println("Dealer card 1: " + greenColor + numValue + " of " + faceValue + resetColor);
                    DealerTotalBJV = BJValue;

                    boolean BJend = false;
                    while (BJend == false){
                        System.out.println("What would you like to do?");
                        System.out.println("1 - Hit\n2 - Stay\n3 - Double Down");
                        System.out.print("> ");
                        int BJdec = Integer.parseInt(scanner.nextLine());
                        if (BJdec == 1){
                            int randomNumber4;
                            do{
                                randomNumber4 = random.nextInt(52) + 1;
                            } while (randomNumber4 == randomNumber3 || randomNumber4 == randomNumber2 || randomNumber4 == randomNumber);
                            userHands[2] = (randomNumber4);

                            NumToCard(randomNumber4);
                            System.out.println("User card 3: " + greenColor + numValue + " of " + faceValue + resetColor);
                        }

                    }


                }

            }
            System.out.println("dog you're not logged in");
        }

    }

    public static void NumToCard(int num) {
        if (num == 1){
            numValue = "Ace";
            faceValue = "Heart";
            BJValue = 1;
        }
        if (num >= 2 && num <= 10) {
            numValue = String.valueOf(num);
            faceValue = "Heart";
            BJValue = num;
        }
        if (num == 11) {
            numValue = "Jack";
            faceValue = "Heart";
            BJValue = 10;
        }
        if (num == 12) {
            numValue = "Queen";
            faceValue = "heart";
            BJValue = 10;
        }
        if (num == 13) {
            numValue = "King";
            faceValue = "heart";
            BJValue = 10;
        }
        if (num >= 14 && num <= 26) {
            num = num - 13;
            if (num == 1){
                numValue = "Ace";
                faceValue = "Diamonds";
                BJValue = 1;
            }
            if (num >= 2 && num <= 10) {
                numValue = String.valueOf(num);
                faceValue = "Diamonds";
                BJValue = num;
            }
            if (num == 11) {
                numValue = "Jack";
                faceValue = "Diamonds";
                BJValue = 10;
            }
            if (num == 12) {
                numValue = "Queen";
                faceValue = "Diamonds";
                BJValue = 10;
            }
            if (num == 13) {
                numValue = "King";
                faceValue = "Diamonds";
                BJValue = 10;
            }
        }
        if (num >= 27 && num <= 39) {
            num = num - 26;
            if (num == 1){
                numValue = "Ace";
                faceValue = "Spades";
                BJValue = 1;
            }
            if (num >= 2 && num <= 10) {
                numValue = String.valueOf(num);
                faceValue = "Spades";
                BJValue = num;
            }
            if (num == 11) {
                numValue = "Jack";
                faceValue = "Spades";
                BJValue = 10;
            }
            if (num == 12) {
                numValue = "Queen";
                faceValue = "Spades";
                BJValue = 10;
            }
            if (num == 13) {
                numValue = "King";
                faceValue = "Spades";
                BJValue = 10;
            }
        }
        if (num >= 40 && num <= 52) {
            num = num - 39;
            if (num == 1){
                numValue = "Ace";
                faceValue = "Clubs";
                BJValue = 1;
            }
            if (num >= 2 && num <= 10) {
                numValue = String.valueOf(num);
                faceValue = "Clubs";
                BJValue = num;
            }
            if (num == 11) {
                numValue = "Jack";
                faceValue = "Clubs";
                BJValue = 10;
            }
            if (num == 12) {
                numValue = "Queen";
                faceValue = "Clubs";
                BJValue = 10;
            }
            if (num == 13) {
                numValue = "King";
                faceValue = "Clubs";
                BJValue = 10;
            }
        }


    }
}

