package task3.custom;

import task3.model.Student;

import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface List<E> extends Iterable<E>{
    boolean isEmpty();

    int size();

    boolean add(E element);

    boolean add(int index, E element);

    void remove(E element);

    E get(int index);

    int indexOf(E element);

    void set(int index, E element);

    boolean contains(E element);

    void clear();

    E[] toArray();

    Stream<E> stream();
}
