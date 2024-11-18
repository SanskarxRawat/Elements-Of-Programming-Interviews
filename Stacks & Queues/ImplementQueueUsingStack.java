import java.util.Deque;
import java.util.LinkedList;

public class ImplementQueueUsingStack {

    /**
     * Your Implementation:
     *
     * push(): O(1)
     * pop(): O(n)
     * peek(): O(n)
     * Total Space: O(n)
     */


    class MyQueue {
        Deque<Integer> mainS;
        Deque<Integer> helper;
        public MyQueue() {
            mainS=new LinkedList<>();
            helper=new LinkedList<>();
        }

        public void push(int x) {
            mainS.push(x);
        }

        public int pop() {
            if(mainS.isEmpty()){
                return -1;
            }
            while(mainS.size()>1){
                helper.push(mainS.pop());
            }
            int val=mainS.pop();

            while(!helper.isEmpty()){
                mainS.push(helper.pop());
            }

            return val;

        }

        public int peek() {
            if(mainS.isEmpty()){
                return -1;
            }
            while(mainS.size()>1){
                helper.push(mainS.pop());
            }
            int val=mainS.pop();
            helper.push(val);
            while(!helper.isEmpty()){
                mainS.push(helper.pop());
            }

            return val;

        }

        public boolean empty() {
            return mainS.isEmpty();
        }
    }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
}
