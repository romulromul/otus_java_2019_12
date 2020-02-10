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
        DIYarrayList<Integer> numbers = new DIYarrayList<>(Arrays.asList(1,2,5,7,4)) ;
        DIYarrayList<Integer> numbers1 = new DIYarrayList<>();
        System.out.println("Размер коллекции NUMBERS: " + numbers.size());
        System.out.println("Тип : " + numbers.getClass().getName());
        System.out.println("Вывод коллекции: " + numbers);

        boolean a = Collections.addAll(numbers,2,4,5,67,43,34,23,45,67,54,65,54,123,43,2,6,7);
        System.out.println("Результат addAll в домашнем задании: " + numbers);
        System.out.println("Размер коллекции после addAll: " + numbers.size());

        numbers.add(20, 6);
        System.out.println("Результат add в домашнем задании: " + numbers);
        System.out.println("Размер коллекции после add: " + numbers.size());

//        // Посмотреть как ведет себя ArrayList и сравнить с домашним заданием
//        ArrayList<Integer> numbers1 = new ArrayList<>(Arrays.asList(1,3,5,4,87));
//        System.out.println("Вывод ArrayList: " + numbers1);
//        boolean i = Collections.addAll(numbers1,12,14,15);
//        System.out.println("Результат addAll для DYIArrayList: " + numbers1);

        //Copy
        DIYarrayList<Integer> firstArray = new DIYarrayList<>(Arrays.asList(1,3,5));
        DIYarrayList<Integer> secondArray = new DIYarrayList<>(Arrays.asList(4,3,6,7));
        Collections.copy(secondArray,firstArray);
        System.out.println("Результат работы copy: " + secondArray);

        //Sort
        DIYarrayList<Integer> sortArray = new DIYarrayList<>(Arrays.asList(32,1,61));
        Collections.sort(sortArray);
        System.out.println("Результат работы sort: " + sortArray);

    }

}
