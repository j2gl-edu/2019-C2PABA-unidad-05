package edu.advanced.unit5.circular;


import edu.advanced.unit5.model.Node;

public class CircularLinkedList {

    private Node head;
    private Node tail;
    private int size;

    /**
     * Constructor por defecto.
     */
    public CircularLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Consulta si la lista esta vacia.
     *
     * @return true si el primer nodo (head), no apunta a otro nodo.
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Consulta cuantos elementos (nodos) tiene la lista.
     *
     * @return numero entero entre [0,n] donde n es el numero de elementos
     * que contenga la lista.
     */
    public int getSize() {
        return size;
    }

    /**
     * Agrega un nuevo nodo al final de la lista linked.
     *
     * @param valor a agregar.
     */
    public void addLast(int valor) {
        // Define un nuevo nodo.
        Node aux = new Node();
        // Agrega al valor al nodo.
        aux.setValue(valor);
        // Consulta si la lista esta vacia.
        if (isEmpty()) {
            // Inicializa la lista agregando como head al nuevo nodo.
            head = aux;
            // De igual forma el tail nodo sera el nuevo.
            tail = aux;
            // Y el puntero del tail debe apuntar al primero.
            tail.setNext(head);
            // Caso contrario el nodo se agrega al final de la lista.
        } else {
            // Apuntamos con el tail nodo de la lista al nuevo.
            tail.setNext(aux);
            // Apuntamos con el nuevo nodo al head de la lista.
            aux.setNext(head);
            // Como ahora como el nuevo nodo es el tail se actualiza
            // la variable tail.
            tail = aux;
        }
        // Incrementa el contador de tamaño de la lista
        size++;
    }

    /**
     * Agrega un nuevo nodo al head de la lista linked.
     *
     * @param valor a agregar.
     */
    public void addFirst(int valor) {
        // Define un nuevo nodo.
        Node nuevo = new Node();
        // Agrega al valor al nodo.
        nuevo.setValue(valor);
        // Consulta si la lista esta vacia.
        if (isEmpty()) {
            // Inicializa la lista agregando como head al nuevo nodo.
            head = nuevo;
            // De igual forma el tail nodo sera el nuevo.
            tail = nuevo;
            // Y el puntero del tail debe apuntar al primero.
            tail.setNext(head);
            // Caso contrario va agregando los nodos al head de la lista.
        } else {
            // Une el nuevo nodo con la lista existente.
            nuevo.setNext(head);
            // Renombra al nuevo nodo como el head de la lista.
            head = nuevo;
            // El puntero del tail debe apuntar al primero.
            tail.setNext(head);
        }
        // Incrementa el contador de tamaño de la lista.
        size++;
    }

    /**
     * Inserta un nuevo nodo despues de otro, ubicado por el valor que contiene.
     *
     * @param element valor del nodo anterior al nuevo nodo a insertar.
     * @param value      del nodo a insertar.
     */
    public void addAfterReference(int element, int value) {
        // Define un nuevo nodo.
        Node newNode = new Node();
        // Agrega al valor al nodo.
        newNode.setValue(value);
        // Verifica si la lista contiene elementos
        if (!isEmpty()) {
            // Consulta si el valor existe en la lista.
            if (contains(element)) {
                // Crea ua copia de la lista.
                Node aux = head;
                // Recorre la lista hasta llegar al nodo de referencia.
                while (aux.getValue() != element) {
                    aux = aux.getNext();
                }
                // Consulta si el nodo a insertar va despues del tail
                if (aux == tail) {
                    // Apuntamos con el tail nodo de la lista al nuevo.
                    aux.setNext(newNode);
                    // Apuntamos con el nuevo nodo al head de la lista.
                    newNode.setNext(head);
                    // Como ahora como el nuevo nodo es el tail se actualiza
                    // la variable tail.
                    tail = newNode;
                } else {
                    // Crea un respaldo de la continuación de la lista.
                    Node siguiente = aux.getNext();
                    // Enlaza el nuevo nodo despues del nodo de referencia.
                    aux.setNext(newNode);
                    // Une la continuacion de la lista al nuevo nodo.
                    newNode.setNext(siguiente);
                }
                // Incrementa el contador de tamaño de la lista.
                size++;
            }
        }
    }

