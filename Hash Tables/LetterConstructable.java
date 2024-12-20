import java.util.HashMap;
import java.util.Map;

public class LetterConstructable {

    /**
     * Time Complexity: O(n+m)
     * Space Complexity: O(l), l is the number of unique characters
     */

      public static boolean isLetterConstructibleFromMagazine(String letterText,String magazineText){

          Map<Character,Integer> frequency=new HashMap<>();

          for(char c:letterText.toCharArray()){
              frequency.merge(c,1,Integer::sum);
          }

          for(char c:magazineText.toCharArray()){
              if(frequency.containsKey(c)){
                  frequency.merge(c,-1,Integer::sum);
              }
              if(frequency.get(c)==0){
                  frequency.remove(c);
                  if(frequency.isEmpty()){
                      break;
                  }
              }
          }

          return frequency.isEmpty();
      }
}
