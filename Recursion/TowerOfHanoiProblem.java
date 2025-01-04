public class TowerOfHanoiProblem {

    /**
     * Write a program which prints a sequence of operations that transfers n rings from one
     * peg to another. You have a third peg, which is initially empty. The only operation
     * you can perform is taking a single ring from the top of one peg and placing it on the
     * top of another peg. You must never place a larger ring above a smaller ring.
     */

    /**
     * Approach: Recursive
     * 1. Move n-1 disks from source to auxiliary peg.
     * 2. Move nth disk from source to destination peg.
     * 3. Move n-1 disks from auxiliary peg to destination peg.
     * 4. Repeat the above steps until all disks are moved from source to destination peg.
     *
     * Time Complexity: O(2^n)
     * Space Complexity: O(n)
     */

    public static void main(String[] args) {
        int n = 3;
        towerOfHanoi(n, 'A', 'C', 'B');
    }

    public static void towerOfHanoi(int n, char from_rod, char to_rod, char aux_rod) {
        if (n == 1) {
            System.out.println("Move disk 1 from rod " + from_rod + " to rod " + to_rod);
            return;
        }
        towerOfHanoi(n - 1, from_rod, aux_rod, to_rod);
        System.out.println("Move disk " + n + " from rod " + from_rod + " to rod " + to_rod);
        towerOfHanoi(n - 1, aux_rod, to_rod, from_rod);
    }

    /**
     * Iterative Approach:
     * 1. Calculate the total number of moves required i.e. "pow(2, n) - 1" where n is the number of disks.
     * 2. If n is even, then interchange destination peg and auxiliary peg.
     * 3. For i = 1 to total number of moves:
     *     a. If i % 3 == 1, then move the top disk between source peg and destination peg.
     *     b. If i % 3 == 2, then move the top disk between source peg and auxiliary peg.
     *     c. If i % 3 == 0, then move the top disk between auxiliary peg and destination peg.
     *     d. Repeat the above steps until all disks are moved from source to destination peg.
     */


    public static void towerOfHanoiIterative(int n) {
        int totalMoves = (int) Math.pow(2, n) - 1;
        char source = 'A', destination = 'C', auxiliary = 'B';
        if (n % 2 == 0) {
            char temp = destination;
            destination = auxiliary;
            auxiliary = temp;
        }
        for (int i = 1; i <= totalMoves; i++) {
            if (i % 3 == 1) {
                System.out.println("Move disk 1 from rod " + source + " to rod " + destination);
            } else if (i % 3 == 2) {
                System.out.println("Move disk 1 from rod " + source + " to rod " + auxiliary);
            } else if (i % 3 == 0) {
                System.out.println("Move disk 1 from rod " + auxiliary + " to rod " + destination);
            }
        }
    }
}
