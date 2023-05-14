package dsa.mycode;

public class Stack {
    private int[] array;
    private int top;
    private int capacity;

    public Stack(int size) {
        array = new int[size];
        capacity = size;
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    public void push(int item) {
        if (isFull()) {
            System.out.println("Stack is full.");
            return;
        }
        array[++top] = item;
        System.out.println("Pushed " + item + " to the stack.");
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return -1;
        }
        int item = array[top--];
        System.out.println("Popped " + item + " from the stack.");
        return item;
    }
    public static String reverseString(String s) {
        int len = s.length();
        char[] chars = s.toCharArray();
        for (int i = 0; i < len / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[len - i - 1];
            chars[len - i - 1] = temp;
        }
        return new String(chars);
    }

    public static boolean isParanthesisBalanced(String s) {
        java.util.Stack<Character> stack = new java.util.Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if ((c == ')' && top != '(') || (c == '}' && top != '{') || (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return -1;
        }
        return array[top];
    }

    public static int evaluatePostfix(String postfix) {
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        for (char c : postfix.toCharArray()) {
            if (Character.isDigit(c)) {
                stack.push(c - '0');
            } else {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                switch (c) {
                    case '+':
                        stack.push(operand1 + operand2);
                        break;
                    case '-':
                        stack.push(operand1 - operand2);
                        break;
                    case '*':
                        stack.push(operand1 * operand2);
                        break;
                    case '/':
                        stack.push(operand1 / operand2);
                        break;
                    case '^':
                        stack.push((int) Math.pow(operand1, operand2));
                        break;
                }
            }
        }
        return stack.pop();
    }

    public static String infixToPostfix(String infix) {
        java.util.Stack<Character> stack = new java.util.Stack<>();
        StringBuilder postfix = new StringBuilder();
        for (char c : infix.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                postfix.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                }
            } else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    postfix.append(stack.pop());
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }
        return postfix.toString();
    }

    public static int precedence(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }


    public static void main(String[] args) {
        Stack stack = new Stack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.pop();
        System.out.println("Top element is " + stack.peek());

        String str = "Hello, world!";
        String reversedStr = reverseString(str);
        System.out.println(reversedStr);


        String s1 = "{(a+b)*(c+d)}";
        String s2 = "[(a+b)*(c+d)";
        String s3 = "(a+b)*[c+d)]";
        System.out.println(isParanthesisBalanced(s1)); // true
        System.out.println(isParanthesisBalanced(s2)); // false
        System.out.println(isParanthesisBalanced(s3)); // false

        String infix = "a+b*(c^d-e)^(f+g*h)-i";
        String postfix = infixToPostfix(infix);
        System.out.println(postfix); // abcd^e-fgh*+^*+i-

        String postfix1 = "234*+5-";
        int result = evaluatePostfix(postfix1);
        System.out.println(result); // 1
    }
}

