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
        int min=nums.get(0);
        int max=nums.get(1);
        if(nums.get(0)>nums.get(1)){
                max=nums.get(0);
                min=nums.get(1);
            }
        for (int i=1;i<nums.size();i++){
            if(nums.get(i)>max){
                max=nums.get(i);
            }
            if(nums.get(i)<min){
                min=nums.get(i);
            }
        }
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
