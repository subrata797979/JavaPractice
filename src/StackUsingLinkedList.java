import java.util.Scanner;

public class StackUsingLinkedList {

    private int val;
    private StackUsingLinkedList next;
    private static int count = 1;

    StackUsingLinkedList() {
        StackUsingLinkedList next = null;
    }

    StackUsingLinkedList(int val) {
        this.val = val;
        this.next = null;
    }

    public static void push(StackUsingLinkedList itr, int val) {
        while(itr.next!=null) {
            itr = itr.next;
        }
        StackUsingLinkedList pushed = new StackUsingLinkedList(val);
        itr.next = pushed;
    }

    public static int pop(StackUsingLinkedList itr) {
        while(itr.next.next!=null) {
            itr = itr.next;
        }
        int popped = itr.next.val;
        itr.next = null;
        return popped;
    }

    public static void print(StackUsingLinkedList itr) {
        if(StackUsingLinkedList.count<=1)
            System.out.println("Nothing to print!");
        else {
            System.out.print("\nStack elements are : ");
            while(itr.next!=null) {
                System.out.print(itr.next.val+" ");
                itr = itr.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StackUsingLinkedList head = new StackUsingLinkedList();
        StackUsingLinkedList itr = head;

        System.out.println("Enter the size of the stack : ");
        final int SIZE = sc.nextInt();

        while(true) {
            System.out.println("\n\n\nEnter your choice : ");
            System.out.println("1. Push \n2. Pop \n3. Print\n4. Exit\n");
            int choice = sc.nextInt();
            switch(choice) {

                case 1:
                    if(count>SIZE)
                        System.out.println("Stack Overflow!");
                    else {
                        itr = head;
                        System.out.println("Enter value to push : ");
                        int val = sc.nextInt();
                        push(itr,val);
                        StackUsingLinkedList.count++;
                        // print
                        itr = head;
                        print(itr);
                    }
                    break;

                case 2:
                    if(count<=1)
                        System.out.println("Stack Empty!");
                    else {
                        itr = head;
                        int ele = pop(itr);
                        System.out.println("Popped element : "+ele);
                        StackUsingLinkedList.count--;
                        // print
                        itr = head;
                        print(itr);
                    }
                    break;

                case 3:
                    if(count<=1)
                        System.out.println("Stack Empty!");
                    else {
                        itr = head;
                        print(itr);
                    }
                    break;

                case 4:
                    System.exit(1);

                default:
                    System.out.println("Wrong Input! Try Again!!");
            }

            // hold
            System.out.println("(press any key and enter to continue)");
            sc.next();
        }
    }
}
