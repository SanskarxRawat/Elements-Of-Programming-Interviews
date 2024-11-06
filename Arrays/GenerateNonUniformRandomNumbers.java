import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GenerateNonUniformRandomNumbers {


    public static int  nonUniformRandomNumberGeneration(List<Integer> values, List<Double> probabilities) {


        List<Double> prefixSumOfProbabilities = new ArrayList<Double>();
        prefixSumOfProbabilities.add(0.0);

        for (Double p : probabilities) {
            prefixSumOfProbabilities.add(prefixSumOfProbabilities.get(prefixSumOfProbabilities.size() - 1) + p);
        }

        Random random = new Random();

        final double uniform01 = random.nextDouble();

        int it = Collections.binarySearch(prefixSumOfProbabilities, uniform01);
        if (it < 0) {
            // We want the index of the first element in the array which is
            // greater than the key.
            //
            // When a key is not present in the array, Collect ions .binarySearch()
            // returns the negative of 1 plus the smallest index whose entry
            // is greater than the key.
            // Therefore , if the return value is negative , by taking its absolute
            // value and adding 1 to it , we get the desired index.
            final int intervalIndx=(Math.abs(it)-1)-1;
            return values.get(intervalIndx);
        }else{
            return values.get(it);
        }
    }
}
