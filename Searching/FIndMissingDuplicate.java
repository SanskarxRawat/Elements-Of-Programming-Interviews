import java.util.List;

public class FIndMissingDuplicate {

    /**
     *  Time Complexity: O(n)
     *  Space Complexity: O(1)
     */

    private static class DuplicateAndMissing{
        public Integer duplicate;
        public Integer missing;

        public DuplicateAndMissing(Integer duplicate,Integer missing){
            this.duplicate=duplicate;
            this.missing=missing;
        }


        public static DuplicateAndMissing findDuplicateAndMissing(List<Integer> A){

            //Compute the XOR of all numbers from 0 to |A|-1 and all entries in A

            int missXORDup=0;

            for(int i=0;i<A.size();i++){
                missXORDup^=i^A.get(i);
            }

            /** We need to find a bit that's set to 1 in missXORDup.Such
             * a bit must exist if there is a single missing number and single duplicated number in A
             *
             *
             * The bit-fiddling assignment below sets all of bits in differentBit to 0
             * except for the least significant bit in missXORDup that's 1
             */


            int differBit=missXORDup&(~(missXORDup-1));
            int missOrDup=0;

            for(int i=0;i<A.size();i++){
                //Focus on entries and numbers in which differBit-th bit is 1


                if((i&differBit)!=0){
                    missOrDup^=i;
                }

                if((A.get(i)&differBit)!=0){
                    missOrDup^=A.get(i);
                }
            }

            for(int a:A){
                if(a==missOrDup){ //missOdDup is the duplicate
                    return new DuplicateAndMissing(missOrDup,missOrDup^missXORDup);
                }
            }
            //missOrDup is the missing value
            return new DuplicateAndMissing(missOrDup^missXORDup,missOrDup);
        }
    }
}
