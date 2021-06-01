package hashtable;

import java.util.ArrayList;
import java.util.Objects;

public class HashTable<K, V> {
    private ArrayList<HashNode<K, V>> hashTable;
    private int entries;
    private int size;

    public HashTable() {
        hashTable = new ArrayList<>();
        entries = 10;
        size = 0;

        for (int i = 0; i < entries; i++) {
            hashTable.add(null);
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    private int hashCode(Object key) {
        return Objects.hashCode(key);
    }

    private int getEntryIndex(Object key) {
        int hashCode = hashCode(key);
        int index = hashCode % entries;

        index = index < 0 ? index * -1 : index;
        return index;
    }

    public V remove(Object key) {
        int bucketIndex = getEntryIndex(key);
        int hashCode = hashCode(key);
        HashNode<K, V> head = hashTable.get(bucketIndex);

        HashNode<K, V> prev = null;
        while (head != null) {
            if (head.getKey().equals(key) && hashCode == head.hashCode) {
                break;
            }
            prev = head;
            head = head.next;
        }

        if (head == null) {
            return null;
        }

        size--;

        if (prev != null) {
            prev.next = head.next;
        } else {
            hashTable.set(bucketIndex, head.next);
        }
        return head.getValue();
    }

    public V get(Object key) {
        int bucketIndex = getEntryIndex(key);
        int hashCode = hashCode(key);

        HashNode<K, V> head = hashTable.get(bucketIndex);

        while (head != null) {
            if (head.getKey().equals(key) && head.hashCode == hashCode) {
                return head.getValue();
            }
            head = head.next;
        }
        return null;
    }


    public void add(K key, V value) {
        int bucketIndex = getEntryIndex(key);
        int hashCode = hashCode(key);
        HashNode<K, V> head = hashTable.get(bucketIndex);

        while (head != null) {
            if (head.getKey().equals(key) && head.hashCode == hashCode) {
                head.setValue(value);
                return;
            }
            head = head.next;
        }

        size++;
        head = hashTable.get(bucketIndex);
        HashNode<K, V> newNode = new HashNode<>(key, value, hashCode);
        newNode.next = head;
        hashTable.set(bucketIndex, newNode);

        if ((1.0 * size) / entries >= 0.7) {
            extendSize();
        }
    }

    private void extendSize() {
        ArrayList<HashNode<K, V>> temp = hashTable;
        hashTable = new ArrayList<>();
        entries = 2 * entries;
        size = 0;
        for (int i = 0; i < entries; i++) {
            hashTable.add(null);
        }

        for (HashNode<K, V> headNode : temp) {
            while (headNode != null) {
                add(headNode.getKey(), headNode.getValue());
                headNode = headNode.next;
            }
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (isEmpty()) {
            return stringBuilder.append("{ }").toString();
        }
        stringBuilder.append("{");
        for (HashNode<K,V> e : hashTable) {
            if (Objects.equals(e, null)) {
                stringBuilder.append(e).append(", ");
            } else {
                stringBuilder.append(e.getKey()).append("=").append(e.getValue()).append(", ");
            }
        }
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length()).append("}");

        return stringBuilder.toString();
    }
}