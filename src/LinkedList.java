import java.util.Scanner;

public class LinkedList {
    public int val;
    public LinkedList next;

    LinkedList() {
        this.next = null;
    }

    LinkedList(int val) {
        this.val = val;
        this.next = null;
    }

    public static void addFirst(LinkedList itr, int val) {
        LinkedList temp = new LinkedList(val);
        LinkedList store = itr.next;
        itr.next = temp;
        temp.next = store;
    }

    public static void addLast(LinkedList itr, int val) {
        LinkedList temp = new LinkedList(val);
        while(itr.next!=null)
            itr = itr.next;
        itr.next = temp;
    }

    public static void addAfter(LinkedList itr, int val, int index) {
        LinkedList temp = new LinkedList(val);
        int i = 0;
        while(i++<index) {
            if(itr.next == null)
                break;
            else
                itr = itr.next;
        }
        LinkedList store = itr.next;
        itr.next = temp;
        temp.next = store;
    }

    public static int deleteFirst(LinkedList itr) {
        int deleted = itr.next.val;
        itr.next = itr.next.next;
        return deleted;
    }

    public static int deleteLast(LinkedList itr) {
        while(itr.next.next!=null)
            itr = itr.next;
        int deleted = itr.next.val;
        itr.next = null;
        return deleted;
    }

    public static int deleteAt(LinkedList itr, int index) {
        int i = 0;
        while(i++<index-1) {
            if(itr.next.next == null)
                break;
            else
                itr = itr.next;
        }
        int deleted = itr.next.val;
        itr.next = itr.next.next;
        return deleted;
    }

    public static void printNode(LinkedList node) {

        if(node == null)
            System.out.println("Nothing to print!");
        else {
            System.out.println("Node elements are : ");
            while(node!=null) {
                System.out.print(node.val+" ");
                node = node.next;
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList head = new LinkedList();

        while (true) {

            System.out.println("\n\n\nEnter your choice : \n-------------------");
            System.out.println("1. insert at front");
            System.out.println("2. insert at rear");
            System.out.println("3. insert after position");
            System.out.println("4. delete from front");
            System.out.println("5. delete from rear");
            System.out.println("6. delete at position");
            System.out.println("7. print elements");
            System.out.println("8. exit\n\n");

            System.out.print("select : ");
            int choice = sc.nextInt();
            System.out.println();

            switch (choice) {
                case 1:
                    LinkedList itr1 = head;
                    System.out.println("Enter value to be inserted at first: ");
                    int val1 = sc.nextInt();
                    addFirst(itr1,val1);
                    printNode(head.next);
                    break;
                case 2:
                    LinkedList itr2 = head;
                    System.out.println("Enter value to be inserted at last: ");
                    int val2 = sc.nextInt();
                    addLast(itr2,val2);
                    printNode(head.next);
                    break;
                case 3:
                    LinkedList itr3 = head;
                    System.out.println("Enter value to be inserted at position: ");
                    int val3 = sc.nextInt();
                    System.out.println("Enter position after : ");
                    int index1 = sc.nextInt();
                    addAfter(itr3,val3,index1);
                    printNode(head.next);
                    break;
                case 4:
                    LinkedList itr4 = head;
                    int ele1 = deleteFirst(itr4);
                    System.out.println("Deleted element : "+ele1);
                    printNode(head.next);
                    break;
                case 5:
                    LinkedList itr5 = head;
                    int ele2 = deleteLast(itr5);
                    System.out.println("Deleted element : "+ele2);
                    printNode(head.next);
                    break;
                case 6:
                    LinkedList itr6 = head;
                    System.out.println("Enter position after : ");
                    int index2 = sc.nextInt();
                    int ele3 = deleteAt(itr6,index2);
                    System.out.println("Deleted element : "+ele3);
                    printNode(head.next);
                    break;
                case 7:
                    printNode(head.next);
                    break;
                case 8:
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
