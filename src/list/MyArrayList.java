package list;

import java.util.Iterator;

public class MyArrayList<E> extends MyAbstractList<E> {
    public static final int INITIAL_CAPACITY = 16;
    public static final byte NUMBER_BEGIN = 0;
    private E[] data = (E[]) new Object[INITIAL_CAPACITY];

    private void ensureCapacity(){
        if(size >= data.length){
            E[] newData = (E[]) new Object[size * 2 + 1];
            System.arraycopy(data,0,newData,0,data.length);
            data = newData;
        }
    }

    @Override
    public void add(int index, E e) {
        ensureCapacity();
        for(int i = size; i >= index; i--){
            data[i] = data[i - 1];
        }
        data[index] = e;
        size++;
    }

    @Override
    public void clear() {
        data = (E[]) new Object[INITIAL_CAPACITY];
        size = NUMBER_BEGIN;
    }

    @Override
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if(data[i].equals(e)){
                return true;
            }
        }
        return false;
    }

    private void checkIndex(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
        }
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return data[index];
    }

    @Override
    public int indexOf(E e, int from) {
        for(int i = from ; i < size; i++){
            if (data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(E e) {
        for (int i = size - 1; i >= NUMBER_BEGIN ; i++) {
            if(data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        E objReturn = get(index);
        for (int i = index; i < size; i++) {
            data[i] = data[i + 1];
        }
        data[size - 1] = null;
        size--;
        return objReturn;
    }

    @Override
    public Object set(int index, E e) {
        checkIndex(index);
        E old = data[index];
        data[index] = e;
        return old;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void reverseList() {

    }

    @Override
    public boolean incrementList() {
        return false;
    }

    @Override
    public void removeAllOdd() {

    }

    @Override
    public void sort() {

    }

    @Override
    public void insertIncrement() {

    }

    @Override
    public void findMiddleList() {

    }

    public void trimToSize(){
        if(size != data.length){
            E[] newDate = (E[]) new Object[size];
            System.arraycopy(data,0,newDate,0,size);
            data = newDate;
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder().append("[ ");
        for (int i = 0; i < size; i++) {
            result.append(data[i]);
            if(i < size - 1){
                result.append(", ");
            }
        }
        result.append("]");
        return result.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator{
        private int current = 0;

        @Override
        public boolean hasNext() {
            return current < size;
        }

        @Override
        public Object next() {
            return data[current++];
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(current);
        }
    }
}
