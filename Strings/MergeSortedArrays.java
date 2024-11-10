public class MergeSortedArrays {

    public static void mergeSortedArrays(int[] A, int m, int[] B, int n) {
        int writeIndex = m + n - 1;
        int aIndex = m - 1;
        int bIndex = n - 1;

        // Merge A and B from the end to the beginning
        while (aIndex >= 0 && bIndex >= 0) {
            if (A[aIndex] > B[bIndex]) {
                A[writeIndex--] = A[aIndex--];
            } else {
                A[writeIndex--] = B[bIndex--];
            }
        }

        // Copy remaining elements from B, if any
        while (bIndex >= 0) {
            A[writeIndex--] = B[bIndex--];
        }
    }
}
