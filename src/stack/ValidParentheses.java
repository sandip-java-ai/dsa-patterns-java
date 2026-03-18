package stack;

// Problem: Valid Parentheses
// LeetCode: https://leetcode.com/problems/valid-parentheses/
// Pattern: Stack

// Approach:
// - Use a stack to track opening brackets
// - Match closing brackets with stack top
// - If mismatch → invalid

// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) return false;

                char top = stack.pop();
                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    // Main method for testing
    public static void main(String[] args) {
        ValidParentheses vp = new ValidParentheses();

        String[] testCases = {
            "()",
            "()[]{}",
            "(]",
            "([)]",
            "{[]}",
            "",
            "(",
            "((()))",
            "[(])"
        };

        for (String test : testCases) {
            boolean result = vp.isValid(test);
            System.out.println("Input: " + test + " -> " + result);
        }
    }
}