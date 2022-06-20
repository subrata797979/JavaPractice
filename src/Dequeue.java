import java.util.Scanner;

public class Dequeue {
    private int[] arr;
    private int front;
    private int rear;

    private final int SIZE = 4;

    Dequeue() {
        arr = new int[SIZE];
        front = 0;
        rear = -1;
    }

    // checks

    public boolean isEmpty() {
        return front > rear;
    }

    public boolean isFull() {
        return front == 0 && rear == SIZE-1;
    }

    boolean addRearPossible() {
        return rear < SIZE-1;
    }

    boolean removeFrontPossible() {
        return front <= rear;
    }

    boolean addFrontPossible() {
        return front!=0 || (front==0 && rear==-1);
    }

    boolean removeRearPossible() {
        return front <= rear;
    }

    // operations

    public void addRear(int val) {
        rear++;
        arr[rear] = val;
    }

    public int removeFront() {
        int removed = arr[front];
        front++;
        if(front>rear && rear==SIZE-1) {
            front = 0;
            rear = -1;
        }
        return removed;
    }

    public void addFront(int val) {
        if(front == 0 && rear == -1) {
            arr[front] = val;
            rear++;
        }
        else {
            front--;
            arr[front] = val;
        }
    }

    public int removeRear() {
        int deleted = arr[rear];
        rear--;
        return deleted;
    }

    public void print() {
        if(front>rear)
            System.out.println("Nothing to display!");
        else {
            System.out.print("\nDequeue elements are : ");
            for(int i=front; i<=rear; i++) {
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Dequeue queue = new Dequeue();

        while (true) {

            System.out.println("\n\n\nEnter your choice : \n-------------------");
            System.out.println("1. add at front");
            System.out.println("2. delete from rear");
            System.out.println("3. add at rear");
            System.out.println("4. delete from front");
            System.out.println("5. print elements");
            System.out.println("6. exit\n\n");

            if(queue.isEmpty()) System.out.println("Deque is empty!");
            if(queue.isFull()) System.out.println("Deque is full!");

            System.out.print("select : ");
            int choice = sc.nextInt();
            System.out.println();

            switch (choice) {
                case 1:
                    if(!queue.addFrontPossible())
                        System.out.println("insertion at front not possible!");
                    else {
                        System.out.println("Enter value : ");
                        queue.addFront(sc.nextInt());
                        queue.print();
                    }
                    break;
                case 2:
                    if(!queue.removeRearPossible())
                        System.out.println("deletion from rear not possible!");
                    else {
                        int removed = queue.removeRear();
                        System.out.println("Removed element : "+removed+"\n");
                        queue.print();
                    }
                    break;
                case 3:
                    if(!queue.addRearPossible())
                        System.out.println("insertion at rear not possible!");
                    else {
                        System.out.println("Enter value : ");
                        queue.addRear(sc.nextInt());
                        queue.print();
                    }
                    break;
                case 4:
                    if(!queue.removeFrontPossible())
                        System.out.println("deletion from front not possible!");
                    else {
                        int removed = queue.removeFront();
                        System.out.println("Removed element : "+removed+"\n");
                        queue.print();
                    }
                    break;
                case 5:
                    queue.print();
                    break;
                case 6:
                    System.exit(1);
                default:
                    System.out.println("Wrong Option!");
                    break;
            }

            // hold
            System.out.println("(press 1 to again / press any to exit)");
            if(sc.nextInt()!=1)  break;
        }
    }
}
