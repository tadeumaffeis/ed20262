/**
 * Implementa uma fila (FIFO - First In, First Out)
 * como especialização de LinkedLinearList.
 *
 * @param <T> tipo dos elementos armazenados
 */
public class Queue<T> extends LinkedLinearList<T> {

    /**
     * Cria uma fila com capacidade fixa.
     *
     * @param capacity capacidade máxima da fila
     */
    public Queue(int capacity) {
        super(capacity);
    }

    /**
     * Insere um elemento no final da fila.
     *
     * @param value elemento a ser inserido
     * @return true se inserido; false se a fila estiver cheia
     */
    public boolean enqueue(T value) {
        return add(value);
    }

    /**
     * Remove e retorna o primeiro elemento da fila.
     *
     * @return elemento removido
     * @throws OperationFailed se a fila estiver vazia
     */
    public T dequeue() throws OperationFailed {
        return pop();
    }

    /**
     * Consulta o primeiro elemento da fila sem removê-lo.
     *
     * @return primeiro elemento da fila
     * @throws OperationFailed se a fila estiver vazia
     */
    public T peek() throws OperationFailed {
        if (isEmpty()) {
            throw new OperationFailed();
        }

        return get(0);
    }
}