    /**
     * Inserta un nuevo nodo despues en una posición determinada.
     *
     * @param index en la cual se va a insertar el nuevo nodo.
     * @param value valor del nuevo nodo de la lista.
     */
    public void add(int index, int value) {
        // Verifica si la posición ingresada se encuentre en el rango
        // >= 0 y <= que el numero de elementos del la lista.
        if (index >= 0 && index <= size) {
            Node newNode = new Node();
            newNode.setValue(value);
            // Consulta si el nuevo nodo a ingresar va al head de la lista.
            if (index == 0) {
                // Une el nuevo nodo con la lista existente.
                newNode.setNext(head);
                // Renombra al nuevo nodo como el head de la lista.
                head = newNode;
                // El puntero del tail debe apuntar al primero.
                tail.setNext(head);
            } else {
                // Si el nodo a inserta va al final de la lista.
                if (index == size) {
                    // Apuntamos con el tail nodo de la lista al nuevo.
                    tail.setNext(newNode);
                    // Apuntamos con el nuevo nodo al head de la lista.
                    newNode.setNext(head);
                    // Como ahora como el nuevo nodo es el tail se actualiza
                    // la variable tail.
                    tail = newNode;
                } else {
                    // Si el nodo a insertar va en el medio de la lista.
                    Node aux = head;
                    // Recorre la lista hasta llegar al nodo anterior
                    // a la posicion en la cual se insertara el nuevo nodo.
                    for (int i = 0; i < (index - 1); i++) {
                        aux = aux.getNext();
                    }
                    // Guarda el nodo siguiente al nodo en la posición
                    // en la cual va a insertar el nevo nodo.
                    Node siguiente = aux.getNext();
                    // Inserta el nuevo nodo en la posición indicada.
                    aux.setNext(aux);
                    // Une el nuevo nodo con el resto de la lista.
                    aux.setNext(siguiente);
                }
            }
            // Incrementa el contador de tamaño de la lista.
            size++;
        }
    }

    /**
     * Obtiene el valor de un nodo en una determinada posición.
     *
     * @param index del nodo que se desea obtener su valor.
     * @return un numero entero entre [0,n-1] n = numero de nodos de la lista.
     * @throws IndexOutOfBoundsException si index es invalido
     */
    public int get(int index) throws IndexOutOfBoundsException {
        // Verifica si la posición ingresada se encuentre en el rango
        // >= 0 y < que el numero de elementos del la lista.
        if (index >= 0 && index < size) {
            // Consulta si la posicion es el head de la lista.
            if (index == 0) {
                // Retorna el valor del head de la lista.
                return head.getValue();
            } else {
                // Crea una copia de la lista.
                Node aux = head;
                // Recorre la lista hasta la posición ingresada.
                for (int i = 0; i < index; i++) {
                    aux = aux.getNext();
                }
                // Retorna el valor del nodo.
                return aux.getValue();
            }
            // Crea una excepción de Posicion inexistente en la lista.
        } else {
            throw new IndexOutOfBoundsException("Posicion inexistente en la lista.");
        }
    }

    /**
     * Busca si existe un valor en la lista.
     *
     * @param element valor a contains.
     * @return true si existe el valor en la lista.
     */
    public boolean contains(int element) {
        // Crea una copia de la lista.
        Node aux = head;
        // Bandera para indicar si el valor existe.
        boolean found = false;
        // Recorre la lista hasta encontrar el elemento o hasta
        // llegar al primer nodo nuevamente.
        do {
            // Consulta si el valor del nodo es igual al de referencia.
            if (element == aux.getValue()) {
                // Canbia el valor de la bandera.
                found = true;
            } else {
                // Avansa al siguiente. nodo.
                aux = aux.getNext();
            }
        } while (aux != head && !found);
        // Retorna el resultado de la bandera.
        return found;
    }

    /**
     * Consulta la posición de un elemento en la lista
     *
     * @param element valor del nodo el cual se desea saber la posición.
     * @return un valor entero entre [0,n] que indica la posición del nodo o -1 si el elemento no está contenido.
     */
    public int indexOf(int element) {
        // Consulta si el valor existe en la lista.
        if (contains(element)) {
            // Crea una copia de la lista.
            Node aux = head;
            // COntado para almacenar la posición del nodo.
            int cont = 0;
            // Recoore la lista hasta llegar al nodo de referencia.
            while (element != aux.getValue()) {
                // Incrementa el contador.
                cont++;
                // Avansa al siguiente. nodo.
                aux = aux.getNext();
            }
            // Retorna el valor del contador.
            return cont;
            // Crea una excepción de Valor inexistente en la lista.
        }
        return -1;
    }

