/**
 * Reúne o tamanho e as referências das extremidades da lista.
 *
 * @param <E> tipo dos elementos armazenados
 */
public class Descriptor<E> {
    private int size = 0;
    private Node<E> inicio = null;
    private Node<E> fim = null;

    public Descriptor() {
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Node<E> getInicio() {
        return inicio;
    }

    public void setInicio(Node<E> inicio) {
        this.inicio = inicio;
    }

    public Node<E> getFim() {
        return fim;
    }

    public void setFim(Node<E> fim) {
        this.fim = fim;
    }
}
