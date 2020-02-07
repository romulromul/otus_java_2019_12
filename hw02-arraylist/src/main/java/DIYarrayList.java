import java.util.*;

public class DIYarrayList<T> implements List<T> {

    private final int init_size = 4;
    private int size;
    private Object[] myArray;

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
        throw new UnsupportedOperationException();
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

}
