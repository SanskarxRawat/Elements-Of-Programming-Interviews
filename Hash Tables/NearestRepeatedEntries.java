import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NearestRepeatedEntries {


    /**
     * Write a program which takes as input an array and finds the distance between a
     * closest pair of equal entries. For example, if s = ("All", "work", "and", "no", "play",
     * "makes", "for", "no", "work", "no", "fun", "and", "no", "results"), then the second
     * and third occurrences of "no" is the closest pair.
     */

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(d) , d is the distinct entries in paragraph
     */


    public static int findNearestRepetition(List<String> paragraph){

        Map<String,Integer> wordToLatestIndex=new HashMap<>();

        int nearestRepeatedDistance=Integer.MAX_VALUE;


        for(int i=0;i<paragraph.size();i++){
            if(wordToLatestIndex.containsKey(paragraph.get(i))){
                nearestRepeatedDistance=Math.min(nearestRepeatedDistance,i-wordToLatestIndex.get(paragraph.get(i)));
            }

            wordToLatestIndex.put(paragraph.get(i),i);
        }
        return nearestRepeatedDistance;

    }
}
