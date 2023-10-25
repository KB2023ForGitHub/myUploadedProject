import java.util.LinkedList;

public class Queue <T>{

    //Using a LinkedList means removing from queue will always be O(1)
    //because it doesn't need to shift elements
    private LinkedList<T> queue = new LinkedList<>();

    public void enqueue(T item){
        //Add at end of queue. Adding at end of queue is O(1) because
        //LinkedList requires an updating of pointers and not a whole
        //shifting of items.
        queue.addLast(item);
    }
    public T dequeue(){
        //Remove from beginning of queue and then return item removed.
        //By removing an item in the queue first adding to queue is O(1),
        //because using a LinkedList means removing is about
        //updating the pointers -- which will be O(1)
        return queue.removeFirst();
    }

    public boolean isEmpty(){
        //Checks if the queue is empty.
        //This is O(1) because just checking if the size is 0
        if (queue.size()==0){
            return true;
        }
        return false;
    }

}
