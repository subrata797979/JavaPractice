import java.util.Scanner;

public class CircularQueue {
    private int[] arr;
    private int front;
    private int rear;
    private  int count;

    private final int SIZE = 5;

    CircularQueue() {
        arr = new int[1000];
        front = 0;
        rear = -1;
        count = 0;
    }

    boolean isEmpty() {
        return count==0;
    }

    boolean isFull() {
        return count==SIZE;
    }

    public void add(int val) {
        rear = rear%SIZE+1;
        arr[rear] = val;
        count++;
    }

    public int remove() {
        int temp = arr[front];
        front = front%SIZE+1;
        count--;
        return temp;
    }

    public void print() {
        int size = count;
        if(size == 0)
            System.out.println("Nothing to display!");
        else {
            System.out.print("\nCircular Queue elements are : ");
            int i = front;
            while(size-->0) {
                System.out.print(arr[i]+" ");
                i=i%SIZE+1;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CircularQueue queue = new CircularQueue();

        while(true) {
            System.out.println("\n\n\nEnter your choice : \n-------------------");
            System.out.println("1. add an element in circular queue");
            System.out.println("2. remove an element from circular queue");
            System.out.println("3. print elements of circular queue");
            System.out.println("4. exit from the program\n");

            int choice = sc.nextInt();
            switch(choice) {
                case 1:
                    if(!queue.isFull()) {
                        System.out.println("Enter the value of the element to be added : ");
                        queue.add(sc.nextInt());
                        queue.print();
                    }
                    else {
                        System.out.println("Queue is full!");
                    }
                    break;
                case 2:
                    if(!queue.isEmpty()) {
                        int deleted = queue.remove();
                        System.out.println("Deleted element is : "+deleted);
                        queue.print();
                    }
                    else {
                        System.out.println("Queue is empty!");
                    }
                    break;
                case 3:
                    queue.print();
                    break;
                case 4:
                    System.exit(1);
                default:
                    System.out.println("Wrong Option!");
                    break;
            }
        }
    }
}
