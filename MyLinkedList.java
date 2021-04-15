import java.util.Collection;
import java.util.ListIterator;
import java.lang.Iterable;

public class MyLinkedList<V> {
    private Node<V> list;
    private int size = 0;
    private class Node<V> {
        Object value;
        Node<V> prev;
        Node<V> next;
            Node(Node<V> prev, V element, Node<V> next) {
            this.value = element;
            this.next = next;
            this.prev = prev;

        }
    }

   public void add(V value) {
        size++;
        if (this.list == null) {
             this.list = new Node<V>(null, value, null);

        }
        else {
                while (list.next != null) { list = list.next; }
            list.next = new Node<V>(list, value, null);
        }
      }
      public int size() {
        return size;
      }
      public void remove(int index){ //удаляет элемент под индексом
          int count = 0;
          if (index < 0 | index >= size) {
              System.out.println("Невозможно удалить елемент списка! - Индекс выходит за пределы списка");
              return;
          }
          while (list.prev != null) { list = list.prev; }
          if (index == 0) {
              list = list.next;
              list.prev = null;
              size--;
              return;
          }

          while (list.next != null)
          {
              if (count == index) {
                  list.prev.next = list.next;
                  list.next.prev = list.prev;
                  size--; return;
              } list = list.next;
              count++;
          }
          if (index == size - 1) {
              while (list.next != null) {list = list.next;}
              list = list.prev;
              list.next = null;
              size--; return;
          }

      }
    public void clear() {
        list = new Node<V>(null,null, null);
        size = 0;
    }
    public V get(int index) {   //возвращает элемент под индексом
        int count = 0;
        V value = null;
        if (index < 0 | index >= size) {
            System.out.println("Невозможно вернуть елемент списка! - Индекс выходит за пределы списка");
        }
            while (list.prev != null) { list = list.prev;}
            if (index == 0) value = (V) list.value;
        while (list.next != null)
        {
            if (count == index-1) {
                value = (V) list.next.value;
            } list = list.next;
            count++;
        }
        return value;
    }

    @Override public String toString() {
        while (list.prev != null) { list = list.prev; }
        if (list.value == null) {
            return "Список пуст!";
        }


        else {

           String s = (String) list.value;

            while (list.next != null) {
                list = list.next;
                s += " " + list.value;
            }
            return s.trim();
        }
    }

}
