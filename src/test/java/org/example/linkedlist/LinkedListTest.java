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

    @Test
    @DisplayName("Append a new value to a linked list with one element")
    void should_appendNewValue_when_appendToLinkedListWithOneElement() {
        LinkedList linkedList = new LinkedList(1);

        Integer expectedHeadValue = new LinkedList.Node(1).value;
        Integer expectedTailValue = new LinkedList.Node(2).value;
        int expectedLength = 2;

        linkedList.append(2);

        Integer actualHeadValue = linkedList.getHead().value;
        Integer actualTailValue = linkedList.getTail().value;
        int actualLength = linkedList.getLength();

        assertAll(
                () -> assertEquals(expectedHeadValue, actualHeadValue),
                () -> assertEquals(expectedTailValue, actualTailValue),
                () -> assertEquals(expectedLength, actualLength)
        );
    }

    @Test
    @DisplayName("Append a new value to an empty linked list")
    void should_appendNewValue_when_appendToEmptyLinkedList() {
        LinkedList linkedList = new LinkedList();

        Integer expectedHeadValue = new LinkedList.Node(123).value;
        Integer expectedTailValue = new LinkedList.Node(123).value;
        int expectedLength = 1;

        linkedList.append(123);

        Integer actualHeadValue = linkedList.getHead().value;
        Integer actualTailValue = linkedList.getTail().value;
        int actualLength = linkedList.getLength();

        assertAll(
                () -> assertEquals(expectedHeadValue, actualHeadValue),
                () -> assertEquals(expectedTailValue, actualTailValue),
                () -> assertEquals(expectedLength, actualLength)
        );
    }

    @Test
    @DisplayName("Remove last element from a linked list of multiple elements")
    void should_removeLastAndReturnNode_when_removeLastFromLinkedListWithMultipleElements() {
        LinkedList linkedList = new LinkedList(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.append(5);

        Integer expectedRemovedNodeValue = new LinkedList.Node(5).value;
        Integer expectedHeadValue = new LinkedList.Node(1).value;
        Integer expectedTailValue = new LinkedList.Node(4).value;
        int expectedLength = 4;

        LinkedList.Node removedLast = linkedList.removeLast();

        Integer actualRemovedNodeValue = removedLast.value;
        Integer actualHeadValue = linkedList.getHead().value;
        Integer actualTailValue = linkedList.getTail().value;
        int actualLength = linkedList.getLength();

        assertAll(
                () -> assertEquals(expectedHeadValue, actualHeadValue),
                () -> assertEquals(expectedTailValue, actualTailValue),
                () -> assertEquals(expectedLength, actualLength),
                () -> assertEquals(expectedRemovedNodeValue, actualRemovedNodeValue)
        );
    }

    @Test
    @DisplayName("Remove last element from a linked list of one element")
    void should_removeLastAndReturnNode_when_removeLastFromLinkedListWithOneElement() {
        LinkedList linkedList = new LinkedList(1);

        Integer expectedRemovedNodeValue = new LinkedList.Node(1).value;
        LinkedList.Node expectedHead = null;
        LinkedList.Node expectedTail = null;
        int expectedLength = 0;

        LinkedList.Node removedLast = linkedList.removeLast();

        Integer actualRemovedNodeValue = removedLast.value;
        LinkedList.Node actualHead = linkedList.getHead();
        LinkedList.Node actualTail = linkedList.getTail();
        int actualLength = linkedList.getLength();

        assertAll(
                () -> assertEquals(expectedHead, actualHead),
                () -> assertEquals(expectedTail, actualTail),
                () -> assertEquals(expectedLength, actualLength),
                () -> assertEquals(expectedRemovedNodeValue, actualRemovedNodeValue)
        );
    }

    @Test
    @DisplayName("Remove last element from an empty linked list")
    void should_removeLastAndReturnNull_when_removeLastFromEmptyLinkedList() {
        LinkedList linkedList = new LinkedList();

        LinkedList.Node expectedRemovedNode = null;
        LinkedList.Node expectedHead = null;
        LinkedList.Node expectedTail = null;
        int expectedLength = 0;

        LinkedList.Node actualRemovedNode = linkedList.removeLast();
        LinkedList.Node actualHead = linkedList.getHead();
        LinkedList.Node actualTail = linkedList.getTail();
        int actualLength = linkedList.getLength();

        assertAll(
                () -> assertEquals(expectedHead, actualHead),
                () -> assertEquals(expectedTail, actualTail),
                () -> assertEquals(expectedLength, actualLength),
                () -> assertEquals(expectedRemovedNode, actualRemovedNode)
        );
    }

    @Test
    @DisplayName("Prepend an element to an empty linked list")
    void should_prependElement_when_prependToEmptyLinkedList() {
        LinkedList linkedList = new LinkedList();

        LinkedList.Node prepended = new LinkedList.Node(1);
        int expectedHead = prepended.value;
        int expectedTail = prepended.value;
        int expectedLength = 1;

        linkedList.prepend(1);

        int actualHead = linkedList.getHead().value;
        int actualTail = linkedList.getTail().value;
        int actualLength = linkedList.getLength();

        assertAll(
                () -> assertEquals(expectedHead, actualHead),
                () -> assertEquals(expectedTail, actualTail),
                () -> assertEquals(expectedLength, actualLength)
        );
    }

    @Test
    @DisplayName("Prepend an element to a linked list with one element")
    void should_prependElement_when_prependToLinkedListWithOneElement() {
        LinkedList linkedList = new LinkedList(1);

        int expectedHead = new LinkedList.Node(123).value;
        int expectedTail = new LinkedList.Node(1).value;
        int expectedLength = 2;

        linkedList.prepend(123);

        int actualHead = linkedList.getHead().value;
        int actualTail = linkedList.getTail().value;
        int actualLength = linkedList.getLength();

        assertAll(
                () -> assertEquals(expectedHead, actualHead),
                () -> assertEquals(expectedTail, actualTail),
                () -> assertEquals(expectedLength, actualLength)
        );
    }

    @Test
    @DisplayName("Prepend an element to a linked list with multiple elements")
    void should_prependElement_when_prependToLinkedListWithMultipleElements() {
        LinkedList linkedList = new LinkedList(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.append(5);

        int expectedHead = new LinkedList.Node(123).value;
        int expectedTail = new LinkedList.Node(5).value;
        int expectedLength = 6;

        linkedList.prepend(123);

        int actualHead = linkedList.getHead().value;
        int actualTail = linkedList.getTail().value;
        int actualLength = linkedList.getLength();

        assertAll(
                () -> assertEquals(expectedHead, actualHead),
                () -> assertEquals(expectedTail, actualTail),
                () -> assertEquals(expectedLength, actualLength)
        );
    }

    @Test
    @DisplayName("Remove first element from a linked list of multiple elements")
    void should_removeFirstAndReturnNode_when_removeFirstFromLinkedListWithMultipleElements() {
        LinkedList linkedList = new LinkedList(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.append(5);

        Integer expectedRemovedNodeValue = new LinkedList.Node(1).value;
        Integer expectedHeadValue = new LinkedList.Node(2).value;
        Integer expectedTailValue = new LinkedList.Node(5).value;
        int expectedLength = 4;

        LinkedList.Node removeFirst = linkedList.removeFirst();

        Integer actualRemovedNodeValue = removeFirst.value;
        Integer actualHeadValue = linkedList.getHead().value;
        Integer actualTailValue = linkedList.getTail().value;
        int actualLength = linkedList.getLength();

        assertAll(
                () -> assertEquals(expectedHeadValue, actualHeadValue),
                () -> assertEquals(expectedTailValue, actualTailValue),
                () -> assertEquals(expectedLength, actualLength),
                () -> assertEquals(expectedRemovedNodeValue, actualRemovedNodeValue)
        );
    }

    @Test
    @DisplayName("Remove first element from a linked list of one element")
    void should_removeFirstAndReturnNode_when_removeFirstFromLinkedListWithOneElement() {
        LinkedList linkedList = new LinkedList(123);

        Integer expectedRemovedNodeValue = new LinkedList.Node(123).value;
        LinkedList.Node expectedHead = null;
        LinkedList.Node expectedTail = null;
        int expectedLength = 0;

        LinkedList.Node removeFirst = linkedList.removeFirst();

        Integer actualRemovedNodeValue = removeFirst.value;
        LinkedList.Node actualHead = linkedList.getHead();
        LinkedList.Node actualTail = linkedList.getTail();
        int actualLength = linkedList.getLength();

        assertAll(
                () -> assertEquals(expectedHead, actualHead),
                () -> assertEquals(expectedTail, actualTail),
                () -> assertEquals(expectedLength, actualLength),
                () -> assertEquals(expectedRemovedNodeValue, actualRemovedNodeValue)
        );
    }

    @Test
    @DisplayName("Remove first element from an empty linked list")
    void should_removeFirstAndReturnNull_when_removeFirstFromEmptyLinkedList() {
        LinkedList linkedList = new LinkedList();

        LinkedList.Node expectedRemovedNode = null;
        LinkedList.Node expectedHead = null;
        LinkedList.Node expectedTail = null;
        int expectedLength = 0;

        LinkedList.Node actualRemovedNode = linkedList.removeFirst();
        LinkedList.Node actualHead = linkedList.getHead();
        LinkedList.Node actualTail = linkedList.getTail();
        int actualLength = linkedList.getLength();

        assertAll(
                () -> assertEquals(expectedHead, actualHead),
                () -> assertEquals(expectedTail, actualTail),
                () -> assertEquals(expectedLength, actualLength),
                () -> assertEquals(expectedRemovedNode, actualRemovedNode)
        );
    }

    @Test
    @DisplayName("Get element by valid middle index from a linked list of multiple elements")
    void should_getElementAndReturnNode_when_getByValidMiddleIndexFromLinkedListWithMultipleElements() {
        LinkedList linkedList = new LinkedList(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.append(5);
        linkedList.append(6);

        int index = 3;
        Integer expectedGetNodeValue = new LinkedList.Node(4).value;
        Integer expectedHeadValue = new LinkedList.Node(1).value;
        Integer expectedTailValue = new LinkedList.Node(6).value;
        int expectedLength = 6;

        LinkedList.Node node = linkedList.get(index);

        Integer actualGetNodeValue = node.value;
        Integer actualHeadValue = linkedList.getHead().value;
        Integer actualTailValue = linkedList.getTail().value;
        int actualLength = linkedList.getLength();

        assertAll(
                () -> assertEquals(expectedGetNodeValue, actualGetNodeValue),
                () -> assertEquals(expectedHeadValue, actualHeadValue),
                () -> assertEquals(expectedTailValue, actualTailValue),
                () -> assertEquals(expectedLength, actualLength)
        );
    }

    @Test
    @DisplayName("Get element by valid start index from a linked list of multiple elements")
    void should_getElementAndReturnNode_when_getByValidStartIndexFromLinkedListWithMultipleElements() {
        LinkedList linkedList = new LinkedList(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.append(5);
        linkedList.append(6);

        int index = 0;
        Integer expectedGetNodeValue = new LinkedList.Node(1).value;
        Integer expectedHeadValue = new LinkedList.Node(1).value;
        Integer expectedTailValue = new LinkedList.Node(6).value;
        int expectedLength = 6;

        LinkedList.Node node = linkedList.get(index);

        Integer actualGetNodeValue = node.value;
        Integer actualHeadValue = linkedList.getHead().value;
        Integer actualTailValue = linkedList.getTail().value;
        int actualLength = linkedList.getLength();

        assertAll(
                () -> assertEquals(expectedGetNodeValue, actualGetNodeValue),
                () -> assertEquals(expectedHeadValue, actualHeadValue),
                () -> assertEquals(expectedTailValue, actualTailValue),
                () -> assertEquals(expectedLength, actualLength)
        );
    }

    @Test
    @DisplayName("Get element by valid end index from a linked list of multiple elements")
    void should_getElementAndReturnNode_when_getByValidEndIndexFromLinkedListWithMultipleElements() {
        LinkedList linkedList = new LinkedList(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.append(5);
        linkedList.append(6);

        int index = 5;
        Integer expectedGetNodeValue = new LinkedList.Node(6).value;
        Integer expectedHeadValue = new LinkedList.Node(1).value;
        Integer expectedTailValue = new LinkedList.Node(6).value;
        int expectedLength = 6;

        LinkedList.Node node = linkedList.get(index);

        Integer actualGetNodeValue = node.value;
        Integer actualHeadValue = linkedList.getHead().value;
        Integer actualTailValue = linkedList.getTail().value;
        int actualLength = linkedList.getLength();

        assertAll(
                () -> assertEquals(expectedGetNodeValue, actualGetNodeValue),
                () -> assertEquals(expectedHeadValue, actualHeadValue),
                () -> assertEquals(expectedTailValue, actualTailValue),
                () -> assertEquals(expectedLength, actualLength)
        );
    }

    @Test
    @DisplayName("Get element by invalid positive index from a linked list of multiple elements")
    void should_getElementAndReturnNull_when_getByInvalidPositiveIndexFromLinkedListWithMultipleElements() {
        LinkedList linkedList = new LinkedList(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.append(5);
        linkedList.append(6);

        int index = 100;
        LinkedList.Node expectedGetNode = null;
        Integer expectedHeadValue = new LinkedList.Node(1).value;
        Integer expectedTailValue = new LinkedList.Node(6).value;
        int expectedLength = 6;

        LinkedList.Node actualGetNode = linkedList.get(index);
        Integer actualHeadValue = linkedList.getHead().value;
        Integer actualTailValue = linkedList.getTail().value;
        int actualLength = linkedList.getLength();

        assertAll(
                () -> assertEquals(expectedGetNode, actualGetNode),
                () -> assertEquals(expectedHeadValue, actualHeadValue),
                () -> assertEquals(expectedTailValue, actualTailValue),
                () -> assertEquals(expectedLength, actualLength)
        );
    }

    @Test
    @DisplayName("Get element by invalid negative index from a linked list of multiple elements")
    void should_getElementAndReturnNull_when_getByInvalidNegativeIndexFromLinkedListWithMultipleElements() {
        LinkedList linkedList = new LinkedList(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.append(5);
        linkedList.append(6);

        int index = -100;
        LinkedList.Node expectedGetNode = null;
        Integer expectedHeadValue = new LinkedList.Node(1).value;
        Integer expectedTailValue = new LinkedList.Node(6).value;
        int expectedLength = 6;

        LinkedList.Node actualGetNode = linkedList.get(index);
        Integer actualHeadValue = linkedList.getHead().value;
        Integer actualTailValue = linkedList.getTail().value;
        int actualLength = linkedList.getLength();

        assertAll(
                () -> assertEquals(expectedGetNode, actualGetNode),
                () -> assertEquals(expectedHeadValue, actualHeadValue),
                () -> assertEquals(expectedTailValue, actualTailValue),
                () -> assertEquals(expectedLength, actualLength)
        );
    }

    @Test
    @DisplayName("Get element by zero index from an empty linked list")
    void should_getElementAndReturnNull_when_getByZeroIndexFromEmptyLinkedList() {
        LinkedList linkedList = new LinkedList();

        int index = 0;
        LinkedList.Node expectedGetNode = null;
        LinkedList.Node expectedHead = null;
        LinkedList.Node expectedTail = null;
        int expectedLength = 0;

        LinkedList.Node actualGetNode = linkedList.get(index);
        LinkedList.Node actualHead = linkedList.getHead();
        LinkedList.Node actualTail = linkedList.getTail();
        int actualLength = linkedList.getLength();

        assertAll(
                () -> assertEquals(expectedGetNode, actualGetNode),
                () -> assertEquals(expectedHead, actualHead),
                () -> assertEquals(expectedTail, actualTail),
                () -> assertEquals(expectedLength, actualLength)
        );
    }

    @Test
    @DisplayName("Get element by zero index from a linked list of one element")
    void should_getElementAndReturnNode_when_getByZeroIndexFromLinkedListWithOneElement() {
        LinkedList linkedList = new LinkedList(1);

        int index = 0;
        LinkedList.Node node = new LinkedList.Node(1);
        Integer expectedGetNodeValue = node.value;
        Integer expectedHeadValue = node.value;
        Integer expectedTailValue = node.value;
        int expectedLength = 1;

        Integer actualGetNodeValue = linkedList.get(index).value;
        Integer actualHeadValue = linkedList.getHead().value;
        Integer actualTailValue = linkedList.getTail().value;
        int actualLength = linkedList.getLength();

        assertAll(
                () -> assertEquals(expectedGetNodeValue, actualGetNodeValue),
                () -> assertEquals(expectedHeadValue, actualHeadValue),
                () -> assertEquals(expectedTailValue, actualTailValue),
                () -> assertEquals(expectedLength, actualLength)
        );
    }
}