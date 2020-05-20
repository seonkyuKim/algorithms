import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class JUMPGAME {
    static int[][] board;
    static int[][] cache;
    static int N;

    public static void main(String[] args) throws Exception {
        int T;

        String path = JUMPGAME.class.getResource("").getPath();
        Scanner sc = new Scanner(new File(path + "/input.txt"));
//        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();

        for (int test_case = 0; test_case < T; test_case++) {
            N = sc.nextInt();

            // 보드 초기화
            board = new int[N][N];
            cache = new int[N][N];



            for (int row = 0; row < N; row++) {

                // 보드 초기화
                Arrays.fill(cache[row], -1);
                for (int col = 0; col < N; col++) {
                    board[row][col] = sc.nextInt();
                }
            }


            boolean res = solve(0, 0);
            System.out.println(res? "YES": "NO");

        }
    }

    // 이동할 row, col 변수. 끝에 도달 할 수 있으면 true 반환.
    public static boolean solve(int row, int col) {
        // 범위를 벗어난 경우 false
        if (row >= N || col >= N) return false;

        // 끝일 경우 true
        if (row == N - 1 && col == N - 1) return true;


        // 방문 했을 경우
        if (cache[row][col] != -1) {
            if (cache[row][col] == 1) return true;
            if (cache[row][col] == 0) return false;
        }

        // 이동할 칸 수
        int step = board[row][col];

        // row, col에서 끝에 도달할 수 있는지 알기 위해서는 그 다음 칸에서 끝까지 갈 수 있는지 여부를 알아야 함
        // 갈 수 있다면 캐시 처리
        boolean res = solve(row + step, col) || solve(row, col + step);
        if (res) cache[row][col] = 1;
        else cache[row][col] = 0;

        return res;
    }

}
