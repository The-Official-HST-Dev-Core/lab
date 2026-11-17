package Lab4s2;

import java.util.ArrayList;
import java.util.List;

public class PriorityQueueImpl implements PriorityQueue<Integer> {
    private static class Node {
        int value;
        long opId;

        Node(int value, long opId) {
            this.value = value;
            this.opId = opId;
        }
    }

    private final List<Node> heap = new ArrayList<>();
    private final List<Integer> positionByOp = new ArrayList<>();
    private long opCounter = 0;

    public PriorityQueueImpl() {
        positionByOp.add(-1);
    }

    @Override
    public void enqueue(Integer value) {
        opCounter++;
        Node newNode = new Node(value, opCounter);
        
        heap.add(newNode);
        int currIndex = heap.size() - 1;
        positionByOp.add(currIndex);
        
        goUp(currIndex);
    }

    private void swap(int i, int j) {
        Node nodeI = heap.get(i);
        Node nodeJ = heap.get(j);

        heap.set(i, nodeJ);
        heap.set(j, nodeI);

        positionByOp.set((int) nodeI.opId, j);
        positionByOp.set((int) nodeJ.opId, i);
    }

    private void goUp(int index) {
        int parentIndex = ((index-1)/2);
        while ( index > 0 && heap.get(parentIndex).value < heap.get(index).value ){
            swap(parentIndex, index);
            index=parentIndex;
            parentIndex = ((index-1)/2);
        }
   }
   private void goDown(int index){
            int bigKid = index;
        while (bigKid < heap.size()){
            int childLIndex = (2*index+1);
            int childRIndex = (2*index+2);
            bigKid = index;

            if (childLIndex < heap.size() && heap.get(childLIndex).value > heap.get(bigKid).value){
                bigKid = childLIndex;
            }
            if (childRIndex < heap.size() && heap.get(childRIndex).value > heap.get(bigKid).value){
                bigKid = childRIndex;
            }
            if (heap.size()< childLIndex || heap.size() < childRIndex || index == bigKid){
                break;
            }
            swap(index, bigKid);
            index=bigKid;
        }
   }

    @Override
    public Integer dequeueMax() {
	// TODO
        if (heap.isEmpty()) {return null;};
        Node deleted = heap.get(0);              
        int delIndex = heap.size() - 1;
        swap(0, delIndex);
        heap.remove(delIndex);                    
        positionByOp.set((int) deleted.opId, -1); 
        if (!heap.isEmpty()) goDown(0);
        return deleted.value;
    }

    @Override
    public void increment(long operation, Integer addition) {
        if (operation < 1 || operation >= positionByOp.size()){return;};
        int pos = positionByOp.get((int) operation);
        if (pos < 0) {return;};              
        heap.get(pos).value += addition;
        if (addition >0){
            goUp(pos);

        }else if (addition <0){
            goDown(pos);
        }
        	// TODO
    }
} 
