//Need a separate class that is about making the counter that converts numbers
//to a desired base in order to make the code easier to follow and understand
public class BCImplementation {
    //Need a base variable in this class to be able to be use the base
    //number received from the Main class (where the object of this class
    //is instantiated) inside this class and this class' methods
//    private int base;

    //Need a number variable in this class to be able to be use the number
    //received from the Main class (where the object of this class is
    //instantiated) inside this class and this class' methods
//    private int number;

    //Need to instantiate an object from Queue class as will be using it
    //in almost every method. The queue holds Strings to make it easier
    //to concatenate and print out the numbers
    private Queue<String> q = new Queue<>();

    //Need to have two separate variables for the attaching of digits, once
    //a number has been dequeued. Otherwise it would be hard to add the
    //next digit of the one's place to the number once it was already
    //attached to a previous digit.
    String string1 = "";
    String string2 = "";

    public BCImplementation() {

    }

    //The premise of the function is to print out the one's place of a base
    //and enqueue all of them. Then take the first element off of the queue
    //to attach each of the one's place. Numbers from base 2-10 have a
    //pattern of where the digits of the one's place are written first
    //before the number "10" and that each of the one's digits is attached
    //to "1" in "10". For example, in base 3 it is 1, 2, 10. And for base 4
    // it is 1, 2, 3, 10.  All of this goes on for numbers "20" to "30",
    // "30" to "40", etc. So this method does this for all numbers from 1
    //to the target number in the desired base.
    public void baseCounting(int b, int num) {
        //Making sure that the base is between 2-8; if not make a default
        //base and number
        if (b < 2 || b > 8) {
            System.out.println("The base must be 2-8, including 2 and 8.");
            System.out.println("Here is an example with base as 3 and number as 5");

            b = 3;
            num = 5;
        }

        //Letting user know what base and number are being used in the program.
        System.out.println("The numbers from 1 to " + num + " in base " + b + " is:");

        //Print out one's place of desired base
        //Add it to queue to print out later and to attach other digits to
        //that number.
        for (int i = 1; i < b; i++) {
            q.enqueue(String.valueOf(i));
        }

        //Counting up from 1 to desired number in base
        for (int i = 1; i <= num; i++) {
            //Dequeue the number in the queue and print out result.
            string1 = q.dequeue();
            System.out.println(string1);
            //After dequeueing that number, for every digit of the one's place
            //attach it to that number and then enqueue it.
            for (int j = 0; j < b; j++) {
                string2 = string1 + j;
                q.enqueue(string2);
            }
        }


    }

}


        //For each number in the range of 1 to the target number, print out
        //what is in the queue and remove it from the queue.
//        for (int i = 1; i <= number; i++) {
//            string1 = q.dequeue();
//            System.out.println(string1);
//            //After dequeueing that number, for every digit of the one's place
//            //attach it to that number and then enqueue it.
//            for (int j = 0; j < base; j++) {
//                string2 = string1 + j;
//                q.enqueue(string2);
//            }
//        }



//    Queue<String> q = new Queue<>();
//    int n = 10;
//    //q.enqueue("1");
//    String string1 = "";
//    String string2= "";
//    int base = 5;
//
////Print out one's place of base
//
//        for(int i =1; i<base; i++){
//        q.enqueue(String.valueOf(i));
//        }
//
//        for(int i =1; i<=n; i++){
//        string1 = q.dequeue();
//        System.out.println(string1);
//        for (int j=0; j<base; j++){
//        string2 = string1 +j;
//        q.enqueue(string2);
//        }
//        }

