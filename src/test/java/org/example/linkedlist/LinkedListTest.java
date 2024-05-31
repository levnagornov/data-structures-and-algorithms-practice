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

        int expected = new LinkedList.Node(1).value;
        int actual = linkedList.getHead().value;

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

        int expectedHeadValue = new LinkedList.Node(1).value;
        int expectedTailValue = new LinkedList.Node(2).value;
        int expectedLength = 2;

        linkedList.append(2);

        int actualHeadValue = linkedList.getHead().value;
        int actualTailValue = linkedList.getTail().value;
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

        int expectedHeadValue = new LinkedList.Node(123).value;
        int expectedTailValue = new LinkedList.Node(123).value;
        int expectedLength = 1;

        linkedList.append(123);

        int actualHeadValue = linkedList.getHead().value;
        int actualTailValue = linkedList.getTail().value;
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

        int expectedRemovedNodeValue = new LinkedList.Node(5).value;
        int expectedHeadValue = new LinkedList.Node(1).value;
        int expectedTailValue = new LinkedList.Node(4).value;
        int expectedLength = 4;

        LinkedList.Node removedLast = linkedList.removeLast();

        int actualRemovedNodeValue = removedLast.value;
        int actualHeadValue = linkedList.getHead().value;
        int actualTailValue = linkedList.getTail().value;
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

        int expectedRemovedNodeValue = new LinkedList.Node(1).value;
        LinkedList.Node expectedHead = null;
        LinkedList.Node expectedTail = null;
        int expectedLength = 0;

        LinkedList.Node removedLast = linkedList.removeLast();

        int actualRemovedNodeValue = removedLast.value;
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
    void should_returnNull_when_removeLastFromEmptyLinkedList() {
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

        int expectedRemovedNodeValue = new LinkedList.Node(1).value;
        int expectedHeadValue = new LinkedList.Node(2).value;
        int expectedTailValue = new LinkedList.Node(5).value;
        int expectedLength = 4;

        LinkedList.Node removeFirst = linkedList.removeFirst();

        int actualRemovedNodeValue = removeFirst.value;
        int actualHeadValue = linkedList.getHead().value;
        int actualTailValue = linkedList.getTail().value;
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

        int expectedRemovedNodeValue = new LinkedList.Node(123).value;
        LinkedList.Node expectedHead = null;
        LinkedList.Node expectedTail = null;
        int expectedLength = 0;

        LinkedList.Node removeFirst = linkedList.removeFirst();

        int actualRemovedNodeValue = removeFirst.value;
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
    void should_returnNull_when_removeFirstFromEmptyLinkedList() {
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
    void should_returnNode_when_getByValidMiddleIndexFromLinkedListWithMultipleElements() {
        LinkedList linkedList = new LinkedList(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.append(5);
        linkedList.append(6);

        int index = 3;
        int expectedGetNodeValue = new LinkedList.Node(4).value;
        int expectedHeadValue = new LinkedList.Node(1).value;
        int expectedTailValue = new LinkedList.Node(6).value;
        int expectedLength = 6;

        LinkedList.Node node = linkedList.get(index);

        int actualGetNodeValue = node.value;
        int actualHeadValue = linkedList.getHead().value;
        int actualTailValue = linkedList.getTail().value;
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
    void should_returnNode_when_getByValidStartIndexFromLinkedListWithMultipleElements() {
        LinkedList linkedList = new LinkedList(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.append(5);
        linkedList.append(6);

        int index = 0;
        int expectedGetNodeValue = new LinkedList.Node(1).value;
        int expectedHeadValue = new LinkedList.Node(1).value;
        int expectedTailValue = new LinkedList.Node(6).value;
        int expectedLength = 6;

        LinkedList.Node node = linkedList.get(index);

        int actualGetNodeValue = node.value;
        int actualHeadValue = linkedList.getHead().value;
        int actualTailValue = linkedList.getTail().value;
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
    void should_returnNode_when_getByValidEndIndexFromLinkedListWithMultipleElements() {
        LinkedList linkedList = new LinkedList(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.append(5);
        linkedList.append(6);

        int index = 5;
        int expectedGetNodeValue = new LinkedList.Node(6).value;
        int expectedHeadValue = new LinkedList.Node(1).value;
        int expectedTailValue = new LinkedList.Node(6).value;
        int expectedLength = 6;

        LinkedList.Node node = linkedList.get(index);

        int actualGetNodeValue = node.value;
        int actualHeadValue = linkedList.getHead().value;
        int actualTailValue = linkedList.getTail().value;
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
    void should_returnNull_when_getByInvalidPositiveIndexFromLinkedListWithMultipleElements() {
        LinkedList linkedList = new LinkedList(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.append(5);
        linkedList.append(6);

        int index = 100;
        LinkedList.Node expectedGetNode = null;
        int expectedHeadValue = new LinkedList.Node(1).value;
        int expectedTailValue = new LinkedList.Node(6).value;
        int expectedLength = 6;

        LinkedList.Node actualGetNode = linkedList.get(index);
        int actualHeadValue = linkedList.getHead().value;
        int actualTailValue = linkedList.getTail().value;
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
    void should_returnNull_when_getByInvalidNegativeIndexFromLinkedListWithMultipleElements() {
        LinkedList linkedList = new LinkedList(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.append(5);
        linkedList.append(6);

        int index = -100;
        LinkedList.Node expectedGetNode = null;
        int expectedHeadValue = new LinkedList.Node(1).value;
        int expectedTailValue = new LinkedList.Node(6).value;
        int expectedLength = 6;

        LinkedList.Node actualGetNode = linkedList.get(index);
        int actualHeadValue = linkedList.getHead().value;
        int actualTailValue = linkedList.getTail().value;
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
    void should_returnNull_when_getByZeroIndexFromEmptyLinkedList() {
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
    void should_returnNode_when_getByZeroIndexFromLinkedListWithOneElement() {
        LinkedList linkedList = new LinkedList(1);

        int index = 0;
        LinkedList.Node node = new LinkedList.Node(1);
        int expectedGetNodeValue = node.value;
        int expectedHeadValue = node.value;
        int expectedTailValue = node.value;
        int expectedLength = 1;

        int actualGetNodeValue = linkedList.get(index).value;
        int actualHeadValue = linkedList.getHead().value;
        int actualTailValue = linkedList.getTail().value;
        int actualLength = linkedList.getLength();

        assertAll(
                () -> assertEquals(expectedGetNodeValue, actualGetNodeValue),
                () -> assertEquals(expectedHeadValue, actualHeadValue),
                () -> assertEquals(expectedTailValue, actualTailValue),
                () -> assertEquals(expectedLength, actualLength)
        );
    }

    @Test
    @DisplayName("Set value by zero index of a linked list with multiple elements")
    void should_setValueAndReturnTrue_when_setByZeroIndexOfLinkedListWithMultipleElements() {
        LinkedList linkedList = new LinkedList(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.append(5);
        linkedList.append(6);

        int index = 0;
        int value = 999;
        boolean expectedReturnValue = true;
        LinkedList.Node node = new LinkedList.Node(value);
        int expectedGetNodeValue = node.value;
        int expectedHeadValue = node.value;
        int expectedTailValue = new LinkedList.Node(6).value;
        int expectedLength = 6;

        boolean actualReturnValue = linkedList.set(index, value);
        int actualGetNodeValue = linkedList.get(index).value;
        int actualHeadValue = linkedList.getHead().value;
        int actualTailValue = linkedList.getTail().value;
        int actualLength = linkedList.getLength();

        assertAll(
                () -> assertEquals(expectedReturnValue, actualReturnValue),
                () -> assertEquals(expectedGetNodeValue, actualGetNodeValue),
                () -> assertEquals(expectedHeadValue, actualHeadValue),
                () -> assertEquals(expectedTailValue, actualTailValue),
                () -> assertEquals(expectedLength, actualLength)
        );
    }

    @Test
    @DisplayName("Set value by middle index of a linked list with multiple elements")
    void should_setValueAndReturnTrue_when_setByMiddleIndexOfLinkedListWithMultipleElements() {
        LinkedList linkedList = new LinkedList(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.append(5);
        linkedList.append(6);

        int index = 3;
        int value = 999;
        boolean expectedReturnValue = true;
        int expectedGetNodeValue = new LinkedList.Node(value).value;
        int expectedHeadValue = new LinkedList.Node(1).value;
        int expectedTailValue = new LinkedList.Node(6).value;
        int expectedLength = 6;

        boolean actualReturnValue = linkedList.set(index, value);
        int actualGetNodeValue = linkedList.get(index).value;
        int actualHeadValue = linkedList.getHead().value;
        int actualTailValue = linkedList.getTail().value;
        int actualLength = linkedList.getLength();

        assertAll(
                () -> assertEquals(expectedReturnValue, actualReturnValue),
                () -> assertEquals(expectedGetNodeValue, actualGetNodeValue),
                () -> assertEquals(expectedHeadValue, actualHeadValue),
                () -> assertEquals(expectedTailValue, actualTailValue),
                () -> assertEquals(expectedLength, actualLength)
        );
    }

    @Test
    @DisplayName("Set value by end index of a linked list with multiple elements")
    void should_setValueAndReturnTrue_when_setByEndIndexOfLinkedListWithMultipleElements() {
        LinkedList linkedList = new LinkedList(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.append(5);
        linkedList.append(6);

        int index = 5;
        int value = 999;
        boolean expectedReturnValue = true;
        LinkedList.Node node = new LinkedList.Node(value);
        int expectedGetNodeValue = node.value;
        int expectedHeadValue = new LinkedList.Node(1).value;
        int expectedTailValue = node.value;
        int expectedLength = 6;

        boolean actualReturnValue = linkedList.set(index, value);
        int actualGetNodeValue = linkedList.get(index).value;
        int actualHeadValue = linkedList.getHead().value;
        int actualTailValue = linkedList.getTail().value;
        int actualLength = linkedList.getLength();

        assertAll(
                () -> assertEquals(expectedReturnValue, actualReturnValue),
                () -> assertEquals(expectedGetNodeValue, actualGetNodeValue),
                () -> assertEquals(expectedHeadValue, actualHeadValue),
                () -> assertEquals(expectedTailValue, actualTailValue),
                () -> assertEquals(expectedLength, actualLength)
        );
    }

    @Test
    @DisplayName("Set value by invalid positive index of a linked list with multiple elements")
    void should_returnFalse_when_setByInvalidPositiveIndexOfLinkedListWithMultipleElements() {
        LinkedList linkedList = new LinkedList(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.append(5);
        linkedList.append(6);

        int index = 123;
        int value = 999;
        boolean expectedReturnValue = false;
        LinkedList.Node expectedGetNode = null;
        int expectedHeadValue = new LinkedList.Node(1).value;
        int expectedTailValue = new LinkedList.Node(6).value;
        int expectedLength = 6;

        boolean actualReturnValue = linkedList.set(index, value);
        LinkedList.Node actualGetNode = linkedList.get(index);
        int actualHeadValue = linkedList.getHead().value;
        int actualTailValue = linkedList.getTail().value;
        int actualLength = linkedList.getLength();

        assertAll(
                () -> assertEquals(expectedReturnValue, actualReturnValue),
                () -> assertEquals(expectedGetNode, actualGetNode),
                () -> assertEquals(expectedHeadValue, actualHeadValue),
                () -> assertEquals(expectedTailValue, actualTailValue),
                () -> assertEquals(expectedLength, actualLength)
        );
    }

    @Test
    @DisplayName("Set value by invalid negative index of a linked list with multiple elements")
    void should_returnFalse_when_setByInvalidNegativeIndexOfLinkedListWithMultipleElements() {
        LinkedList linkedList = new LinkedList(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.append(5);
        linkedList.append(6);

        int index = -123;
        int value = 999;
        boolean expectedReturnValue = false;
        LinkedList.Node expectedGetNode = null;
        int expectedHeadValue = new LinkedList.Node(1).value;
        int expectedTailValue = new LinkedList.Node(6).value;
        int expectedLength = 6;

        boolean actualReturnValue = linkedList.set(index, value);
        LinkedList.Node actualGetNode = linkedList.get(index);
        int actualHeadValue = linkedList.getHead().value;
        int actualTailValue = linkedList.getTail().value;
        int actualLength = linkedList.getLength();

        assertAll(
                () -> assertEquals(expectedReturnValue, actualReturnValue),
                () -> assertEquals(expectedGetNode, actualGetNode),
                () -> assertEquals(expectedHeadValue, actualHeadValue),
                () -> assertEquals(expectedTailValue, actualTailValue),
                () -> assertEquals(expectedLength, actualLength)
        );
    }

    @Test
    @DisplayName("Insert node by zero index of a linked list with multiple elements")
    void should_insertNodeAndReturnTrue_when_insertByZeroIndexOfLinkedListWithMultipleElements() {
        LinkedList linkedList = new LinkedList(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.append(5);
        linkedList.append(6);

        int index = 0;
        int value = 999;
        boolean expectedReturnValue = true;
        LinkedList.Node node = new LinkedList.Node(value);
        int expectedGetNodeValue = node.value;
        int expectedGetNextNodeValue = new LinkedList.Node(1).value;
        int expectedHeadValue = node.value;
        int expectedTailValue = new LinkedList.Node(6).value;
        int expectedLength = 7;

        boolean actualReturnValue = linkedList.insert(index, value);
        LinkedList.Node actualGetNode = linkedList.get(index);
        int actualGetNodeValue = actualGetNode.value;
        int actualGetNextNodeValue = actualGetNode.next.value;
        int actualHeadValue = linkedList.getHead().value;
        int actualTailValue = linkedList.getTail().value;
        int actualLength = linkedList.getLength();

        assertAll(
                () -> assertEquals(expectedReturnValue, actualReturnValue),
                () -> assertEquals(expectedGetNodeValue, actualGetNodeValue),
                () -> assertEquals(expectedGetNextNodeValue, actualGetNextNodeValue),
                () -> assertEquals(expectedHeadValue, actualHeadValue),
                () -> assertEquals(expectedTailValue, actualTailValue),
                () -> assertEquals(expectedLength, actualLength)
        );
    }

    @Test
    @DisplayName("Insert node by middle index of a linked list with multiple elements")
    void should_insertNodeAndReturnTrue_when_insertByMiddleIndexOfLinkedListWithMultipleElements() {
        LinkedList linkedList = new LinkedList(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.append(5);
        linkedList.append(6);

        int index = 3;
        int value = 999;
        boolean expectedReturnValue = true;
        int expectedGetNodeValue = new LinkedList.Node(value).value;
        int expectedGetNextNodeValue = new LinkedList.Node(4).value;
        int expectedHeadValue = new LinkedList.Node(1).value;
        int expectedTailValue = new LinkedList.Node(6).value;
        int expectedLength = 7;

        boolean actualReturnValue = linkedList.insert(index, value);
        LinkedList.Node actualGetNode = linkedList.get(index);
        int actualGetNodeValue = actualGetNode.value;
        int actualGetNextNodeValue = actualGetNode.next.value;
        int actualHeadValue = linkedList.getHead().value;
        int actualTailValue = linkedList.getTail().value;
        int actualLength = linkedList.getLength();

        assertAll(
                () -> assertEquals(expectedReturnValue, actualReturnValue),
                () -> assertEquals(expectedGetNodeValue, actualGetNodeValue),
                () -> assertEquals(expectedGetNextNodeValue, actualGetNextNodeValue),
                () -> assertEquals(expectedHeadValue, actualHeadValue),
                () -> assertEquals(expectedTailValue, actualTailValue),
                () -> assertEquals(expectedLength, actualLength)
        );
    }

    @Test
    @DisplayName("Insert node by end index of a linked list with multiple elements")
    void should_insertNodeAndReturnTrue_when_insertByEndIndexOfLinkedListWithMultipleElements() {
        LinkedList linkedList = new LinkedList(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.append(5);
        linkedList.append(6);

        int index = 6;
        int value = 999;
        boolean expectedReturnValue = true;
        LinkedList.Node node = new LinkedList.Node(value);
        int expectedGetNodeValue = node.value;
        LinkedList.Node expectedGetNextNode = null;
        int expectedHeadValue = new LinkedList.Node(1).value;
        int expectedTailValue = node.value;
        int expectedLength = 7;

        boolean actualReturnValue = linkedList.insert(index, value);
        LinkedList.Node actualGetNode = linkedList.get(index);
        int actualGetNodeValue = actualGetNode.value;
        LinkedList.Node actualGetNextNode = actualGetNode.next;
        int actualHeadValue = linkedList.getHead().value;
        int actualTailValue = linkedList.getTail().value;
        int actualLength = linkedList.getLength();

        assertAll(
                () -> assertEquals(expectedReturnValue, actualReturnValue),
                () -> assertEquals(expectedGetNodeValue, actualGetNodeValue),
                () -> assertEquals(expectedGetNextNode, actualGetNextNode),
                () -> assertEquals(expectedHeadValue, actualHeadValue),
                () -> assertEquals(expectedTailValue, actualTailValue),
                () -> assertEquals(expectedLength, actualLength)
        );
    }

    @Test
    @DisplayName("Insert node by invalid positive index of a linked list with multiple elements")
    void should_returnFalse_when_insertByInvalidPositiveIndexOfLinkedListWithMultipleElements() {
        LinkedList linkedList = new LinkedList(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.append(5);
        linkedList.append(6);

        int index = 123;
        int value = 999;
        boolean expectedReturnValue = false;
        LinkedList.Node expectedGetNode = null;
        int expectedHeadValue = new LinkedList.Node(1).value;
        int expectedTailValue = new LinkedList.Node(6).value;
        int expectedLength = 6;

        boolean actualReturnValue = linkedList.insert(index, value);
        LinkedList.Node actualGetNode = linkedList.get(index);
        int actualHeadValue = linkedList.getHead().value;
        int actualTailValue = linkedList.getTail().value;
        int actualLength = linkedList.getLength();

        assertAll(
                () -> assertEquals(expectedReturnValue, actualReturnValue),
                () -> assertEquals(expectedGetNode, actualGetNode),
                () -> assertEquals(expectedHeadValue, actualHeadValue),
                () -> assertEquals(expectedTailValue, actualTailValue),
                () -> assertEquals(expectedLength, actualLength)
        );
    }

    @Test
    @DisplayName("Insert node by invalid negative index of a linked list with multiple elements")
    void should_returnFalse_when_insertByInvalidNegativeIndexOfLinkedListWithMultipleElements() {
        LinkedList linkedList = new LinkedList(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.append(5);
        linkedList.append(6);

        int index = -123;
        int value = 999;
        boolean expectedReturnValue = false;
        LinkedList.Node expectedGetNode = null;
        int expectedHeadValue = new LinkedList.Node(1).value;
        int expectedTailValue = new LinkedList.Node(6).value;
        int expectedLength = 6;

        boolean actualReturnValue = linkedList.insert(index, value);
        LinkedList.Node actualGetNode = linkedList.get(index);
        int actualHeadValue = linkedList.getHead().value;
        int actualTailValue = linkedList.getTail().value;
        int actualLength = linkedList.getLength();

        assertAll(
                () -> assertEquals(expectedReturnValue, actualReturnValue),
                () -> assertEquals(expectedGetNode, actualGetNode),
                () -> assertEquals(expectedHeadValue, actualHeadValue),
                () -> assertEquals(expectedTailValue, actualTailValue),
                () -> assertEquals(expectedLength, actualLength)
        );
    }
}