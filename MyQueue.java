public class MyQueue<V> {
    private MyArrayList<V> list = new MyArrayList<>();
    public void add(V value) { //добавляет элемент в конец
        list.add(value);
    }
    public void remove(int index) { //удаляет элемент под индексом
        list.remove(index);
    }
    public void clear() { //очищает коллекцию
        list.clear();
    }
    public int size() {//возвращает размер коллекции
        return list.size();
    }
    public V peek() { //возвращает первый элемент в очереди (FIFO)
        return list.get(0);
    }
    public V poll() { //возвращает первый элемент в очереди и удаляет его из коллекции
        V value = list.get(0);
        list.remove(0);
        return value;
    }
    @Override public String toString() {
        String s = "";
        for (int i = 0; i < list.size(); i++) s += list.get(i) + " ";
        return s.trim();
    }
}
