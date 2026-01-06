import java.util.*;
class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> r=new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(ch=='(' || ch=='['||ch=='{')
            r.push(ch);
           else
           {
            if(r.size()==0)
            return false;
            else
            {
                if(r.peek()=='(' && s.charAt(i)==')') r.pop();
                else if(r.peek()=='[' && s.charAt(i)==']') r.pop();
                else if(r.peek()=='{' && s.charAt(i)=='}') r.pop();
                else if(s.charAt(i)==')' || s.charAt(i)==']' || s.charAt(i)=='}')
                return false;
            }
           }
        }
        if(r.size() != 0)
        return false;
        else
        return true;
    }
}