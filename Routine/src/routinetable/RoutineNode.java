package routinetable;

public class RoutineNode<K, V> {
    private K key;
    private V value;
    final int hashCode;
    public RoutineNode<K, V> next;

    public RoutineNode(K key, V value, int hashCode) {
        this.key = key;
        this.value = value;
        this.hashCode = hashCode;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public void setHead(RoutineNode<K, V> head) {
        this.next = head;
    }
}
