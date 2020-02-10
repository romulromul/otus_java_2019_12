import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CallArrayList {

    public static void main(String[] args) {

//        // Потренироваться с generic'ами
//        GenericTest<Integer> newObject;
//        newObject = new GenericTest<>(100);
//
//        newObject.showType();
//
//        int value = newObject.getob();
//        System.out.println("Значение " + value);

        // Домашнее задание
        DIYarrayList<Integer> numbers = new DIYarrayList<>();
        List<Integer> numbers1 = new ArrayList<>();
        numbers.add(0,1);
        numbers.add(1,5);
        numbers.add(2,3);
        numbers.add(3,33);
        numbers.add(4,11);
        numbers.add(5,6);
        numbers.add(6,16);
        System.out.println("Размер коллекции: " + numbers.size());
        System.out.println("Тип : " + numbers.getClass().getName());
        System.out.println("Вывод коллекции: " + numbers);
        boolean a = Collections.addAll(numbers,2,4,5);
        System.out.println("Результат addAll в домашнем задании: " + numbers);


//        // Посмотреть как ведет себя ArrayList и сравнить с домашним заданием
//        ArrayList<Integer> numbers1 = new ArrayList<>(Arrays.asList(1,3,5,4,87));
//        System.out.println("Вывод ArrayList: " + numbers1);
//        boolean i = Collections.addAll(numbers1,12,14,15);
//        System.out.println("Результат addAll для DYIArrayList: " + numbers1);

        //Copy
        Collections.copy(numbers1, numbers);
        System.out.println("Результат работы copy: " + numbers1);

        //Sort
//        Collections.sort(numbers);
//        System.out.println("Результат работы sort: " + numbers);


    }

}
