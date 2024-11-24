import java.util.*;

public class kClosestStar {

    /**
     *  Time Complexity: O(nlog(k))
     *  Space Complexity: O(k)
     */

    public static class Star implements Comparable<Star>{

        private double x,y,z;

        public Star(double x,double y, double z){
            this.x=x;
            this.y=y;
            this.z=z;
        }

        public double distance(){
            return Math.sqrt(x*x+y*y+z*z);
        }
        @Override
        public int compareTo(Star o) {
            return Double.compare(this.distance(),o.distance());
        }
    }

    public static List<Star> kClosestStart(Iterator<Star> stars, int k){

        Queue<Star> maxHeap=new PriorityQueue<>(k, Collections.reverseOrder());

        while(stars.hasNext()){
            Star star=stars.next();
            maxHeap.add(star);
            if(maxHeap.size()==k+1){
                maxHeap.remove();
            }
        }

        List<Star> closestStars=new ArrayList<>(maxHeap);
        Collections.sort(closestStars);

        return closestStars;

    }
}
