import java.util.*;
import java.util.LinkedList;

public class ComputeBuildingHeightSunset {


    static class BuildingHeight{
        int height;
        int buildingId;

        public BuildingHeight(int height,int buildingId){
            this.buildingId=buildingId;
            this.height=height;
        }
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */


    private static Deque<BuildingHeight> calculateSunsetViewETW(Iterator<Integer> heights){
        int buildingIndex=0;

        Deque<BuildingHeight> buildingWithSunset=new LinkedList<>();

        while(heights.hasNext()){

            int height=heights.next();

            while(!buildingWithSunset.isEmpty() && (Integer.compare(height,buildingWithSunset.getLast().height)>=0)){
                buildingWithSunset.removeLast();
            }

            buildingWithSunset.addLast(
                    new BuildingHeight(buildingIndex++, height));
        }

        return buildingWithSunset;

    }

    private static List<Integer> calculateSunsetViewWTE(Iterator<Integer> heights) {
        int buildingIndex = 0;
        int maxHeight = Integer.MIN_VALUE;

        // Use an ArrayList to store the indices of buildings that can see the sunset
        List<Integer> buildingsWithSunsetView = new ArrayList<>();

        while (heights.hasNext()) {
            int height = heights.next();

            if (height > maxHeight) {
                // Current building can see the sunset
                buildingsWithSunsetView.add(buildingIndex);
                maxHeight = height;
            }

            buildingIndex++;
        }

        return buildingsWithSunsetView;
    }
}
