import java.util.Map;
import java.util.TreeMap;

public class AddCredit {


    /**
     * Consider a server that a large number of clients connect to. Each client is identified by
     * a string. Each client has a "credit", which is a non-negative integer value. The server
     * needs to maintain a data structure to which clients can be added, removed, queried,
     * or updated. In addition, the server needs to be able to add a specified number of
     * credits to all clients simultaneously.
     */

    /**
     * Design a data structure that implements the following methods:
     * • Insert: add a client with specified credit, replacing any existing entry for the
     * client.
     * • Remove: delete the specified client.
     * • Lookup: return the number of credits associated with the specified client.
     * • Add-to-all: increment the credit count for all current clients by the specified
     * amount.
     * • Max: return a client with the highest number of credits.
     */

    /**
     * Insert, Remove and LookUp works in O(logn) time complexity.
     * Add-to-all works in O(1) time complexity.
     * Max is efficient time complexity.
     */

    private Map<String,Integer> clientToCredit;
    private TreeMap<Integer,Integer> creditCounts;
    private int globalIncrement;


    public AddCredit(){
        clientToCredit = new TreeMap<>();
        creditCounts = new TreeMap<>();
        globalIncrement = 0;
    }

    public void insert(String clientId,int credit){
        if(clientToCredit.containsKey(clientId)){
            remove(clientId);
        }
        int adjustedCredit = credit - globalIncrement;
        clientToCredit.put(clientId, adjustedCredit);
        creditCounts.put(adjustedCredit, creditCounts.getOrDefault(adjustedCredit, 0) + 1);
    }

    public void remove(String clientId){
       if(!clientToCredit.containsKey(clientId)) return;

       int credit = clientToCredit.get(clientId);
       int creditCount=creditCounts.get(credit);
       if(creditCount==1){
           creditCounts.remove(credit);
         }else{
           creditCounts.put(credit,creditCount-1);
       }
         clientToCredit.remove(clientId);
    }

    public int lookUp(String clientId){
       if(!clientToCredit.containsKey(clientId)) return -1;

       return clientToCredit.get(clientId)+globalIncrement;
    }

    public String max(){
        if(clientToCredit.isEmpty()){
            return null;
        }

        int maxAdujustedCredit = creditCounts.lastKey()+globalIncrement;

        for(Map.Entry<String,Integer> entry:clientToCredit.entrySet()){
            if(entry.getValue()+globalIncrement==maxAdujustedCredit){
                return entry.getKey();
            }
        }

        return null;
    }
    // Increment the credit of all clients by the specified amount
    public void addToAll(int amount) {
        globalIncrement += amount;
    }
}
