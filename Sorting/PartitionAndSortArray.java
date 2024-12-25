import java.util.*;

public class PartitionAndSortArray {

    /**
     * You are given an array of student objects. Each student hasan integer-valued age field
     * that is to be treated as a key. Rearrange the elements of the array so that students of
     * equal age appear together. The order in which different ages appear is not important.
     * How would your solution change if ages have to appear in sorted order?
     */

    /**
     * Time complexity: O(n)
     * Space complexity: O(m) m is the distinct ages in the array
     */

    static class Person{
        int age;
        String name;

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }

    public static List<Person> partitionAndSort(List<Person> people) {
        Map<Integer, Integer> ageToCount = new HashMap<>();
        for (Person person : people) {
            ageToCount.put(person.age, ageToCount.getOrDefault(person.age, 0) + 1);
        }

        Map<Integer, Integer> ageToOffset = new HashMap<>();
        int offset = 0;
        for (Map.Entry<Integer, Integer> entry : ageToCount.entrySet()) {
            ageToOffset.put(entry.getKey(), offset);
            offset += entry.getValue();
        }

        while (!ageToOffset.isEmpty()) {
            Map.Entry<Integer, Integer> from = ageToOffset.entrySet().iterator().next();
            Integer toAge = people.get(from.getValue()).age;
            Integer toValue = ageToOffset.get(toAge);
            Collections.swap(people, from.getValue(), toValue);
            // Use ageToCount to see when we are finished with a particular age
            Integer count = ageToCount.get(toAge) - 1;
            ageToCount.put(toAge, count);
            if (count > 0) {
                ageToOffset.put(toAge, toValue + 1);
            } else {
                ageToOffset.remove(toAge);
            }
        }
        return people;
    }
}
