import java.util.HashSet;
import java.util.List;

public class ContactList {

    public List<String> names;

    public ContactList(List<String> names){
        this.names=names;
    }

    public boolean equals(Object obj){
        if(obj==null || !(obj instanceof ContactList)){
            return false;
        }

        return this==obj?true: new HashSet<>(names).equals(new HashSet<>(((ContactList)obj).names));
    }

    public int hashCode(){
        return new HashSet<>(names).hashCode();
    }

}
