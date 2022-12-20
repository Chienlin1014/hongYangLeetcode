
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

// 有50、25、10、5、1五種硬幣，輸入0-7489金額，輸出共有多少排列組合可達成金額。2146113925
public class Test12 {
    static int count(int[] coins, int amount) {
        int[] count = new int[amount + 1];
        count[0] = 1;
        for (int coin : coins) {
            for (int x = coin; x <= amount; x++) {
                count[x] += count[x - coin];
            }
        }
        return count[amount];
    }

    public static void main(String[] args) {
        int[] coin = {1, 5, 10, 25, 50};
        System.out.println("請輸入總金額：");
        Scanner sc = new Scanner(System.in);
        int amount = sc.nextInt();
        var begin = LocalDateTime.now();
        System.out.println("共：" + count(coin, amount) + "種");
        System.out.println("共" + ChronoUnit.MILLIS.between(begin, LocalDateTime.now()) + "ms");
    }
}
