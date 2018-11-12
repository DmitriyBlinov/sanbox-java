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
9. разворот списка за линейное время +-
10. копирование списка +
 */

import java.util.NoSuchElementException;

public class SinglyLinkedList<T> {
    private ListItem<T> head;
    private int count;

    public SinglyLinkedList() {
    }

    //1. Получение размера списка
    public int getSize() {
        return count;
    }

    //2. Получение значение первого элемента
    public T getHead() {
        return head.getData();
    }

    //3.1 Получение значения по указанному индексу
    public T getItem(int index) {
        if (index > count || index < 0) {
            throw new NoSuchElementException("Элемента с таким индексом не существует!");
        }
        ListItem<T> p = head;
        for (int i = 0; i < index - 1; i++) {
            p = p.getNext();
        }
        return p.getData();
    }

    //3.2 Изменение значения по указанному индексу
    public T setItem(T data, int index) {
        if (index > count - 1 || index < 0) {
            throw new NoSuchElementException("Элемента с таким индексом не существует!");
        }
        T temp = head.getData();
        if (count == 1) {
            head = new ListItem<>(data,null);
        } else {
            ListItem<T> p = head;
            for (int i = 0; i < index - 1; i++) {
                p = p.getNext();
            }
            temp = p.getData();
            p.setData(data);
        }
        return temp;
    }

    //4. Удаление элемента по индексу, пусть выдает значение элемента
    public T removeItem(int index) {
        if (index > count || index < 0) {
            throw new NoSuchElementException("Элемента с таким индексом не существует!");
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

    //5. Вставка в начало
    public void add(T data) {
        if (count == 0) {
            head = new ListItem<>(data, null);
        } else if (count == 1) {
            ListItem<T> p = new ListItem<>(data, null);
            head.setNext(p);
        } else {
            ListItem<T> p = head;
            for (int i = 0; i < count - 1; i++) {
                p = p.getNext();
            }
            ListItem<T> q = new ListItem<>(data, null);
            p.setNext(q);
        }
        count++;
    }

    //6. Вставка по индексу
    public void addAt(T data, int index) {
        ListItem<T> q = new ListItem<>(data);
        ListItem<T> p = head;
        for (int i = 0; i < index - 1; i++) {
            p = p.getNext();
        }
        q.setNext(p.getNext());
        p.setNext(q);
        count++;
    }

    //7. Удаление узла по значению (удаляет все по идее)
    public boolean removeByData(T data) {
        boolean count = false;
        for (ListItem<T> p = head; p.getNext() != null; p = p.getNext()) {
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
        if (count <= 0) {
            throw new NoSuchElementException("Список пуст!");
        }
        T temp = head.getData();
        head = head.getNext();
        count--;
        return temp;
    }

    //9. Разворот списка за линейное время
    public void reverseList() {
        if (count <= 0) {
            throw new NoSuchElementException("Список пуст!");
        }
        int i = 0;
        for (ListItem<T> p = head, prev = null; i < count - 1; prev = p, p = p.getNext(), i++) {
            p.getNext().setNext(prev);
        }
    }

    //10. Копирование спика
    public void copyLinkedList(SinglyLinkedList<T> linkedList) {
        if (linkedList.count <= 0) {
            throw new NoSuchElementException("Список для копирования пуст!");
        }
        for (ListItem<T> p = linkedList.head; p != null; p = p.getNext()) {
            add(p.getData());
        }
    }

    @Override
    public String toString() {
        if (count <= 0) {
            throw new NoSuchElementException("Список пуст!");
        }
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("{ ");
        for (ListItem<T> p = head; p != null; p = p.getNext()) {
            stringBuilder.append(p.getData()).append(", ");
        }
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length()).append(" }");

        return stringBuilder.toString();
    }
}