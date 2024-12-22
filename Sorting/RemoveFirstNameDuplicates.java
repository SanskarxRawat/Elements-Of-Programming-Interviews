import java.util.Collections;
import java.util.List;

public class RemoveFirstNameDuplicates {

    /**
     * Design an efficient algorithm for removing all first-name duplicatesfrom an array. For
     * example, if the input is ((Ian, Botham), (David,Gower), (Ian, Bell), (Ian, Chappell)),
     * one result could be ((Ian, Bell), (David,Gower)); ((David,Gower), (Ian, Botham))
     * would also be acceptable.
     */

    /**
     * Time Complexity: O(NlogN)
     * Space Complexity: O(1)
     */


    static class Name implements Comparable<Name> {
        String firstName;
        String lastName;

        public Name(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        @Override
        public int compareTo(Name o) {
            int cmpFirst = firstName.compareTo(o.firstName);
            if (cmpFirst != 0) {
                return cmpFirst;
            }
            return lastName.compareTo(o.lastName);
        }
    }


    public static void removeFirstNameDuplicates(List<Name> names) {

        Collections.sort(names);

        int writeIndex = 1;
        for (int i = 1; i < names.size(); i++) {
            if (names.get(i).compareTo(names.get(writeIndex - 1)) != 0) {
                names.set(writeIndex++, names.get(i));
            }
        }

        names.subList(writeIndex, names.size()).clear();
    }
}
