/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.Scanner;

public class RemoveWhiteSpaces {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Method 1: Using replaceAll with regex
        String noSpaces = input.replaceAll("\\s", "");  // "\\s" matches any whitespace

        System.out.println("String without spaces: " + noSpaces);

        sc.close();
    }
}
