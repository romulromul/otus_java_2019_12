import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Consumer;

public class DIYarrayList<T> implements List<T> {

    private final int init_size = 20;
    private int size;
    transient Object[] myArray;

    public DIYarrayList() {
        this.myArray = new Object[init_size];
    }

    //копирование конструктора из ArrayList
//    public DIYarrayList(Collection<? extends T> c) {
//        myArray = c.toArray();
//        if ((size = myArray.length) != 0) {
//            if (myArray.getClass() != Object[].class)
//                myArray = Arrays.copyOf(myArray, size, Object[].class);
//        } else {
//            this.myArray = new Object[init_size];
//        }
//    }


    //method Add
    @Override
    public boolean add(T element) {
        if (size > myArray.length - 1){
            doubleArray();
        }

        myArray[size] = element;
        size++;
        return true;
    }

    @Override
    public void add(int index, T element) {

        if (size > myArray.length - 1) {
            doubleArray();
        }
// сделать смещение
        myArray[index] = element;
        size++;
    }

    @Override
    public int size() {
        return this.size;
    }

    //метод увеличение myArray
    private void doubleArray(){
        Object[] newArray = new Object[myArray.length * 2];
        newArray = Arrays.copyOf(myArray, newArray.length);
        myArray = newArray;
    }

    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < size; i++) {
            if (i != 0){
                sb.append(",");
            }
            sb.append(myArray[i].toString());
        }
        sb.append(']');

        return sb.toString();
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object[] toArray() {
            return  Arrays.copyOfRange(myArray,0,size-1);
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public T get(int index) {
        return (T) myArray[index];
    }

    @Override
    public T set(int index, T element) {
        throw new UnsupportedOperationException();
    }


    @Override
    public T remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<T> listIterator() {
        return new DIYarrayList.ListItr(0);
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    public void addAll() {
        throw new UnsupportedOperationException();
    }

    /**
     * Copy-paste from ArrayList
     */

    // Positional Access Operations

    @SuppressWarnings("unchecked")
    T myArray(int index) {
        return (T) myArray[index];
    }

    @SuppressWarnings("unchecked")
    static <T> T elementAt(Object[] es, int index) {
        return (T) es[index];
    }


    protected transient int modCount = 0;

    /**
     * An optimized version of AbstractList.Itr
     */
    private class Itr implements Iterator<T> {
        int cursor;       // index of next element to return
        int lastRet = -1; // index of last element returned; -1 if no such
        int expectedModCount = modCount;

        // prevent creating a synthetic constructor
        Itr() {}

        public boolean hasNext() {
            return cursor != size;
        }

        @SuppressWarnings("unchecked")
        public T next() {
            checkForComodification();
            int i = cursor;
            if (i >= size)
                throw new NoSuchElementException();
            Object[] myArray = DIYarrayList.this.myArray;
            if (i >= myArray.length)
                throw new ConcurrentModificationException();
            cursor = i + 1;
            return (T) myArray[lastRet = i];
        }

        public void remove() {
            if (lastRet < 0)
                throw new IllegalStateException();
            checkForComodification();

            try {
                DIYarrayList.this.remove(lastRet);
                cursor = lastRet;
                lastRet = -1;
                expectedModCount = modCount;
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }

        @Override
        public void forEachRemaining(Consumer<? super T> action) {
            Objects.requireNonNull(action);
            final int size = DIYarrayList.this.size;
            int i = cursor;
            if (i < size) {
                final Object[] es = myArray;
                if (i >= es.length)
                    throw new ConcurrentModificationException();
                for (; i < size && modCount == expectedModCount; i++)
                    action.accept(elementAt(es, i));
                // update once at end to reduce heap write traffic
                cursor = i;
                lastRet = i - 1;
                checkForComodification();
            }
        }

        final void checkForComodification() {
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();
        }
    }

    /**
     * An optimized version of AbstractList.ListItr
     */
    public class ListItr extends Itr implements ListIterator<T> {
        ListItr(int index) {
            super();
            cursor = index;
        }

        public boolean hasPrevious() {
            return cursor != 0;
        }

        public int nextIndex() {
            return cursor;
        }

        public int previousIndex() {
            return cursor - 1;
        }

        @SuppressWarnings("unchecked")
        public T previous() {
            checkForComodification();
            int i = cursor - 1;
            if (i < 0)
                throw new NoSuchElementException();
            Object[] myArray = DIYarrayList.this.myArray;
            if (i >= myArray.length)
                throw new ConcurrentModificationException();
            cursor = i;
            return (T) myArray[lastRet = i];
        }

        public void set(T e) {
            if (lastRet < 0)
                throw new IllegalStateException();
            checkForComodification();

            try {
                DIYarrayList.this.set(lastRet, e);
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }

        public void add(T e) {
            checkForComodification();

            try {
                int i = cursor;
                DIYarrayList.this.add(i, e);
                cursor = i + 1;
                lastRet = -1;
                expectedModCount = modCount;
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }

        /**
         * next
         */
        @SuppressWarnings("unchecked")
        public T next() {
            return (T) myArray[cursor];
        }


    }


}
