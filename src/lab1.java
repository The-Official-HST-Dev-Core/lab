import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;


public class Solution{
    public checkArray(String str){
        Deque<Character> stack = new ArrayDeque<>();
        for(int i=0; i<str.length();i++){
            char ch = str.charAt(i);
            stack.push(ch);
            if (((ch == ')') && (stack.pop() != '(')) || (!stack.isEmpty())){
                return false;
            }
            if (((ch == ']') && (stack.pop() != '[')) || (!stack.isEmpty())){
                return false;
            }
            if (((ch == '{') && (stack.pop() != '}')) || (!stack.isEmpty())){
                return false;
            }
        }
        return stack.isEmpty();
    }
}
Main program = new Solution();
program.checkArray("(((){}))");
