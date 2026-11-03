package Lab3s1;
import SortInterface.*;

import java.util.ArrayList;
import java.util.List;

public class CountingSort implements Sorting<Integer>{
    @Override 
    public void sort(List<Integer> nums){
        if(nums == null || nums.size()<=1 ){
            return;
        }
        int min=0;
        int max=127;
        int[] accountant = new int[max-min+1];
        for(int j=0; j<nums.size();j++){
            accountant[nums.get(j)-min]++;
        }
        int cntr=0;
        for(int k=0; k<(max-min+1);k++){
            if (accountant[k]!=0){
                while (accountant[k]!=0) {
                nums.set(cntr, k+min);
                accountant[k]--;
                cntr++;
                }
            }
        }
    }
}
