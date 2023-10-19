import java.util.Scanner;

public class CurrencyConverter {
    public static void main() {
        System.out.println("\nWelcome to the Currency Converter\n");
        System.out.println("1 - USD (United States Dollar)\n2 - EUR (Euro)");
        System.out.println("3 - JPY (Japanese Yen)\n4 - GBP (British Pound Sterling\n5 - AUD (Australian Dollar)");
        System.out.println("6 - CAD (Canadian Dollar)\n7 - CHF (Swiss Franc)\n8 - NZD (New Zealand Dollar)");
        System.out.println("Type the currency you have, followed by a space, and then type the currency you wanted to converted into");

        Scanner scanner = new Scanner(System.in);
        String curr = scanner.nextLine();
        String[] temp1 = curr.split(" ");
        int curr1 = Integer.parseInt(temp1[0]);
        int curr2 = Integer.parseInt(temp1[1]);
        System.out.print("enter amount of money: ");
        int moneyVal = Integer.parseInt(scanner.nextLine());
        currconn(curr1, curr2, moneyVal);
    }
        public static void currconn(int curr1, int curr2, int moneyVal){

        if (curr1 == 1){
            if (curr2 == 1){
                System.out.println("r u foooking dumb m8, thats the same currency");
            }
            if (curr2 == 2){
                double temp = moneyVal * 0.945;
                System.out.println("USD -> EURO: "+ moneyVal+" -> "+temp );
            }
            if (curr2 == 3){
                double temp = moneyVal * 149.76;
                System.out.println("USD -> JPY: "+ moneyVal+" -> "+temp );
            }
            if (curr2 == 4){
                double temp = moneyVal * 0.823;
                System.out.println("USD -> GBP: "+ moneyVal+" -> "+temp );
            }
            if (curr2 == 5){
                double temp = moneyVal * 1.575;
                System.out.println("USD -> AUD: "+ moneyVal+" -> "+temp );
            }
            if (curr2 == 6){
                double temp = moneyVal * 1.366;
                System.out.println("USD -> CAD: "+ moneyVal+" -> "+temp );
            }
            if (curr2 == 7){
                double temp = moneyVal * 0.901;
                System.out.println("USD -> CHF: "+ moneyVal+" -> "+temp );
            }
            if (curr2 == 8){
                double temp = moneyVal * 1.697;
                System.out.println("USD -> NZD: "+ moneyVal+" -> "+temp );
            }
        }
        if (curr1 == 2){
            if (curr2 == 1){
                double temp = USD(curr1, moneyVal);
                System.out.println("EURO -> USD: " + moneyVal + " -> "+temp);
            }
            if (curr2 == 2){
                System.out.println("r u foooking dumb m8, thats the same currency");
            }
            if (curr2 == 3){
                double jpytemp = USD(curr1, moneyVal);
                System.out.println("EURO -> JPY: " + moneyVal + " -> "+jpytemp*149.76);
            }
            if (curr2 == 4){
                double temp = USD(curr1, moneyVal);
                System.out.println("EURO -> GBP: " + moneyVal + " -> "+temp*0.823);
            }
            if (curr2 == 5){
                double temp = USD(curr1, moneyVal);
                System.out.println("EURO -> AUD: " + moneyVal + " -> "+temp*1.575);
            }
            if (curr2 == 6){
                double temp = USD(curr1, moneyVal);
                System.out.println("EURO -> CAD: " + moneyVal + " -> "+temp*1.366);
            }
            if (curr2 == 7){
                double temp = USD(curr1, moneyVal);
                System.out.println("EURO -> CHF: " + moneyVal + " -> "+temp*0.901);
            }
            if (curr2 == 8){
                double temp = USD(curr1, moneyVal);
                System.out.println("EURO -> NZD: " + moneyVal + " -> "+temp*1.697);
            }
        }
        if (curr1 == 3){
            if (curr2 == 1){
                double temp = USD(curr1, moneyVal);
                System.out.println("JPY -> GBP: " + moneyVal + " -> "+temp);
            }
            if (curr2 == 2){
                double temp = USD(curr1, moneyVal);
                System.out.println("JPY -> EUR: " + moneyVal + " -> "+temp*0.945);
            }
            if (curr2 == 3){
                System.out.println("r u foooking dumb m8, thats the same currency");
            }
            if (curr2 == 4){
                double temp = USD(curr1, moneyVal);
                System.out.println("JPY -> GBP: " + moneyVal + " -> "+temp*0.823);
            }
            if (curr2 == 5){
                double temp = USD(curr1, moneyVal);
                System.out.println("JPY -> AUD: " + moneyVal + " -> "+temp*1.575);
            }
            if (curr2 == 6){
                double temp = USD(curr1, moneyVal);
                System.out.println("JPY -> CAD: " + moneyVal + " -> "+temp*1.366);
            }
            if (curr2 == 7){
                double temp = USD(curr1, moneyVal);
                System.out.println("JPY -> CHF: " + moneyVal + " -> "+temp*0.901);
            }
            if (curr2 == 8){
                double temp = USD(curr1, moneyVal);
                System.out.println("JPY -> NZD: " + moneyVal + " -> "+temp*1.697);
            }
        }
        if (curr1 == 4){
            if (curr2 == 1){
                double temp = USD(curr1, moneyVal);
                System.out.println("GPB -> USD: " + moneyVal + " -> "+temp);
            }
            if (curr2 == 2){
                double temp = USD(curr1, moneyVal);
                System.out.println("GPB -> EUR: " + moneyVal + " -> "+temp*0.945);
            }
            if (curr2 == 3){
                double temp = USD(curr1, moneyVal);
                System.out.println("GPB -> JPY: " + moneyVal + " -> "+temp*149.76);
            }
            if (curr2 == 4){
                System.out.println("r u foooking dumb m8, thats the same currency");
            }
            if (curr2 == 5){
                double temp = USD(curr1, moneyVal);
                System.out.println("GPB -> AUD: " + moneyVal + " -> "+temp*1.575);
            }
            if (curr2 == 6){
                double temp = USD(curr1, moneyVal);
                System.out.println("GPB -> CAD: " + moneyVal + " -> "+temp*1.366);
            }
            if (curr2 == 7){
                double temp = USD(curr1, moneyVal);
                System.out.println("GPB -> CHF: " + moneyVal + " -> "+temp*0.901);
            }
            if (curr2 == 8){
                double temp = USD(curr1, moneyVal);
                System.out.println("GPB -> NZD: " + moneyVal + " -> "+temp*1.697);
            }
        }
        if (curr1 == 5){
            if (curr2 == 1){
                double temp = USD(curr1, moneyVal);
                System.out.println("AUD -> USD: " + moneyVal + " -> "+temp);
            }
            if (curr2 == 2){
                double temp = USD(curr1, moneyVal);
                System.out.println("AUD -> EUR: " + moneyVal + " -> "+temp*0.945);
            }
            if (curr2 == 3){
                double temp = USD(curr1, moneyVal);
                System.out.println("AUD -> JPY: " + moneyVal + " -> "+temp*149.76);
            }
            if (curr2 == 4){
                double temp = USD(curr1, moneyVal);
                System.out.println("AUD -> GBP: " + moneyVal + " -> "+temp*0.823);
            }
            if (curr2 == 5){
                System.out.println("r u foooking dumb m8, thats the same currency");
            }
            if (curr2 == 6){
                double temp = USD(curr1, moneyVal);
                System.out.println("AUD -> CAD: " + moneyVal + " -> "+temp*1.366);
            }
            if (curr2 == 7){
                double temp = USD(curr1, moneyVal);
                System.out.println("AUD -> CHF: " + moneyVal + " -> "+temp*0.901);
            }
            if (curr2 == 8){
                double temp = USD(curr1, moneyVal);
                System.out.println("EURO -> NZD: " + moneyVal + " -> "+temp*1.697);
            }
        }
        if (curr1 == 6){
            if (curr2 == 1){
                double temp = USD(curr1, moneyVal);
                System.out.println("CAD -> USD: " + moneyVal + " -> "+temp);
            }
            if (curr2 == 2){
                double temp = USD(curr1, moneyVal);
                System.out.println("CAD -> EUR: " + moneyVal + " -> "+temp*0.945);
            }
            if (curr2 == 3){
                double temp = USD(curr1, moneyVal);
                System.out.println("CAD -> JPY: " + moneyVal + " -> "+temp*149.76);
            }
            if (curr2 == 4){
                double temp = USD(curr1, moneyVal);
                System.out.println("CAD -> GBP: " + moneyVal + " -> "+temp*0.823);
            }
            if (curr2 == 5){
                double temp = USD(curr1, moneyVal);
                System.out.println("CAD -> AUD: " + moneyVal + " -> "+temp*1.575);
            }
            if (curr2 == 6){
                System.out.println("r u foooking dumb m8, thats the same currency");
            }
            if (curr2 == 7){
                double temp = USD(curr1, moneyVal);
                System.out.println("CAD -> CHF: " + moneyVal + " -> "+temp*0.901);
            }
            if (curr2 == 8){
                double temp = USD(curr1, moneyVal);
                System.out.println("CAD -> NZD: " + moneyVal + " -> "+temp*1.697);
            }
        }
        if (curr1 == 7){
            if (curr2 == 1){
                double temp = USD(curr1, moneyVal);
                System.out.println("CHF -> USD: " + moneyVal + " -> "+temp);
            }
            if (curr2 == 2){
                double temp = USD(curr1, moneyVal);
                System.out.println("CHF -> EUR: " + moneyVal + " -> "+temp*0.945);
            }
            if (curr2 == 3){
                double temp = USD(curr1, moneyVal);
                System.out.println("CHF -> JPY: " + moneyVal + " -> "+temp*149.76);
            }
            if (curr2 == 4){
                double temp = USD(curr1, moneyVal);
                System.out.println("CHF -> GBP: " + moneyVal + " -> "+temp*0.823);
            }
            if (curr2 == 5){
                double temp = USD(curr1, moneyVal);
                System.out.println("CHF -> AUD: " + moneyVal + " -> "+temp*1.575);
            }
            if (curr2 == 6){
                double temp = USD(curr1, moneyVal);
                System.out.println("CHF -> CAD: " + moneyVal + " -> "+temp*1.366);
            }
            if (curr2 == 7){
                System.out.println("r u foooking dumb m8, thats the same currency");
            }
            if (curr2 == 8){
                double temp = USD(curr1, moneyVal);
                System.out.println("CHF -> NZD: " + moneyVal + " -> "+temp*1.697);
            }
        }
        if (curr1 == 8){
            if (curr2 == 1){
                double temp = USD(curr1, moneyVal);
                System.out.println("NZD -> USD: " + moneyVal + " -> "+temp);
            }
            if (curr2 == 2){
                double temp = USD(curr1, moneyVal);
                System.out.println("NZD -> EUR: " + moneyVal + " -> "+temp*0.945);
            }
            if (curr2 == 3){
                double temp = USD(curr1, moneyVal);
                System.out.println("NZD -> JPY: " + moneyVal + " -> "+temp*149.76);
            }
            if (curr2 == 4){
                double temp = USD(curr1, moneyVal);
                System.out.println("NZD -> GBP: " + moneyVal + " -> "+temp*0.823);
            }
            if (curr2 == 5){
                double temp = USD(curr1, moneyVal);
                System.out.println("NZD -> AUD: " + moneyVal + " -> "+temp*1.575);
            }
            if (curr2 == 6){
                double temp = USD(curr1, moneyVal);
                System.out.println("NZD -> CAD: " + moneyVal + " -> "+temp*1.366);
            }
            if (curr2 == 7){
                double temp = USD(curr1, moneyVal);
                System.out.println("NZD -> CHF: " + moneyVal + " -> "+temp*0.901);
            }
            if (curr2 == 8){
                System.out.println("r u foooking dumb m8, thats the same currency");
            }
        }
    }
    public static double USD(int curr1, int moneyVal){
        if (curr1 == 1){
            System.out.println("you just converted into the same currency, here's a bruhcoin");
        }
        if (curr1 == 2){
            return moneyVal * 1.05;
        }
        if (curr1 == 3){
            return moneyVal * 0.0067;
        }
        if (curr1 == 4){
            return moneyVal * 1.22;
        }
        if (curr1 == 5){
            return moneyVal * 0.64;
        }
        if (curr1 == 6){
            return moneyVal * 0.73;
        }
        if (curr1 == 7){
            return moneyVal * 1.11;
        }
        if (curr1 == 8){
            return moneyVal * 0.59;
        }
        return 0;
    }


}
