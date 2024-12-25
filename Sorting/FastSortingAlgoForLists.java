import java.util.ArrayList;
import java.util.List;

public class FastSortingAlgoForLists {

    /**
     * Implement a routine which sorts lists efficiently. It should be a stable sort, i.e., the
     * relative positions of equal elements must remain unchanged.
     */


    public static <T extends Comparable<T>> void stableSort(List<T> list) {
        if (list == null || list.size() <= 1) {
            return;
        }
        List<T> aux = new ArrayList<>(list); // Create a copy for auxiliary space
        mergeSort(list, aux, 0, list.size() - 1);
    }

    private static <T extends Comparable<T>> void mergeSort(List<T> list, List<T> aux, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = low + (high - low) / 2;
        mergeSort(aux, list, low, mid); // Note: swapping list and aux
        mergeSort(aux, list, mid + 1, high);
        merge(list, aux, low, mid, high);
    }

    private static <T extends Comparable<T>> void merge(List<T> list, List<T> aux, int low, int mid, int high) {
        int left = low, right = mid + 1, current = low;

        while (left <= mid && right <= high) {
            if (aux.get(left).compareTo(aux.get(right)) <= 0) {
                list.set(current++, aux.get(left++));
            } else {
                list.set(current++, aux.get(right++));
            }
        }
        while (left <= mid) {
            list.set(current++, aux.get(left++));
        }
        while (right <= high) {
            list.set(current++, aux.get(right++));
        }
    }
}
