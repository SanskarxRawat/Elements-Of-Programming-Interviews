import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SmallestSubarrayCoveringAllValues {

    /**
     * Write a program which takes an array of strings and a set of strings, and return the
     * indices of the starting and ending index of a shortest subarray of the given array that
     * "covers" the set, i.e., contains all strings in the set.
     */
    private static class SubArray{
        public Integer start;
        public Integer end;

        public SubArray(Integer start,Integer end){
            this.start=start;
            this.end=end;
        }
    }

    /**
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */


    public static SubArray findSmallestSubarray(List<String> paragraphs, Set<String> keywords){

        Map<String,Integer> keyWordsToCover=new HashMap<>();

        for(String keyword:keywords){
            keyWordsToCover.merge(keyword,1,Integer::sum);
        }

        SubArray result=new SubArray(-1,-1);

        int remainingToCover = keywords.size();

        for (int left = 0, right = 0; right < paragraphs.size(); ++right) {
            Integer keyWordCount = keyWordsToCover.get(paragraphs.get(right));

            if (keyWordCount != null) {
                keyWordsToCover.put(paragraphs.get(right), --keyWordCount);
                if (keyWordCount >= 0) {
                    --remainingToCover;
                }
            }
            // Keeps advancing left until it reaches end or keywordsToCover does not
            // have all keywords .
            while (remainingToCover == 0){
                if ((result.start == -1 && result.end == -1)
                        || right - left < result.end - result.start) {
                    result.start = left;
                    result.end = right;
                }
                keyWordCount = keyWordsToCover.get(paragraphs.get(left));
                if (keyWordCount != null) {
                    keyWordsToCover.put(paragraphs.get(left), ++keyWordCount);
                    if (keyWordCount > 0){
                        ++remainingToCover;
                    }
                }
                ++left;
            }
        }
        return result;

    }
}
