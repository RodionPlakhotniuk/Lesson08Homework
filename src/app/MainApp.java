import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class MainApp {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random random = new Random();

        int[] number = new int[15];

        for (int i = 0; i < number.length; i++) {
            number[i] = random.nextInt(100) + 1;
        }
        System.out.println("Початковий вигляд масиву: " + Arrays.toString(number));

        int n = number.length;
        for (int i = 1; i < n; i++) {
            int key = number[i];
            int j = i - 1;
            while (j >= 0 && number[j] > key) {

                number[j + 1] = number[j];
                j--;
            }

            number[j + 1] = key;
        }
        System.out.println("Відсортований масив: " + Arrays.toString(number));

        System.out.println("Введіть число для пошуку в масиві:");
        int userNumber = scan.nextInt();

        int left = 0;
        int right = number.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (number[mid] == userNumber) {
                System.out.println("Індекс числа " + userNumber + " у відсортованому масиві: " + mid);
                break;
            } else if (number[mid] < userNumber) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (left > right) {
            System.out.println("Числа " + userNumber + " немає у масиві.");
        }

    }

}

