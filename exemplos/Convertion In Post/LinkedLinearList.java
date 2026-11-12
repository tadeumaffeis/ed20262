import java.util.Objects;

/**
 * Representa uma lista linear duplamente encadeada com descritor e capacidade fixa.
 *
 * @param <T> tipo dos elementos armazenados na lista
 */
public class LinkedLinearList<T> {

    private final Descriptor<T> descritor = new Descriptor<>();

    /**
     * Quantidade máxima de elementos permitida.
     */
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
        this.capacity = capacity;
    }

    /**
     * Verifica se a lista não contém elementos.
     *
     * @return {@code true} se a lista estiver vazia; caso contrário,
     * {@code false}
     */
    public boolean isEmpty() {
        return descritor.getSize() == 0;
    }

    /**
     * Verifica se a lista atingiu sua capacidade máxima.
     *
     * @return {@code true} se a lista estiver cheia; caso contrário,
     * {@code false}
     */
    public boolean isFull() {
        return descritor.getSize() == capacity;
    }

    /**
     * Retorna a quantidade atual de elementos da lista.
     *
     * @return número de elementos armazenados
     */
    public int size() {
        return descritor.getSize();
    }

    /**
     * Adiciona um elemento ao final da lista.
     *
     * @param value elemento a ser adicionado
     * @return {@code true} se o elemento for adicionado; {@code false} se a
     * lista estiver cheia
     */
    public boolean add(T value) {
        return insert(descritor.getSize(), value);
    }

    /**
     * Retorna uma representação textual dos elementos da lista.
     *
     * @return representação dos elementos entre colchetes
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node<T> current = descritor.getInicio();
        while (current != null) {
            result.append(current.getValue());
            current = current.getNext();
            if (current != null) {
                result.append(", ");
            }
        }
        return result.append("]").toString();
    }

    /**
     * Exibe a lista na saída padrão.
     */
    public void display() {
        System.out.printf(toString()+"\n\r");
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
        Node<T> current = descritor.getInicio();
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
     * @return {@code true} se o elemento for inserido; {@code false} se a lista
     * estiver cheia
     */
    public boolean insertAtBeginning(T value) {
        return insert(0, value);
    }

    /**
     * Insere um elemento na posição informada.
     *
     * @param position índice no qual o elemento será inserido
     * @param value elemento a ser inserido
     * @return {@code true} se o elemento for inserido; {@code false} se a lista
     * estiver cheia ou a posição for inválida
     */
    public boolean insert(int position, T value) {
        if (isFull() || position < 0 || position > descritor.getSize()) {
            return false;
        }

        Node<T> newNode = new Node<>(position, value);
        if (position == 0) {
            newNode.setNext(descritor.getInicio());
            if (descritor.getInicio() != null) {
                descritor.getInicio().setPrev(newNode);
            }
            descritor.setInicio(newNode);
            if (descritor.getSize() == 0) {
                descritor.setFim(newNode);
            }
        } else if (position == descritor.getSize()) {
            // O descritor permite inserir no final sem percorrer a lista.
            newNode.setPrev(descritor.getFim());
            descritor.getFim().setNext(newNode);
            descritor.setFim(newNode);
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

        descritor.setSize(descritor.getSize() + 1);
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
        return remove(descritor.getSize() - 1);
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
            descritor.setInicio(next);
        } else {
            previous.setNext(next);
        }
        if (next == null) {
            descritor.setFim(previous);
        } else {
            next.setPrev(previous);
        }

        node.setPrev(null);
        node.setNext(null);

        descritor.setSize(descritor.getSize() - 1);
        return node.getValue();
    }

    /**
     * Valida uma posição existente na lista.
     *
     * @param position índice a ser validado
     * @throws OperationFailed se a posição não corresponder a um elemento
     */
    private void validatePosition(int position) throws OperationFailed {
        if (position < 0 || position >= descritor.getSize()) {
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
        if (position < 0 || position >= descritor.getSize()) {
            throw new IndexOutOfBoundsException("Invalid position: " + position);
        }

        Node<T> current;
        // Percorre a partir da extremidade mais próxima da posição.
        if (position < descritor.getSize() / 2) {
            current = descritor.getInicio();
            for (int index = 0; index < position; index++) {
                current = current.getNext();
            }
        } else {
            current = descritor.getFim();
            for (int index = descritor.getSize() - 1; index > position; index--) {
                current = current.getPrev();
            }
        }
        return current;
    }

    /**
     * Calcula o somatório dos elementos numéricos da lista.
     *
     * @return soma dos elementos
     * @throws IllegalStateException se algum elemento não for numérico
     */
    public float sum() {
        float sum = 0.0f;
        Node<T> current = descritor.getInicio();

        while (current != null) {
            if (!(current.getValue() instanceof Number)) {
                throw new IllegalStateException(
                        "The list contains a non-numeric element"
                );
            }

            sum += ((Number) current.getValue()).floatValue();
            current = current.getNext();
        }

        return sum;
    }

    /**
     * Calcula o produtório dos elementos numéricos da lista.
     *
     * @return produto dos elementos
     * @throws IllegalStateException se algum elemento não for numérico
     */
    public float product() {
        float product = 1.0f;
        Node<T> current = descritor.getInicio();

        while (current != null) {
            if (!(current.getValue() instanceof Number)) {
                throw new IllegalStateException(
                        "The list contains a non-numeric element"
                );
            }

            product *= ((Number) current.getValue()).floatValue();
            current = current.getNext();
        }

        return product;
    }

    /**
     * Calcula a média aritmética simples dos elementos numéricos da lista.
     *
     * @return média aritmética dos elementos
     * @throws IllegalStateException se a lista estiver vazia ou contiver
     * elemento não numérico
     */
    public float average() {
        if (isEmpty()) {
            throw new IllegalStateException(
                    "Cannot calculate the average of an empty list"
            );
        }

        return sum() / descritor.getSize();
    }
}
