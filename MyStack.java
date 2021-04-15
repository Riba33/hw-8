public class MyStack<V> {
    private MyLinkedList<V> list = new MyLinkedList<>();
    public void push(Object value) { //добавляет элемент в конец
        list.add((V) value);
    }
    public void remove(int index) { //удаляет элемент под индексом
        list.remove(index);
    }
    public void clear() { //очищает коллекцию
        list.clear();
    }
    public int size() { //возвращает размер коллекции
        return list.size();
    }
    public V peek() { //возвращает первый элемент в стеке (LIFO)
        return list.get(list.size() -1);
    }
    public V pop() { //возвращает первый элемент в стеке и удаляет его из коллекции
        V value = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return value;
    }
    @Override public String toString() {
        if (list == null) {
            return "Список пуст!";
        }
        String s = "";
        int i = list.size() - 1;
        while (i >=0) {
            s += list.get(i) + " ";
            i--;
        }
        return s.trim();
    }
}
