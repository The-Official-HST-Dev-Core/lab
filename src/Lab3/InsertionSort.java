package Lab3;
import SortInterface.Sorting;

import java.util.List;

public class InsertionSort implements Sorting<Integer> {
    @Override
    public void sort(List<Integer> nums) {

        if (nums ==null || nums.size()<=1){
            return;
        }
        for (int i=nums.size()-2;i>= 0;i--) {
            int lastel = nums.get(i);
            int j = i+1;
            while (j <= nums.size()-1 && nums.get(j) < lastel) {
                nums.set(j - 1, nums.get(j));
                j++;
            }
            nums.set(j-1,lastel);
        }

    }
}