package java_core.list;

public abstract class MyAbstractList<E> implements MyList<E>{
    protected int size = 0;

    protected MyAbstractList() {
    }

    protected MyAbstractList(int size) {
        this.size = size;
    }

    @Override
    public int indexOf(E e) {
        return indexOf(e,0);
    }

    @Override
    public void add(E e) {
        add(size, e);
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean remove(E e) {
        if(indexOf(e) != -1){
            remove(indexOf(e));
            return true;
        }
        return false;
    }
}
