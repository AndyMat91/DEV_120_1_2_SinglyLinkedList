package org.example;

import java.util.Iterator;

public class LinkedList<T> implements Iterable<T> {

    private Node<T> head;  //голова

    public LinkedList() {
    }

    public LinkedList(Node<T> head) {
        this.head = head;
    }

    private static class Node<V> {
        public V data; //данные
        public Node<V> next; //ссылка на следующий узел

        public Node(V data) {
            this.data = data;
        }
    }

    public void addInBeginning(T data) {
        if (data != null) {
            Node<T> newNode = new Node<>(data);
            if (head != null) {
                newNode.next = head;
            }
            head = newNode;
        }
    }

    public T extValueFromTheBeginningWithoutDeleting() {  //извлечение значения из начала списка без его удаления из списка;
        return head.data;
    }

    public T extValueFromTheBeginningWithDeleting() {  //извлечение значения из начала списка с удалением его из списка;
        T x = head.data;
        remove(head.data);
        return x;
    }

    public T extValueFromTheEndWithoutDeleting() {  //извлечение значения из конца списка без удаления из списка;
        Node<T> currentNode = head;
        if (head == null)
            return null;
        else {
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            return currentNode.data;
        }
    }

    public T extValueFromTheEndWithDeleting() { //извлечение значения из конца списка с удалением;
        Node<T> currentNode = head;
        if (head == null)
            return null;
        else {
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            T k = currentNode.data;
            remove(currentNode.data);
            return k;
        }
    }

    public void addInEnd(T data) {
        if (data != null) {
            Node<T> newNode = new Node<>(data);
            Node<T> currentNode = head;              //текущий узел

            if (head == null) {                   //если голова отсутствует
                head = newNode;
            } else {
                while (currentNode.next != null) {     //перемещение по списку
                    currentNode = currentNode.next;
                }
                currentNode.next = newNode;  //добравшись до последнего элемента, в качестве следующего установил newNode
            }
        }
    }

    public boolean searchValue(T data) {   //определение, содержит ли список заданное значение, или нет;
        if (data != null) {
            Node<T> currentNode = head;
            while (currentNode != null) {
                if (data.equals(currentNode.data)) {
                    return true;
                } else if (currentNode.next != null) {
                    currentNode = currentNode.next;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public void remove(T data) {//удаление заданного значения из списка;
        if (head == null || data == null) return;
        Node<T> currentNode = head;
        Node<T> previousNode = null;
        if (searchValue(data)) {
            while (currentNode != null) {
                if (currentNode.data.equals(data)) {
                    if (currentNode == head) {
                        head = currentNode.next;
                    } else {
                        previousNode.next = currentNode.next;
                    }
                }
                previousNode = currentNode;
                currentNode = currentNode.next;
            }
        }
    }

    public boolean empty() {   //определение, является ли список пустым, или нет;
        return head == null;
    }

    public void printAll() {                         //печать всех значений списка;
        forEach(System.out::println);
        System.out.println();
    }


    @Override
    public Iterator<T> iterator() {
        return new MyIterator(head);
    }

    private class MyIterator implements Iterator<T>{
        Node<T> current;

        MyIterator(Node<T> current){
            this.current = current;
        }
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T data = current.data;
            current = current.next;
            return data;
        }
    }


    public LinkedList<T> listHeadToValue(T data) {
        if (data != null) {
            LinkedList<T> newList = new LinkedList<>();
            Node<T> currentNode = head;
            while (currentNode != null) {
                if (data.equals(currentNode.data)) {
                    newList.addInEnd(currentNode.data);
                    break;
                } else if (currentNode.next != null) {
                    newList.addInEnd(currentNode.data);
                    currentNode = currentNode.next;
                } else {
                    newList.addInEnd(currentNode.data);
                    break;
                }
            }
            return newList;
        }
        return new LinkedList<>();
    }

    public LinkedList<T> listValueToTail(T data) {
        if (data != null) {
            LinkedList<T> newList = new LinkedList<>();
            Node<T> currentNode = head;
            while (currentNode != null) {
                if (data.equals(currentNode.data)) {
                    newList.addInEnd(currentNode.data);
                    while (currentNode.next != null) {
                        currentNode = currentNode.next;
                        newList.addInEnd(currentNode.data);
                    }
                    break;
                } else if (currentNode.next != null) {
                    currentNode = currentNode.next;
                } else {
                    break;
                }
            }
            return newList;
        }
        return new LinkedList<>();
    }
}
