import java.io.*;
import java.util.*;

public class BetSystem {
    static String userName;static String userPass;static int userTotal;static String faceValue;static String numValue;static int BJValue;static int UserTotalBJV;static int DealerTotalBJV;
    static String userFind;static int randomNumber2;static int randomNumber3;static int randomNumber;static int randomNumber4;static boolean Dealergg = false; static boolean bettingOver = false; static boolean stop = false;
    static boolean aceChoice = false; static List<Integer> warUserOne = new ArrayList<>();;static boolean redoInt = false;static ArrayList<Integer> warComputer = new ArrayList<>();;static List<Integer> TotalWarHands = new ArrayList<>();
    static int warValue; static int totalamount = 0; static int betAmount = 0;static String filePath = "BetLogins.txt";static String greenColor = "\u001B[32m";static String resetColor = "\u001B[0m";
    static boolean dealerCard = false; static boolean GotFirstNum = false;public static HashSet<Integer> CardNumHolder = new HashSet<>(); static boolean DealerAce = false;static boolean initialized = false;
    static int[] userChips = new int[5];static String redText = "\u001B[31m";static String blueText = "\u001B[34m"; static String whiteText = "\u001B[37m";static int[] botOneChips = new int[5];static int[] botTwoChips = new int[5];
    static int UserPokerHandOne = 0;static int UserPokerHandTwo = 0; static int BotOnePokerHand1 =0; static int BotOnePokerHand2 =0;static int BotTwoPokerHand1 =0; static int BotTwoPokerHand2 =0; static int pokerPotTotal = 0;
    static int[] PokerRiver = new int[4];

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
            System.exit(0);
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
                    CardNumHolder.clear();
                    BlackJack();
                }
                if (betSelect == 2){
                    CardNumHolder.clear();
                    numberGuesser();
                }
                if (betSelect == 3){
                    CardNumHolder.clear();
                    playWar();
                }
                if (betSelect == 4){
                    CardNumHolder.clear();
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
            if(!dealerCard) {
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
                if(!dealerCard){
                    aceChoice = true;
                }
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
                if(!dealerCard) {
                    aceChoice = true;
                }

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
                if(!dealerCard) {
                    aceChoice = true;
                }
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
    public static int GetUniqueNum(){
        Random random = new Random();
        int randomNumber;
        if(!GotFirstNum){
            randomNumber = random.nextInt(52)+1;
            CardNumHolder.add(randomNumber);
            GotFirstNum = true;
        }else{
            do {
                randomNumber = random.nextInt(52)+1;
            } while (CardNumHolder.contains(randomNumber));
            CardNumHolder.add(randomNumber);
        }
        return randomNumber;
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
    public static void PrintPokerAmount(int decider){
        if(decider == 1){
            System.out.println("USER");
            System.out.println(greenColor+"Green Chips (Worth $500) -> "+userChips[3]+resetColor);
            System.out.println(redText+"Red Chips (Worth $100) -> "+userChips[2]+resetColor);
            System.out.println(blueText+"Blue Chips (Worth $50) -> "+userChips[1]+resetColor);
            System.out.println(whiteText+"White Chips (Worth $10) -> "+userChips[0]+resetColor);
        }
        if(decider == 2){
            System.out.println(  "COMPUTER ONE---------------------COMPUTER TWO");
            System.out.println(greenColor+"Green Chips -> "+botOneChips[3]+"\tGreen Chips -> "+botOneChips[3]+resetColor);
            System.out.println(redText+"Red Chips -> "+botOneChips[2]+"\tRed Chips -> "+botOneChips[2]+resetColor);
            System.out.println(blueText+"Blue Chips -> "+botOneChips[1]+"\tBlue Chips -> "+botOneChips[1]+resetColor);
            System.out.println(whiteText+"White Chips -> "+botOneChips[0]+"\tWhite Chips -> "+botOneChips[0]+resetColor);
        }
        if(decider == 3){
            System.out.println("USER");
            System.out.println(greenColor+"Green Chips (Worth $500) -> "+userChips[3]+resetColor);
            System.out.println(redText+"Red Chips (Worth $100) -> "+userChips[2]+resetColor);
            System.out.println(blueText+"Blue Chips (Worth $50) -> "+userChips[1]+resetColor);
            System.out.println(whiteText+"White Chips (Worth $10) -> "+userChips[0]+resetColor);
            System.out.println("\nCOMPUTER ONE---------------------COMPUTER TWO");
            System.out.println(greenColor+"Green Chips -> "+botOneChips[3]+"\tGreen Chips -> "+botOneChips[3]+resetColor);
            System.out.println(redText+"Red Chips -> "+botOneChips[2]+"\tRed Chips -> "+botOneChips[2]+resetColor);
            System.out.println(blueText+"Blue Chips -> "+botOneChips[1]+"\tBlue Chips -> "+botOneChips[1]+resetColor);
            System.out.println(whiteText+"White Chips -> "+botOneChips[0]+"\tWhite Chips -> "+botOneChips[0]+resetColor);
        }


    }
    public static void BotChipSetup(){
        int temptemp = (betAmount / 1000)+1;
        int GreenChips = temptemp;         //500  3
        int RedChips = 3 * temptemp;       //100  2
        int BlueChips = 3 * temptemp;      //50   1
        int WhiteChips = 5 * temptemp;     //10   0
        botOneChips[0] = WhiteChips;botOneChips[1] = BlueChips;botOneChips[2] = RedChips;botOneChips[3] = GreenChips;
        botTwoChips[0] = WhiteChips;botTwoChips[1] = BlueChips;botTwoChips[2] = RedChips;botTwoChips[3] = GreenChips;
        botOneChips[4] = (WhiteChips*10)+(BlueChips*50)+(RedChips*100)+(GreenChips*500);
        botTwoChips[4] = (WhiteChips*10)+(BlueChips*50)+(RedChips*100)+(GreenChips*500);

    }

    public static void PlayersBetAmount(int id, int betAmount){
        int temptemp1 = 0;
        int tempGreenChips = 0;
        if (betAmount / 500 >= 1) {
            tempGreenChips = betAmount / 500;
            temptemp1 = betAmount % 500;
            if(id == 1){
                userChips[3] = userChips[3]-tempGreenChips;
            }
            if(id == 2){
               botOneChips[3] = botOneChips[3]-tempGreenChips;
            }
            if(id == 3){
                botTwoChips[3] = botTwoChips[3]-tempGreenChips;
            }
            if(id == 4){
                userChips[3] = userChips[3]-tempGreenChips;
                botOneChips[3] = botOneChips[3]-tempGreenChips;
                botTwoChips[3] = botTwoChips[3]-tempGreenChips;
            }
        } else {
            temptemp1 = betAmount;
        }
        int temptemp2 = 0;
        int tempRedChips = 0;
        if (temptemp1 / 100 >= 1) {
            tempRedChips = temptemp1 / 100;
            temptemp2 = temptemp1 % 100;
            if(id == 1){
                userChips[2] = userChips[2]-tempRedChips;
            }
            if(id == 2){
                botOneChips[2] = botOneChips[2]-tempRedChips;
            }
            if(id == 3){
                botTwoChips[2] = botTwoChips[2]-tempRedChips;
            }
            if(id == 4){
                userChips[2] = userChips[2]-tempRedChips;
                botOneChips[2] = botOneChips[2]-tempRedChips;
                botTwoChips[2] = botTwoChips[2]-tempRedChips;
            }
        } else {
            temptemp2 = temptemp1;
        }
        int temptemp3 = 0;
        int tempBlueChips = 0;
        if (temptemp2 / 50 >= 1) {
            tempBlueChips = temptemp2 / 50;
            temptemp3 = temptemp2 % 50;
            if(id == 1){
                userChips[1] = userChips[1]-tempBlueChips;
            }
            if(id == 2){
                botOneChips[1] = botOneChips[1]-tempBlueChips;
            }
            if(id == 3){
                botTwoChips[1] = botTwoChips[1]-tempBlueChips;
            }
            if(id == 4){
                userChips[1] = userChips[1]-tempBlueChips;
                botOneChips[1] = botOneChips[1]-tempBlueChips;
                botTwoChips[1] = botTwoChips[1]-tempBlueChips;
            }
        }else{
            temptemp3 = temptemp2;
        }
        int tempWhiteChips = 0;
        if (temptemp3 / 10 >= 1) {
            tempWhiteChips = temptemp3 / 10;
            if(id == 1){
                userChips[0] = userChips[0]-tempWhiteChips;
            }
            if(id == 2){
                botOneChips[0] = botOneChips[0]-tempWhiteChips;
            }
            if(id == 3){
                botTwoChips[0] = botTwoChips[0]-tempWhiteChips;
            }
            if(id == 4){
                userChips[0] = userChips[0]-tempWhiteChips;
                botOneChips[0] = botOneChips[0]-tempWhiteChips;
                botTwoChips[0] = botTwoChips[0]-tempWhiteChips;
            }
        }
        if(id == 1) {
            System.out.println("Player has bet: ");
            if(tempGreenChips!=0){
                System.out.println("Green chips -> " + tempGreenChips);
            }
            if(tempRedChips!=0) {
                System.out.println("Red chips -> " + tempRedChips);
            }
            if(tempBlueChips!=0){
                System.out.println("Blue chips -> " + tempBlueChips);
            }
            if(tempWhiteChips!=0){
                System.out.println("White chips -> " + tempWhiteChips);
            }
            pokerPotTotal = pokerPotTotal + (tempGreenChips*500) + (tempRedChips*100) + (tempBlueChips*50) + (tempWhiteChips*10);

        }
        if(id == 2){
            System.out.println("\nComputer 1 has bet: ");
            if(tempGreenChips!=0){
                System.out.println("Green chips -> " + tempGreenChips);
            }
            if(tempRedChips!=0) {
                System.out.println("Red chips -> " + tempRedChips);
            }
            if(tempBlueChips!=0){
                System.out.println("Blue chips -> " + tempBlueChips);
            }
            if(tempWhiteChips!=0){
                System.out.println("White chips -> " + tempWhiteChips);
            }
            pokerPotTotal = pokerPotTotal + (tempGreenChips*500) + (tempRedChips*100) + (tempBlueChips*50) + (tempWhiteChips*10);
            System.out.println("Pot total: "+pokerPotTotal);
        }
        if(id == 3){
            System.out.println("\nComputer 2 has bet: ");
            if(tempGreenChips!=0){
                System.out.println("Green chips -> " + tempGreenChips);
            }
            if(tempRedChips!=0) {
                System.out.println("Red chips -> " + tempRedChips);
            }
            if(tempBlueChips!=0){
                System.out.println("Blue chips -> " + tempBlueChips);
            }
            if(tempWhiteChips!=0){
                System.out.println("White chips -> " + tempWhiteChips);
            }
            pokerPotTotal = pokerPotTotal + (tempGreenChips*500) + (tempRedChips*100) + (tempBlueChips*50) + (tempWhiteChips*10);
            System.out.println("Pot total: "+pokerPotTotal);
        }
        if(id == 4){
            System.out.println("Player has bet: ");
            if(tempGreenChips!=0){
                System.out.println("Green chips -> " + tempGreenChips);
            }
            if(tempRedChips!=0) {
                System.out.println("Red chips -> " + tempRedChips);
            }
            if(tempBlueChips!=0){
                System.out.println("Blue chips -> " + tempBlueChips);
            }
            if(tempWhiteChips!=0){
                System.out.println("White chips -> " + tempWhiteChips);
            }
            System.out.println("\nComputer 1 has bet: ");
            if(tempGreenChips!=0){
                System.out.println("Green chips -> " + tempGreenChips);
            }
            if(tempRedChips!=0) {
                System.out.println("Red chips -> " + tempRedChips);
            }
            if(tempBlueChips!=0){
                System.out.println("Blue chips -> " + tempBlueChips);
            }
            if(tempWhiteChips!=0){
                System.out.println("White chips -> " + tempWhiteChips);
            }
            System.out.println("\nComputer 2 has bet: ");
            if(tempGreenChips!=0){
                System.out.println("Green chips -> " + tempGreenChips);
            }
            if(tempRedChips!=0) {
                System.out.println("Red chips -> " + tempRedChips);
            }
            if(tempBlueChips!=0){
                System.out.println("Blue chips -> " + tempBlueChips);
            }
            if(tempWhiteChips!=0){
                System.out.println("White chips -> " + tempWhiteChips);
            }
            pokerPotTotal = pokerPotTotal + (tempGreenChips*1500) + (tempRedChips*300) + (tempBlueChips*150) + (tempWhiteChips*30);
            System.out.println("Pot total: "+pokerPotTotal);
        }


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


        randomNumber = GetUniqueNum();
        userHands[0] = (randomNumber);
        NumToCard(randomNumber);
        System.out.println("User card 1: "+ greenColor + numValue + " of " + faceValue + resetColor);
        UserTotalBJV = BJValue;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {}


        randomNumber2 = GetUniqueNum();
        userHands[1] = (randomNumber2);
        NumToCard(randomNumber2);
        System.out.println("User card 2: " + greenColor + numValue + " of " + faceValue + resetColor+"\n");
        UserTotalBJV = UserTotalBJV + BJValue;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {}



        randomNumber3 = GetUniqueNum();
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

            System.out.println("1 - Hit\n2 - Stay\n3 - Double Down");
            System.out.print("> ");
            int BJdec = Integer.parseInt(scanner.nextLine());
            if (BJdec == 1){
                int randomNumber4;

                randomNumber4 = GetUniqueNum();
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
                if (aceChoice){
                    System.out.println("Would you like your ace to count as a 1 or an 11");
                    System.out.print("> ");
                    int aceInput = Integer.parseInt(scanner.nextLine());
                    if(aceInput == 11){
                        userTotal = (userTotal+10);
                    }
                }
                int DealerCardNum = 0;
                BJend = true;
                int counter = 1;
                while(DealerTotalBJV <= 17){
                    counter++;
                    randomNumber4 = GetUniqueNum();
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
        System.out.print("Wager odds -> 1:"+(guesserRange)+"\n");
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
                System.out.println(grandomNumber+" was the number");
                int guesserTemp = guesserBet * (guesserRange+1);
                userTotal = userTotal + guesserTemp;
                NewTotal(userFind,userTotal);
                System.out.println("Bet won: "+guesserTemp);
                System.out.println("New user total: "+ greenColor + userTotal + resetColor);

            }else{
                System.out.println("L\nBet lost");
                System.out.println(grandomNumber+" was the number");
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
            warRandom1 = GetUniqueNum();
            warUserOne.add(warRandom1);
            TotalWarHands.add(warRandom1);
        }

        for(int i = 1;i<26;i++){
            warRandom1 = GetUniqueNum();
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

            while(!warOver){
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
            Thread.sleep(500);
        } catch (InterruptedException ignored) {}
        do{
            System.out.println("Enter bet amount, must be in 1000's:");
            System.out.print("> ");
            betAmount = Integer.parseInt(scanner.nextLine());
        }while(betAmount % 1000 != 0);

        if(betAmount>userTotal){
            System.out.println("you minga dinga. dont got the funds");
            System.exit(0);
        }


        int temptemp = betAmount / 1000;
        int GreenChips = temptemp;         //500  3
        int RedChips = 3 * temptemp;       //100  2
        int BlueChips = 3 * temptemp;      //50   1
        int WhiteChips = 5 * temptemp;     //10   0
        userChips[0] = WhiteChips;
        userChips[1] = BlueChips;
        userChips[2] = RedChips;
        userChips[3] = GreenChips;
        userChips[4] = (WhiteChips*10)+(BlueChips*50)+(RedChips*100)+(GreenChips*500);

        System.out.println("Here are your current chips..........\n");
        PrintPokerAmount(1);

        try {
            Thread.sleep(1500);
        } catch (InterruptedException ignored) {}

        System.out.println("here are the Computer player's chips");
        PrintPokerAmount(2);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException ignored) {}
        System.out.println("Dealing.......");

        UserPokerHandOne = GetUniqueNum();
        NumToCard(UserPokerHandOne);
        System.out.println(greenColor +"User card one: "+resetColor+numValue+" of "+faceValue);

        BotOnePokerHand1 = GetUniqueNum();

        BotTwoPokerHand1 = GetUniqueNum();

        UserPokerHandTwo = GetUniqueNum();
        NumToCard(UserPokerHandTwo);
        System.out.println(greenColor+"User card two: "+resetColor+numValue+" of "+faceValue);

        BotOnePokerHand2 = GetUniqueNum();

        BotTwoPokerHand2 = GetUniqueNum();
        System.out.println("Cards to all players have been dealt...............");

        BotChipSetup();

        try {
            Thread.sleep(1500);
        } catch (InterruptedException ignored) {}

        System.out.println("starting the first round of betting........\nAnte Up!");
        PlayersBetAmount(4,10);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {}

        System.out.println("Creating river");
        PokerRiver[0] = GetUniqueNum();
        NumToCard(PokerRiver[0]);
        System.out.println("River card one: "+numValue+" of "+faceValue);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {}

        PokerRiver[1] = GetUniqueNum();
        NumToCard(PokerRiver[1]);
        System.out.println("River card two: "+numValue+" of "+faceValue);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {}

        PokerRiver[2] = GetUniqueNum();
        NumToCard(PokerRiver[2]);
        System.out.println("River card three: "+numValue+" of "+faceValue);
        PrintPokerAmount(1);

        Scanner newScanner = new Scanner(System.in);
        System.out.println("Round one betting.........");
        System.out.println("How many chips would you like to bet?");
        System.out.print("Green chips -> ");
        int PokerUserChips = 500*(Integer.parseInt(newScanner.nextLine()));
        System.out.print("\nRed chips -> ");
        PokerUserChips =PokerUserChips+ 100*(Integer.parseInt(newScanner.nextLine()));
        System.out.print("\nBlue chips -> ");
        PokerUserChips = PokerUserChips+ 50*(Integer.parseInt(newScanner.nextLine()));
        System.out.println("\nWhite chips -> ");
        PokerUserChips= PokerUserChips+ 10*(Integer.parseInt(newScanner.nextLine()));
        pokerPotTotal = pokerPotTotal + PokerUserChips;

        try {
            Thread.sleep(1500);
        } catch (InterruptedException ignored) {}

        System.out.println("Computer one betting.......");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {}
        



    }

}

