
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/*2-2147483647質因數分解 */
public class Test3 {
    static boolean isPrime(int number) {
        int k = (int) Math.sqrt(number);
        for (int i = 2; i <= k; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    static void factor(int number) {
        var begin = LocalDateTime.now();
        System.out.print(number);

        ArrayList<Integer> keys = new ArrayList<>();
        HashMap<Integer, Integer> factorNumber = new HashMap<>();
        if (number < 2) {
            System.out.println("不得輸入小於2之整數");
        } else if (isPrime(number)) {
            System.out.println("本身是質數");
        } else {
            System.out.print("=");
            int count = 0;
            for (int i = 2; i <= number; i++) {
                count = 0;
                if (number % i == 0) {
                    while (number % i == 0) {
                        number = number / i;
                        count++;
                    }
                    keys.add(i);
                    factorNumber.put(i, count);
                    if (number > 1 && isPrime(number)) {
                        keys.add(number);
                        factorNumber.put(number, 1);
                        break;
                    }
                }
            }
        }
        int j = 1;
        for (Integer key : keys) {
            System.out.print(key);
            if (factorNumber.get(key) > 1) {
                System.out.print("^" + factorNumber.get(key));
            }
            if (j < keys.size()) {
                System.out.print("*");
            }
            j++;
        }
        System.out.println();
        System.out.println("共" + ChronoUnit.MILLIS.between(begin, LocalDateTime.now()) + "ms");
    }

    public static void main(String[] args) {
        System.out.println("請輸入2-2147483647間之整數：");
        var sc = new Scanner(System.in);
        int i = sc.nextInt();
        Test3.factor(i);
    }
}
