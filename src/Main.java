import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        String exampleOne = "{[()]}";
        String failedExample = "([}}])";
//        String exampleTwo = "()[]{}";
//        String exampleThree = "(]";
//        boolean result = isValid(exampleOne);
//        System.out.println("() results in: " + isValid(exampleOne));
//        System.out.println("()[]{} results in: " + isValid(exampleTwo));
//        System.out.println("(] results in: " + isValid(exampleThree));
        boolean result = isValid(failedExample);

       // System.out.println("{[()]} should return true: " + isValid(exampleOne));
        System.out.println("([}}]) should return false: " + isValid(failedExample));


    }

    public static boolean isValid(String s) {

        // flag to be returned
        boolean flag = false;

        // keep track of the amount of characters that are removed
        int removedCharacterCount = 0;
        // if s has an odd number of letters, then return false
        if(s.length()%2 != 0){
            return false;
        }

        // we need a stack
        Stack<Character> stack = new Stack<Character>();

        // iterate through and add the "open" brackets to the stack
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
                stack.push(s.charAt(i));
            }
            // if a "closed" character appears, and there is an opening bracket to go with it, pop it from stack
            // make sure the stack is not empty
            else if(s.charAt(i) == ')' && !stack.isEmpty() && stack.peek() == '('){
                // this will remove the open (
                stack.pop();
                removedCharacterCount++;
            }
            // check the bracket scenario
            else if(s.charAt(i) == ']'&& !stack.isEmpty() && stack.peek() == '[' ){

                // this will remove the open [ from the stack
                stack.pop();
                removedCharacterCount++;
            }
            // check the curley brace scenario
            else if(s.charAt(i) == '}'&& !stack.isEmpty() && stack.peek() == '{' ){
                // this will remove the { from the stack
                stack.pop();
                removedCharacterCount++;
            }

        }

        // print for testing purposes
        //System.out.println(stack.toString());
        //System.out.println(stack.peek().toString());
        if(removedCharacterCount * 2 == s.length()){
            flag = true;
        }
        else{
            flag = false;
        }

        return flag;
    }
}

