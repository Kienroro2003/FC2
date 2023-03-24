package list;

import java.util.Iterator;

public class MyLinkedList<E> extends MyAbstractList<E> {
    private class Node<E> {
        private E e;
        private Node<E> next;
        private Node<E> previous;

        public Node(E e) {
            this.e = e;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "e=" + e +
                    ", next=" + next +
                    '}';
        }
    }

    private Node<E> head;
    private Node<E> tail;

    public void addFirst(E e) {
        Node<E> node = new Node<>(e);
        node.next = head;
        head = node;
        if (tail == null) {
            tail = head;
        }
        size++;
    }

    public void addLast(E e) {
        Node<E> node = new Node<>(e);
        tail.next = node;
        node.previous = tail;
        tail = node;
//        System.out.println("Next: " + tail.e);
//        System.out.println("Previous: " + tail.previous.e);
        if (head == null) {
            head = tail;
        }
        size++;
    }

    public E removeFirst() {
        if (size == 0) {
            return null;
        } else {
            Node<E> temp = head;
            head = head.next;
            size--;
            if (head == null) tail = null;
            return temp.e;
        }
    }

    public E removeLast() {
        if (size == 0) {
            return null;
        } else if (size == 1) {
            Node<E> temp = tail;
            head = tail = null;
            size--;
            return temp.e;
        } else {
//            Node<E> node = head;
//            for (int i = 0; i < size - 2; i++) {
//                node = node.next;
//            }
//            E e = tail.e;
//            tail = node;
//            tail.next = null;

            E e = tail.e;
            tail = tail.previous;
            tail.next = null;
            size--;
            return e;
        }
    }


    @Override
    public void add(int index, E e) {
        checkIndex(index);
        Node<E> node = new Node<>(e);
        if (index == 0) {
            addFirst(e);
        } else if (index == size - 1) {
            addLast(e);
        } else {
            Node<E> nodeBeforeIndex = head;
            Node<E> nodeAfterIndex = null;
            for (int i = 0; i < index - 1; i++) {
                nodeBeforeIndex = nodeBeforeIndex.next;
            }
            nodeAfterIndex = nodeBeforeIndex.next;
            nodeBeforeIndex.next = node;
            node.previous = nodeBeforeIndex;
            node.next = nodeAfterIndex;
        }
        size++;
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public boolean contains(E e) {
        Node<E> current = head;
        if(get(0).equals(e)){
            return true;
        }else if(get(size-1).equals(e)){
            return true;
        }else {
            for (int i = 1; i < size - 2; i++) {
                if (current.e.equals(e)) {
                    return true;
                }
                current = current.next;
            }
            return false;
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
        }
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        if (index == 0) {
            return head.e;
        } else if (index == size - 1) {
            return tail.e;
        } else {
            Node<E> current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current.e;
        }
    }

    @Override
    public int indexOf(E e, int from) {
        Node<E> node = head;
        for (int i = from; i < size - 1; i++) {
            if(node.e.equals(e)){
                return i;
            }
            node = node.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(E e) {
        Node<E> node = tail;
        for (int i = size - 1 ; i >= 0 ; i--){
            if(node.e.equals(e)){
                return i;
            }
            node = node.previous;
        }
        return -1;
    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        E result = get(index);
        if (index == 0) {
            head = head.next;
        } else if (index == size - 1) {
            tail = tail.previous;
            tail.next = null;
        }
        return result;
    }

    @Override
    public Object set(int index, E e) {
        checkIndex(index);
        E oldValue = get(index);
        if(index == 0){
            head.e = e;
        }else if (index == size - 1){
            tail.e = e;
        }else{
            Node<E> current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            current.e = e;
        }
        return oldValue;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return "MyLinkedList{" +
                "head=" + head +
                ", tail=" + tail +
                '}';
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
