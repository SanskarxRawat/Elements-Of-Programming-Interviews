public class FindTheFirstOccurrenceOfString {

    /**
     * Time Complexity: O(m+n)
     * Space Complexity: O(1)
     */
    private static int rabinKarp(String t,String s){
        if(s.length()>t.length()){
            return -1;
        }

        final int BASE=26;
        int tHash=0,sHash=0;
        int powerS=1;

        for(int i=0;i<s.length();i++){
            powerS=i>0?powerS*BASE:1;
            tHash=tHash*BASE+t.charAt(i);
            sHash=sHash*BASE+s.charAt(i);
        }

        for(int i=s.length();i<t.length();i++){
            if(tHash==sHash && t.substring(i-s.length(),i).equals(s)){
                return i-s.length();
            }

            tHash-=t.charAt(i-s.length())*powerS;
            sHash=sHash*BASE+t.charAt(i);
        }

        if(tHash==sHash && t.substring(t.length()-s.length()).equals(s)){
            return t.length()-s.length();
        }

        return -1;
    }
}
