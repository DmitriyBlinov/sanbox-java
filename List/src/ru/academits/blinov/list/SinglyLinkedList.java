package ru.academits.blinov.list;
/*
•	получение размера списка +
•	получение значение первого элемента +
•	получение/изменение значения по указанному индексу.
Изменение значения по индексу пусть выдает старое значение.
•	удаление элемента по индексу, пусть выдает значение элемента
•	вставка элемента в начало +-
•	вставка элемента по индексу
•	удаление узла по значению, пусть выдает true, если элемент был удален
•	удаление первого элемента, пусть выдает значение элемента +
•	разворот списка за линейное время
•	копирование списка
 */

public class SinglyLinkedList<T> {
    private ListItem<T> head;
    private int count;

    public SinglyLinkedList(){}

    public int getLength() {
        return count;
    }

    public T getHead(){
        return head.getData();
    }

    //вставка в начало
    public void insertAtHead(ListItem<T> item) {
        ListItem<T> p = new ListItem<>(item.getData(), head);
        head = p;
    }

    //вставка по индексу - есть в главе "Задача"
    //TODO
    public void insertAt(ListItem<T> item, int index) {
        ListItem<T> p = new ListItem<>(item.getData(), item);
        item = p;
    }

    //удаление узла по значению (удаляет все)
    public boolean deleteItemByData(T data) {
        boolean count = false;
        for (ListItem<T> p = head; p != null; p = p.getNext()) {
            if (p.getData().equals(data)) {
                count = true;
            }
        }
        return count;
    }

    //удаление первого элемента
    public T deleteHead() {
        T temp = head.getData();
        head = head.getNext();
        return temp;
    }
}
