import java.util.*;
public class stack
{
	public static void main(String[] args) {
		Stack s=new Stack<>();
		s.push(1);
		s.push(2);
    	s.push(3);
	System.out.println(s.peek());
	System.out.println(s.pop());
	}
}