/**
 * Implementa uma pilha (LIFO - Last In, First Out)
 * como especialização de LinkedLinearList.
 *
 * @param <T> tipo dos elementos armazenados
 */
public class Stack<T> extends LinkedLinearList<T> {

    /**
     * Cria uma pilha com capacidade fixa.
     *
     * @param capacity capacidade máxima da pilha
     */
    public Stack(int capacity) {
        super(capacity);
    }

    /**
     * Insere um elemento no topo da pilha.
     *
     * @param value elemento a ser inserido
     * @return true se inserido; false se a pilha estiver cheia
     */
    public boolean push(T value) {
        return add(value);
    }

    /**
     * Remove e retorna o elemento do topo.
     *
     * @return elemento removido
     * @throws OperationFailed se a pilha estiver vazia
     */
    @Override
    public T pop() throws OperationFailed {
        return removeLast();
    }

    @Override
    public void display() {
        super.display();
    }

    /**
     * Consulta o elemento do topo sem removê-lo.
     *
     * @return elemento localizado no topo
     * @throws OperationFailed se a pilha estiver vazia
     */
    public T peek() throws OperationFailed {
        if (isEmpty()) {
            throw new OperationFailed();
        }

        return get(size() - 1);
    }
}