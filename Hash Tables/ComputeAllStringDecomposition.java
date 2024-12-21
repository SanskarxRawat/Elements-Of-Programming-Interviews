import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComputeAllStringDecomposition {

    /**
     * This problem is concerned with taking a string (the "sentence" string) and a set
     * of strings (the "words"), and finding the substrings of the sentence which are the
     * concatenation of all the words (in any order). For example, if the sentence string
     * is "amanaplanacanal" and the set of words is {"can","apl","ana"), "aplanacan" is a
     * substring of the sentence that is the concatenation of all words.
     */

    /**
     * Time Complexity: O(n*m) where n is the length of the sentence and m is the length of the words
     * Space Complexity: O(m) where m is the number of the words
     */


    public static List<Integer> findAllSubstrings(String s, List<String> words){
        List<Integer> ans=new ArrayList<>();

        int len=words.get(0).length();

        Map<String,Integer> wordCount=new HashMap<>();
        for(String word:words){
            wordCount.put(word,wordCount.getOrDefault(word,0)+1);
        }

        for(int i=0;i<=s.length()-len*words.size();i++){

            Map<String,Integer> countMap=new HashMap<>(wordCount);

            for(int j=0;j<words.size();j++){

                String str=s.substring(i+j*len,i+j*len+len);

                if(countMap.containsKey(str)){
                    if(countMap.get(str)==1) {
                        countMap.remove(str);
                    }else{
                        countMap.put(str,countMap.get(str)-1);
                    }
                    if(countMap.isEmpty()){
                        ans.add(i);
                        break;
                    }
                }else{
                    break;
                }
            }
        }

        return ans;
    }
}
