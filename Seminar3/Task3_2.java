package Seminar3;

import org.w3c.dom.Node;

public class Task3_2 {
    // 1.Расширяем структуру связного списка до двухсвязного.
    // 2.Мы научились работать с односвязным список, теперь можно ближе
    // познакомиться со структурой двухсвязного списка и особенностей его
    // внутреннего строения.
    // 3.Стоит напомнить, что двухсвязный список представляет из себя цепочку
    // элементов, которые умеют ссылаться не только на следующий элемент
    // последовательности, но и на предыдущий.
    // 4.Вносить корректировки в уже готовые методы на текущий момент не стоит, их
    // модификацией мы займемся позднее

    private Node head;
    private Node tail;

    private class Node {
        private Node next;
        private Node prev;
        private int value;
    }

    // [Node <=> NodeTest]
    public void addFirst(int value) {
        Node node = new Node();
        node.value = value;
        if (head != null) {
            node.next = head;
            head.prev = node;
        } else {
            tail = node;
        }
        head = node;
    }

    public void removeFirst() {
        if (head != null && head.next != null) {
            head.next.prev = null;
            head = head.next;
        } else {
            head = null;
            tail = null;
        }
    }

    public void addLast(int value) {
        Node node = new Node();
        node.value = value;
        if (tail != null) {
            node.prev = tail;
            tail.next = node;
        } else {
            head = node;
        }
        tail = node;
    }

    public void removeLast() {
        if (tail != null && tail.prev != null) {
            tail = tail.prev;
            tail.next = null;

        } else {
            head = null;
            tail = null;
        }
    }

    public void rever() {
        Node node = head;
        // меняем местами указатели на head и tail
        Node temp = head;
        head = tail;
        tail = temp;

        // перибираем список, переворачивая указатели
        while (node.next != null) {
            temp = node.next;
            node.next = node.prev;
            node = node.prev;
        }
    }

    public void sort() {
        boolean needSort;
        do {
            needSort = false;
            Node node = head;
            while (node != null && node.next != null){
                if (node.value > node.next.value){
                    Node before = node.prev;
                    Node after = node.next.next;
                    Node current = node;
                    Node next = node.next;

                    current.next = after;
                    current.prev = next;
                    next.next = current;
                    next.prev = before;
                    if (before != null){
                        before.next = next;
                    } else {
                        head = next;
                    }
                    if (after != null) {
                        after.prev = current;
                    } else  {
                        tail = current;
                    }

                    needSort = true;
                }
                node = node.next;
            }
        } while (needSort);
    }
}
