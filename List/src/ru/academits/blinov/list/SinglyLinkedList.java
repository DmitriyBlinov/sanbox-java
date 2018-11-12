package ru.academits.blinov.list;
/*
1. получение размера списка +
2. получение значение первого элемента +
3. получение/изменение значения по указанному индексу. ++
Изменение значения по индексу пусть выдает старое значение.
4. удаление элемента по индексу, пусть выдает значение элемента +
5. вставка элемента в начало +
6. вставка элемента по индексу +
7. удаление узла по значению, пусть выдает true, если элемент был удален +
8. удаление первого элемента, пусть выдает значение элемента +
9. разворот списка за линейное время
10. копирование списка
 */

public class SinglyLinkedList<T> {
    private ListItem<T> head;
    private int count;

    public SinglyLinkedList(ListItem<T> head) {
        this.head = head;
    }

    //1. Получение размера списка
    public int getLength() {
        return count;
    }

    //2. Получение значение первого элемента
    public T getHead() {
        return head.getData();
    }

    //3.1 Получение значения по указанному индексу
    public T getItem(int index) {
        ListItem<T> p = head;
        for (int i = 0; i < index; i++) {
            p = p.getNext();
        }
        return p.getData();
    }

    //3.2 Изменение значения по указанному индексу
    public T setItem(T data, int index) {
        ListItem<T> p = head;
        for (int i = 0; i < index; i++) {
            p = p.getNext();
        }
        T temp = p.getData();
        p.setData(data);
        return temp;
    }

    //4. Удаление элемента по индексу, пусть выдает значение элемента
    public T removeItem (int index) {
        ListItem<T> p = head;
        for (int i = 0; i < index; i++) {
            p = p.getNext();
        }
        T temp = p.getData();
        p.setNext(p.getNext().getNext());
        count--;
        return temp;
    }

    //5. Вставка в начало
    public void insertAtHead(T data) {
        ListItem<T> p = new ListItem<>(data, head);
        head = p;
    }

    //6. Вставка по индексу
    public void insertAt(T data, int index) {
        ListItem<T> q = new ListItem<>(data);
        ListItem<T> p = head;
        for (int i = 0; i < index; i++) {
            p = p.getNext();
        }
        q.setNext(p.getNext());
        p.setNext(q);
        count++;
    }

    //7. Удаление узла по значению (удаляет все по идее)
    public boolean removeItemByData(T data) {
        boolean count = false;
        for (ListItem<T> p = head; p != null; p = p.getNext()) {
            if (p.getNext().getData().equals(data)) {
                p.setNext(p.getNext().getNext());
                count = true;
                this.count--;
            }
        }
        return count;
    }

    //8. Удаление первого элемента
    public T removeHead() {
        T temp = head.getData();
        head = head.getNext();
        count--;
        return temp;
    }
}
