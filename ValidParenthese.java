/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
*/

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        char[] charc=s.toCharArray();
        for(char c:charc){
            if(c=='('||c=='{'||c=='[') stack.push(c);
            else {
                if(stack.isEmpty()) return false;
                char t=stack.pop();
                if(!match(t,c)) return false; 
            }
        }
        return stack.isEmpty();
    }
    public boolean match(char t, char c){
        if(t=='('&&c==')') return true;
        if(t=='{'&&c=='}') return true;
        if(t=='['&&c==']') return true;
        return false;
    }
    
}
