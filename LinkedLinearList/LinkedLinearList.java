import java.util.Objects;

/**
 * Representa uma lista linear duplamente encadeada com capacidade fixa.
 *
 * @param <T> tipo dos elementos armazenados na lista
 */
public class LinkedLinearList<T> {
    /** Primeiro no da lista. */
    private Node<T> head;
    /** Quantidade atual de elementos armazenados. */
    private int size;
    /** Quantidade máxima de elementos permitida. */
    private final int capacity;

    /**
     * Cria uma lista vazia com a capacidade informada.
     *
     * @param capacity quantidade máxima de elementos da lista
     * @throws IllegalArgumentException se a capacidade for negativa
     */
    public LinkedLinearList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity cannot be negative");
        }
        this.head = null;
        this.size = 0;
        this.capacity = capacity;
    }

    /**
     * Verifica se a lista não contém elementos.
     *
     * @return {@code true} se a lista estiver vazia; caso contrário,
     *         {@code false}
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Verifica se a lista atingiu sua capacidade máxima.
     *
     * @return {@code true} se a lista estiver cheia; caso contrário,
     *         {@code false}
     */
    public boolean isFull() {
        return size == capacity;
    }

    /**
     * Retorna a quantidade atual de elementos da lista.
     *
     * @return número de elementos armazenados
     */
    public int size() {
        return size;
    }

    /**
     * Adiciona um elemento ao final da lista.
     *
     * @param value elemento a ser adicionado
     * @return {@code true} se o elemento for adicionado; {@code false} se a
     *         lista estiver cheia
     */
    public boolean add(T value) {
        return insert(size, value);
    }

    /**
     * Retorna uma representação textual dos elementos da lista.
     *
     * @return representação dos elementos entre colchetes
     */
    @Override
    public String toString() {
        System.out.print("[");
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.getValue());
            current = current.getNext();
            if (current != null) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
        return "";
    }

    /**
     * Exibe a lista na saída padrão.
     */
    public void display() {
        System.out.println(toString());
    }

    /**
     * Retorna o elemento armazenado na posição informada.
     *
     * @param position índice do elemento, começando em zero
     * @return elemento armazenado na posição
     * @throws IndexOutOfBoundsException se a posição for inválida
     */
    public T get(int position) {
        return nodeAt(position).getValue();
    }

    /**
     * Procura um elemento na lista usando comparação baseada em conteúdo.
     *
     * @param value elemento procurado
     * @return índice da primeira ocorrência ou {@code -1} se não encontrado
     */
    public int search(T value) {
        Node<T> current = head;
        int position = 0;

        while (current != null) {
            if (Objects.equals(current.getValue(), value)) {
                return position;
            }
            current = current.getNext();
            position++;
        }

        return -1;
    }

    /**
     * Insere um elemento no início da lista.
     *
     * @param value elemento a ser inserido
     * @return {@code true} se o elemento for inserido; {@code false} se a
     *         lista estiver cheia
     */
    public boolean insertAtBeginning(T value) {
        return insert(0, value);
    }

    /**
     * Insere um elemento na posição informada.
     *
     * @param position índice no qual o elemento será inserido
     * @param value elemento a ser inserido
     * @return {@code true} se o elemento for inserido; {@code false} se a
     *         lista estiver cheia ou a posição for inválida
     */
    public boolean insert(int position, T value) {
        if (isFull() || position < 0 || position > size) {
            return false;
        }

        Node<T> newNode = new Node<>(position, value);
        if (position == 0) {
            newNode.setNext(head);
            if (head != null) {
                head.setPrev(newNode);
            }
            head = newNode;
        } else {
            Node<T> previous = nodeAt(position - 1);
            Node<T> next = previous.getNext();
            newNode.setPrev(previous);
            newNode.setNext(next);
            previous.setNext(newNode);
            if (next != null) {
                next.setPrev(newNode);
            }
        }

        size++;
        return true;
    }

    /**
     * Remove e retorna o primeiro elemento da lista.
     *
     * @return elemento removido
     * @throws OperationFailed se a lista estiver vazia
     */
    public T pop() throws OperationFailed {
        return remove(0);
    }

    /**
     * Remove e retorna o último elemento da lista.
     *
     * @return elemento removido
     * @throws OperationFailed se a lista estiver vazia
     */
    public T removeLast() throws OperationFailed {
        return remove(size - 1);
    }

    /**
     * Remove e retorna o elemento na posição informada.
     *
     * @param position índice do elemento a ser removido
     * @return elemento removido
     * @throws OperationFailed se a posição for inválida
     */
    public T remove(int position) throws OperationFailed {
        validatePosition(position);
        Node<T> node = nodeAt(position);
        Node<T> previous = node.getPrev();
        Node<T> next = node.getNext();

        if (previous == null) {
            head = next;
        } else {
            previous.setNext(next);
        }
        if (next != null) {
            next.setPrev(previous);
        }

        size--;
        return node.getValue();
    }

    /**
     * Valida uma posição existente na lista.
     *
     * @param position índice a ser validado
     * @throws OperationFailed se a posição não corresponder a um elemento
     */
    private void validatePosition(int position) throws OperationFailed {
        if (position < 0 || position >= size) {
            throw new OperationFailed();
        }
    }

    /**
     * Localiza o nó em uma posição específica.
     *
     * @param position índice do nó, começando em zero
     * @return nó localizado
     * @throws IndexOutOfBoundsException se a posição for inválida
     */
    private Node<T> nodeAt(int position) {
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException("Invalid position: " + position);
        }

        Node<T> current = head;
        for (int index = 0; index < position; index++) {
            current = current.getNext();
        }
        return current;
    }
}