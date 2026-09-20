import java.util.ArrayDeque;
import java.util.Deque;


public class Lab1{
    public static void main(String[] str1) {
        Lab1 program = new Lab1();
        System.out.println(program.checkArray("(((){}{}}))"));
    }
    public boolean checkArray(String str){
        Deque<Character> stack = new ArrayDeque<>();
        for(int i=0; i<str.length();i++){
            char ch = str.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            }else if (ch == ')' || ch == ']' || ch == '}'){
                if (stack.isEmpty()){
                    return false;
                }
                char ch2 = stack.pop();
                if ((ch == ')') && ch2 != '('){return false;}
                if ((ch == ']') && ch2 != '['){return false;}
                if ((ch == '}') && ch2 != '{'){return false;}

            }

        }
        return stack.isEmpty();
    }
}

