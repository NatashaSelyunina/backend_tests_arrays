package lesson_02_homeworks;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArraysUtilsTest {
    private ArraysUtils utils;

    @Test
    public void checkSortedArrayWithPositiveNumbers() {
        ArraysUtils utils = new ArraysUtils();
        int[] array = {19, 17, 8, 13, 22, 7};
        int[] expectedArray = {7, 8, 13, 17, 19, 22};
        int[] actualArray = utils.getSortedArray(array);
        assertArrayEquals(expectedArray, actualArray);
        assertEquals(expectedArray[2], actualArray[2]);
        assertNotNull(actualArray);
        assertNotEquals(2, actualArray.length);
    }

    @Test
    public void checkSortedArrayWithNegativeNumbers() {
        ArraysUtils utils = new ArraysUtils();
        int[] array = {-19, -17, -8, -13, -22, -7};
        int[] expectedArray = {-22, -19, -17, -13, -8, -7};
        int[] actualArray = utils.getSortedArray(array);
        assertArrayEquals(expectedArray, actualArray);
        assertEquals(expectedArray[2], actualArray[2]);
        assertNotNull(actualArray);
        assertNotEquals(2, actualArray.length);
    }

    @Test
    public void checkSortedArrayAlreadySortedArray() {
        ArraysUtils utils = new ArraysUtils();
        int[] array = {7, 8, 13, 17, 19, 22};
        int[] expectedArray = {7, 8, 13, 17, 19, 22};
        int[] actualArray = utils.getSortedArray(array);
        assertArrayEquals(expectedArray, actualArray);
        assertEquals(expectedArray[3], actualArray[3]);
        assertNotNull(actualArray);
        assertNotEquals(2, actualArray.length);
    }

    @Test
    public void checkSortedArrayWithOneElement() {
        ArraysUtils utils = new ArraysUtils();
        int[] array = {7};
        int[] expectedArray = {7};
        int[] actualArray = utils.getSortedArray(array);
        assertArrayEquals(expectedArray, actualArray);
        assertEquals(expectedArray[0], actualArray[0]);
        assertNotNull(actualArray);
    }

    @Test
    public void checkSortedEmptyArray() {
        ArraysUtils utils = new ArraysUtils();
        int[] array = {};
        int[] expectedArray = {};
        int[] actualArray = utils.getSortedArray(array);
        assertArrayEquals(expectedArray, actualArray);
        assertNotNull(actualArray);
        assertNotEquals(2, actualArray.length);
    }

    @Test
    public void checkSortedNull() {
        ArraysUtils utils = new ArraysUtils();
        int[] array = null;
        try {
            utils.getSortedArray(array);
        } catch (IllegalArgumentException e) {
            return;
        }
        assertNull(array);
        fail();
    }

    @Test
    public void getNewArrayWithSeveralPositiveMatchingElements() {
        ArraysUtils utils = new ArraysUtils();
        int[] array1 = {10, 4, 19, 22, 7, 9, 11, 22, 1, 4, 90, 18};
        int[] array2 = {19, 17, 8, 13, 22, 7};
        int[] expectedArray = {19, 22, 7};
        int[] actualArray = utils.getNewArrayWithMatchingElements(array2, array1);

        assertArrayEquals(expectedArray, actualArray);
        assertEquals(expectedArray[1], actualArray[1]);
        assertNotNull(actualArray);
        assertEquals(3, actualArray.length);
    }

    @Test
    public void getNewArrayWithSeveralNegativeMatchingElements() {
        ArraysUtils utils = new ArraysUtils();
        int[] array1 = {-2, 4, 19, -3, -7, 9, 11, 22, 1, 4, 90, 18};
        int[] array2 = {-3, 17, 8, 13, -2, -7};
        int[] expectedArray = {-3, -2, -7};
        int[] actualArray = utils.getNewArrayWithMatchingElements(array2, array1);

        assertArrayEquals(expectedArray, actualArray);
        assertEquals(expectedArray[2], actualArray[2]);
        assertEquals(3, actualArray.length);
        assertNotNull(actualArray);
    }

    @Test
    public void getNewArrayWithSeveralNegativeAndPositiveMatchingElements() {
        ArraysUtils utils = new ArraysUtils();
        int[] array1 = {-2, 4, 19, -3, -7, 9, 11, 17, 1, 4, 90, 8};
        int[] array2 = {-3, 17, 8, 13, -2, -9, 28};
        int[] expectedArray = {-3, 17, 8, -2};
        int[] actualArray = utils.getNewArrayWithMatchingElements(array2, array1);

        assertArrayEquals(expectedArray, actualArray);
        assertEquals(expectedArray[2], actualArray[2]);
        assertNotNull(actualArray);
        assertNotEquals(3, actualArray.length);
    }

    @Test
    public void getNewArrayWithoutMatchingElements() {
        ArraysUtils utils = new ArraysUtils();
        int[] array1 = {-2, 4, 19, -3, -7, 9, 11, 17, 1, 4, 90, 8};
        int[] array2 = {-14, 18, 15, 13, -10, -9, 28};
        int[] expectedArray = {};
        int[] actualArray = utils.getNewArrayWithMatchingElements(array2, array1);

        assertArrayEquals(expectedArray, actualArray);
        assertNotNull(actualArray);
        assertNotEquals(3, actualArray.length);
    }

    @Test
    public void getNewArrayWithoutMatchingElementsWithOneArrayEmpty() {
        ArraysUtils utils = new ArraysUtils();
        int[] array1 = {};
        int[] array2 = {-14, 18, 15, 13, -10, -9, 28};
        int[] expectedArray = {};
        int[] actualArray = utils.getNewArrayWithMatchingElements(array1, array2);

        assertArrayEquals(expectedArray, actualArray);
        assertNotNull(actualArray);
        assertNotEquals(3, actualArray.length);
    }

    @Test
    public void getNewArrayWithoutMatchingElementsWithBothArraysEmpty() {
        ArraysUtils utils = new ArraysUtils();
        int[] array1 = {};
        int[] array2 = {};
        int[] expectedArray = {};
        int[] actualArray = utils.getNewArrayWithMatchingElements(array1, array2);

        assertArrayEquals(expectedArray, actualArray);
        assertNotNull(actualArray);
        assertNotEquals(3, actualArray.length);
    }

    @Test
    public void getNewArrayWithMatchingElementsWithPresenceOfZero() {
        ArraysUtils utils = new ArraysUtils();
        int[] array1 = {-2, 4, 19, -3, -7, 0, 11, 17, 1, 28, 90, 8};
        int[] array2 = {0, 18, 15, 13, -10, -9, 28};
        int[] expectedArray = {0, 28};
        int[] actualArray = utils.getNewArrayWithMatchingElements(array2, array1);

        assertArrayEquals(expectedArray, actualArray);
        assertEquals(expectedArray[1], actualArray[1]);
        assertNotNull(actualArray);
        assertEquals(2, actualArray.length);
    }

    @Test
    public void getNewArrayWithMatchingElementsWithArraysOfSizeOne() {
        ArraysUtils utils = new ArraysUtils();
        int[] array1 = {-4};
        int[] array2 = {-4};
        int[] expectedArray = {-4};
        int[] actualArray = utils.getNewArrayWithMatchingElements(array2, array1);

        assertArrayEquals(expectedArray, actualArray);
        assertEquals(expectedArray[0], actualArray[0]);
        assertNotNull(actualArray);
        assertEquals(1, actualArray.length);
    }

    @Test
    public void getNewArrayWithoutMatchingElementsWithArraysOfSizeOne() {
        ArraysUtils utils = new ArraysUtils();
        int[] array1 = {-4};
        int[] array2 = {3};
        int[] expectedArray = {};
        int[] actualArray = utils.getNewArrayWithMatchingElements(array2, array1);

        assertArrayEquals(expectedArray, actualArray);
        assertNotNull(actualArray);
        assertNotEquals(2, actualArray.length);
    }

    @Test
    public void getNewArrayWithMatchingElementsWithArrayWithDuplicateElements() {
        ArraysUtils utils = new ArraysUtils();
        int[] array1 = {-2, 4, 15, -3, -7, 0, 11, 17, 1, 28, 90, 8};
        int[] array2 = {0, 18, 15, 13, 0, -9, 28};
        int[] expectedArray = {0, 15, 0, 28};
        int[] actualArray = utils.getNewArrayWithMatchingElements(array2, array1);

        assertArrayEquals(expectedArray, actualArray);
        assertEquals(expectedArray[1], actualArray[1]);
        assertNotNull(actualArray);
        assertNotEquals(2, actualArray.length);
    }

    @Test
    public void getNewArrayWithMatchingElementsWithSortedArrayWithDuplicateElements() {
        ArraysUtils utils = new ArraysUtils();
        int[] array1 = {-2, 4, 15, 1, -7, 0, 11, 17, 1, 0, 90, 28};
        int[] array2 = {0, 18, 15, 13, 1, -9, 28};
        int[] expectedArray = {0, 15, 1, 28};
        int[] actualArray = utils.getNewArrayWithMatchingElements(array2, array1);

        assertArrayEquals(expectedArray, actualArray);
        assertEquals(expectedArray[2], actualArray[2]);
        assertNotNull(actualArray);
        assertNotEquals(2, actualArray.length);
    }

    @Test
    public void getNewArrayWithoutMatchingElementsWithArrayNull() {
        ArraysUtils utils = new ArraysUtils();
        int[] array1 = {-2, 4, 15, 1, -7, 0, 11, 17, 1, 0, 90, 28};
        int[] array2 = null;

        try {
            utils.getNewArrayWithMatchingElements(array2, array1);
        } catch (IllegalArgumentException e) {
            return;
        }

        assertNull(array2);
        fail();
    }

    @Test
    public void getNewArrayWithoutMatchingElementsWithSortedArrayNull() {
        ArraysUtils utils = new ArraysUtils();
        int[] array1 = null;
        int[] array2 = {-2, 4, 15, 1, -7, 0, 11, 17, 1, 0, 90, 28};

        try {
            utils.getNewArrayWithMatchingElements(array2, array1);
        } catch (IllegalArgumentException e) {
            return;
        }

        assertNull(array1);
        fail();
    }

    @Test
    public void getNewArrayWithoutDuplicateElementsPositiveNumbers() {
        ArraysUtils utils = new ArraysUtils();
        int[] array = {19, 17, 8, 13, 22, 7, 17, 8};
        int[] expectedArray = {19, 17, 8, 13, 22, 7};
        int[] actualArray = utils.getNewArrayWithoutDuplicateElements(array);
        assertArrayEquals(expectedArray, actualArray);
        assertEquals(expectedArray[2], actualArray[2]);
        assertNotNull(actualArray);
        assertNotEquals(2, actualArray.length);
    }

    @Test
    public void getNewArrayWithoutDuplicateElementsNegativeNumbers() {
        ArraysUtils utils = new ArraysUtils();
        int[] array = {-19, -17, -8, -13, -22, -8, -7, -19};
        int[] expectedArray = {-19, -17, -8, -13, -22, -7};
        int[] actualArray = utils.getNewArrayWithoutDuplicateElements(array);
        assertArrayEquals(expectedArray, actualArray);
        assertEquals(expectedArray[3], actualArray[3]);
        assertNotNull(actualArray);
        assertEquals(6, actualArray.length);
    }

    @Test
    public void getNewArrayWithoutDuplicateElementsPositiveAndNegativeNumbers() {
        ArraysUtils utils = new ArraysUtils();
        int[] array = {-2, 4, 19, -3, -7, 9, -3, 11, 17, 1, 4, 90, 8};
        int[] expectedArray = {-2, 4, 19, -3, -7, 9, 11, 17, 1, 90, 8};
        int[] actualArray = utils.getNewArrayWithoutDuplicateElements(array);
        assertArrayEquals(expectedArray, actualArray);
        assertEquals(expectedArray[1], actualArray[1]);
        assertNotNull(actualArray);
        assertNotEquals(6, actualArray.length);
    }

    @Test
    public void getNewArrayWithoutDuplicateElementsEmptyArray() {
        ArraysUtils utils = new ArraysUtils();
        int[] array = {};
        try {
            utils.getNewArrayWithoutDuplicateElements(array);
        } catch (IllegalArgumentException e) {
            return;
        }
        fail();
    }

    @Test
    public void getNewArrayWithoutDuplicateElementsArrayIsNull() {
        ArraysUtils utils = new ArraysUtils();
        int[] array = null;
        try {
            utils.getNewArrayWithoutDuplicateElements(array);
        } catch (IllegalArgumentException e) {
            return;
        }
        assertNull(array);
        fail();
    }

    @Test
    public void getNewArrayWithoutDuplicateElementsForArrayWithOneElement() {
        ArraysUtils utils = new ArraysUtils();
        int[] array = {-2};
        int[] expectedArray = {-2};
        int[] actualArray = utils.getNewArrayWithoutDuplicateElements(array);
        assertArrayEquals(expectedArray, actualArray);
        assertEquals(expectedArray[0], actualArray[0]);
        assertNotNull(actualArray);
        assertNotEquals(6, actualArray.length);
    }

    @Test
    public void getNewArrayWithoutDuplicateElementsForArrayWithZero() {
        ArraysUtils utils = new ArraysUtils();
        int[] array = {0, 0, 0, 0};
        int[] expectedArray = {0};
        int[] actualArray = utils.getNewArrayWithoutDuplicateElements(array);
        assertArrayEquals(expectedArray, actualArray);
        assertEquals(expectedArray[0], actualArray[0]);
        assertNotNull(actualArray);
        assertEquals(1, actualArray.length);
    }

    @Test
    public void searchTheSecondLargestElementFromArrayWithPositiveNumbers() {
        ArraysUtils utils = new ArraysUtils();
        int[] array = {19, 17, 8, 13, 22, 7, 17, 8};
        int expectedNumber = 19;
        int actualNumber = utils.searchTheSecondLargestElement(array);
        assertEquals(expectedNumber, actualNumber);
    }

    @Test
    public void searchTheSecondLargestElementFromArrayWithNegativeNumbers() {
        ArraysUtils utils = new ArraysUtils();
        int[] array = {-19, -17, -8, -13, -22, -8, -7, -19};
        int expectedNumber = -8;
        int actualNumber = utils.searchTheSecondLargestElement(array);
        assertEquals(expectedNumber, actualNumber);
    }

    @Test
    public void searchTheSecondLargestElementFromArrayWithPositiveAndNegativeNumbers() {
        ArraysUtils utils = new ArraysUtils();
        int[] array = {-2, 4, 19, -3, -7, 9, -3, 11, 17, 1, 4, 90, 8};
        int expectedNumber = 19;
        int actualNumber = utils.searchTheSecondLargestElement(array);
        assertEquals(expectedNumber, actualNumber);
    }

    @Test
    public void searchTheSecondLargestElementFromArrayWithDuplicateNumbers() {
        ArraysUtils utils = new ArraysUtils();
        int[] array = {-2, 4, 19, 19, -7, 9, -3, 90, 17, 1, 4, 90, 8};
        int expectedNumber = 19;
        int actualNumber = utils.searchTheSecondLargestElement(array);
        assertEquals(expectedNumber, actualNumber);
    }

    @Test
    public void searchTheSecondLargestElementFromArrayContainingZerosNumbers() {
        ArraysUtils utils = new ArraysUtils();
        int[] array = {0, 4, 19, 19, -7, 0, -3, 90, 17, 0, 4, 90, 0};
        int expectedNumber = 19;
        int actualNumber = utils.searchTheSecondLargestElement(array);
        assertEquals(expectedNumber, actualNumber);
    }

    @Test
    public void searchTheSecondLargestElementFromArrayWithIdenticalElements() {
        ArraysUtils utils = new ArraysUtils();
        int[] array = {7, 7, 7, 7, 7, 7};
        try {
            utils.searchTheSecondLargestElement(array);
        } catch (IllegalArgumentException e) {
            return;
        }
        fail();
    }

    @Test
    public void searchTheSecondLargestElementFromArrayIsNull() {
        ArraysUtils utils = new ArraysUtils();
        int[] array = null;
        try {
            utils.searchTheSecondLargestElement(array);
        } catch (IllegalArgumentException e) {
            return;
        }
        assertNull(array);
        fail();
    }

    @Test
    public void searchTheSecondLargestElementFromArrayWithOneElement() {
        ArraysUtils utils = new ArraysUtils();
        int[] array = {7};
        try {
            utils.searchTheSecondLargestElement(array);
        } catch (IllegalArgumentException e) {
            return;
        }
        fail();
    }

    @Test
    public void searchTheSecondLargestElementFromEmptyArray() {
        ArraysUtils utils = new ArraysUtils();
        int[] array = {};
        try {
            utils.searchTheSecondLargestElement(array);
        } catch (IllegalArgumentException e) {
            return;
        }
        fail();
    }

    @Test
    public void searchTheSecondSmallestElementFromArrayWithPositiveNumbers() {
        ArraysUtils utils = new ArraysUtils();
        int[] array = {19, 17, 8, 13, 22, 7, 17, 8};
        int expectedNumber = 8;
        int actualNumber = utils.searchTheSecondSmallestElement(array);
        assertEquals(expectedNumber, actualNumber);
    }

    @Test
    public void searchTheSecondSmallestElementFromArrayWithNegativeNumbers() {
        ArraysUtils utils = new ArraysUtils();
        int[] array = {-19, -17, -8, -13, -22, -8, -7, -19};
        int expectedNumber = -19;
        int actualNumber = utils.searchTheSecondSmallestElement(array);
        assertEquals(expectedNumber, actualNumber);
    }

    @Test
    public void searchTheSecondSmallestElementFromArrayWithPositiveAndNegativeNumbers() {
        ArraysUtils utils = new ArraysUtils();
        int[] array = {-2, 4, 19, -3, -7, 9, -3, 11, 17, 1, 4, 90, 8};
        int expectedNumber = -3;
        int actualNumber = utils.searchTheSecondSmallestElement(array);
        assertEquals(expectedNumber, actualNumber);
    }

    @Test
    public void searchTheSecondSmallestElementFromArrayWithDuplicateNumbers() {
        ArraysUtils utils = new ArraysUtils();
        int[] array = {-2, 4, 19, 19, -7, 9, -3, 90, 17, 1, 4, 90, 8};
        int expectedNumber = -3;
        int actualNumber = utils.searchTheSecondSmallestElement(array);
        assertEquals(expectedNumber, actualNumber);
    }

    @Test
    public void searchTheSecondSmallestElementFromArrayContainingZerosNumbers() {
        ArraysUtils utils = new ArraysUtils();
        int[] array = {0, 4, 19, 19, -7, 0, -3, 90, 17, 0, 4, 90, 0};
        int expectedNumber = -3;
        int actualNumber = utils.searchTheSecondSmallestElement(array);
        assertEquals(expectedNumber, actualNumber);
    }

    @Test
    public void searchTheSecondSmallestElementFromArrayWithIdenticalElements() {
        ArraysUtils utils = new ArraysUtils();
        int[] array = {7, 7, 7, 7, 7, 7};
        try {
            utils.searchTheSecondSmallestElement(array);
        } catch (IllegalArgumentException e) {
            return;
        }
        fail();
    }

    @Test
    public void searchTheSecondSmallestElementFromArrayIsNull() {
        ArraysUtils utils = new ArraysUtils();
        int[] array = null;
        try {
            utils.searchTheSecondSmallestElement(array);
        } catch (IllegalArgumentException e) {
            return;
        }
        assertNull(array);
        fail();
    }

    @Test
    public void searchTheSecondSmallestElementFromArrayWithOneElement() {
        ArraysUtils utils = new ArraysUtils();
        int[] array = {7};
        try {
            utils.searchTheSecondSmallestElement(array);
        } catch (IllegalArgumentException e) {
            return;
        }
        fail();
    }

    @Test
    public void searchTheSecondSmallestElementFromEmptyArray() {
        ArraysUtils utils = new ArraysUtils();
        int[] array = {};
        try {
            utils.searchTheSecondSmallestElement(array);
        } catch (IllegalArgumentException e) {
            return;
        }
        fail();
    }
}
