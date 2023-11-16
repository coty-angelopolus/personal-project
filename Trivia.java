import java.util.Random;
import java.util.Scanner;

public class Trivia {
    static int[] tenNumbers = new int[10];
    static boolean checker = false;
    static boolean good2go = false;
    static String Solution;
    static String choice;
    static long startTime;
    static long endTime;
    static boolean solved = false;
    static long userPoints;
    static int fireStreak = 0;

    public static void main() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello and welcome to trivia");
        System.out.println("This project will include a working scoreboard that keeps the all time high score\nplus their time");
        System.out.println("\nINSTRUCTIONS");
        System.out.println("\nyou will be given 10 trivia questions\nyou will have 10 seconds to answer each question\n");
        System.out.println("The quicker you answer the question the more points you will get");
        GetTenNumbers();
        System.out.println("Click enter to start");
        scanner.nextLine();
        System.out.println("\nLoading questions.............");
        try {
            Thread.sleep(1500);
        } catch (InterruptedException ignored) {}

        long overallStartTime = System.currentTimeMillis();
        int i = 1;
        while(i<10){
            long tempTime = 0;
            QuestionGrabber(tenNumbers[i]);
            i++;
            System.out.print("Selection -> ");
            startTime = System.currentTimeMillis();
            choice = (scanner.nextLine()).toUpperCase();
            if (choice.equals(Solution)){
                System.out.println("You're Correct!");
                endTime = System.currentTimeMillis();
                tempTime = endTime - startTime;
                long tempscore = 10000 - tempTime;
                if(tempscore<0){
                    System.out.println("You took longer than 10 seconds");
                    System.out.println("0 points");
                    tempscore =0;
                }
                if(fireStreak >=4 && fireStreak<7){
                    long addtempScore = tempscore/4;
                    tempscore = tempscore + addtempScore;
                }
                if(fireStreak >=7){
                    long addtempScore = tempscore/2;
                    tempscore = tempscore + addtempScore;
                }
                System.out.println("You scored "+tempscore);
                if(fireStreak>=3){
                    System.out.println("Fire Streak: "+fireStreak+"!");
                }
                userPoints = userPoints + tempscore;
                System.out.println("\nTotal Player Score: "+userPoints);
                fireStreak = fireStreak + 1;
            }else{
                fireStreak = 0;
                System.out.println("That was incorrect");
                System.out.println("The correct answer was: "+Solution);
            }
            System.out.println("Loading next quesiton..........");
            try {
                Thread.sleep(1500);
            } catch (InterruptedException ignored) {}

        }
        System.out.println("\nGame over");
        System.out.println("\nTotal score: "+userPoints);
        long overallEndTime = System.currentTimeMillis();
        long tempSeshTime = overallEndTime - overallStartTime;
        System.out.println("total time to complete: "+(tempSeshTime/1000)+" seconds");
        System.out.println("Press enter to continue");
        scanner.nextLine();

    }
    public static void GetTenNumbers(){
        int i = 1;
        int tennums;
        Random random = new Random();
        tenNumbers[0] = random.nextInt(24)+1;
        while(i<10){
            do{
                tennums = random.nextInt(24)+1;
                TenNumsCheck(tennums);
            }while(!good2go);
            tenNumbers[i] = tennums;
            i++;
        }
    }
    public static void TenNumsCheck(int check){
        checker = false;
        good2go = false;
        for(int i = 0; i <tenNumbers.length;i++){
            if(check == tenNumbers[i]){
                checker = true;
            }
        }
        if(!checker){
            good2go = true;
        }

    }
    public static void QuestionGrabber(int question){
        if(question == 1){
            System.out.println("\nWhat is the capital of Australia?\n" + "\n" + "A) Sydney\n" + "B) Canberra\n" + "C) Melbourne\n" + "D) Brisbane");
            Solution = "B";
        } else if (question == 2) {
            System.out.println("\nWhich planet is known as the Red Planet?\n" + "\n" + "A) Venus\n" + "B) Mars\n" + "C) Jupiter\n" + "D) Saturn");
            Solution = "B";
        } else if (question == 3) {
            System.out.println("\nIn what year did the first manned moon landing occur?\n" + "\n" + "A) 1965\n" + "B) 1969\n" + "C) 1975\n" + "D) 1981");
            Solution = "B";
        } else if (question == 4) {
            System.out.println("\nWhich country is known as the Land of the Rising Sun?\n" + "\n" + "A) China\n" + "B) South Korea\n" + "C) Japan\n" + "D) Vietnam");
            Solution = "C";
        } else if (question == 5) {
            System.out.println("\nWhich planet is known as the \"Jewel of the Solar System\"?\n" + "\n" + "A) Earth\n" + "B) Jupiter\n" + "C) Venus\n" + "D) Saturn");
            Solution = "D";
        } else if (question == 6) {
            System.out.println("\nWhat is the smallest prime number?\n" + "\n" + "A) 1\n" + "B) 2\n" + "C) 3\n" + "D) 4");
            Solution = "B";
        } else if (question == 7) {
            System.out.println("\nWho wrote \"To Kill a Mockingbird\"?\n" + "\n" + "A) J.K. Rowling\n" + "B) Harper Lee\n" + "C) Ernest Hemingway\n" + "D) F. Scott Fitzgerald");
            Solution = "B";
        } else if (question == 8) {
            System.out.println("\nWhat is the largest species of big cat?\n" + "\n" + "A) Lion\n" + "B) Leopard\n" + "C) Tiger\n" + "D) Cheetah");
            Solution = "C";
        } else if (question == 9) {
            System.out.println("\nIn what year did the Titanic sink?\n" + "\n" + "A) 1912\n" + "B) 1905\n" + "C) 1931\n" + "D) 1923");
            Solution = "A";
        } else if (question == 10) {
            System.out.println("\nWho is known as the \"Father of Computers\"?\n" + "\n" + "A) Bill Gates\n" + "B) Steve Jobs\n" + "C) Charles Babbage\n" + "D) Alan Turing");
            Solution = "C";
        } else if (question == 11) {
            System.out.println("\nIn which year did the Chernobyl nuclear disaster occur?\n" + "A) 1980\n" + "B) 1975\n" + "C) 1991\n" + "D) 1986");
            Solution = "D";
        } else if (question == 12) {
            System.out.println("\nWhich chemical element has the symbol 'Fe' on the periodic table?\n" + "A) Iron\n" + "B) Gold\n" + "C) Silver\n" + "D) Copper");
            Solution = "A";
        } else if (question == 13) {
            System.out.println("\nIn Greek mythology, who is the goddess of wisdom and warfare?\n" + "A) Aphrodite\n" + "B) Hera\n" + "C) Athena\n" + "D) Demeter");
            Solution = "C";
        } else if (question == 14) {
            System.out.println("\nWhich country is the largest by land area?\n" + "A) Russia\n" + "B) Canada\n" + "C) China\n" + "D) United States");
            Solution = "A";
        } else if (question == 15) {
            System.out.println("\nWhich element is represented by the chemical symbol \"K\" on the periodic table?\n" + "A) Potassium\n" + "B) Calcium\n" + "C) Sodium\n" + "D) Iron");
            Solution = "A";
        } else if (question == 16) {
            System.out.println("\nIn what year did the Berlin Wall fall, marking the end of the Cold War?\n" + "A) 1985\n" + "B) 1989\n" + "C) 1991\n" + "D) 1979");
            Solution = "B";
        } else if (question == 17) {
            System.out.println("\nWhich planet is often referred to as the \"Morning Star\" or \"Evening Star\"?\n" + "A) Mercury\n" + "B) Venus\n" + "C) Mars\n" + "D) Jupiter");
            Solution = "B";
        } else if (question == 18) {
            System.out.println("\nWho is the protagonist in J.D. Salinger's novel \"The Catcher in the Rye\"?\n" + "A) Holden Caulfield\n" + "B) Jay Gatsby\n" + "C) Atticus Finch\n" + "D) Elizabeth Bennet");
            Solution = "A";
        } else if (question == 19) {
            System.out.println("\nWhich city is known as the \"City of Canals\"?\n" + "A) Rome\n" + "B) Amsterdam\n" + "C) Paris\n" + "D) Venice");
            Solution = "D";
        } else if (question == 20) {
            System.out.println("\nWhat is the largest ocean on Earth?\n" + "A) Atlantic Ocean\n" + "B) Indian Ocean\n" + "C) Southern Ocean\n" + "D) Pacific Ocean");
            Solution = "D";
        } else if (question == 21) {
            System.out.println("\nWhat is the currency of Japan?\n" + "A) Won\n" + "B) Yuan\n" + "C) Yen\n" + "D) Ringgit");
            Solution = "C";
        } else if (question == 22) {
            System.out.println("\nWhich famous scientist is known for his theory of evolution by natural selection?\n" + "A) Isaac Newton\n" + "B) Charles Darwin\n" + "C) Gregor Mendel\n" + "D) Louis Pasteur");
            Solution = "B";
        } else if (question == 23) {
            System.out.println("\nWhich mountain range is the longest in the world?\n" + "A) Himalayas\n" + "B) Rocky Mountains\n" + "C) Andes\n" + "D) Alps");
            Solution = "A";
        } else if (question == 24) {
            System.out.println("\nWhich planet is known as the \"Red Planet\" due to its reddish appearance?\n" + "A) Venus\n" + "B) Mars\n" + "C) Jupiter\n" + "D) Saturn");
            Solution = "B";
        } else if (question == 25) {
            System.out.println("\nWhich famous physicist formulated the theory of general relativity?\n" + "A) Isaac Newton\n" + "B) Albert Einstein\n" + "C) Stephen Hawking\n" + "D) Niels Bohr");
            Solution = "B";
        }
    }

}