    /**
     * Actualiza el valor de un nodo que se encuentre en la lista ubicado
     * por un valor de referencia.
     *
     * @param element valor del nodo el cual se desea actualizar.
     * @param value      nuevo valor para el nodo.
     */
    public void modifyByValue(int element, int value) {
        // Consulta si el valor existe en la lista.
        if (contains(element)) {
            // Crea ua copia de la lista.
            Node aux = head;
            // Recorre la lista hasta llegar al nodo de referencia.
            while (aux.getValue() != element) {
                aux = aux.getNext();
            }
            // Actualizamos el valor del nodo
            aux.setValue(value);
        }
    }

    /**
     * Actualiza el valor de un nodo que se encuentre en la lista ubicado
     * por su posición.
     *
     * @param index en la cual se encuentra el nodo a actualizar.
     * @param value    nuevo valor para el nodo.
     */
    public void modify(int index, int value) {
        // Verifica si la posición ingresada se encuentre en el rango
        // >= 0 y < que el numero de elementos del la lista.
        if (index >= 0 && index < size) {
            // Consulta si el nodo a clear es el primero.
            if (index == 0) {
                // Alctualiza el valor delprimer nodo.
                head.setValue(value);
            } else {
                // En caso que el nodo a clear este por el medio
                // o sea el tail
                Node aux = head;
                // Recorre la lista hasta lleger al nodo anterior al clear.
                for (int i = 0; i < index; i++) {
                    aux = aux.getNext();
                }
                // Alctualiza el valor del nodo.
                aux.setValue(value);
            }
        }
    }

    /**
     * Elimina un nodo que se encuentre en la lista ubicado
     * por un valor de referencia.
     *
     * @param element valor del nodo que se desea clear.
     */
    public void removeByElement(int element) {
        // Consulta si el valor de referencia existe en la lista.
        if (contains(element)) {
            // Consulta si el nodo a clear es el pirmero
            if (head.getValue() == element) {
                if (head == tail) {
                    head = null;
                    tail = null;
                } else {
                    head = head.getNext();
                    tail.setNext(head);
                }
            } else {
                // Crea ua copia de la lista.
                Node aux = head;
                // Recorre la lista hasta llegar al nodo anterior
                // al de referencia.
                while (aux.getNext().getValue() != element) {
                    aux = aux.getNext();
                }
                if (aux.getNext() == tail) {
                    aux.setNext(head);
                    tail = aux;
                } else {
                    // Guarda el nodo siguiente del nodo a clear.
                    Node siguiente = aux.getNext();
                    // Enlaza el nodo anterior al de clear con el
                    // sguiente despues de el.
                    aux.setNext(siguiente.getNext());
                    // Actualizamos el puntero del tail nodo
                }
            }
            // Disminuye el contador de tamaño de la lista.
            size--;
        }
    }

    /**
     * Elimina un nodo que se encuentre en la lista ubicado
     * por su posición.
     *
     * @param index en la cual se encuentra el nodo a clear.
     */
    public void remove(int index) {
        if (index >= 0 && index < size) {
            if (index == 0) {
                if (head == tail) {
                    head = null;
                    tail = null;
                } else {
                    head = head.getNext();
                    tail.setNext(head);
                }
            } else {
                Node aux = head;
                for (int i = 0; i < index - 1; i++) {
                    aux = aux.getNext();
                }
                if (aux.getNext() == tail) {
                    aux.setNext(head);
                    tail = aux;
                } else {
                    Node siguiente = aux.getNext();
                    aux.setNext(siguiente.getNext());
                }
            }
            size--;
        }
    }

    /**
     * Elimina la lista
     */
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public String convertToString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (!isEmpty()) {
            Node aux = head;
            int i = 0;

            do {
                stringBuilder.append("[")
                        .append(i)
                        .append("] ")
                        .append("-> ")
                        .append(aux.getValue())
                        .append(" ");
                aux = aux.getNext();
                i++;
            } while (aux != head);
        }
        return stringBuilder.toString();
    }

    public void display() {
        String s = convertToString();
        if (s == null || s.isEmpty()) {
            s = "[ ] -> List is empty.";
        }
        System.out.print(s);
    }
}
