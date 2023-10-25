import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("1) Base counter");
        System.out.println("2) Postfix calculator");

        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) {
            System.err.println("Invalid choice");
            System.exit(1);
        }
        int choice = sc.nextInt();
        switch (choice) {
            case 1 -> baseCounter();
            case 2 -> postfixCalculator();
            default -> {
                System.out.println("Invalid choice");
                System.exit(1);
            }
        }
    }


//        for(int i =1; i<=10;i++) {
//            str = qString.dequeue();
//            System.out.println(str);
//

//            str2 = str+"1";
//            str +="0";
//
//            qString.enqueue(str);
//            qString.enqueue(str2);

//
//
//        }


    private static void baseCounter() {
        //Getting input from text file in the form of base first then the number
        InputStream is = Main.class.getResourceAsStream("base_test.txt");
        Scanner sc = new Scanner(is);

        //Instantiating the class that brings together the process of converting
        //a number from base 10 to desired base to use it on every number from
        //1 to the desired number.
        BCImplementation b = new BCImplementation();

        //If there is nothing in the line, then the file is empty.
        if (!sc.hasNext()) {
            System.out.println("The file is empty.");

            //If there is a integer in the file, then that is the base
        } else if (sc.hasNextInt()) {
            //Assigning number from file to base
            int base = sc.nextInt();

            //Check to see if there is a number inside file. If there isn't print an
            //error message. If there is a number then the counting can begin.
            if (!sc.hasNextInt()) {
                System.out.println("There is a base, but no number in the file");
            } else {

                //Assigning a number from the file to number
                int number = sc.nextInt();

                //Count up to desired number in desired base
                b.baseCounting(base, number);
            }

            //If there is something in the file but it is not an integer, then it is
            //invalid input. Error message is printed
        } else {
            System.out.print("The file has invalid input. ");
            System.out.println("The file must have two integers with a space in between them.");
        }
    }

    private static void postfixCalculator() {
        //Getting input from file
        InputStream is = Main.class.getResourceAsStream("postfix_test.txt");
        Scanner sc = new Scanner(is);

        //Instantiating stack class
        Stack<Integer> st = new Stack<>();

        //Instantiating the class that checks what operator is pulled from the file
        //so math operations can be performed on the numbers from the file
        PostfixImplementation pFI = new PostfixImplementation();


        //Declaring variables. There will always be a first or second number that
        //will need to be operated on as per the rules of postfix calculators.
        //Also will need ta variable for result to store the value after the
        //operation.
        int num = 0;
        int secondNum = 0;
        int result = 0;

        //Check to see if file is empty. If so, then print out error message
        if(!sc.hasNext()){
            System.out.println("The file is empty.");
        }


        //Checking to see if there is a line to read As long as there is a line to
        //read, then it is possible to proceed with reading from the file.
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            Scanner lineScanner = new Scanner(line);

            //Checks if there is anything in a line of a file. If not then
            //display error message. If there is, continue.
            if (!lineScanner.hasNext()) {
                System.out.println("There are no numbers or operations in this line");
            } else {
                //As long as there is something in that line and it is an int
                //then push that integer in the stack. Otherwise if it is not an
                //int, then is an operator. This means pop two numbers off the stack
                //and perform a mathematical operation on them depending on what
                //was the operator.
                while (lineScanner.hasNext()) {
                    if (lineScanner.hasNextInt()) {
                        int number = lineScanner.nextInt();
                        st.push(number);

                        //If there is a string then need to find out if string is
                        // a plus, a minus, a multiplication sign, or division sign.
                    } else if (lineScanner.hasNext()) {
                        String operator = lineScanner.next();

                        //Checking if operator is valid
                        if (operator.equals("+") || operator.equals("-") | operator.equals("/") || operator.equals("*")) {

                            //The second number is the last number pushed on the
                            //stack. Need to keep track so the calculations are
                            //done in the right order.
                            secondNum = st.pop();
                            num = st.pop();

                            //Get the result of the math operation
                            result = pFI.performOperation(num, secondNum, operator);

                            //Push result on the stack
                            st.push(result);
                        }
                    }
                }
                //Take final result off of the stack.
                result =st.pop();

                //If calculations were done correctly there should only be one final
                //number that should be printed out, which means once it is taken
                //off the stack, the stack should be empty. If not then the there
                //was something wrong with the line in the file, and thus error
                //message is printed.
                if(st.isEmpty()) {
                    //Print out final result for each line
                    System.out.println(result);
                } else{
                    //If no valid operator detected, then exit program
                    //as there is no mathematical operation to be performed.
                    System.out.print("No valid operator detected.");
                    System.out.print(" Please check the file to make sure");
                    System.out.print(" that there are only numbers and either");
                    System.out.print(" \"+\", \"-\", \"*\", or \"/\" and a space between each");
                    System.out.println(" character.");

                }

                //Delete contents of queue since done with that line. If calculations
                //were done incorrectly due to whatever reason, then values are on
                //the stack which means they need to be taken off for the next
                //set of calculations to be done in the next line in the file.
                while(!st.isEmpty()){
                    st.pop();
                }
            }
        }
    }
}


//    //int base = 9;
//    //int number = 1590;
//    //int num = 266308009;
//    int numSave;

//       Random rand = new Random();
//       int num;
//       num = rand.nextInt();
//       int base;
//       base= (int)(Math.random()*(7)+2);