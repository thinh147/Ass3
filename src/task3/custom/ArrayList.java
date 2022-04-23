package task3.custom;

import task3.model.Student;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class ArrayList<E> implements List<E> {

    private E[] elements;
    private int size;

    public ArrayList() {
        this(10);
    }

    public ArrayList(int initSize) {
        if (initSize < 0) {
            throw new IllegalArgumentException("illegal size:" + initSize);
        }
        this.elements = (E[]) new Object[initSize];
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    private void ensureCapacity(int needCapacity) {
        if (needCapacity > elements.length) {
            Object[] oldElements = this.elements;
            int newSize = this.size * 2 + 1;
            this.elements = (E[]) new Object[newSize];
            this.elements = (E[]) Arrays.copyOf(oldElements, newSize);
        }
    }

    @Override
    public boolean add(E element) {
        ensureCapacity(this.size + 1);
        elements[this.size++] = element;
        return true;
    }

    private void checkRange(int index) {
        if (index < 0 || index >= (this.size + 1)) {
            throw new IllegalArgumentException("illegal index:" + index);
        }
    }

    @Override
    public boolean add(int index, E element) {
        checkRange(index);
        ensureCapacity(this.size + 1);
        System.arraycopy(this.elements, index, elements, index + 1, size - index);
        elements[index] = element;
        this.size++;
        return true;
    }

    @Override
    public void remove(E element) {
        if (element == null) {
            for (int i = 0; i < this.size; i++) {
                if (this.elements[i] == null) {
                    fastRemove(i);
                    return;
                }
            }
        } else {
            for (int i = 0; i < this.size; i++) {
                if (element.equals(this.elements[i])) {
                    fastRemove(i);
                    return;
                }
            }
        }
    }

    private void fastRemove(int index) {
        int movedNumber = this.size - index - 1;
        if (movedNumber > 0) {
            System.arraycopy(this.elements, index + 1, this.elements, index, movedNumber);
        }
        this.elements[--this.size] = null;
    }

    @Override
    public E get(int index) {
        E e = this.elements[index];
        return e;
    }

    @Override
    public int indexOf(E element) {

        if (element == null) {
            for (int i = 0; i < this.elements.length; i++) {
                if (this.elements[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < this.elements.length; i++) {
                if (element.equals(this.elements[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public void set(int index, E element) {
        checkRange(index);
        ensureCapacity(this.size + 1);
        this.elements[index] = element;
    }

    @Override
    public boolean contains(E element) {
        if (element == null) {
            for (E e : this.elements) {
                if (e == null) {
                    return true;
                }
            }
        } else {
            for (E e : this.elements) {
                if (element.equals(e)) {
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public void clear() {
        for (int i = 0; i < this.size; i++) {
            this.elements[i] = null;
        }
        this.size = 0;
    }

    @Override
    public E[] toArray() {
        return this.elements;
    }

    @Override
    public Iterator<E> iterator() {
        return new CustomIterator<>();
    }

    @Override
    public String toString() {
        return "ArrayList{" +
                "elements=" + Arrays.toString(elements) +
                ", size=" + size +
                '}';
    }

    private class CustomIterator<E> implements Iterator<E> {

        private int current = 0;

        @Override
        public boolean hasNext() {
            return this.current < size();
        }

        @Override
        public E next() {
            E value = (E) elements[current++];
            return value;
        }
    }

    @Override
    public void forEach(Consumer<? super E> action) {
        List.super.forEach(action);
    }

    @Override
    public Spliterator<E> spliterator() {
        return List.super.spliterator();
    }

    @Override
    public Stream<E> stream(){
        return Stream.<E>builder().build();
    }
}

