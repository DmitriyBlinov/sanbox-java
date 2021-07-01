package hashtable;

import java.util.ArrayList;
import java.util.Objects;

public class HashTable<K, V> {
    private ArrayList<HashNode<K, V>> hashTable;
    private int nodeCount;
    private int size;

    public HashTable() {
        hashTable = new ArrayList<>();
        nodeCount = 10;
        size = 0;

        for (int i = 0; i < nodeCount; i++) {
            hashTable.add(null);
        }
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    //TODO change to manual calculation?
    private int hashCode(K key) {
        return Objects.hashCode(key);
    }

    private int getNodeIndex(K key) {
        int hashCode = hashCode(key);
        int index = hashCode % nodeCount;

        index = index < 0 ? index * -1 : index;
        return index;
    }

    public V remove(K key) {
        int nodeIndex = getNodeIndex(key);
        int hashCode = hashCode(key);
        HashNode<K, V> head = hashTable.get(nodeIndex);

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
            hashTable.set(nodeIndex, head.next);
        }
        return head.getValue();
    }

    public V get(K key) {
        int nodeIndex = getNodeIndex(key);
        int hashCode = hashCode(key);

        HashNode<K, V> head = hashTable.get(nodeIndex);

        while (head != null) {
            if (head.getKey().equals(key) && head.hashCode == hashCode) {
                return head.getValue();
            }
            head = head.next;
        }
        return null;
    }


    public void add(K key, V value) {
        int nodeIndex = getNodeIndex(key);
        int hashCode = hashCode(key);
        HashNode<K, V> head = hashTable.get(nodeIndex);

        while (head != null) {
            if (head.getKey().equals(key) && head.hashCode == hashCode) {
                head.setValue(value);
                return;
            }
            head = head.next;
        }

        size++;

        head = hashTable.get(nodeIndex);
        HashNode<K, V> newNode = new HashNode<>(key, value, hashCode);
        newNode.next = head;
        hashTable.set(nodeIndex, newNode);

        if (checkLoadFactor()) {
            rehash();
        }
    }

    private boolean checkLoadFactor() {
        return (1.0 * size) / nodeCount >= 0.7;
    }

    private void rehash() {
        ArrayList<HashNode<K, V>> temp = hashTable;
        hashTable = new ArrayList<>();
        nodeCount = 2 * nodeCount;
        size = 0;
        for (int i = 0; i < nodeCount; i++) {
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
            return stringBuilder.append("[ ]").toString();
        }
        stringBuilder.append("[");
        for (HashNode<K,V> e : hashTable) {
            if (Objects.equals(e, null)) {
                stringBuilder.append(e).append(", ");
            } else {
                stringBuilder.append(e.getKey()).append("->").append(e.getValue()).append(", ");
            }
        }
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length()).append("]");

        return stringBuilder.toString();
    }
}