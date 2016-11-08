import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Альберт on 04.11.2016.
 */
public class MyArrayList <E> implements List <E>{

       private int size;
       private int sizeX;
       Object [] arr;
       MyArrayList(){
           size = 0;
           sizeX = 15;
           arr = new Object [sizeX];
       }

    @Override
    public  synchronized  int size() {
       // System.out.println("Ух ты выполнился мой метод");
        return size;
    }

    @Override
    public  synchronized boolean isEmpty() {
        if (size == 0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public  synchronized boolean add(Object o) {
        size = size+1;

        if ((int)(size*1.5) > sizeX){
            Object [] arrClone = new Object [sizeX];

      //      System.out.println("Сайз умножить на полтора равен " + (int)(size*1.5));
            for (int i = 0; i < size-1 ; i++) {
                arrClone[i]=arr[i];
            }
            arr = new Object [(int) (sizeX * 1.5)];
            for (int i = 0; i < size-1; i++) {
                arr[i]= arrClone[i];
            }
           // arrClone = null;
            sizeX = (int) (sizeX * 1.5);
        }
 //       System.out.println("Добавляем новое значение в ячейку = " + (size-1));
        arr[size-1] = o;
        return true;
    }

    @Override
    public boolean remove(Object o) {


        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public  synchronized  E get(int index) {

        if (index>size-1) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return (E) arr[index];
    }

    @Override
    public  synchronized Object set(int index, Object element) {
        arr[index]=element;
        return null;
    }

    @Override
    public  synchronized void add(int index, Object element) {
        if (index>size-1) {
            throw new ArrayIndexOutOfBoundsException();
        }


        if ((int)(size*1.5) > sizeX){
            Object [] arrClone = new Object [sizeX];

            //      System.out.println("Сайз умножить на полтора равен " + (int)(size*1.5));
            for (int i = 0; i < size-1 ; i++) {
                arrClone[i]=arr[i];
            }
            arr = new Object [(int) (sizeX * 1.5)];
            for (int i = 0; i < size-1; i++) {
                arr[i]= arrClone[i];
            }
            // arrClone = null;
            sizeX = (int) (sizeX * 1.5);
        }


        for (int i = size; i > index; i--) {
            arr[i]=arr[i-1];
        }
        arr[index]=element;
        size = size+1;
    }

    @Override
    public  synchronized  E remove(int index) {
        if (index>size-1) {
            throw new ArrayIndexOutOfBoundsException();
        }
        for (int i = index; i < size-1; i++) {
            arr[i]=arr[i+1];
        }
        arr[size-1]=null;
        size = size-1;
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}
