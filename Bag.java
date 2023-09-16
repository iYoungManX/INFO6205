import java.util.ArrayList;
import java.util.Random;

// Assignment 1
public class Bag<T> {

    private ArrayList<T> items;

    public Bag() {
        items = new ArrayList<>();
    }

    // To add an element to the bag
    public void add(T item) {
        items.add(item);
    }

    // To clear ALL contents of the bag
    public void clear() {
        items.clear();
    }

    // Returns true if the element is in the bag, false if it is not
    public boolean contains(T item) {
        return items.contains(item);
    }

    // Return a random element in the bag
    public T grab() {
        if (items.isEmpty()) {
            return null;
        }
        Random random = new Random();
        return items.get(random.nextInt(items.size()));
    }

    // Returns true if the bag is empty, otherwise false
    public boolean isEmpty() {
        return items.isEmpty();
    }

    // Removes ONE instance of the item T.
    public boolean remove(T item) {
        return items.remove(item);
    }

    // Returns the number of elements in the bag
    public int size() {
        return items.size();
    }

    // Returns an array with all of the elements in the bag in the array
    public ArrayList<T> toArray() {
        return new ArrayList<>(items);
    }

    // Returns a string that displays all of the elements in the bag
    @Override
    public String toString() {
        return items.toString();
    }
}
