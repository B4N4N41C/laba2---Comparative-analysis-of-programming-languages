import java.util.Arrays;

public class Methods {
     public static void main(String[] args) throws Exception {
        int[] arrayConsistDuplicates = {1, 1, 1, 5, 5, 2, 2, 6, 7, 8, 7, 6, 5, 4, 5, 6, 7, 2, 1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 8, 7, 6, 5, 4, 3, 2, 1}; 
        System.out.println("Изночальный массив: " + Arrays.toString(arrayConsistDuplicates));
        System.out.println("Массив с удалёнными дубликатами: " + Arrays.toString(removeDuplicates(arrayConsistDuplicates)));
        System.out.println("Первые 5 элементов массива: " + Arrays.toString(getFirst(arrayConsistDuplicates, 5)));
        System.out.println("Последнии 10 элементов массива: " + Arrays.toString(getLast(arrayConsistDuplicates, 10)));
        System.out.println("Количество уникальных элементов массива: " + countIdentic(arrayConsistDuplicates));
    }

    private static int[] removeDuplicates(int[] array) {
        int[] numbers = new int[array.length];
        int currenIndex = 0;
        for (int indexArray = 0; indexArray < array.length; indexArray++) {
            boolean isDuplicate = false;
            for (int indexNumbers = 0; indexNumbers < numbers.length; indexNumbers++) {
                if (numbers[indexNumbers] == array[indexArray]) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                numbers[currenIndex] = array[indexArray];
                currenIndex++;
            }
        }
        int[] result = new int[currenIndex];
        result = Arrays.copyOf(numbers, currenIndex);
        return result;
    }
    private static int[] getFirst(int[] array, int n){
        return Arrays.copyOf(array, n);
    }
    private static int[] getLast(int[] array, int n){
        return Arrays.copyOfRange(array, array.length - n, array.length);
    }
    private static int countIdentic(int[] array){
        return array.length - removeDuplicates(array).length;
    }
}
