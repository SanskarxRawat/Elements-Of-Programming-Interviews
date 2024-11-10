public class ReverseAllWordInString {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static void reverseWords(char[] s) {

        reverse(s,0,s.length);
        int start=0,end;
        while((end=findChar(s,start,' '))!=-1){
            reverse(s,start,end);
            start=end+1;
        }
        reverse(s,start,s.length);
    }

    private static void reverse(char[] s,int start,int stopIndex){
        if(start >= stopIndex){
            return;
        }
        int last=stopIndex-1;
        for(int i=start;i<=start+(last-start)/2;i++){
            char tmp=s[i];
            s[i]=s[last-i+start];
            s[last-i+start]=tmp;
        }
    }

    private static int findChar(char[] s,int start,char c){
        for(int i=start;i<s.length;i++){

            if(s[i]==c){
                return i;
            }
        }
        return -1;
    }
}
