package Lab2s1;
import SortInterface.Sorting;

import java.util.List;

public class InsertionSort<T extends Comparable<? super T>> implements Sorting<T>{
    @Override
    public void sort(List<T> nums) {

        if (nums ==null || nums.size()<=1){
            return;
        }
        for (int i=nums.size()-2;i>= 0;i--) {
            //int lastel = nums.get(i);
            int j = i+1;
            while (j <= nums.size()-1 && nums.get(j).compareTo(nums.get(i))<0) {
                nums.set(j - 1, nums.get(j));
                j++;
            }
            nums.set(j-1,nums.get(i));
        }
    }
}