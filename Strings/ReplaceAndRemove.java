public class ReplaceAndRemove {

    /**
     * Consider the following two rules that are to be applied to an array of characters.
     * • Replace each 'a' by two 'd's.
     * • Delete each entry containing a 'b'.
     * For example, applying these rules to the array (a,c,d,b,b,c,a ) results in the array
     * (d,d,c,d,c,d,d)
     */

    /**
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */

    public static int replaceAndRemove(int size,char[] chars) {
        int writeIndex=0,aCount=0;


        for(int i=0;i<chars.length;i++){

            if(chars[i]!='b'){
                chars[writeIndex++]=chars[i];
            }
            if(chars[i]=='a'){
                aCount++;
            }
        }

        int currentIndex=writeIndex-1;

        writeIndex = writeIndex + aCount - 1;

        final int finalSize=writeIndex+1;

        while(currentIndex>=0){

            if(chars[currentIndex]=='a'){
                chars[writeIndex--]='d';
                chars[writeIndex--]='d';
            }else{
                chars[writeIndex--]=chars[currentIndex];
            }
            --currentIndex;
        }

        return finalSize;
    }
}
