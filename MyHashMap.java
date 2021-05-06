public class MyHashMap<K,V> {
    private Node<K,V>[] table =new Node[16];
    private int size = 0;
    private class Node<K,V> {
        int hash;
        Object key;
        Object value;
        Node<K, V> next;

        Node(K key, V value, Node<K, V> next) {
            this.hash = hash(key.hashCode());
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
        public void put(K key, V value) { //добавляет пару ключ + значение
            int hash = hash(key.hashCode());
            int index = indexFor(hash, table.length);
            if (size == table.length * 3 / 4) {
                Node<K,V>[] newTable = new Node[table.length * 2];
                transfer(newTable);
            }
            if (key == null) { putForNullKey(value); size++;}
            else
            { int val = 0;
                for (Node<K,V> map: table)
                {
                    while (map != null)
                    {
                        if (map.hash == hash &&(key == map.key || key.equals(map.key)))
                        {
                            map.value = value;
                            val++;
                        }
                        map = map.next;
                    }
                }
                if(val == 0) {addNode(hash,key,value,index); size++;}
            }
        }

        public void remove(Object key)
        { //удаляет пару по ключу
            int val = 0;
            int hash = hash(key.hashCode());
            int index = indexFor(hash(key.hashCode()), table.length);
            Node<K,V> map = table[index];
            if(map.hash == hash &&(key == map.key || key.equals(map.key)))
            {
                table[index] = map.next; size--;
            }
        }
        public void clear() {//очищает коллекцию
            table = new Node[16];
            size = 0;
        }
        public int size() {//возвращает размер коллекции
            return size;
        }
        public Object get(Object key) { //возвращает значение(Object value) по ключу
            Object value = null;
            int hash = hash(key.hashCode());
            for(Node<K,V> map: table) {
                while (map != null) {
                    if (map.hash == hash &&(key == map.key || key.equals(map.key))) value = map.value;
                    map = map.next;
                }
            }
            return value;
        }
        static int hash(int h)
        {
            h ^= (h >>> 20) ^ (h >>> 12);
            return h ^ (h >>> 7) ^ (h >>> 4);
        }
        static int indexFor(int h, int length)
        {
            return h & (length - 1);
        }
        void addNode(int hash, K key, V value, int index)
        {
            Node<K, V> e = table[index];
            table[index] = new Node<K, V>(key, value, e);
        }
        void transfer(Node<K,V>[] newTable)
        {
            for(Node<K,V> map: table){
                while (map != null) {
                    newTable[indexFor(map.hash, newTable.length)] = new Node(map.key,map.value,null);
                    map = map.next;
                }
            }
            table = newTable;
        }
        void putForNullKey(V value){
            Node<K,V> map = table[0];
            int val = 0;
            while (map != null) {
                if(map.key == null) {
                    map.value = value;
                    val++;
                }
            }
            if (val == 0) addNode(0,null,value,0);
        }
        public String toString()
        {
            String s = "";
            for (Node<K,V> map: table) {
                while (map != null) {
                    s += map.key + " " + map.value + " ";
                    map = map.next;
                }
            }
            return s.trim();
        }
}


