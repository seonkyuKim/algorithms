package bj_2473;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        String path = bj_2473.Main.class.getResource("").getPath();

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(path + "/input.txt"));

        int N = Integer.parseInt(br.readLine());
        long[] liquids = new long[N];
        String[] input = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            liquids[i] = Long.parseLong(input[i]);
        }

        Arrays.sort(liquids);
        long[] answer = findLiquids(liquids);
        System.out.println(answer[0] + " " + answer[1] + " " + answer[2]);
    }

    public static long[] findLiquids(long[] sortedLiquids) {

        // x, y, z는 반환할 값
        long x = sortedLiquids[0], y = sortedLiquids[1], z = sortedLiquids[sortedLiquids.length - 1];
        long sum = x + y + z;

        // axis 이동값
        for (int axis = 0; axis < sortedLiquids.length - 2; axis++) {
            int right, left;
            // axis 제외한 좌, 우 Index
            left = axis + 1;
            right = sortedLiquids.length - 1;
            while (left < right) {
                long tempSum = sortedLiquids[axis] + sortedLiquids[left] + sortedLiquids[right];

                if (Math.abs(tempSum) < Math.abs(sum)) {
                    x = sortedLiquids[axis];
                    y = sortedLiquids[left];
                    z = sortedLiquids[right];
                    sum = tempSum;
                }

                if (tempSum > 0) right = right - 1;
                else if (tempSum < 0) left = left + 1;
                else return new long[]{x, y, z};   // 0일 경우 바로 반환
            }
        }
        return new long[]{x, y, z};


    }
}
