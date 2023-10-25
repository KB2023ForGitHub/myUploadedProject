//Need a separate class that is about making the counter that converts numbers
//to a desired base in order to make the code easier to follow and understand
public class BaseCounterImplementation {
    //Need a base variable here to be able to be use the base number
    //received from the Main class (where the object of this class is
    //instantiated) inside this class and this class' methods
    private int base;

    //Need to instantiate an object from Queue class as will be using it
    //in almost every method. The queue holds Integers since the numbers
    //inputted will be of type int, which gets unwrapped and wrapped in
    //Java
    private Queue<Integer> q = new Queue<>();

    //Need to keep track of size of queue to be able to put the contents
    //of queue in an array to reverse the order in which components of number
    //in desired base are added to queue in so the number is printed out
    //correctly.
    private int size = 0;

    public BaseCounterImplementation(int b) {
        base = b;
    }


    //Basically, for each number in a range from 1 to desired number,
    //will convert from base 10 to desired base. In order to convert,
    //must divide number by base, and then divide the quotient by the base,
    //and then divide that quotient. The quotient keeps getting divided
    //until quotient is 0. The remainder of each division represents the
    //place holder of the number represented in the desired base. Each
    //place holder is individually enqueued backwards as is the nature of
    //the division. This method includes parameter of type int as will be
    //getting the desired number from Main method.
    public void convertNumToBase(int currentNum) {
        //Need to keep track of what the remainder is as this gie place
        //holders needed to construct the desired number in the desired base
        int remainder;

        while (currentNum != 0) {
            //Using the '%' shows if a number has a remainder if the
            //number was divided by the base.
            remainder = currentNum % base;

            //Divide the number and update the current number after the
            //division so can keep dividing until current number is 0.
            currentNum = currentNum / base;

            //Add the remainder to queue
            q.enqueue(remainder);
            //Every time place holder is enqueued size of the queue goes up
            //one
            size++;

        }

    }

    //Once the  place holders have been enqueued must reverse the order to
    //get the correct representation. Example: if number is 6 and the base
    //is 2 then if the place holders for 6 in base 2 were printed out, it
    //would look like "011" instead of "110".
    public int[] reverseOrder() {
        //Creating an array that can hold the size of the queue.
        int[] orderedList = new int[size];

        //Keeping track of position to be able to increase it to the next
        //position after copy of the element from the queue has been
        //assigned to the array
        int pos = 0;

        //Remove an element from the queue and assign a copy of the removed
        //element to the array. Move up to the next position in the array.
        //Stop once queue is fully empty.
        while (!q.isEmpty()) {
            int number = q.dequeue();
            orderedList[pos] = number;
            pos++;
        }

        //Now that array is filled with place holder, must reverse the order
        //of the place holders.
        for (int i = 0; i < orderedList.length / 2; i++) {
            int swap = orderedList[i];
            orderedList[i] = orderedList[orderedList.length - i - 1];
            orderedList[orderedList.length - i - 1] = swap;
        }
        size = 0;
        return orderedList;
    }

    //For each place holder convert it into a String. And then place each
    //String into one big String. The input is the array that contains the
    //place holders which are of type int.
    public String numToString(int[] array) {
        int numForString;
        String convertToString = "";
        for (int i = 0; i < array.length; i++) {
            numForString = array[i];
            if (numForString == 0) {
                convertToString += "0";
            } else if (numForString == 1) {
                convertToString += "1";
            } else if (numForString == 2) {
                convertToString += "2";
            } else if (numForString == 3) {
                convertToString += "3";
            } else if (numForString == 4) {
                convertToString += "4";
            } else if (numForString == 5) {
                convertToString += "5";
            } else if (numForString == 6) {
                convertToString += "6";
            } else if (numForString == 7) {
                convertToString += "7";
            } else if (numForString == 8) {
                convertToString += "8";
            }
        }
        //Return the number in the desired base
        return convertToString;

    }


}
