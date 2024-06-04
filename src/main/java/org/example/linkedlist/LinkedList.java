package org.example.linkedlist;

/**
 * My version of a simple Linked list
 */
public class LinkedList {
    private Node head;
    private Node tail;
    private int length;

    public LinkedList() {
        head = null;
        tail = null;
        length = 0;
    }

    public LinkedList(int value) {
        head = new Node(value);
        tail = head;
        length = 1;
    }

    public static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }

    public void printList() {
        Node temp = head;

        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (length == 0) {
            System.out.println("Head: null");
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
        }

        System.out.println("Length: " + length);
        System.out.println("\nLinkedList:");

        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    public void makeEmpty() {
        head = null;
        tail = null;
        length = 0;
    }

    public void append(int value) {
        Node newNode = new Node(value);

        if (length == 0) {
            head = newNode;
        } else {
            tail.next = newNode;
        }

        tail = newNode;
        length++;
    }

    public Node removeLast() {
        if (length == 0) {
            return null;
        }

        Node temp = head;
        Node pre = head;

        while (temp.next != null) {
            pre = temp;
            temp = temp.next;
        }

        tail = pre;
        tail.next = null;
        length--;

        if (length == 0) {
            head = null;
            tail = null;
        }

        return temp;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);

        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }

        length++;
    }

    public Node removeFirst() {
        if (length == 0) {
            return null;
        }

        Node temp = head;
        head = temp.next;
        temp.next = null;
        length--;

        if (length == 0) {
            head = null;
            tail = null;
        }

        return temp;
    }

    public Node get(int index) {
        if (length == 0 || index < 0 || index >= length) {
            return null;
        }

        Node current = head;

        for (int i = 0; i < length; i++) {
            if (i == index) {
                break;
            }
            current = current.next;
        }

        return current;
    }

    public boolean set(int index, int value) {
        if (index < 0 || index >= length) {
            return false;
        }

        Node node = get(index);
        node.value = value;

        return true;
    }

    public boolean insert(int index, int value) {
        if (index < 0 || index > length) {
            return false;
        }

        if (index == 0) {
            prepend(value);
            return true;
        }

        if (index == length) {
            append(value);
            return true;
        }

        Node newNode = new Node(value);
        Node nodeBefore = get(index - 1);
        newNode.next = nodeBefore.next;
        nodeBefore.next = newNode;
        length++;

        return true;
    }

    public Node remove(int index) {
        if (index < 0 || index >= length) {
            return null;
        }

        if (index == 0) {
            return removeFirst();
        }

        if (index == length - 1) {
            return removeLast();
        }

        Node beforeRemoved = get(index - 1);
        Node temp = beforeRemoved.next;
        beforeRemoved.next = temp.next;
        temp.next = null;
        length--;

        return temp;
    }

    public void reverse() {
        if (length <= 1) {
            return;
        }

        // swap Head and Tail
        Node temp = head;
        head = tail;
        tail = temp;

        // use 3 pointers technique: before, temp (current), after
        // before   temp   after
        //  null     e1  ->  e2  ->  e3  -> ...
        Node before = null;
        Node after;

        for (int i = 0; i < length; i++) {
            after = temp.next;  // move pointer
            temp.next = before; // redirect the link in the opposite direction
            before = temp;      // move pointer
            temp = after;       // move pointer
        }
    }
}
