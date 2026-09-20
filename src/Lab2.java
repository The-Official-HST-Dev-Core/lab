import java.util.Arrays;

public class Lab2{
    static void main() {
        Lab2 program = new Lab2();
        int array[]={1,2,5,3,5,4};
        System.out.println(program.removeElementInPlace(array,3));
    }
    public int removeElementInPlace(int[] arr, int val){
        int valAssassinTargs = 0;
        for (int i =0; i<arr.length; i++){
            if (arr[i]==val){
                arr[valAssassinTargs]=arr[i]; // literal mindfuckery
                valAssassinTargs++;
            }
        }
        System.out.printf("Targets killed: %d", valAssassinTargs);
        System.out.printf("Non-targets: %s", Arrays.toString(arr));
        return valAssassinTargs;
    }


}