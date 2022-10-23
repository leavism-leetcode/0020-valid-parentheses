import java.util.HashMap;
import java.util.Stack;

public class Solution {

    public static boolean isValid(String s) {
        Stack<Character> bracketStack = new Stack<>();
        HashMap<Character, Character> bracketMap = new HashMap<>();
        bracketMap.put(')', '(');
        bracketMap.put('}', '{');
        bracketMap.put(']', '[');

        for(int index = 0; index < s.length(); index++) {
            // if string at index is open bracket, push to stack
            if(bracketMap.containsValue(s.charAt(index))) {
                bracketStack.push(s.charAt(index));
                continue;
            }
            // if stack is empty or the top of the stack isn't the open bracket for the current close bracket, return false
            if (bracketStack.empty() || bracketStack.pop() != bracketMap.get(s.charAt(index))) {
                return false;
            }
        }
        return bracketStack.empty();
    }

    public static void main(String[] args) {
        String in = "]";

        System.out.println(isValid(in));
    }
}
