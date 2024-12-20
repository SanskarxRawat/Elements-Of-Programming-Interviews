import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {

    /**
     * Create a cache for looking up prices of books identified by their ISBN. You implement
     * lookup, insert, and remove methods. Use the Least Recently Used (LRU) policy for
     * cache eviction. If an ISBN is already present, insert should not change the price, but
     * it should update that entry to be the most recently used entry. Lookup should also
     * update that entry to be the most recently used entry.
     */

    /**
     * Time Complexity: O(1) - lookup
     *                  O(1) - updating
     */


    private Map<Integer,Integer> isBnToPrice;

    public LRUCache(final int capacity){
        this.isBnToPrice=new LinkedHashMap<Integer,Integer>(capacity,1.0f,true){
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return this.size()>capacity;
            }
        };
    }


    public Integer lookup(Integer key){
        if(!isBnToPrice.containsKey(key)){
            return null;
        }

        return isBnToPrice.get(key);
    }


    public Integer insert(Integer key,Integer value){
        // We add the value for key only if key is not present - we don’t update
        // existing values.
        Integer currentValue = isBnToPrice.get(key);
        if (!isBnToPrice.containsKey(key)){
            isBnToPrice.put(key , value);
            return currentValue;
        } else {
            return null ;
        }
    }

    public Integer erase(Object key) {
        return isBnToPrice.remove(key);
    }

}
