public class WaterTrapped {

    /**
     * Intuition:
     * The problem can be modeled as finding two lines in the array, such that they create the maximum area
     * when treated as the sides of a container holding water. To solve this efficiently:
     * - Use a two-pointer approach, starting with one pointer at the beginning and the other at the end of the array.
     * - Calculate the area formed between the two pointers and update the maximum if this area is larger.
     * - Move the pointer with the smaller height inward, as this could result in a taller boundary and potentially
     * a larger area.
     * - Repeat until the pointers meet.
     * <p>
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int[] maxWaterTrappedPair(int[] heights) {
        int left = 0, right = heights.length - 1;
        int maxArea = 0;
        int[] result = new int[2];

        while (left < right) {
            int area = Math.min(heights[left], heights[right]) * (right - left);
            if (area > maxArea) {
                maxArea = area;
                result[0] = left;
                result[1] = right;
            }
            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return result;
    }


    public static int getMaximumWaterTrapped(int[] heights) {
        int maxWater = 0;
        int left = 0, right = heights.length - 1;

        while(left < right){

            int width=right-left;
            maxWater=Math.max(maxWater,width*Math.min(heights[left],heights[right]));
            if(heights[left]>heights[right]){
                --right;
            }else if(heights[left]<heights[right]){
                ++left;
            }else{
                ++left;
                --right;
            }
        }
        return maxWater;
    }
}
