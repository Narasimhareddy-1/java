/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.Scanner;

public class CaseConversion {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a string: ");
		String input = sc.nextLine();


		String lower = input.toLowerCase();


		String upper = input.toUpperCase();


		System.out.println("Lowercase: " + lower);
		System.out.println("Uppercase: " + upper);

		sc.close();
	}
}

