package bj_2217;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        String path = bj_2217.Main.class.getResource("").getPath();
        Scanner sc = new Scanner(new File(path + "/input.txt"));
//        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] possibleWeights = new int[N];   // 각각의 로프가 버틸 수 있는 최대 중량
        for(int i=0; i<N; i++) {
            possibleWeights[i] = sc.nextInt();
        }


        System.out.println(getMaxWeightForRopes(possibleWeights));

    }

    // 가장 적은 무게를 버틸 수 있는 로프를 기준으로 생각
    // Max(사용하는 로프들 중 가장 작은 중량을 버틸 수 있는 로프 * 사용하는 로프 수)
    public static int getMaxWeightForRopes(int[] possibleWeights) {
        // 배열 오름차순 정렬
        Arrays.sort(possibleWeights);

        int max = Integer.MIN_VALUE;
        for (int i=0; i<possibleWeights.length; i++) {
            int temp = (possibleWeights.length - i) * possibleWeights[i];
            max = Integer.max(max, temp);
        }
        return max;
    }

}
