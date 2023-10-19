import java.util.Scanner;

public class TaxCalculator {
    public static void main() {
        System.out.println("Welcome to the Tax Calculator");
        System.out.println("Current Location: USA");
        System.out.print("Enter Income: ");
        Scanner scanner = new Scanner(System.in);
        int Income = Integer.parseInt(scanner.nextLine());

        if (Income <11000){
            double temp = Income*0.1;
            double temp2 = Income-temp;
            System.out.println("Pre-tax: "+Income);
            System.out.println("Post-tax: "+temp2);
        }
         if ((11000<Income)&&(Income<45000)){
            double temp = Income*0.12;
            double temp2 = Income-temp;
            System.out.println("Pre-tax: "+Income);
            System.out.println("Post-tax: "+temp2);
        }
        if ((45000<Income)&&(Income<95300)){
            double temp = Income*0.22;
            double temp2 = Income-temp;
            System.out.println("Pre-tax: "+Income);
            System.out.println("Post-tax: "+temp2);
        }
        if ((95300<Income)&&(Income<182000)){
            double temp = Income*0.24;
            double temp2 = Income-temp;
            System.out.println("Pre-tax: "+Income);
            System.out.println("Post-tax: "+temp2);
        }
        if ((182000<Income)&&(Income<231000)){
            double temp = Income*0.32;
            double temp2 = Income-temp;
            System.out.println("Pre-tax: "+Income);
            System.out.println("Post-tax: "+temp2);
        }
        if ((231000<Income)&&(Income<578000)){
            double temp = Income*0.35;
            double temp2 = Income-temp;
            System.out.println("Pre-tax: "+Income);
            System.out.println("Post-tax: "+temp2);
        }
        if(Income>578000){
            double temp = Income*0.37;
            double temp2 = Income-temp;
            System.out.println("Pre-tax: "+Income);
            System.out.println("Post-tax: "+temp2);
        }
    }
}
