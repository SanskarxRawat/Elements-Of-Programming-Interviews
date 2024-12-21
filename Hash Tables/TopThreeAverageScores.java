import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;

public class TopThreeAverageScores {

    /**
     * Student test scores are recorded in a file. Each line consists of a student ID, which is
     * an alphanumeric string, and an integer between 0 and 100, inclusive.
     * Write a program which takes as input a file containing test scores and returns the
     * student who has the maximum score averaged across his or her top three tests. If the
     * student has fewer than three test scores, ignore that student
     */


    /**
     * Time Complexity: O(N+S)
     * Space Complexity: O(S) where S is the no of unique students
     */




    public static String findStudentWithHighestAverage(Iterator<Object> nameScoreData) {

        Map<String, PriorityQueue<Integer>> studentScores = new HashMap<>();

        while(nameScoreData.hasNext()){

            String name = (String) nameScoreData.next();
            Integer score = (Integer) nameScoreData.next();

            PriorityQueue<Integer> studentScore = studentScores.get(name);
            if(studentScore == null){
                studentScore = new PriorityQueue<>();
                studentScores.put(name, studentScore);
            }
            studentScore.add(score);
            if(studentScore.size() > 3){
                studentScore.poll();
            }
        }

        String topStudent="no such student";
        int currentTopThreeScore=0;

        for(Map.Entry<String, PriorityQueue<Integer>> entry : studentScores.entrySet()){

            if(entry.getValue().size() == 3){
                int currentScore = getCurrentTopThreeScoresSum(entry.getValue());
                if(currentScore > currentTopThreeScore){
                    currentTopThreeScore = currentScore;
                    topStudent = entry.getKey();
                }
            }
        }
        return topStudent;
    }

    private static int getCurrentTopThreeScoresSum(PriorityQueue<Integer> studentScore){
        Iterator<Integer> it=studentScore.iterator();
        int result = 0;

        while (it.hasNext()){
            result += it.next();
        }

        return result;
    }
}
