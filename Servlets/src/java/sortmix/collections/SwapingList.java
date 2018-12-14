package sortmix.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Generic class for storing values and giving the ability to swap values
 *
 * @author Dariusz Opitek
 * @version 1.3
 * @param <T> type in which swaping list should be build
 */
public class SwapingList<T> implements Iterable<T> {
    
    /**
     * stores values in container
     */
    private final ArrayList<T> contents;
     
    /**
     * Default constructor initialising container
     */
    public SwapingList(){
        contents = new ArrayList<>();
    }
    
    /**
     * Size of container
     * @return return size of container
     */
    public int size(){
        return contents.size();
    }
    
    /**
     * Adding object to container
     * @param obj object added to container
     */
    public void add(T obj){
        contents.add(obj);
    }
    
    /**
     * Gets back object at specific index
     * @param index position of object in container
     * @return returns object
     */
    public T get(int index){
        return contents.get(index);
    }
    
    /**
     * Inserts object at given position
     * @param index position to place the object
     * @param obj object to be inserted
     */
    public void set(int index, T obj){
        contents.set(index, obj);
    }
    
    /**
     * Swaps two elements in container
     * @param first position of first object
     * @param second position of second object
     */
    public void swap(int first, int second){
        T obj = contents.get(first);
        contents.set(first, contents.get(second));
        contents.set(second, obj);
    }
    
    /**
     * Removes all objects from container
     */
    public void clear(){
        contents.clear();
    }
    
    /**
     * Iterator used for Swaping List
     * @return returns iterator
     */
    @Override
    public Iterator<T> iterator() {
        return new SwapIterator();
    }
    
    /**
     * Class used to iterate through objects in container
     */
    class SwapIterator implements Iterator<T> {
        int current = 0; 
        
        @Override
        public boolean hasNext() {
            return contents.size()-1 >= current;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return contents.get(current++);
        }
    }
}



