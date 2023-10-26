import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DocAnalyzer {
    public static void main() throws IOException {

        System.out.println("Welcome to the doc analyzer, here you can find specific info with a file in the directory");
        System.out.println("The file must be in the directory in order for the file to be read");
        System.out.println("The file must also end in .txt");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter in file name: ");
        String Fileinfo = scanner.nextLine();
        System.out.println("Thank you for your input................");
        System.out.println("What would you like to do?");
        System.out.println("Press:\n1 - word find\n2 - word count\n3 - word frequency");
        int selector = Integer.parseInt(scanner.nextLine());
        if (selector == 1) {
            System.out.println("Enter in the word you'd like to find: ");
            String WordFind = scanner.nextLine();
            FileReader fileReader = new FileReader(Fileinfo);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            List<Integer> LineCounterHold = new ArrayList<>();
            int lineCounter = 0;

            boolean reader = false;
            while (reader == false) {
                String stringList = null;
                String[] linebreak = null;
                try{
                    stringList = bufferedReader.readLine();
                    linebreak = stringList.split(" ");
                    lineCounter++;

                    for (int i = 0; i <= linebreak.length; i++) {
                        try {
                            if (linebreak[i].equals(WordFind)) {
                                LineCounterHold.add(lineCounter);
                                System.out.println("We found " + linebreak[i] + " at line: " + lineCounter);
                            }
                        } catch (ArrayIndexOutOfBoundsException e) {

                        }

                    }
                } catch (NullPointerException e) {
                    reader = true;
                }

            }
        }
        if (selector == 2) {
            FileReader fileReader = new FileReader(Fileinfo);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String stringList;
            String[] linebreak;
            int wordCount = 0;

            boolean reader1 = false;
            while (reader1 == false) {
                try{
                    stringList = bufferedReader.readLine();
                    linebreak = stringList.split(" ");
                    wordCount = wordCount + linebreak.length;
                } catch (NullPointerException ignored){
                    reader1 = true;
                    System.out.println("Word Count: "+wordCount);
                }

            }
        }
        if (selector == 3){
            System.out.print("Enter in the word you'd like to the frequency of: ");
            String WordFFind = scanner.nextLine();
            FileReader fileReader = new FileReader(Fileinfo);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String stringList;
            String[] linebreak;
            int wordFreq = 0;
            boolean reader2 = false;
            while (reader2 == false){
                try{
                    stringList = bufferedReader.readLine();
                    linebreak = stringList.split(" ");
                    for (int i = 0; i <= linebreak.length; i++) {
                        try {
                            if (linebreak[i].equals(WordFFind)) {
                               wordFreq++;
                            }
                        } catch (ArrayIndexOutOfBoundsException ignored) {

                        }

                    }

                } catch (NullPointerException e) {
                    reader2 = true;
                    System.out.println("We saw "+WordFFind+" "+wordFreq + " times in file: "+Fileinfo);
                }

            }
        }
    }
}
