import java.util.Deque;
import java.util.LinkedList;

public class SimplifyPathNames {


    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public String simplifyPath(String path) {
        Deque<String> st = new LinkedList<>();
        String[] directory = path.split("/");
        for(String dir : directory){
            if(dir.equals(".") || dir.isEmpty()){
                continue;
            } else if(dir.equals("..")){
                if(!st.isEmpty()){
                    st.pop();
                }
            } else{
                st.push(dir);
            }
        }
        return "/" + String.join("/", st);
    }
}
