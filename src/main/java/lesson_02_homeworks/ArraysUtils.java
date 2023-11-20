package lesson_02_homeworks;

import java.util.*;

public class ArraysUtils {
    public int[] getSortedArray(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Входящий массив не может быть null");
        }

        Arrays.sort(array);
        return array;
    }

    public int[] getNewArrayWithMatchingElements(int[] array, int[] array2) {
        if (array == null) {
            throw new IllegalArgumentException("Входящий массив не может быть null");
        }

        ArrayList<Integer> numbers = new ArrayList<>();

        int[] sortedArray2 = getSortedArray(array2);

        for (int i = 0; i < array.length; i++) {
            int currentNumber = array[i];
            boolean binarySearch = binarySearchInArray(sortedArray2, currentNumber);
            if (binarySearch) {
                numbers.add(array[i]);
            }
        }

        int[] newArray = new int[numbers.size()];
        for (int i = 0; i < numbers.size(); i++) {
            newArray[i] = numbers.get(i);
        }

        return newArray;
    }

    public boolean binarySearchInArray(int[] array, int number) {
        int left = 0;
        int right = array.length - 1;
        int middle = left + (right - left) / 2;

        for (int i = 0; i < array.length; i++) {
            while (left <= right) {
                if (number < array[middle]) {
                    right = middle - 1;
                } else if (number > array[middle]) {
                    left = middle + 1;
                } else {
                    return true;
                }
                middle = left + (right - left) / 2;
            }
        }

        return false;
    }

    public int[] getNewArrayWithoutDuplicateElements(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Входящий массив не может быть null");
        }

        if (array.length < 1) {
            throw new IllegalArgumentException("Входящий массив не может быть пустым");
        }

        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();

        for (int i = 0; i < array.length; i++) {
            linkedHashSet.add(array[i]);
        }

        int[] newArray = linkedHashSet.stream().mapToInt(Integer::intValue).toArray();

        return newArray;
    }

    public int searchTheSecondLargestElement(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Входящий массив не может быть null");
        }

        if (array.length < 2) {
            throw new IllegalArgumentException(
                    "Для нахождения второго по величине элемента массив не должен быть меньше двух элементов");
        }

        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        for (int i = 0; i < array.length; i++) {
            linkedHashSet.add(array[i]);
        }
        if (linkedHashSet.size() == 1) {
            throw new IllegalArgumentException("Входящий массив содержит одинаковые элементы");
        }

        array = getSortedArray(array);
        int secondLargestElement = array[array.length - 1];
        for (int i = array.length - 2; i > 0; i--) {
            if (secondLargestElement > array[i]) {
                secondLargestElement = array[i];
                break;
            }
        }
        return secondLargestElement;
    }

    public int searchTheSecondSmallestElement(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Входящий массив не может быть null");
        }

        if (array.length < 2) {
            throw new IllegalArgumentException("Для нахождения второго наименьшего по величине элемента массив " +
                    "не должен быть меньше двух элементов");
        }

        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        for (int i = 0; i < array.length; i++) {
            linkedHashSet.add(array[i]);
        }
        if (linkedHashSet.size() == 1) {
            throw new IllegalArgumentException("Входящий массив содержит одинаковые элементы");
        }

        array = getSortedArray(array);
        int secondSmallestNumber = array[0];
        for (int i = 1; i < array.length; i++) {
            if (secondSmallestNumber < array[i]) {
                secondSmallestNumber = array[i];
                break;
            }
        }
        return secondSmallestNumber;
    }
}
