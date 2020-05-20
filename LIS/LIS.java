import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LIS {
    static int N;
    static List<Integer> array;
    static int[] cache;

    public static void main (String[] args) throws Exception {
        int T;

        String path = LIS.class.getResource("").getPath();
        Scanner sc = new Scanner(new File(path + "input.txt"));

        T = sc.nextInt();

        for (int test_case = 0; test_case < T; test_case++) {
            // 초기화
            N = sc.nextInt();
            array = new ArrayList<>();
            cache = new int[N];
            Arrays.fill(cache, -1);
            cache[N-1] = 1;

            for (int i=0; i<N; i++) {
                array.add(sc.nextInt());
            }

            System.out.println(lis(array));
        }


    }
    // 배열이 주어질 경우 완전탐색하여 lis 길이를 구하는 완전탐색 함수
    // 주어진 리스트에서 가능한 최대 lis 길이를 반환
    public static int lis(List<Integer> arr) {
        int length = arr.size();
        if (length == 0) return 0;

        // 빈 매열이 아니라면 적어도 1개의 lis 가 있음
        int max = 1;
        for (int curr=0; curr<length; curr++) {

            // i번째 원소보다 뒤에 있고 큰 수들을 배열에 모두 담아야 함
            List<Integer> nextArr = new ArrayList<>();
            for (int next=curr+1; next<length; next++) {
                if (arr.get(curr) < arr.get(next)) {
                    nextArr.add(arr.get(next));
                }
            }

            max = Math.max(lis(nextArr) + 1, max);
        }
        // 자기 자신의 경우 +1 해서 반환
        return max;
    }

    // lis 함수와 같지만 memoization 사용. 원 배열의 start index 에서 시작하는 가능한 최대 lis 길이를 반환.
    public static int lis2(int start) {
        // 범위를 벗어난 경우 0
        if (start == N) return 0;

        // 메모이제이션 값 반환
        if (cache[start] != -1) return cache[start];

        // 최소 자기 자신의 길이가 있기에 1
        int max = 1;

        for (int next=start+1; next<N; next++) {
            if(array.get(start) < array.get(next)) {
                max = Math.max(lis2(next) + 1, max);
                cache[start] = max;
            }
        }

        return max;
    }
}
