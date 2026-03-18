// Problem: Valid Parentheses
// Pattern: Stack
// LeetCode: 20

// Approach:
// - Use a stack to keep track of opening brackets
// - For every closing bracket, check top of stack
// - If mismatch → invalid

// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.*;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(char ch : s.toCharArray()) {
            if(ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if(stack.isEmpty()) return false;

                char top = stack.pop();
                if((ch == ')' && top != '(') ||
                   (ch == '}' && top != '{') ||
                   (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
