public class Main {

    public static void main(String[] args) {

        String exampleOne ="()";
        String exampleTwo ="()[]{}";
        String exampleThree ="(]";
        boolean result = isValid(exampleOne);
        System.out.println("() results in: " + isValid(exampleOne));
        System.out.println("()[]{} results in: " + isValid(exampleTwo));
        System.out.println("(] results in: " + isValid(exampleThree));
    }

    public static boolean isValid(String s){
        // need a flag for result of for loop
        boolean flag = true;

        int sizeOfString = s.length();

        // if there is an odd number of character in string, set flag to false
        if(sizeOfString % 2 != 0){
            flag = false;
        }
        else{
            // I want to find the "middle" set of brackets
            int leftIndex = 0 ;  //need to minus 1 because index starts at zero
            int rightIndex = leftIndex +1;     // right index should be placed at the correct index by dividing by 2

            // start from the middle and work outwards
            while(flag && rightIndex <= s.length()-1){
                flag = parenthesesChecker(s.charAt(leftIndex), s.charAt(rightIndex));

                // need to make sure we do not decrement lower than zero
                // if flag is still true, decrement leftIndex, increment rightIndex, check again with the next set
                if(flag){
                    leftIndex +=2;
                    rightIndex = leftIndex +1;
                }
            }
        }

            return flag;
    }

    public static boolean parenthesesChecker(char lI, char rI){
        boolean flag = false;
        // ()
        if(lI == '(' && rI == ')'){
            flag = true;
        }

        //{}
        else if(lI == '{' && rI == '}'){
            flag = true;
        }
        // []
        else if(lI == '[' && rI == ']'){
            flag = true;
        }
        return flag;
    }
}
