package Lab4;
import SortInterface.Sorting;

import java.util.ArrayList;
import java.util.List;

public class MergeSort implements Sorting<Integer> {
    private void slice(List<Integer> nums, int start, int end) {
        if (start >= end){
            return;
        }
        int mid = start + (end-start)/2;
        slice(nums,mid+1,end);
        slice(nums,start,mid);

        merge(nums, start, mid, end);
        
        //slice(nums,);
    }

    private void merge(List<Integer> nums, int start, int middle, int end) {
        List<Integer> temporal = new ArrayList<>(end - start + 1);
        int i = start;
        int j = middle+1;

        while (i <= middle && j <= end){
            if (nums.get(i) >= nums.get(j)){
                temporal.add(nums.get(j));
                j++;
            } else{
                temporal.add(nums.get(i));
                i++;
            }
        }
        while (i <= middle) {
            temporal.add(nums.get(i));
            i++;
        }
        while (j <= end) {
            temporal.add(nums.get(j));
            j++;
        }
        for (int z = 0; z < temporal.size(); z++) {
            nums.set(start + z, temporal.get(z));
        }
        // TODO
    }
    @Override
    public void sort(List<Integer> nums) {
        if (nums == null || nums.size() <= 1){
            return;
        }
        slice(nums, 0, nums.size() - 1);
    }
}
