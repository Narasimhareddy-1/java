/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
 import java.util.*;
public class Main
{
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		  String a =sc.nextLine();
		  String b=" ";
		  for( int i=a.length()-1;i>-1;i--)
		  {
		     b=b+a.charAt(i);
		  }
		   System.out.println(b);
		  
	}
}