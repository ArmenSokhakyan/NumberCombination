import java.util.Scanner;

public class NumberCombination {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter max number");

        int n = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter number length");
        int m = Integer.parseInt(scanner.nextLine());

        int[] numberArray = new int[n];

        for (int i = 1; i <= n; i++) {
            numberArray[i - 1] = i;
        }

        int[] numberDigits = new int[m];

        calculateCombinations(numberArray, numberDigits, 0, n - 1, 0, m);
    }

    static void calculateCombinations(int[] numberArray, int[] numberDigits, int startPosition,
                                      int endPosition, int position, int countOfDigits) {

        if (position == countOfDigits) {

            for (int j = 0; j < countOfDigits; j++) {
                System.out.print(numberDigits[j]);
            }

            System.out.println("");
            return;
        }

        for (int i = startPosition; i <= endPosition && endPosition - i + 1 >= countOfDigits - position; i++) {
            numberDigits[position] = numberArray[i];
            calculateCombinations(numberArray, numberDigits, i + 1, endPosition, position + 1, countOfDigits);
        }
    }

}
