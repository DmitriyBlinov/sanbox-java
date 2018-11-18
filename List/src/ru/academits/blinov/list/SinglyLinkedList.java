package ru.academits.blinov.list;

public class SinglyLinkedList<T> {
    private ListItem<T> head;
    private int count;

    public SinglyLinkedList() {
    }

    public int getSize() {
        return count;
    }

    public T getHead() {
        if (count == 0) {
            throw new NullPointerException("Элемента не существует!");
        }
        return head.getData();
    }

    public T getItem(int index) {
        if (index >= count || index < 0) {
            throw new NullPointerException("Элемента с таким индексом не существует!");
        }
        ListItem<T> p = head;
        for (int i = 0; i < index; i++) {
            p = p.getNext();
        }
        return p.getData();
    }

    public T setItem(T data, int index) {
        if (index >= count || index < 0) {
            throw new NullPointerException("Элемента с таким индексом не существует!");
        }
        T temp = head.getData();
        if (index == 0) {
            head.setData(data);
        } else {
            ListItem<T> p = head;
            for (int i = 0; i < index; i++) {
                p = p.getNext();
            }
            temp = p.getData();
            p.setData(data);
        }
        return temp;
    }

    public T removeItem(int index) {
        if (index >= count || index < 0) {
            throw new NullPointerException("Элемента с таким индексом не существует!");
        }
        ListItem<T> p = head;
        for (int i = 0; i < index - 1; i++) {
            p = p.getNext();
        }
        T temp = p.getNext().getData();
        p.setNext(p.getNext().getNext());
        count--;
        return temp;
    }

    public void add(T data) {
        if (count == 0) {
            head = new ListItem<>(data, null);
        } else if (count == 1) {
            ListItem<T> p = new ListItem<>(data, null);
            head.setNext(p);
        } else {
            ListItem<T> p = findItem(count);
            ListItem<T> q = new ListItem<>(data, null);
            p.setNext(q);
        }
        count++;
    }

    public void addAt(T data, int index) {
        if (index > count || index < 0) {
            throw new NullPointerException("Некорректный индекс");
        }
        ListItem<T> q = new ListItem<>(data);
        ListItem<T> p = findItem(index);
        q.setNext(p.getNext());
        p.setNext(q);
        count++;
    }

    public boolean removeByData(T data) {
        boolean count = false;
        ListItem<T> p = head;
        if ((p.getData().equals(data)) || (p.getData() == data)) {
            removeHead();
            count = true;
        }
        for (int i = 0; i < this.count - 1; i++, p = p.getNext()) {
            //TODO можно вынести, конечно, в 2 if для проверки null там или не null
            if ((p.getNext().getData() == data) || (p.getNext().getData().equals(data))) {
                p.setNext(p.getNext().getNext());
                count = true;
                this.count--;

            }
        }
        return count;
    }

    public T removeHead() {
        if (count == 0) {
            throw new NullPointerException("Список пуст!");
        }
        T temp = head.getData();
        head = head.getNext();
        count--;
        return temp;
    }

    public void reverseList() {
        for (ListItem<T> p = head, prev = null, temp; p != null; prev = p, p = temp) {
            temp = p.getNext();
            p.setNext(prev);
            head = p;
        }
    }

    public SinglyLinkedList<T> copy() {
        if (count == 0) {
            return new SinglyLinkedList<>();
        }
        SinglyLinkedList<T> temp = new SinglyLinkedList<>();
        for (ListItem<T> p = head; p != null; p = p.getNext()) {
            temp.add(p.getData());
        }
        return temp;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (count == 0) {
            return stringBuilder.append("[ ").append(" ]").toString();
        }

        stringBuilder.append("[");
        for (ListItem<T> p = head; p != null; p = p.getNext()) {
            stringBuilder.append(p.getData()).append(", ");
        }
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length()).append("]");

        return stringBuilder.toString();
    }

    public ListItem<T> findItem (int index) {
        if (index == 0) {
           return head;
        }
        ListItem<T> p = head;
        for (int i = 0; i < index - 1; i++) {
            p = p.getNext();
        }
        return p;
    }
}