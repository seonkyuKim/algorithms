import java.io.File;
import java.util.Scanner;

public class TRIANGLEPATH {
    static int N;
    static int[][] triangle;
    static int[][] cache;

    public static void main(String[] args) throws Exception {
        int T;

        String path = TRIANGLEPATH.class.getResource("").getPath();
        Scanner sc = new Scanner(new File(path + "/input.txt"));
        T = sc.nextInt();

        for (int test_case = 0; test_case < T; test_case++) {
            N = sc.nextInt();
            triangle = new int[N][N];
            cache = new int[N][N];

            for (int row=0; row<N; row++) {
                for (int col=0; col<row+1; col++) {
                    triangle[row][col] = sc.nextInt();
                    getMaxSum(row, col);
                }
            }



            int max = -1;
            for (int i=0; i<N; i++) {
                max = Math.max(cache[N-1][i], max);
            }

            System.out.println(max);
        }

    }

    // input: row, col. output: 여기까지 올 수 있는 최대 경로 반환
    public static void getMaxSum(int row, int col) {
        int max;
        // 맨 위의 경우
        if (row == 0 && col == 0) {
            max = triangle[row][col];
            cache[row][col] = max;
            return;
        }

        // col = 0일 때
        if (col == 0) {
            max = cache[row-1][col] + triangle[row][col];
            cache[row][col] = max;
            return;
        }

        // 바로 위 + 자기자신   혹은 왼쪽 위 + 자기자신
        max = Math.max(cache[row-1][col], cache[row-1][col-1]) + triangle[row][col];
        cache[row][col] = max;
        return;
    }
}
