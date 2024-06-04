package org.example.linkedlist.interviews.find_middle_node;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    @DisplayName("Find the middle node of a linked list of even size")
    void should_returnMiddleNode_when_findMiddleNodeOfLinkedListEvenElements() {
        LinkedList linkedList = new LinkedList(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.append(5);
        linkedList.append(6);

        int expectedMiddleNodeValue = new LinkedList.Node(4).value;
        int expectedHeadValue = new LinkedList.Node(1).value;
        int expectedTailValue = new LinkedList.Node(6).value;

        int actualMiddleNodeValue = linkedList.findMiddleNode().value;
        int actualHeadValue = linkedList.getHead().value;
        int actualTailValue = linkedList.getTail().value;

        assertAll(
                () -> assertEquals(expectedMiddleNodeValue, actualMiddleNodeValue),
                () -> assertEquals(expectedHeadValue, actualHeadValue),
                () -> assertEquals(expectedTailValue, actualTailValue)
        );
    }

    @Test
    @DisplayName("Find the middle node of a linked list of odd size")
    void should_returnMiddleNode_when_findMiddleNodeOfLinkedListOddElements() {
        LinkedList linkedList = new LinkedList(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.append(5);
        linkedList.append(6);
        linkedList.append(7);

        int expectedMiddleNodeValue = new LinkedList.Node(4).value;
        int expectedHeadValue = new LinkedList.Node(1).value;
        int expectedTailValue = new LinkedList.Node(7).value;

        int actualMiddleNodeValue = linkedList.findMiddleNode().value;
        int actualHeadValue = linkedList.getHead().value;
        int actualTailValue = linkedList.getTail().value;

        assertAll(
                () -> assertEquals(expectedMiddleNodeValue, actualMiddleNodeValue),
                () -> assertEquals(expectedHeadValue, actualHeadValue),
                () -> assertEquals(expectedTailValue, actualTailValue)
        );
    }

    @Test
    @DisplayName("Find the middle node of a linked list of one element")
    void should_returnMiddleNode_when_findMiddleNodeOfLinkedListOneElement() {
        LinkedList linkedList = new LinkedList(1);

        LinkedList.Node node = new LinkedList.Node(1);
        int expectedMiddleNodeValue = node.value;
        int expectedHeadValue = node.value;
        int expectedTailValue = node.value;

        int actualMiddleNodeValue = linkedList.findMiddleNode().value;
        int actualHeadValue = linkedList.getHead().value;
        int actualTailValue = linkedList.getTail().value;

        assertAll(
                () -> assertEquals(expectedMiddleNodeValue, actualMiddleNodeValue),
                () -> assertEquals(expectedHeadValue, actualHeadValue),
                () -> assertEquals(expectedTailValue, actualTailValue)
        );
    }

    @Test
    @DisplayName("Find the middle node of an empty linked list")
    void should_returnNull_when_findMiddleNodeOfEmptyLinkedList() {
        LinkedList linkedList = new LinkedList();

        LinkedList.Node expectedMiddleNode = null;
        LinkedList.Node expectedHead = null;
        LinkedList.Node expectedTail = null;

        LinkedList.Node actualMiddleNode = linkedList.findMiddleNode();
        LinkedList.Node actualHead = linkedList.getHead();
        LinkedList.Node actualTail = linkedList.getTail();

        assertAll(
                () -> assertEquals(expectedMiddleNode, actualMiddleNode),
                () -> assertEquals(expectedHead, actualHead),
                () -> assertEquals(expectedTail, actualTail)
        );
    }
}