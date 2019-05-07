package edu.advanced.unit5.circular;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class CircularLinkedListTest {

    private CircularLinkedList circularLinkedList;

    @BeforeEach
    void setUp() {
        circularLinkedList = new CircularLinkedList();
    }

    @Test
    void isEmpty() {
        assertThat(circularLinkedList.isEmpty(), is(true));

        circularLinkedList.addFirst(1);

        assertThat(circularLinkedList.isEmpty(), is(false));
    }

    @Test
    void getSize() {
        assertThat(circularLinkedList.getSize(), is(0));

        circularLinkedList.addFirst(1);
        assertThat(circularLinkedList.getSize(), is(1));

        circularLinkedList.addFirst(2);
        circularLinkedList.addFirst(3);
        assertThat(circularLinkedList.getSize(), is(3));
    }

    @Test
    void addLast() {
        circularLinkedList.addLast(0);
        circularLinkedList.addLast(1);
        circularLinkedList.addLast(2);
        circularLinkedList.addLast(3);

        assertThat(circularLinkedList.indexOf(0), is(0));
        assertThat(circularLinkedList.indexOf(1), is(1));
        assertThat(circularLinkedList.indexOf(2), is(2));
    }

    @Test
    void addFirst() {
    }

    @Test
    void addAfterReference() {
    }

    @Test
    void add() {
    }

    @Test
    void get() {
    }

    @Test
    void contains() {
    }

    @Test
    void indexOf() {
    }

    @Test
    void modifyByValue() {
    }

    @Test
    void modify() {
    }

    @Test
    void removeByElement() {
    }

    @Test
    void remove() {
    }

    @Test
    void clear() {
    }

    @Test
    void convertToString() {
    }

    @Test
    void display() {
    }
}