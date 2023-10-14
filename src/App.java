import java.util.Arrays;
import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        int count = 70000;
        int[] array = new int[count];
        Random random = new Random();

        for (int i = 0; i < count; i++) {
            array[i] = random.nextInt();
        }

        int[] arrayClone = array.clone();
        Arrays.sort(arrayClone);

        int[] arrayTenPercentRandom = arrayClone.clone();
        for (int i = 0; i < count * 0.1; i++) {
            arrayTenPercentRandom[i] = random.nextInt();
        }
        System.out.println("");
        System.out.println("Not sort array");
        System.out.println("");
        
        double time = System.currentTimeMillis();
        bubbleSort(array.clone());
        System.out.print("BubbleSort: ");
        System.out.println(System.currentTimeMillis() - time);

        time = System.currentTimeMillis();
        insertionSort(array.clone());
        System.out.print("Insertion Sort: ");
        System.out.println(System.currentTimeMillis() - time);

        time = System.currentTimeMillis();
        selectionSort(array.clone());
        System.out.print("Selection Sort: ");
        System.out.println(System.currentTimeMillis() - time);

        time = System.currentTimeMillis();
        mergeSort(array.clone(), 0, count - 1);
        System.out.print("Merge Sort: ");
        System.out.println(System.currentTimeMillis() - time);

        time = System.currentTimeMillis();
        quickSort(array.clone(), 0, count - 1);
        System.out.print("Quick Sort: ");
        System.out.println(System.currentTimeMillis() - time);

        time = System.currentTimeMillis();
        Arrays.sort(array.clone());
        System.out.print("Arrays.sort: ");
        System.out.println(System.currentTimeMillis() - time);
        
        System.out.println("");
        System.out.println("Sort array");
        System.out.println("");
        time = System.currentTimeMillis();
        bubbleSort(arrayClone);
        System.out.print("BubbleSort: ");
        System.out.println(System.currentTimeMillis() - time);

        time = System.currentTimeMillis();
        insertionSort(arrayClone);
        System.out.print("Insertion Sort: ");
        System.out.println(System.currentTimeMillis() - time);

        time = System.currentTimeMillis();
        selectionSort(arrayClone);
        System.out.print("Selection Sort: ");
        System.out.println(System.currentTimeMillis() - time);
        time = System.currentTimeMillis();
        mergeSort(arrayClone, 0, count - 1);
        System.out.print("Merge Sort: ");
        System.out.println(System.currentTimeMillis() - time);

        time = System.currentTimeMillis();
        quickSort(arrayClone, 0, count - 1);
        System.out.print("Quick Sort: ");
        System.out.println(System.currentTimeMillis() - time);

        time = System.currentTimeMillis();
        Arrays.sort(arrayClone);
        System.out.print("Arrays.sort: ");
        System.out.println(System.currentTimeMillis() - time);
        
        System.out.println("");
        System.out.println("Ten percent random array");
        System.out.println("");
        time = System.currentTimeMillis();
        bubbleSort(arrayTenPercentRandom.clone());
        System.out.print("BubbleSort: ");
        System.out.println(System.currentTimeMillis() - time);

        time = System.currentTimeMillis();
        insertionSort(arrayTenPercentRandom.clone());
        System.out.print("Insertion Sort: ");
        System.out.println(System.currentTimeMillis() - time);

        time = System.currentTimeMillis();
        selectionSort(arrayTenPercentRandom.clone());
        System.out.print("Selection Sort: ");
        System.out.println(System.currentTimeMillis() - time);

        time = System.currentTimeMillis();
        mergeSort(arrayTenPercentRandom.clone(), 0, count - 1);
        System.out.print("Merge Sort: ");
        System.out.println(System.currentTimeMillis() - time);

        time = System.currentTimeMillis();
        quickSort(arrayTenPercentRandom.clone(), 0, count - 1);
        System.out.print("Quick Sort: ");
        System.out.println(System.currentTimeMillis() - time);

        time = System.currentTimeMillis();
        Arrays.sort(arrayTenPercentRandom.clone());
        System.out.print("Arrays.sort: ");
        System.out.println(System.currentTimeMillis() - time);
    }

    private static void bubbleSort(int[] array) {
        boolean sorted = false;
        int temp;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    sorted = false;
                }
            }
        }
    }

    private static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;
            while (j >= 0 && current < array[j]) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = current;
        }
    }

    private static void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = array[i];
            int minId = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    minId = j;
                }
            }
            // замена
            int temp = array[i];
            array[i] = min;
            array[minId] = temp;
        }
    }

    public static void mergeSort(int[] array, int left, int right) {
        if (right <= left)
            return;
        int mid = (left + right) / 2;
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        merge(array, left, mid, right);
    }

    private static void merge(int[] array, int left, int mid, int right) {
        int lengthLeft = mid - left + 1;
        int lengthRight = right - mid;
        int leftArray[] = new int[lengthLeft];
        int rightArray[] = new int[lengthRight];
        // копируем отсортированные массивы во временные
        for (int i = 0; i < lengthLeft; i++)
            leftArray[i] = array[left + i];
        for (int i = 0; i < lengthRight; i++)
            rightArray[i] = array[mid + i + 1];
        // итераторы содержат текущий индекс временного подмассива
        int leftIndex = 0;
        int rightIndex = 0;
        // копируем из leftArray и rightArray обратно в массив
        for (int i = left; i < right + 1; i++) {
            // если остаются нескопированные элементы в R и L, копируем минимальный
            if (leftIndex < lengthLeft && rightIndex < lengthRight) {
                if (leftArray[leftIndex] < rightArray[rightIndex]) {
                    array[i] = leftArray[leftIndex];
                    leftIndex++;
                } else {
                    array[i] = rightArray[rightIndex];
                    rightIndex++;
                }
            }
            // если все элементы были скопированы из rightArray, скопировать остальные из
            // leftArray
            else if (leftIndex < lengthLeft) {
                array[i] = leftArray[leftIndex];
                leftIndex++;
            }
            // если все элементы были скопированы из leftArray, то скопировать остальные из
            // rightArray
            else if (rightIndex < lengthRight) {
                array[i] = rightArray[rightIndex];
                rightIndex++;
            }
        }
    }

    private static int partition(int[] array, int begin, int end) {
        int pivot = end;
        int counter = begin;
        for (int i = begin; i < end; i++) {
            if (array[i] < array[pivot]) {
                int temp = array[counter];
                array[counter] = array[i];
                array[i] = temp;
                counter++;
            }
        }
        int temp = array[pivot];
        array[pivot] = array[counter];
        array[counter] = temp;
        return counter;
    }

    private static void quickSort(int[] array, int begin, int end) {
        if (end <= begin)
            return;
        int pivot = partition(array, begin, end - 1);
        quickSort(array, begin, pivot - 1);
        quickSort(array, pivot + 1, end);
    }

}
