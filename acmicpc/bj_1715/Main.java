package bj_1715;


import java.io.File;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

// input: 1 2 4 5
//              이번에 계산    총 계산
// 3 4 5        sum = 3     total_sum = 3
// 7 5          sum = 7     total_sum = 3 + 7 = 10
// 12           sum = 12    total_sum = 10 + 12 = 22

public class Main {
    public static void main(String[] args) throws Exception {
        String path = bj_1715.Main.class.getResource("").getPath();
        Scanner sc = new Scanner(new File(path + "/input.txt"));
//        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // 원소가 하나일 경우 섞는 횟수 0
        if (N==1) {
            System.out.println(0);
            return;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        while (N-- > 0){
            pq.add(sc.nextInt());
        }

        int sum = 0;
        while(pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();

            int next = first + second;
            sum += next;
            pq.add(next);
        }

        System.out.println(sum);
    }
}
