package list;

public interface MyList<E> extends Iterable<E> {
    void add(E e);

    void add(int index, E e);

    void clear();

    boolean contains(E e);

    E get(int index);

    int indexOf(E e);

    int indexOf(E e, int from);

    int lastIndexOf(E e);

    boolean isEmpty();

    boolean remove(E e);

    E remove(int index);

    Object set(int index, E e);

    int size();

    void reverseList();

    boolean incrementList();

    void removeAllOdd();

    void sort();

    void insertIncrement(E e);

    void findMiddleList();

}
