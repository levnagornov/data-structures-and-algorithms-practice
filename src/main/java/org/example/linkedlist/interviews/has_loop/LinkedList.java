package org.example.linkedlist.interviews.has_loop;

/**
 * Version of a simple Linked list with length, head and tail fields.
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

    /**
     * This method detects if a cycle loop present in the linked list.
     * It uses Floyd's cycle-finding algorithm (also known as the "tortoise and the hare" algorithm) to detect the loop.
     * <p>
     * This algorithm uses two pointers: a slow pointer and a fast pointer. The slow pointer moves one step at a time,
     * while the fast pointer moves two steps at a time. If there is a loop in the linked list,
     * the two pointers will eventually meet at some point. If there is no loop, the fast pointer will reach the end of the list.
     *
     * @return {@code true} if a cycle loop present in the linked list, otherwise returns {@code false}
     */
    public boolean hasLoop() {
        if (length < 1) {
            return false;
        }

        Node slowPointer = head;
        Node fastPointer = head;

        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;

            if (slowPointer == fastPointer) {
                return true;
            }
        }

        return false;
    }
}