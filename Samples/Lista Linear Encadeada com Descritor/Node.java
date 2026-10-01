/**
 * Representa um nó de uma lista duplamente encadeada.
 *
 * @param <T> tipo do valor armazenado no nó
 */
public class Node<T> {
    /** Identificador do nó. */
    private int id;
    /** Valor armazenado no nó. */
    private T value;
    /** Referência para o próximo nó da lista. */
    private Node<T> next;
    /** Referência para o nó anterior da lista. */
    private Node<T> prev;

    /**
     * Cria um nó com identificador e valor informados.
     *
     * @param id identificador do nó
     * @param value valor armazenado no nó
     */
    public Node(int id, T value) {
        this.id = id;
        this.value = value;
        this.next = null;
        this.prev = null;
    }

    /**
     * Retorna o identificador do nó.
     *
     * @return identificador do nó
     */
    public int getId() {
        return id;
    }

    /**
     * Retorna o valor armazenado no nó.
     *
     * @return valor do nó
     */
    public T getValue() {
        return value;
    }

    /**
     * Retorna o próximo nó da lista.
     *
     * @return próximo nó, ou {@code null} se não houver
     */
    public Node<T> getNext() {
        return next;
    }

    /**
     * Define o próximo nó da lista.
     *
     * @param next próximo nó
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }

    /**
     * Retorna o nó anterior da lista.
     *
     * @return nó anterior, ou {@code null} se não houver
     */
    public Node<T> getPrev() {
        return prev;
    }

    /**
     * Define o nó anterior da lista.
     *
     * @param prev nó anterior
     */
    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }
}