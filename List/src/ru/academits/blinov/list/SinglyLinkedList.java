package ru.academits.blinov.list;

public class SinglyLinkedList<T> {
    private ListItem<T> head;
    private int count;

    public SinglyLinkedList() {
    }

    public int getSize() {
        return count;
    }

    //Data головы
    public T getHead() {
        if (count == 0) {
            throw new NullPointerException("Элемента не существует!");
        }
        return head.getData();
    }

    //Data айтема
    public T getItem(int index) {
        if (index >= count || index < 0) {
            throw new NullPointerException("Элемента с таким индексом не существует!");
        }
        return findItem(index).getData();
    }

    //Изменить Data у айтема
    public T setItem(T data, int index) {
        if (index >= count || index < 0) {
            throw new NullPointerException("Элемента с таким индексом не существует!");
        }
        T temp = findItem(index).getData();
        findItem(index).setData(data);
        return temp;
    }

    //Удалить айтем по индексу
    public T removeItem(int index) {
        if (index >= count || index < 0) {
            throw new NullPointerException("Элемента с таким индексом не существует!");
        }
        T temp = findItem(index).getNext().getData();
        findItem(index).setNext(findItem(index).getNext().getNext());
        count--;
        return temp;
    }

    //Добавить айтем в конец
    public void add(T data) {
        if (count == 0) {
            head = new ListItem<>(data, null);
        } else if (count == 1) {
            ListItem<T> p = new ListItem<>(data, null);
            head.setNext(p);
        } else {
            ListItem<T> q = new ListItem<>(data, null);
            findItem(count - 1).setNext(q);
        }
        count++;
    }

    //Добавить айтем по индексу
    public void addAt(T data, int index) {
        if (index > count || index < 0) {
            throw new NullPointerException("Некорректный индекс");
        }
        ListItem<T> q = new ListItem<>(data, head);
        if (index == 0) {
            head = q;
        } else {
            q.setNext(findItem(index - 1).getNext());
            findItem(index - 1).setNext(q);
        }
        count++;
    }

    //Удалить айтем по дате
    public boolean removeByData(T data) {
        boolean count = false;
        ListItem<T> p = head;
        if ((p.getData() == data) || (p.getData().equals(data))) {
            removeHead();
            return true;
        }
        for (int i = 0; i < this.count - 1; p = p.getNext()) {
            if ((p.getNext().getData() == null) || (p.getNext().getData().equals(data))) {
                p.setNext(p.getNext().getNext());
                count = true;
                this.count--;
            }
        }

        return count;
    }

    //Удалить голову
    public T removeHead() {
        if (count == 0) {
            throw new NullPointerException("Список пуст!");
        }
        T temp = head.getData();
        head = head.getNext();
        count--;
        return temp;
    }

    //Разворот
    public void reverseList() {
        for (ListItem<T> p = head, prev = null, temp; p != null; prev = p, p = temp) {
            temp = p.getNext();
            p.setNext(prev);
            head = p;
        }
    }

    //Копия
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

    //Поиск элемента
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