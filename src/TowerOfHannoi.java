public class TowerOfHannoi {
    public static int count = 0;
    public static void main(String[] args) {
        System.out.println("Tower Of Hannoi \n------------");
        int n = 3;
        char a = 'A', b = 'B', c='C';
        towerofhannoi(n,a,b,c);
        System.out.println("Total Count : "+count);
    }
    public static void towerofhannoi(int n, char a, char b, char c) {
        if(n>0) {
            towerofhannoi(n-1,a,c,b);
            System.out.println("move a disk from "+a+" to "+b);
            count++;
            towerofhannoi(n-1,b,a,c);
        }
    }
}

/*

simple logic
-------------
move n-1 disks from A to B using C
move a disk from A to C
move n-1 disks from B to C using A

*/

