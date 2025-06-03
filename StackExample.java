import java.util.*;

public class StackExample {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                st.push(Character.getNumericValue(ch));
            } else {
                int b = st.pop();
                int a = st.pop();

                switch (ch) {
                    case '+':
                        st.push(a + b);
                        break;
                    case '-':
                        st.push(a - b);
                        break;
                    case '*':
                        st.push(a * b);
                        break;
                    case '/':
                        st.push(a / b);
                        break;
                    default:
                        System.out.println("Invalid operator: " + ch);
                        return;
                }
            }
        }

        // Print the final result after processing the whole expression
        System.out.println(st.pop());
    }
}
