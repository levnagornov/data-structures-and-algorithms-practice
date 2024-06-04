package org.example.linkedlist.interviews.find_middle_node;

/**
 * Version of a simple Linked list without length variable
 */
public class LinkedList {
    private Node head;
    private Node tail;

    public LinkedList() {
        head = null;
        tail = null;
    }

    public LinkedList(int value) {
        head = new Node(value);
        tail = head;
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

    public void append(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }

        tail = newNode;
    }

    /**
     * This method returns the middle node of the linked list.
     * If the list has an even number of nodes, the method returns the second middle node.
     * It uses the slow and fast pointer technique (also known as Floyd's Tortoise and Hare algorithm)
     * to find the middle element of the linked list efficiently.
     *
     * @return the middle Node.
     */
    public Node findMiddleNode() {
        Node slowPointer = head;
        Node fastPointer = head;

        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        return slowPointer;
    }
}
