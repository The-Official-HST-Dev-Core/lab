package Lab2s3;
import SortInterface.*;

import java.util.ArrayList;
import java.util.List;
import Lab2s1.InsertionSort;

public class StudentSort implements Sorting<Student> {
    public void sortByAlphabet(List<Student> students) {
    if (students == null || students.size() <= 1) return;
    for (int i = students.size() - 2; i >= 0; i--) {
        Student lastel = students.get(i);                       
        int j = i + 1;
        while (j <= students.size() - 1
               && students.get(j).compareTo(lastel) < 0) {       
            students.set(j - 1, students.get(j));
            j++;
        }
        students.set(j - 1, lastel);
    }
}
    private void slice(List<Student> nums, int start, int end) {
        if (start >= end){
            return;
        }
        int mid = start + (end-start)/2;
        slice(nums,mid+1,end);
        slice(nums,start,mid);

        merge(nums, start, mid, end);
        
        //slice(nums,);
    }
    private void merge(List<Student> nums, int start, int middle, int end) {
        List<Student> temporal = new ArrayList<>(end - start + 1);
        int i = start;
        int j = middle+1;

        while (i <= middle && j <= end){
            if (nums.get(i).getAge() >= nums.get(j).getAge()){
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
    public void sort(List<Student> nums) {
        if (nums == null || nums.size() <= 1){
            return;
        }
        slice(nums, 0, nums.size() - 1);
        sortByAlphabet(nums);
    }
}
