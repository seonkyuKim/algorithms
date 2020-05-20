package bj_2579;

import java.io.File;
import java.util.Scanner;


// https://www.acmicpc.net/problem/2579
public class Main {
    static int N;
    // 계단은 0부터 시작
    static int[] steps;
    // i번째 계단까지 갈 수 있는 최대 합
    static int[] cache;


    public static void main (String[] args) throws Exception {
        String path = Main.class.getResource("").getPath();
        Scanner sc = new Scanner(new File(path + "/input.txt"));
        //Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        steps = new int[N];
        cache = new int[N];

        for (int i=0; i<N; i++) {
            steps[i] = sc.nextInt();
        }

        // Base Case
        cache[0] = steps[0];
        if (N > 1) cache[1] = steps[0] + steps[1];
        if (N > 2) cache[2] = Math.max(steps[0] + steps[2], steps[1] + steps[2]);


        System.out.println(getMaxSum(N-1));

    }


    // i번째 계단까지 가는 max Sum을 반화한다.
    // maxSum[i] =  max(cache[i-3] + cache[i-1] + step[i], cache[i-2] + step[i])
    static int getMaxSum(int i) {
        if (cache[i] != 0) return cache[i];

        if (cache[i-3] == 0) cache[i-3] = getMaxSum(i-3);
        if (cache[i-2] == 0) cache[i-2] = getMaxSum(i-2);
        if (cache[i-1] == 0) cache[i-1] = getMaxSum(i-1);


        cache[i] = Math.max(cache[i-3] + steps[i-1] + steps[i], cache[i-2] + steps[i]);
        return cache[i];
    }


}
