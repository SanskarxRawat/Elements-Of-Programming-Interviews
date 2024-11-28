import java.util.List;

public class FindMinMaxSimultaneously {

    /**
     * Design an algorithm to find the min and max elements in an array.
     * for example if A={3,2,5,1,2,4}
     * return 1 and min and 5 as max
     */

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */

    public static class MinMax{
        Integer min;
        Integer max;

        public MinMax(Integer min,Integer max){
            this.min=min;
            this.max=max;
        }

        private static MinMax minMax(Integer a,Integer b){
            return Integer.compare(b,a)<0?new MinMax(b,a):new MinMax(a,b);
        }

        public static MinMax finMinMax(List<Integer> A){
            //process two element at a time

            if(A.size()<=1){
                return new MinMax(A.get(0),A.get(0));
            }

            MinMax globalMinMax=MinMax.minMax(A.get(0),A.get(1));

            for(int i=2;i+1<A.size();i+=2){
                MinMax localMinMax=MinMax.minMax(A.get(i),A.get(i+1));
                globalMinMax=new MinMax(Math.min(localMinMax.min, globalMinMax.min),Math.max(localMinMax.max, globalMinMax.max));
            }

            if((A.size()%2)!=0){
                globalMinMax=new MinMax(Math.min(globalMinMax.min,A.get(A.size()-1)),Math.max(globalMinMax.max,A.get(A.size()-1)));
            }

            return globalMinMax;
        }
    }

    /** Class Pair is used to return two values from getMinMax() */
    static class Pair {

        int min;
        int max;
    }

    static Pair getMinMax(int arr[], int n) {
        Pair minmax = new Pair();
        int i;
            /* If array has even number of elements then
        initialize the first two elements as minimum and
        maximum */
        if (n % 2 == 0) {
            if (arr[0] > arr[1]) {
                minmax.max = arr[0];
                minmax.min = arr[1];
            } else {
                minmax.min = arr[0];
                minmax.max = arr[1];
            }
            i = 2;
            /* set the starting index for loop */
        } /* If array has odd number of elements then
        initialize the first element as minimum and
        maximum */ else {
            minmax.min = arr[0];
            minmax.max = arr[0];
            i = 1;
            /* set the starting index for loop */
        }

            /* In the while loop, pick elements in pair and
         compare the pair with max and min so far */
        while (i < n - 1) {
            if (arr[i] > arr[i + 1]) {
                if (arr[i] > minmax.max) {
                    minmax.max = arr[i];
                }
                if (arr[i + 1] < minmax.min) {
                    minmax.min = arr[i + 1];
                }
            } else {
                if (arr[i + 1] > minmax.max) {
                    minmax.max = arr[i + 1];
                }
                if (arr[i] < minmax.min) {
                    minmax.min = arr[i];
                }
            }
            i += 2;
                /* Increment the index by 2 as two
                   elements are processed in loop */
        }

        return minmax;
    }

}
