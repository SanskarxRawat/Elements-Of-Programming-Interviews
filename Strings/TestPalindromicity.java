public class TestPalindromicity {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    private boolean palindromicity(String str) {


        int left=0,right=str.length()-1;

        while(left<right){

           while(!Character.isDigit(str.charAt(left)) && left<right){
               left++;
           }

           while(!Character.isDigit(str.charAt(right)) && left<right){
               right--;
           }

           if(Character.toLowerCase(str.charAt(left++)) != Character.toLowerCase(str.charAt(right--))){
               return false;
           }
        }

        return true;
    }
}
