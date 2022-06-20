class StackUtil {
    private int tos;
    private int[] arr;
    private final int SIZE = 3;
    StackUtil() {
        tos = -1;
        arr = new int[SIZE];
    }
    public void push(int val) {
        if(tos == SIZE-1)
            System.out.println("Stack Overflow!");
        else {
            tos++;
            arr[tos] = val;
            System.out.println("pushed successfully! val = "+val);
        }
    }
    public int pop() {
        if(tos == -1)
            System.out.println("Stack Underflow!");
        else {
            int popped = arr[tos];
            this.tos--;
            return popped;
        }
        return -1;
    }
    public void print() {
        if(tos == -1)
            System.out.println("Nothing to print!");
        else {
            for(int i=tos; i>=0; i--) {
                System.out.println(arr[i]);
            }
        }
    }
}
public class Stack {
    public static void main(String[] args) {
        StackUtil st = new StackUtil();

        st.push(3);
        st.print();

        st.push(4);
        st.print();

        st.push(5);
        st.print();

        st.push(4);
        st.print();

        st.push(5);
        st.print();

        System.out.println("popped : "+st.pop());
        st.print();

        st.push(10);
        st.print();

        st.push(10);
        st.print();

        System.out.println("popped : "+st.pop());
        st.print();

        System.out.println("popped : "+st.pop());
        st.print();

        System.out.println("popped : "+st.pop());
        st.print();

        System.out.println("popped : "+st.pop());
        st.print();

        st.push(1);
        st.print();
    }
}
