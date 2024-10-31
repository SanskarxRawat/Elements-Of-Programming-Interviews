import java.util.Collections;
import java.util.List;

public class DutchNationalFlag {

    /**
     * Brute Force
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */

    public static enum Color {RED, WHITE, BLUE}


    public static void dutchNationalFlag(List<Color> colors, int pivotIndex) {

        Color color = colors.get(pivotIndex);

        for (int i = 0; i < colors.size(); ++i) {
            // Look for a smaller element.
            for (int j = i + 1; j < colors.size(); ++j) {
                if (colors.get(j).ordinal() < color.ordinal()) {
                    Collections.swap(colors, i, j);
                    break;
                }
            }
        }

        // Second pass: group elements larger than pivot.
        for (int i = colors.size() - 1; i >= 0 && colors.get(i).ordinal() >= color.ordinal(); --i) {
            // Look for a larger element. Stop when we reach an element less
            // than pivot, since first pass has moved them to the start of A.
            for (int j = i - 1; j >= 0 && colors.get(j).ordinal() >= color.ordinal(); --j) {
                if (colors.get(j).ordinal() > color.ordinal()) {
                    Collections.swap(colors, i, j);
                    break;
                }
            }
        }
    }

    /**
     * Brute Force - 2
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */


    public static void dutchNationalFlag2(List<Color> colors, int pivotIndex) {

        Color color = colors.get(pivotIndex);

        int smaller=0;

        for(int index=0;index<colors.size();index++){
            if(colors.get(index).ordinal()<color.ordinal()){
                Collections.swap(colors,smaller++,index);
            }
        }
        int larger=colors.size()-1;

        for(int index=colors.size()-1;index>=0&& colors.get(index).ordinal()>=color.ordinal();index--){

            if(colors.get(index).ordinal()>color.ordinal()){
                Collections.swap(colors,larger--,index);
            }
        }
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */

    public static void dutchNationalFlag3(List<Color> colors, int pivotIndex) {
        Color color = colors.get(pivotIndex);

        /**
         * Keep the following invariants during partitioning
         * bottom group: A.subList(0,smaller)
         * middle group: A.subList(smaller,equal)
         * unclassified: A.subList(equal,larger)
         * top group: A.subList(larger,A.size())
         */

        int smaller=0,equal=0,larger=colors.size()-1;

        while(equal<larger){

            if(colors.get(equal).ordinal()<color.ordinal()){
                Collections.swap(colors,smaller++,equal++);
            }else if(colors.get(equal).ordinal()==color.ordinal()){
                equal++;
            }else{
                Collections.swap(colors,equal,larger);
            }

        }
    }

    public static void reorderBooleanKeys(List<Boolean> keys) {
        int falseIndex = 0;
        for (int i = 0; i < keys.size(); i++) {
            if (!keys.get(i)) {
                Collections.swap(keys, falseIndex++, i);
            }
        }
    }

    /**
     * Maintain Relative Order
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */

    public static void reorderBooleanKeysStable(List<Boolean> keys) {
        int falseIndex = 0;
        for (int i = 0; i < keys.size(); i++) {
            if (!keys.get(i)) {
                Boolean temp = keys.remove(i);
                keys.add(falseIndex++, temp);
            }
        }
    }

}
