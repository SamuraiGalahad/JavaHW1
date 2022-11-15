import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class Main {
    static Scanner reader = new Scanner(System.in);
    static Boolean flag = true;
    public static void get_command() {
        while (true) {
            if (flag) {
                System.out.println("Commands list:");
                System.out.println("first   -> to show 1.1");
                System.out.println("second  -> to show 1.2");
                System.out.println("third   -> to show 1.3");
                System.out.println("forth   -> to show 1.4");
                System.out.println("fifth   -> to show 1.5");
                System.out.println("exit    -> to exit\n");

            }
            flag = true;
            System.out.print("~>");
            String command = reader.nextLine();
            if (Objects.equals(command, "first")) {
                first();
            } else if (Objects.equals(command, "second")) {
                second();
            } else if (Objects.equals(command, "third")) {
                third();
            } else if (Objects.equals(command, "forth")) {
                forth();
            } else if (Objects.equals(command, "fifth")) {
                fifth();
                System.out.println(1);
            } else if (Objects.equals(command, "exit")) {
                break;
            } else {
                if (command.length() == 0) {
                    flag = false;
                    continue;
                }
                System.out.println("Wrong command. Write 'exit' to end program...");
            }
        }
    }

    public static void print(int answer) {
        System.out.printf("Answer: %d%n", answer);
    }

    public static void print_first(int num, String answer) {
        System.out.printf("For num: %d answer is %s%n", num, answer);
    }

    public static int get_num() {
        System.out.print("Enter a number: ");
        return reader.nextInt();
    }

    public static int[] get_array() {
        int n = get_num();
        int[] arr = new int[n];
        System.out.println("Array created...");
        System.out.println("Enter numbers in array:");
        int input;
        for (int i = 0; i < n; i++) {
            input = get_num();
            arr[i] = input;
        }
        return arr;
    }

    public static void print_arr(int[] arr) {
        for (int j : arr) {
            System.out.printf("%d ", j);
        }
    }

    public static String get_string() {
        System.out.print("Write line: ");
        return reader.nextLine();
    }

    public static void first() {
        for (int i = 1; i <= 100; i++) {
            if (i % 5 == 0 && i % 3 == 0) {
                print_first(i, "FizzBuzz");
            } else if (i % 3 == 0) {
                print_first(i, "Fizz");
            } else if (i % 5 == 0) {
                print_first(i, "Buzz");
            } else {
                print_first(i, Integer.toString(i));
            }
        }
    }

    public static void second() {
        int n = get_num();
        int last = 0;
        int prev;
        int next = 1;
        if (n == 1) {
            System.out.println(1);
        } else {
            for (int i = 0; i < n; i++) {
                System.out.println(next);
                prev = last;
                last = next;
                next = prev + last;
            }
        }
    }

    public static void third() {
        int n = get_num();
        if (n == 0) {
            n = 1;
        } else {
            int k = 1;
            for (int i = 1; i <= n; i++) {
                k *= i;
            }
            n = k;
        }
        print(n);
    }

    public static void forth() {
        int[] arr = get_array();
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        print_arr(arr);
    }

    public static void fifth() {
        String str = get_string();
        char[] char_arr = str.toCharArray();
        Set<Character> vowels = new HashSet<Character>();
        for (char ch : "aeiou".toCharArray()) {
            vowels.add(ch);
        }
        int count = 0;
        int all_len = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetter(char_arr[i])) {
                if (vowels.contains(Character.toLowerCase(char_arr[i]))) {
                    count++;
                }
                all_len++;
            }
        }
        System.out.printf("Vowels: %d\n", count);
        System.out.printf("Consonants: %d\n", all_len - count);
    }


    public static void main(String[] args) {
        get_command();
    }
}