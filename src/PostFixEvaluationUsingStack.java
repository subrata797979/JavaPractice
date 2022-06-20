import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class PostFixEvaluationUsingStack {
    public static void main(String[] args) {
        Stack<String> st = new Stack<>();
        List<String> list = Arrays.asList("2","3","+","4","5","+","*");

        for(String s : list) {
            switch(s) {
                case "+" :
                    st.push(String.valueOf(Integer.valueOf(st.pop())+Integer.valueOf(st.pop())));
                    break;
                case "-" :
                    st.push(String.valueOf(Integer.valueOf(st.pop())-Integer.valueOf(st.pop())));
                    break;
                case "*" :
                    st.push(String.valueOf(Integer.valueOf(st.pop())*Integer.valueOf(st.pop())));
                    break;
                case "/" :
                    st.push(String.valueOf(Integer.valueOf(st.pop())/Integer.valueOf(st.pop())));
                    break;
                case "^" :
                    st.push(String.valueOf((int)Math.pow(Integer.valueOf(st.pop()),Integer.valueOf(st.pop()))));
                    break;
                default:
                    st.push(s);
                    break;
            }
            System.out.println(st.toString());
        }
        System.out.println(st.pop());
    }
}
