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
        for (int i = 1; i < accountant.length; i++) {
            accountant[i]+=accountant[i-1];
        }

        List<Integer> temp = new ArrayList<>(java.util.Collections.nCopies(nums.size(), 0));
        for(int k=nums.size()-1; k>=0;k--){
            temp.set(accountant[nums.get(k)-min]-1,nums.get(k));
            accountant[nums.get(k)-min]--;
        }
        for(int i=0; i<nums.size();i++){
            nums.set(i, temp.get(i));
        }
    }
}
