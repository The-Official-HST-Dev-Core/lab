package Lab5s1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class HashMapImpl<V> implements HashMap<String, V> {
    private static final int TABLE_SIZE = 300007;
    private static final int A = 31;
    /**
     * Алгоритм хеширования строк.
     *
     * @param value ключ, по которому сохранится значение в хэш-таблицу
     * @return значение хэша
     */
    private static class Pair<V> {
        String key;
        V value;
        Pair(String key, V value) {
            this.key = key;
            this.value = value;
        }
    }
    private final List<LinkedList<Pair<V>>> table;
    public HashMapImpl() {
        table = new ArrayList<>(TABLE_SIZE);
        for (int i = 0; i < TABLE_SIZE; i++) {
            table.add(new LinkedList<>());
        }
    }
    private long hashByString(String value) {
        long hash = 0;
        for (Character ch : value.toCharArray()) {
            hash = (hash * A + ch) % TABLE_SIZE;
        }
        return hash;
    }

    @Override
    public void put(String key, V value) {
	// TODO
    int listIndex = (int) hashByString(key);
    LinkedList<Pair<V>> linkedList = table.get(listIndex);
    for (Pair<V> pair : linkedList) {

        if (pair.key.equals(key)) {
            pair.value = value;
            return;
        }
    }

    linkedList.add(new Pair<>(key, value));
    }
    @Override
    public V getValue(String key) {
	// TODO
        int listIndex = (int) hashByString(key);
        LinkedList<Pair<V>> linkedList = table.get(listIndex);
         for (Pair<V> pair : linkedList) {
            if (pair.key.equals(key)) {
                return pair.value;
            }
        }
        return null;
    }

    @Override
    public V delete(String key) {
	// TODO
        int index = (int) hashByString(key);
        Iterator<Pair<V>> it = table.get(index).iterator();
        while (it.hasNext()) {
            Pair<V> pair = it.next();
            if (pair.key.equals(key)) {
                V removed = pair.value;
                it.remove();
                return removed;
            }
    }
    return null;
    }
} 