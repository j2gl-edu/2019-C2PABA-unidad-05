package edu.advanced.unit5.circular;

public class CircularLinekedListMain {

    public static void main(String[] args) {
        CircularLinkedList circularLinkedList = new CircularLinkedList();

        System.out.println("-- Circular Linked List Example -->>\n");

        // Agregar al final de la lista linked
        circularLinkedList.addLast(9);
        // Agregar in inicio de la lista linked
        circularLinkedList.addFirst(41);
        circularLinkedList.addFirst(6);

        System.out.println("-- Circular List --");
        circularLinkedList.display();
        System.out.println();

        circularLinkedList.remove(0);
        circularLinkedList.removeByElement(41);
        circularLinkedList.removeByElement(6);

        circularLinkedList.display();

    }
}
