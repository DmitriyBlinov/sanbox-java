package ru.academits.blinov.list;

import java.util.Objects;

public class SinglyLinkedList<T> {
    private ListItem<T> head;
    private int count;

    public SinglyLinkedList() {
    }

    public SinglyLinkedList(T headData) {
        head = new ListItem<>(headData, null);
        count++;
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
            throw new IndexOutOfBoundsException("Элемента с таким индексом не существует!");
        }
        return findItem(index).getData();
    }

    public T setItem(T data, int index) {
        if (index >= count || index < 0) {
            throw new IndexOutOfBoundsException("Элемента с таким индексом не существует!");
        }
        ListItem<T> current = findItem(index);
        T temp = current.getData();
        current.setData(data);
        return temp;
    }

    public T removeItem(int index) {
        if (index >= count || index < 0) {
            throw new IndexOutOfBoundsException("Элемента с таким индексом не существует!");
        }
        if (index == 0) {
            return removeHead();
        }
        ListItem<T> prev = findItem(index - 1);
        T temp = prev.getNext().getData();
        prev.setNext(prev.getNext().getNext());
        count--;
        return temp;
    }

    public void add(T data) {
        if (count == 0) {
            head = new ListItem<>(data, null);
        } else {
            ListItem<T> q = new ListItem<>(data, null);
            findItem(count - 1).setNext(q);
        }
        count++;
    }

    public void addAt(T data, int index) {
        if (index > count || index < 0) {
            throw new IndexOutOfBoundsException("Некорректный индекс");
        }
        ListItem<T> p = new ListItem<>(data, null);
        if (index == 0) {
            head = p;
        } else {
            ListItem<T> q = findItem(index - 1);
            p.setNext(q.getNext());
            q.setNext(p);
        }
        count++;
    }

    public void addAtStart(T data) {
        head = new ListItem<>(data, head);
        count++;
    }

    public boolean removeByData(T data) {
        if (count == 0) {
            throw new NullPointerException("Список пуст!");
        }
        ListItem<T> p = head;
        if (Objects.equals(p.getData(), data)) {
            removeHead();
            return true;
        }
        while (p.getNext() != null) {
            if (Objects.equals(p.getNext().getData(), data)) {
                p.setNext(p.getNext().getNext());
                this.count--;
                return true;
            }
            p = p.getNext();
        }
        return false;
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
        SinglyLinkedList<T> temp = new SinglyLinkedList<>(head.getData());
        for (ListItem<T> p = head.getNext(), q = temp.head; p != null; p = p.getNext(), q = q.getNext()) {
            q.setNext(new ListItem<>(p.getData(), null));
        }
        temp.count = count;
        return temp;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (count == 0) {
            return stringBuilder.append("[ ]").toString();
        }
        stringBuilder.append("[");
        for (ListItem<T> p = head; p != null; p = p.getNext()) {
            stringBuilder.append(p.getData()).append(", ");
        }
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length()).append("]");

        return stringBuilder.toString();
    }

    private ListItem<T> findItem(int index) {
        if (index == 0) {
            return head;
        }
        ListItem<T> p = head;
        for (int i = 0; i < index; i++) {
            p = p.getNext();
        }
        return p;
    }
}