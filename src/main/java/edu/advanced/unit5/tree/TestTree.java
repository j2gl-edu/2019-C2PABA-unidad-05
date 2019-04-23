package edu.advanced.unit5.tree;

public class TestTree {

    public static void main(String[] args) {
        NodeTree root = new NodeTree(10);
        root.add(20);
        root.add(4);
        root.add(2);
        root.add(9);
        root.add(5);
        root.add(8);
        root.add(12);
        root.add(15);
        root.add(25);

        NodeTree result = root.find(11);
        if (result != null) {
            System.out.println(result);
        } else {
            System.out.println("No encontrado");
        }

        result = root.find(8);
        if (result != null) {
            System.out.println(result);
        } else {
            System.out.println("No encontrado");
        }
        System.out.println("Impresion: in order");
        root.printInOrder();
        System.out.println("Impresion: pos order");
        root.printPosOrder();
        System.out.println("Impresion: pre order");
        root.printPreOrder();
    }
    
}
