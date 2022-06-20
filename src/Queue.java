import java.util.Scanner;

public class Queue {
    public static void main(String[] args) {
        int[] arr = new int[1000];
        int front = 0;
        int rear = -1;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the Queue : ");
        int size = sc.nextInt();

        while(true) {
            System.out.println("Queue Operations : " +
                    "\n1. add at rear" +
                    "\n2. remove from front" +
                    "\n3. print the queue" +
                    "\n4. exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    if(rear >= size-1)
                        System.out.println("Can't add! Queue is full!");
                    else {
                        rear++;
                        System.out.println("Enter value to add : ");
                        int val = sc.nextInt();
                        arr[rear] = val;
                        System.out.println("add done!");
                    }
                    break;

                case 2:
                    if(front > rear)
                        System.out.println("Can't remove! Queue is empty!");
                    else {
                        front++;
                        System.out.println("remove done!");
                        if (front >= size) {
                            front = 0;
                            rear = -1;
                            System.out.println("queue reset!");
                        }
                    }
                    break;

                case 3:
                    if(front>rear)
                        System.out.println("nothing to display! queue is empty!");
                    else {
                        System.out.println("\nQueue elements are : ");
                        for(int i=front; i<=rear; i++) {
                            System.out.print(arr[i]+" ");
                        }
                        System.out.println("\n");
                    }
                    break;

                default:
                    System.exit(1);
            }
        }
    }
}
