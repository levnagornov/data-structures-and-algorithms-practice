package org.example.linkedlist.interviews.find_kth_node_from_end;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    @DisplayName("Find Kth Node from the end of a linked list with size less then K")
    void should_returnNull_when_findKthNodeFromEndOfLinkedListWithSizeLessK() {
        LinkedList linkedList = new LinkedList(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.append(3);
        linkedList.append(2);

        int kBiggerThanLength = 7;

        LinkedList.Node expectedKthNodeFromEnd = null;
        LinkedList.Node actualNodeKthNodeFromEnd = linkedList.findKthNodeFromEnd(kBiggerThanLength);

        assertEquals(expectedKthNodeFromEnd, actualNodeKthNodeFromEnd);
    }

    @Test
    @DisplayName("Find Kth Node from the end of a linked list with size equal to K")
    void should_returnKthNodeFromEnd_when_findKthNodeFromEndOfLinkedListWithSizeEqualK() {
        LinkedList linkedList = new LinkedList(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.append(3);
        linkedList.append(2);

        int kEqualToLength = 6;

        int expectedKthNodeValueFromEnd = new LinkedList.Node(1).value;
        int actualNodeValueKthNodeFromEnd = linkedList.findKthNodeFromEnd(kEqualToLength).value;

        assertEquals(expectedKthNodeValueFromEnd, actualNodeValueKthNodeFromEnd);
    }

    @Test
    @DisplayName("Find Kth Node from the end of a linked list with size bigger than K")
    void should_returnKthNodeFromEnd_when_findKthNodeFromEndOfLinkedListWithSizeBiggerK() {
        LinkedList linkedList = new LinkedList(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.append(3);
        linkedList.append(2);

        int kLessThanLength = 5;

        int expectedKthNodeValueFromEnd = new LinkedList.Node(2).value;
        int actualValueKthNodeFromEnd = linkedList.findKthNodeFromEnd(kLessThanLength).value;

        assertEquals(expectedKthNodeValueFromEnd, actualValueKthNodeFromEnd);
    }

    @Test
    @DisplayName("Find Kth Node from the end of a linked list of one element")
    void should_returnKthNodeFromEnd_when_findKthNodeFromEndOfLinkedListOfOneElement() {
        LinkedList linkedList = new LinkedList(123);

        int k = 1;

        int expectedKthNodeValueFromEnd = new LinkedList.Node(123).value;
        int actualValueKthNodeFromEnd = linkedList.findKthNodeFromEnd(k).value;

        assertEquals(expectedKthNodeValueFromEnd, actualValueKthNodeFromEnd);
    }

    @Test
    @DisplayName("Find Kth Node from the end of an empty linked list")
    void should_returnNull_when_findKthNodeFromEndOfEmptyLinkedList() {
        LinkedList linkedList = new LinkedList();

        int kLessThanLength = 0;

        LinkedList.Node expectedKthNodeFromEnd = null;
        LinkedList.Node actualKthNodeFromEnd = linkedList.findKthNodeFromEnd(kLessThanLength);

        assertEquals(expectedKthNodeFromEnd, actualKthNodeFromEnd);
    }


}