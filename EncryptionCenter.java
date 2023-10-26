import java.util.Scanner;

public class EncryptionCenter {
    public static void main() {
        System.out.println("Welcome to the Encryption center");
        System.out.println("Here you can store encrypted data, or use the tool to decode information");
        System.out.println("\nEach encrypted phrase has a number between 1-10, that will be an extra security device");
        System.out.println("It is very important to remember the number that is associated with your message");
        System.out.println("\nWhat would you like to do:\n1 - Encrypted a message\n2 - Decode a message");
        System.out.print("> ");
        Scanner scanner = new Scanner(System.in);
        int EncryptSel = Integer.parseInt(scanner.nextLine());
        if (EncryptSel == 1) {
            System.out.print("Enter in your phrase to be encrypted\n> ");
            String Phrase = scanner.nextLine();
            EncryptSel(Phrase);
        }
        if (EncryptSel == 2) {
            System.out.print("Enter in your phrase to be decoded\n> ");
            String Phrase = scanner.nextLine();
            DecodeSel(Phrase);
        }
    }

    public static void EncryptSel(String Phrase) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Pick a number between 1 and 10: ");
        int SecNum = Integer.parseInt(scanner.nextLine());
        String[] disect = Phrase.split("");
        int unicodeValue;
        int[] changed = new int[disect.length];
        for (int i = 0; i < disect.length; i++) {
            char c = disect[i].charAt(0);
            if (Character.isLetter(c)) {
                unicodeValue = (int) c;
                int tempval = (unicodeValue * 2) * SecNum;
                changed[i] = tempval;
            } else if (Character.isDigit(c)) {
                unicodeValue = (int) c;
                int tempval = (unicodeValue * 2) * SecNum;
                changed[i] = tempval;
            } else {
                changed[i] = 777;
            }
        }
        System.out.println("Your encrypted code is:");
        System.out.print(changed[0]);
        for (int i = 1; i < changed.length; i++) {
            System.out.print(":" + changed[i]);
        }
        System.out.println("\nWith security code " + SecNum);
    }

    public static void DecodeSel(String Phrase) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your security number: ");
        int SecNum = Integer.parseInt(scanner.nextLine());
        String[] disect = Phrase.split(":");
        int[] disectNew = new int[disect.length];
        for (int i = 0; i < disect.length; i++) {
            disectNew[i] = Integer.parseInt(disect[i]);
        }
        char[] changed = new char[disectNew.length];

        for (int i = 0; i < disect.length; i++) {
            int numericValue = disectNew[i];
            char decodedChar;

            if (numericValue == 777) {
                decodedChar = ' ';
            } else {
                int tempval = (numericValue / 2) / SecNum;
                char[] originalCharacter = Character.toChars(tempval);
                decodedChar = originalCharacter[0];

            }

            changed[i] = decodedChar;
        }
        System.out.println("\nYour decoded message is:");
        for (int i = 0; i < changed.length; i++) {
            System.out.print(changed[i]);
        }
        System.out.println("\n");
    }
}
