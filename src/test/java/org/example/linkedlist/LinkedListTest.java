package org.example.linkedlist;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    @DisplayName("Get head of a linked list of one element")
    void should_returnNode_when_getHeadOfLinkedListWithOneElement() {
        LinkedList linkedList = new LinkedList(1);

        Integer expected = new LinkedList.Node(1).value;
        Integer actual = linkedList.getHead().value;

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Get head of an empty linked list")
    void should_returnNull_when_getHeadOfEmptyLinkedList() {
        LinkedList linkedList = new LinkedList();

        LinkedList.Node expected = null;
        LinkedList.Node actual = linkedList.getHead();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Get tail of a linked list of one element")
    void should_returnNode_when_getTailOfLinkedListWithOneElement() {
        LinkedList linkedList = new LinkedList(2);

        int expected = new LinkedList.Node(2).value;
        int actual = linkedList.getTail().value;

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Get tail of empty linked list")
    void should_returnNull_when_getTailOfEmptyLinkedList() {
        LinkedList linkedList = new LinkedList();

        LinkedList.Node expected = null;
        LinkedList.Node actual = linkedList.getTail();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Get length of a linked list of one element")
    void should_return1_when_getLengthOfLinkedListWithOneElement() {
        LinkedList linkedList = new LinkedList(1);

        int expected = 1;
        int actual = linkedList.getLength();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Get length of an empty linked list")
    void should_return0_when_getLengthOfEmptyLinkedList() {
        LinkedList linkedList = new LinkedList();

        int expected = 0;
        int actual = linkedList.getLength();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Print elements of a linked list of one element")
    void should_printListOfOneElement_when_printListOfLinkedListWithOneElement() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        LinkedList linkedList = new LinkedList(1);

        String expected = "1\n";
        linkedList.printList();
        String actual = outContent.toString();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Print empty linked list")
    void should_printNothing_when_printListOfEmptyLinkedList() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        LinkedList linkedList = new LinkedList();

        String expected = "";
        linkedList.printList();
        String actual = outContent.toString();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Print all: head, tail and elements of a linked list with one element")
    void should_printListOfOneElement_when_printAllOfLinkedListWithOneElement() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        LinkedList linkedList = new LinkedList(1);

        String expected = "Head: 1\nTail: 1\nLength: 1\n\nLinkedList:\n1\n";
        linkedList.printAll();
        String actual = outContent.toString();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Print all: head, tail and elements of an empty linked list")
    void should_printListEmpty_when_printAllOfEmptyLinkedList() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        LinkedList linkedList = new LinkedList();

        String expected = "Head: null\nTail: null\nLength: 0\n\nLinkedList:\nempty\n";
        linkedList.printAll();
        String actual = outContent.toString();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Make empty an empty linked list")
    void should_makeLinkedListEmpty_when_makeEmptyOfEmptyLinkedList() {
        LinkedList linkedList = new LinkedList();

        LinkedList.Node expectedHead = null;
        LinkedList.Node expectedTail = null;
        int expectedLength = 0;

        linkedList.makeEmpty();

        LinkedList.Node actualHead = linkedList.getHead();
        LinkedList.Node actualTail = linkedList.getTail();
        int actualLength = linkedList.getLength();

        assertAll(
                () -> assertEquals(expectedHead, actualHead),
                () -> assertEquals(expectedTail, actualTail),
                () -> assertEquals(expectedLength, actualLength)
        );
    }

    @Test
    @DisplayName("Make empty a linked list with one element")
    void should_makeLinkedListEmpty_when_makeEmptyOfLinkedListWithOneElement() {
        LinkedList linkedList = new LinkedList(1);

        LinkedList.Node expectedHead = null;
        LinkedList.Node expectedTail = null;
        int expectedLength = 0;

        linkedList.makeEmpty();

        LinkedList.Node actualHead = linkedList.getHead();
        LinkedList.Node actualTail = linkedList.getTail();
        int actualLength = linkedList.getLength();

        assertAll(
                () -> assertEquals(expectedHead, actualHead),
                () -> assertEquals(expectedTail, actualTail),
                () -> assertEquals(expectedLength, actualLength)
        );
    }
}