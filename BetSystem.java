import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BetSystem {
    static String userName;static String userPass;static int userTotal;static String faceValue;static String numValue;static int BJValue;static int UserTotalBJV;static int DealerTotalBJV;
    static String userFind;static int randomNumber2;static int randomNumber3;static int randomNumber;static int randomNumber4;static boolean Dealergg = false; static boolean bettingOver = false; static boolean stop = false;
    static boolean aceChoice = false; static List<Integer> warUserOne = new ArrayList<>();;static boolean redoInt = false;static ArrayList<Integer> warComputer = new ArrayList<>();;static List<Integer> TotalWarHands = new ArrayList<>();
    static int warValue; static int totalamount = 0; static int betAmount = 0;static String filePath = "BetLogins.txt";static String greenColor = "\u001B[32m";static String resetColor = "\u001B[0m";
    static boolean dealerCard = false;

    public static void main() throws IOException {
        System.out.println("Welcome to the Clam Betting Arena\nThis will have things continually being added\n");
        System.out.println("Sign up or Login in\n\n1 - Create a account\n2 - Login ");
        System.out.print("> ");
        Scanner scanner = new Scanner(System.in);
        int BetSel = Integer.parseInt(scanner.nextLine());
        boolean loggedIn = false;

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
            userFind = scanner.nextLine();
            String fileName = "BetLogins.txt";
            String line;
            int lineReader = 0;

            try {
                FileReader fileReader = new FileReader(fileName);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                boolean reader = false;
                while (reader == false) {
                    line = bufferedReader.readLine();
                    lineReader++;
                    try{
                        if (line.equals(userFind)) {
                            if((lineReader+2)%3==0){
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
                                }else{
                                    System.out.println("Invalid Password");
                                    System.exit(0);
                                }
                            } else{
                                System.out.println("you really tried to enter your password");
                            }
                            }

                    } catch (NullPointerException e) {
                        System.out.println("Invalid Login");
                        System.exit(0);
                    }
                }
            } catch (IOException ignored) {

            }

        }

        while (!bettingOver) {

            if (loggedIn) {
                totalamount = userTotal;
                betAmount = 0;
                System.out.println("\nLoading content.......................");
                System.out.println("What would you like to play?");
                System.out.println("1 - Blackjack\n2 - Number Guesser\n3 - War\n4 - Poker\n5 - Quit");
                System.out.print("> ");
                int betSelect = Integer.parseInt(scanner.nextLine());
                if (betSelect == 1) {
                    BlackJack();
                }
                if (betSelect == 2){
                    numberGuesser();
                }
                if (betSelect == 3){
                    playWar();
                }
                if (betSelect == 4){
                    playPoker();
                }
                if (betSelect == 5){
                    System.out.println("Thank you for playing");
                    System.exit(0);
                }
                aceChoice = false;
            }
        }

    }

    public static void NumToCard(int num) {
        if(num<14){
            warValue = num;
        }
        if (num == 1){

            numValue = "Ace";
            faceValue = "Heart";
            BJValue = 1;
            if(!dealerCard){
                aceChoice = true;
            }


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
            warValue = num;
            if (num == 1){
                numValue = "Ace";
                faceValue = "Diamonds";
                BJValue = 1;
                aceChoice = true;
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
            warValue = num;
            if (num == 1){
                numValue = "Ace";
                faceValue = "Spades";
                BJValue = 1;
                aceChoice = true;
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
            warValue = num;
            if (num == 1){
                numValue = "Ace";
                faceValue = "Clubs";
                BJValue = 1;
                aceChoice = true;
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
    public static void NewTotal(String targetString, int NewUserBal) {

        String newContent = String.valueOf(NewUserBal);

        // Input file
        File inputFile = new File("BetLogins.txt");

        try (RandomAccessFile file = new RandomAccessFile(inputFile, "rw")) {
            String line;
            long targetPosition;

            while ((line = file.readLine()) != null) {

                if (line.equals(targetString)) {
                    file.readLine();
                    targetPosition = file.getFilePointer();
                    file.seek(targetPosition);
                    file.writeBytes(newContent);
                    break;
                }

            }
        } catch (IOException ignored) {

        }
    }
    public static void WarCardCheck(int numCheck){
        redoInt = false;
        for (Integer totalWarHand : TotalWarHands) {
            if (totalWarHand == numCheck) {
                redoInt = true;
                break;
            }
        }
    }
    public static void PrintPokerAmount(int betAmount){
        int BlackChips = 5;
        int RedChips = 0;
        int BlueChips = 0;
        int WhiteChips = 0;

    }


    public static void BlackJack(){
        Scanner scanner = new Scanner(System.in);

        int[] userHands = new int[4];
        int[] dealerHands = new int[3];
        System.out.println("Welcome to Black Jack");
        System.out.println("Enter bet amount: ");
        System.out.print("> ");
        betAmount = Integer.parseInt(scanner.nextLine());
        System.out.println("user total: " + totalamount);
        System.out.println("bet amount: " + betAmount);


        if (betAmount > userTotal) {
            System.out.println(userTotal);
            System.out.println("you shminga\nyou absolute shminga\nyou don't have the funds\nDeleting system 32...........................");
            System.exit(0);
        }

        System.out.println("\nbest of luck\n");
        System.out.println("Dealer handing out cards........");
        Random random = new Random();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException ignored) {}


        randomNumber = random.nextInt(52) + 1;
        userHands[0] = (randomNumber);
        NumToCard(randomNumber);
        System.out.println("User card 1: "+ greenColor + numValue + " of " + faceValue + resetColor);
        UserTotalBJV = BJValue;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {}


        do{
            randomNumber2 = random.nextInt(52) + 1;
        } while (randomNumber2 == randomNumber);
        userHands[1] = (randomNumber2);
        NumToCard(randomNumber2);
        System.out.println("User card 2: " + greenColor + numValue + " of " + faceValue + resetColor+"\n");
        UserTotalBJV = UserTotalBJV + BJValue;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {}


        do{
            randomNumber3 = random.nextInt(52) + 1;
        }while ((randomNumber3 == randomNumber2)||(randomNumber3 == randomNumber));
        dealerHands[0] = (randomNumber3);
        dealerCard = true;
        NumToCard(randomNumber3);
        dealerCard = false;
        System.out.println("Dealer card 1: " + greenColor + numValue + " of " + faceValue + resetColor+"\n");
        DealerTotalBJV = BJValue;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {}

        boolean BJend = false;
        while (!BJend){
            System.out.println("What would you like to do?");
            if (aceChoice){
                System.out.println("Would you like you ace to count as a 1 or an 11");
                System.out.print("> ");
                int aceInput = Integer.parseInt(scanner.nextLine());
                if(aceInput == 11){
                    userTotal = (userTotal+10);
                }
            }
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
                UserTotalBJV = UserTotalBJV + BJValue;
                System.out.println("User card 3: " + greenColor + numValue + " of " + faceValue + resetColor);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ignored) {}
                if(UserTotalBJV > 21){
                    System.out.println("Game over");
                    BJend = true;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ignored) {}

                    userTotal = userTotal - betAmount;
                    NewTotal(userFind,userTotal);
                    System.out.println("New account balance: " + greenColor + userTotal + resetColor);
                    break;
                }

            }
            if (BJdec == 2){
                int DealerCardNum = 0;
                BJend = true;
                int counter = 1;
                while(DealerTotalBJV <= 17){
                    counter++;
                    do{
                        randomNumber4 = random.nextInt(52) + 1;
                    }while ((randomNumber4 == randomNumber3)||(randomNumber4 == randomNumber2)||randomNumber4 == randomNumber);
                    dealerHands[1] = (randomNumber4);
                    dealerCard = true;
                    NumToCard(randomNumber4);
                    dealerCard = false;
                    int temptemp = DealerTotalBJV + BJValue;
                    Dealergg = false;
                    if (temptemp > 21){
                        System.out.println("Dealer card "+counter+": " + greenColor + numValue + " of " + faceValue + resetColor);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ignored) {}
                        System.out.println("Dealer busted");

                        System.out.println("you win");
                        userTotal = userTotal + betAmount;
                        NewTotal(userFind,userTotal);
                        System.out.println("New account balance: " + greenColor + userTotal + resetColor);
                        Dealergg = true;
                        break;
                    }
                    if (!Dealergg){
                        System.out.println("Dealer card "+counter+": " + greenColor + numValue + " of " + faceValue + resetColor);
                        DealerTotalBJV = DealerTotalBJV + BJValue;
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ignored) {}
                    }

                }

                if (UserTotalBJV > DealerTotalBJV && !Dealergg){
                    System.out.println("you have won!");
                    userTotal = userTotal + betAmount;
                    NewTotal(userFind,userTotal);
                    System.out.println("New account balance: " + greenColor + userTotal + resetColor);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException ignored) {}
                }
                if (UserTotalBJV < DealerTotalBJV && !Dealergg){
                    System.out.println("You have lost");
                    userTotal = userTotal - betAmount;
                    NewTotal(userFind,userTotal);
                    System.out.println("New account balance: " + greenColor + userTotal +resetColor);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException ignored) {}
                }
                if (UserTotalBJV == DealerTotalBJV && !Dealergg){
                    System.out.println("Draw");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException ignored) {}
                }
            }

        }


    }
    public static void numberGuesser(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the number guesser!\n");
        System.out.println("Select the range of numbers to choose from");
        System.out.println("The higher the range of numbers, the higher the payout will be");
        System.out.println("Ex. choosing 0 to 4 will give you a 1:4 payout\n");
        System.out.print("Enter in bet amount: ");
        int guesserBet = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter in range of number: From 0 to ");
        int guesserRange = Integer.parseInt(scanner.nextLine());
        System.out.print("Wager odds -> 1:"+(guesserRange+1)+"\n");
        Random random = new Random();
        int grandomNumber = random.nextInt(guesserRange+1);
        System.out.print("Enter in your guess: ");
        int guesserInput = Integer.parseInt(scanner.nextLine());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ignored) {}
        if(guesserInput > guesserRange){
            System.out.println("Your guess was higher than the range of numbers set");
            stop = true;
        }
        if(!stop){
            if (grandomNumber == guesserInput){
                System.out.println("Good shit");
                int guesserTemp = guesserBet * (guesserRange+1);
                userTotal = userTotal + guesserTemp;
                NewTotal(userFind,userTotal);
                System.out.println("Bet won: "+guesserTemp);
                System.out.println("New user total: "+ greenColor + userTotal + resetColor);

            }else{
                System.out.println("L\nBet lost");
                userTotal = userTotal - guesserBet;
                NewTotal(userFind,userTotal);
                System.out.println("New user total: "+ greenColor + userTotal + resetColor);
            }
        }



    }
    public static void playWar(){
        boolean warGame = true;

        System.out.println("Welcome to War\n");
        System.out.println("Splitting up deck........");

        Random random = new Random();
        int warRandom = (random.nextInt(52))+1;
        warUserOne.add(warRandom);
        TotalWarHands.add(warRandom);
        int warRandom1 = -1;

        for(int i = 1;i<26;i++){
            do{
                warRandom1 = (random.nextInt(52))+1;
                WarCardCheck(warRandom1);
            }while(redoInt);
            warUserOne.add(warRandom1);
            TotalWarHands.add(warRandom1);
        }

        for(int i = 1;i<26;i++){
            do{
                warRandom1 = (random.nextInt(52))+1;
                WarCardCheck(warRandom1);
            }while(redoInt);
            warComputer.add(warRandom1);
            TotalWarHands.add(warRandom1);
        }
        int i =0;
        while (warGame){
            System.out.println("\nCards have been dealt.....................");
            System.out.println("Starting play.....");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ignored) {}

            boolean warOver = false;

            while(warOver == false){
                int warHandPrint = warUserOne.get(i);
                NumToCard(warHandPrint);
                int warUserValue = warValue;
                System.out.println("User Card: "+numValue+" of "+faceValue);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ignored) {}
                int warHandPrint2 = warComputer.get(i);
                NumToCard(warHandPrint2);
                int warCompValue = warValue;
                System.out.println("Computer Card: "+numValue+" of "+faceValue+"\n");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ignored){}

                if(warUserValue > warCompValue){
                    System.out.println("You have Won this round!\nCard added to inventory");
                    int temptemp = i+26;
                    warUserOne.add(warComputer.get(i));
                    warComputer.remove(i);
                    System.out.println("Getting cards for next round.......\n");
                    warOver = true;
                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException ignored) {}
                }
                if(warUserValue < warCompValue){
                    System.out.println("You have Lost this round\nCard removed from inventory");
                    int temptemp = i+26;
                    warComputer.add(warUserOne.get(i));
                    warUserOne.remove(i);
                    System.out.println("Getting cards for next round.......\n");
                    warOver = true;
                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException ignored) {}
                }
                if(warUserValue == warCompValue){
                    System.out.println("WAR!!!!");
                    warOver = true;
                    int warHandPrintA = warUserOne.get(i+1);
                    NumToCard(warHandPrintA);
                    int warUserValueA = warValue;
                    System.out.println("User Card #2: "+numValue+" of "+faceValue);
                    int warHandPrintB = warComputer.get(i+1);
                    NumToCard(warHandPrintB);
                    int warCompValueB = warValue;
                    System.out.println("Computer Card #3: "+numValue+" of "+faceValue+"\n");
                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException ignored) {}
                    if(warUserValueA > warCompValueB){
                        System.out.println("You have Won the war!\nCards added to inventory");
                        warUserOne.set(i, warComputer.get(i));
                        int temptemp = i+1;
                        warUserOne.set(temptemp, warComputer.get(i));
                        warComputer.remove(i);
                        System.out.println("Getting cards for next round.......\n");
                    }
                    if(warUserValueA < warCompValueB){
                        System.out.println("You have Lost the war\nCards removed from inventory");
                        warComputer.set(i, warUserOne.get(i));
                        int temptemp = i+1;
                        warComputer.set(temptemp, warUserOne.get(i));
                        warUserOne.remove(i);
                        System.out.println("Getting cards for next round.......\n");
                    }

                }

            }
            if (warUserOne.size() == 51){
                System.out.println("THE USER HAS WON THE GAME");
                warGame = false;
            }
            if (warComputer.size() == 51){
                System.out.println("THE COMPUTER HAS WON THE GAME");
                warGame = false;
            }
            i++;
        }

    }
    public static void playPoker(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Poker");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {}
        do{
            System.out.println("Enter bet amount, must be in 1000's:");
            System.out.print("> ");
            betAmount = Integer.parseInt(scanner.nextLine());
        }while(betAmount % 1000 != 0);

        PrintPokerAmount(betAmount);

    }

}

