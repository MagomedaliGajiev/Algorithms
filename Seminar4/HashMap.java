package Seminar4;

import org.w3c.dom.Node;

// 1. Начинаем реализацию хэш-таблицы с подготовки структуры и
// необходимых классов.
// 2. Давайте напишем реализацию односвязного списка, в котором мы
// и будем хранить пары ключ-значение.
// 3. Стоит обратить внимание, что можно использовать как дженерики,
// для обобщения возможных типов ключей и значений, так и
// заранее определить для себя конкретные типы, которые будут
// использоваться в качестве ключа и значения. Оба подхода
// допустимы для реализации.
//

public class HashMap<K, V> {
    private final int SIZE = 10;
    private int length = 0;
    private double loadFactory = 0.75;
    List[] list;

    public HashMap(int size) {
        list = (List[]) new Object[size];
    }

    public HashMap() {
         list = (List[]) new Object[SIZE];;
    }

    public int calculateBacketIndex(K key) {
        return key.hashCode() % list.length;
    }

    public V findValueInList(K key) {
        int index = calculateBacketIndex(key);
        if (list[index] != null) {
            return list[index].finfV(key);
        }
        return null;
    }

    public boolean addItem(K key, V value) {
        if (list.length > loadFactory * length) {
            reCalculate();
        }
        Entity newEntity = new Entity();
        newEntity.key = key;
        newEntity.value = value;
        int index = calculateBacketIndex(key);
        List itemList = list[index];
        if (itemList == null) {
            itemList = new List();
            list[index] = itemList;
        }
        boolean flag = list[index].add(newEntity);
        if (flag) {
            length++;    
        }
        return flag;
    }

    public boolean removeItem(K key) {
        int index = calculateBacketIndex(key);
        boolean flag = list[index].remove(key);
        if (flag) {
            length--;
        }
        return flag;
    }

    public void reCalculate() {
        List[] oldList = list;
        list = (List[]) new Object[oldList.length * 2];
        for (int i = 0; i < oldList.length; i++) {
            List itemList = oldList[i];
            List.Node node = itemList.head;
            while (node != null) {
                addItem(node.data.key, node.data.value);
                node = node.next;
            }
            oldList[i] = null;
        }
    }

    public class Entity {
        private K key;
        private V value;
    }

    public class List {
        
        private Node head;
        
        public class Node {
            private Entity data;
            private Node next;

        }

        public V finfV(K key) {
            Node node = head;
            while (node != null) {
                if (node.data.key.equals(key)) {
                    return node.data.value;
                }
                node = node.next;
            }
            return null;
        }

        public boolean add(Entity item) {
            Node node = head;
            while (node != null) {
                if (node.data.key.equals(item.key)) {
                    return false;
                }
                if (node.next == null) {
                    break;
                }
                node = node.next;
            }
            Node newNode = new Node();
            newNode.data = item;
            node.next = newNode;
            return true;
        }

        public boolean remove(K key) {
            Node node = head;
            Node prev = head;
            if (head != null) {
                if (head.data.key.equals(key)) {
                    head = head.next;
                    return true;
                }
            }
            while (node != null) {
                if (node.data.key.equals(key)) {
                    prev.next = node.next;
                    return true;
                }
                prev = node;
                node = node.next;
            }
            return false;
        }
    }
    
}
