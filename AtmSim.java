import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.List;

public class AtmSim {
    public static void main() throws FileNotFoundException {

        int AccountAddC = 0;


        System.out.println("Welcome to the ATM simulation");
        System.out.println("\n loading connection.......");
        System.out.println("Would you like to add an account or view/change an account?\nSelect 1 for adding an account and 2 for accessing");
        Scanner scanner = new Scanner(System.in);
        int userInp = Integer.parseInt(scanner.nextLine());
        if (userInp == 1) {
            String filePath = "ATMsim.txt";

            try {
                // Create a BufferedWriter for writing to the file
                BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true)); // Set 'true' to append to the file
                System.out.print("Type in your new account login: ");
                String userAcc = scanner.nextLine();
                System.out.print("Enter in your password: ");
                String userPass = scanner.nextLine();
                System.out.println("Is this correct: User(" + userAcc + ") Pass(" + userPass + ")");
                System.out.println("Y - Yes\nN - No");
                String userDec = scanner.nextLine();
                if (!userDec.equals("N")) {
                    writer.write(userAcc);
                    writer.newLine();

                    writer.write(userPass);
                    writer.newLine();
                    System.out.println("................Account created..............");
                    System.out.print("Enter fund amount: ");
                    String FundAmount = scanner.nextLine();
                    writer.write(FundAmount);
                    writer.newLine();
                    System.out.println("Account Established");
                }
                if (userDec == "N" || userDec == "n") {
                    System.out.println("Bruhhhh heres a bruhcoin");

                }
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
        if (userInp == 2) {
            System.out.print("Enter username: ");
            String userFind = scanner.nextLine();
            String fileName = "ATMsim.txt";
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
                        int Tuservalue = Integer.parseInt(bufferedReader.readLine());
                        System.out.print("Enter in password: ");
                        String Tpass = scanner.nextLine();
                        if (Tpass.equals(Tuserpass)) {
                            System.out.println("Account login successful!");
                            System.out.println("Current account value: " + Tuservalue);
                            System.out.println("Do you want to see your balance in different currencies?");
                            System.out.println("Y - Yes\nN - No");
                            String Tempdecide = scanner.nextLine();
                            if (!Tempdecide.equals("N")){
                                System.out.println("What currency would you like to convert into?");
                                System.out.println("1 - USD (United States Dollar)\n2 - EUR (Euro)");
                                System.out.println("3 - JPY (Japanese Yen)\n4 - GBP (British Pound Sterling\n5 - AUD (Australian Dollar)");
                                System.out.println("6 - CAD (Canadian Dollar)\n7 - CHF (Swiss Franc)\n8 - NZD (New Zealand Dollar)");
                                int temp = Integer.parseInt(scanner.nextLine());
                                CurrencyConverter.currconn(1,temp,Tuservalue);
                            }
                            }
                        }
                    }
                } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        }
    }
