import java.util.ListIterator;
import java.util.*;

public class MyArrayList<V> {
    private Object[] list = new Object[0];
    private int size = 0;

    public void add(V value) {
        Object[] newList = new Object[list.length * 2 + 1];
        System.arraycopy(list,0,newList,0, list.length);
        list = newList;
        list[size] = value;
        size++;
    }
    public void remove(int index) {
        Object[] newList = new Object[list.length * 2 + 1];
        if (index >= size | index <0) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        int k = 0;
        for (int i = 0; i < size; i++) {
            if(i == index) { k++;}
              newList[i] = list[i+k];

        }
        list = newList;
        size--;
    }
    public V get(int index) {
        if (index >= size | index < 0) {
            throw new ArrayIndexOutOfBoundsException(index);
        } return (V) list[index];
    }
    public void clear() {
        list = new Object[0];
        size = 0;
    }
    public int size() {
        return size;
    }
    @Override public String toString() {
        String s = "";
        for (int i = 0; i < size; i++) s += list[i] + " ";
        return s.trim();
    }
}




