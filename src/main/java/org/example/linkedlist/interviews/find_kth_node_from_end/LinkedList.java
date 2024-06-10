package org.example.linkedlist.interviews.find_kth_node_from_end;

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
     * This method returns the Kth Node from the end of the linked list.
     *
     * @return the Kth Node from the end.
     */
    public Node findKthNodeFromEnd(int k) {
        Node slowPointer = head;
        Node fastPointer = head;

        // move fast pointer K steps forward
        for (int i = 0; i < k; i++) {
            // if we reach the end, then the list is smaller than k, so we can't return Kth Node
            if (fastPointer == null) {
                return null;
            }

            fastPointer = fastPointer.next;
        }

        while (fastPointer != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next;
        }

        return slowPointer;
    }
}
