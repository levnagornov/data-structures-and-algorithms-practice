package org.example.linkedlist.interviews.has_loop;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    @DisplayName("Has loop with no loop")
    void should_returnFalse_when_hasLoopOfLinkedListWithMultipleElementsWithNoLoop() {
        LinkedList linkedList = new LinkedList();
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.append(3);
        linkedList.append(2);

        assertFalse(linkedList.hasLoop());
    }

    @Test
    @DisplayName("Has loop with loop in the tail")
    void should_returnTrue_when_hasLoopOfLinkedListWithMultipleElementsAndTailNextPointingToNode() {
        LinkedList linkedList = new LinkedList();
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.append(3);
        linkedList.append(2);

        // creating a loop
        LinkedList.Node first = linkedList.getHead();
        LinkedList.Node tail = linkedList.getTail();
        tail.next = first;

        assertTrue(linkedList.hasLoop());
    }

    @Test
    @DisplayName("Has loop with loop in the tail")
    void should_returnTrue_when_hasLoopOfLinkedListWithMultipleElementsAndLoopInBetween() {
        LinkedList linkedList = new LinkedList();
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.append(3);
        linkedList.append(2);

        // creating a loop
        LinkedList.Node first = linkedList.getHead();
        LinkedList.Node second = first.next;
        LinkedList.Node third = second.next;
        LinkedList.Node fourth = third.next;
        fourth.next = first;

        assertTrue(linkedList.hasLoop());
    }

    @Test
    @DisplayName("Has loop with empty list")
    void should_returnFalse_when_hasLoopOfLinkedListWithEmptyList() {
        LinkedList linkedList = new LinkedList();

        assertFalse(linkedList.hasLoop());
    }

    @Test
    @DisplayName("Has loop with empty one element list")
    void should_returnFalse_when_hasLoopOfLinkedListWithOneElement() {
        LinkedList linkedList = new LinkedList();
        linkedList.append(2);

        assertFalse(linkedList.hasLoop());
    }
}