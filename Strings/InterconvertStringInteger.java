public class InterconvertStringInteger {


    public static String intToString(int x) {

        boolean isNegative=x<0;

        StringBuilder sb=new StringBuilder();

        do{
            sb.append((char)('0'+Math.abs(x%10)));
            x=x/10;
        }while(x!=0);

        if(isNegative){
            sb.append("-");
        }

        return sb.reverse().toString();
    }

    public static int stringToInt(String str) {
        int result=0;

        for(int i=str.charAt(0)=='-'?1:0;i<str.length();i++){
            final int digit=str.charAt(i)-'0';
            result=result*10+digit;
        }

        return str.charAt(0)=='-'?-result:result;
    }

}
