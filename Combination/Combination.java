import java.util.Scanner;
import java.io.File;


// https://bcp0109.tistory.com/15
public class Combination {
    static int[] arr;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("Combination/input.txt"));

        int N = sc.nextInt();
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        comByRecursive(arr, 3);

    }

    public static void comByRecursive(int[] arr, int r) {
        int N = arr.length;
        boolean[] visited = new boolean[N];

        comByRecursiveHelper(arr, visited, 0, N, r);
    }

    private static void comByRecursiveHelper(int[] arr, boolean[] visited, int depth, int n, int r) {
        // 다 뽑은 경우 종료
        if (depth == n) return;
        if (r == 0) {
            System.out.println(visited);
            return;
        }

        // visited 가 뽑힌 원소들을 나타냄
        visited[depth] = true;
        comByRecursiveHelper(arr, visited, depth+1, n, r-1);

        visited[depth] = false;
        comByRecursiveHelper(arr, visited, depth+1, n, r);
    }
}
