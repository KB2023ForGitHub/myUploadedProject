import java.util.LinkedList;

public class Stack <T>{
    //Using a LinkedList means adding to a stack will only be O(1)
    //because it doesn't need to shift elements.
    private LinkedList<T> stacks = new LinkedList<>();


    public void push(T item){
        //Adding at the beginning of stack because stack is last in first out
        //This takes O(1) because it is a LinkedList.
        stacks.addFirst(item);
    }


    public T pop(){
        //Have to remove from the beginning of stack since it is last in first out.
        //Returns the item that was removed.
        return stacks.removeFirst();

    }

    public boolean isEmpty(){
        //Checks if stack is empty. Takes O(1) time as only checking if
        //size of stack is 0.
        if(stacks.size()!=0){
            return false;
        }
        return true;
    }
}

