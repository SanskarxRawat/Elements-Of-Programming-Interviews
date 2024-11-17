import java.util.Stack;

public class ImplementMaxAPIStack {

    /**
     * Design a stack that includes a max operation, in addition to push and pop. The max
     * method should return the maximum value stored in the stack.

     * Approach 1:
     *         //If current element is greater than
     *         // the top element of track stack, push
     *         // the current element to track stack
     *         // otherwise push the element at top of
     *         // track stack again into it.
     */

    /**
     * Time Complexity: O(1)
     * Space Complexity: O(n)
     */
    static class StackWithMax{
        static Stack<Integer> mainStack = new Stack<Integer> ();

        // Stack to keep track of max element
        static Stack<Integer> trackStack = new Stack<Integer> ();

        static void push(int x){
            mainStack.push(x);
            if (mainStack.size() == 1){
                trackStack.push(x);
                return;
            }
            if (x > trackStack.peek())
                trackStack.push(x);
            else
                trackStack.push(trackStack.peek());
        }

        static int getMax(){
            return trackStack.peek();
        }

        static void pop(){
             mainStack.pop();
            trackStack.pop();
        }
    }

    /**
     * While pushing x into stack if x is greater than maxEle we push modified value = 2 * x-maxEle.
     * So, x > val
     * => x-val>0
     * => adding x to both sides 2x – val >x (this is our updated maxEle  from next steps).
     * Means the modified value is greater than maxEle.
     * After popped out the maxEle should be updated
     * so maxEle = 2*maxEle – y (top value)
     * = 2*maxEle – (2*x- previousMax)
     * = 2*maxEle – 2*maxEle (maxELe = x in next steps) + previousMax
     * = previousMax.
     */


    /**
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */
    static class MaxStack {
        private Stack<Long> stack = new Stack<>();
        private long maxEle;

        public void push(long x) {
            if (stack.isEmpty()) {
                stack.push(x);
                maxEle = x;
            } else if (x <= maxEle) {
                stack.push(x);
            } else {
                // Store modified value
                stack.push(2 * x - maxEle);
                maxEle = x;
            }
        }

        public long pop() {
            if (stack.isEmpty()) {
                throw new RuntimeException("Stack is empty");
            }
            long y = stack.pop();
            if (y <= maxEle) {
                return y;
            } else {
                // y is a modified value
                long prevMax = maxEle;
                maxEle = 2 * maxEle - y;
                return prevMax;
            }
        }

        public long getMax() {
            if (stack.isEmpty()) {
                throw new RuntimeException("Stack is empty");
            }
            return maxEle;
        }
    }



}
