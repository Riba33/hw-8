public class MyHashMap<K,V> {
    private Node<K,V> hashMap;
    private int size = 0;
    private class Node<K,V> {
        Object key;
        Object value;
        Node<K, V> next;

        Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
        public void put(Object key, Object value) { //добавляет пару ключ + значение

            int val = 0;
            if (hashMap == null) {
                hashMap = new Node(key, value, null);
                hashMap.next = hashMap;
                size++;
            }
            else {
                for(int i = 0; i <size; i++) {
                    if (hashMap.key.equals(key)) {hashMap.value = value; val++; }
                    hashMap = hashMap.next;
                }
                if (val == 0) {
                    Node var = hashMap.next;
                    hashMap.next = new Node(key,value, var);
                    size++;
                    }

                }
        }

        public void remove(Object key) { //удаляет пару по ключу
            for (int i = 0; i < size; i++) {
                if(hashMap.next.key.equals(key)){
                    hashMap.next = hashMap.next.next;
                } hashMap = hashMap.next;
            } size--;
        }
        public void clear() {//очищает коллекцию
            hashMap = null;
            size = 0;         //new Node<>(null,null,null)
        }
        public int size() {//возвращает размер коллекции
            return size;
        }
        public Object get(Object key) { //возвращает значение(Object value) по ключу
            Object value = null;
            for(int i = 0; i < size; i++) {
                if (hashMap.key.equals(key)) value = hashMap.value;
            }
            return value;
        }
        public String toString() {
            String s = "";
            for (int i = 0; i < size; i++) {
                s += hashMap.key + " " + hashMap.value + " ";
                hashMap = hashMap.next;}
            return s.trim();
        }
}

