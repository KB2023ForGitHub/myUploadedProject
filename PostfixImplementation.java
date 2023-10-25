//Need a separate class that is mainly for check what type of operator the file
//inputted, and then to perform that operation
public class PostfixImplementation {
    //Need to keep track of what the result is after a mathematical operation was
    //performed so can relay that to Main class.
    private int result;

    public PostfixImplementation(){

    }

    //Find what type of operator was inputted into function and then perform that
    //operation on the numbers.
    public int performOperation(int firstNum, int secondNum, String op){

        if (op.equals("+")) {
            //If the operator is a "+", perform subtraction.
            result = firstNum + secondNum;

        } else if (op.equals("-")) {
            //If the operator is a "-", perform subtraction.
            result = firstNum - secondNum;

        } else if (op.equals("*")) {
            //If the operator is a "*", perform multiplication.
            result = firstNum * secondNum;

        } else if (op.equals("/")) {
            //If the operator is a "/", perform division.
            result = firstNum / secondNum;
        }

        //Return the result
        return result;
    }
}
