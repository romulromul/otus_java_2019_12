import java.util.*;

public class DIYarrayList<T> implements List<T> {

    // начальный размер 4
    private final int init_size = 4;
    private int size;
    private Object[] myArray;
    private Object[] myEmptyArray = {};

    // конструктор для пустой коллекции
    public DIYarrayList() {
        this.myArray = new Object[init_size];
    }

    // конструктор для не-пустой коллекции
    public DIYarrayList(Collection<? extends T> c) {
        this.myArray = new Object[c.size()];
        this.size = c.size();
        System.arraycopy(c.toArray(), 0, this.myArray, 0, size);
    }

    // переопределение метода Add
    @Override
    public boolean add(T element) {
       if (size > myArray.length - 1){
            doubleArray();
        }

        myArray[size] = element;
        size++;
        return true;
    }

    // переопределение метода Add
    @Override
    public void add(int index, T element) {

        if (index > size)
            throw new IndexOutOfBoundsException((index));

        Object[] elementData;
        elementData = this.myArray;
        elementData = grow();
        System.arraycopy(elementData, index, elementData, index + 1, size - index);
        elementData[index] = element;
        size++;

//        modCount++;
//        final int s;
//        Object[] elementData;
//        if ((s = size) == (elementData = this.myArray).length)
//            elementData = grow();
//        System.arraycopy(elementData, index,
//                elementData, index + 1,
//                s - index);
//        elementData[index] = element;
//        size = s + 1;

    }

    private Object[] grow(int minCapacity) {
         Object[] newArray = new Object[myArray.length * 2];
         System.arraycopy(myArray, 0, newArray, 0, size);
         return (myArray = newArray);
    }

    private Object[] grow() {
        return grow(size + 1);
    }

    @Override
    public int size() {
        return this.size;
    }

    //метод увеличение myArray
    private void doubleArray(){
        Object[] newArray = new Object[myArray.length * 2];
        System.arraycopy(myArray, 0, newArray, 0, size);
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
            return  Arrays.copyOfRange(myArray,0,size);
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
        Objects.checkIndex(index, size);
        T oldValue = myArray(index);
        myArray[index] = element;
        return oldValue;
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
        return new DIYarrayList.DYIListListItr();
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

    private T myArray(int index) {
        return (T) myArray[index];
    }

    @SuppressWarnings("unchecked")
    static <T> T elementAt(Object[] es, int index) {
        throw new UnsupportedOperationException();
    }

    // Собственная реализация итератора
    private class DYIListItr implements Iterator<T> {
        int cursor;       // следующий элемент
        int lastRet = -1; // последний возвращенный элемент; -1 если такого нет

        // если не достиг конца списка - возвращай false
        public boolean hasNext() {
            if (cursor != size)
                return false;
            else
                return true;
        }

        // возвращаем следующий элемент списка (если он есть)
        public T next() {
            if (cursor >= size) // Если элемента нет, бросаем exception
                throw new NoSuchElementException();
            else
               return (T) DIYarrayList.this.myArray[lastRet = cursor + 1];
        }

        //удаление элемента
        public void remove() {
            throw new UnsupportedOperationException();
        }

    }


    public class DYIListListItr extends DYIListItr implements ListIterator<T> {

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

            int i = cursor - 1;
            if (i < 0)
                throw new NoSuchElementException();
            Object[] elementData = DIYarrayList.this.myArray;
            if (i >= elementData.length)
                throw new ConcurrentModificationException();
            cursor = i;
            return (T) elementData[lastRet = i];
        }

        public void set(T e) {
            if (lastRet < 0)
                throw new IllegalStateException();


            try {
                DIYarrayList.this.set(lastRet, e);
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }

        public void add(T e) {

            try {
                int i = cursor;
                DIYarrayList.this.add(i, e);
                cursor = i + 1;
                lastRet = -1;
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }

    }
}
