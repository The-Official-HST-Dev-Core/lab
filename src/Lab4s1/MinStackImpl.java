package Lab4s1;
public class MinStackImpl implements MinStack<Integer> {
    private static class Node {
        Integer val;
        Integer min;
        Node next;

        Node(Integer val, Integer min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
    private Node top;
    @Override
    public void push(Integer value) {
    if (value == null){
        return;
    }
    if (top == null){
        top = new Node(value, value, null);
    }else{
        top = new Node(value, Math.min(value, top.min), top);
    }

    // TODO
    }

    @Override
    public Integer pop() {
	// TODO
        if (top ==null){
            return null;
        }else{
            int value = top.val;
            top = top.next;
            return value;
        }
    }

    @Override
    public Integer top() {
	// TODO
        return top.val;
    }

    @Override
    public Integer min() {
	// TODO
        return top.min;
    }
} 
