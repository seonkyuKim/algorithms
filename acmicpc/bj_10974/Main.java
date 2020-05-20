package bj_10974;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        permutation(N);

    }

    public static void permutation(int N) {
        boolean[] visited = new boolean[N];
        LinkedList<Integer> permutation = new LinkedList<>();
        helperPermutation(N, visited, permutation);

    }

    private static void helperPermutation(int N, boolean[] visited, LinkedList<Integer> permutation) {

        if (permutation.size() == N) {
            printList(permutation);
            return;
        }

        for(int i = 0; i < N; i++) {
            // 방문을 안 한 경우
            if(!visited[i]) {
                // DFS
                visited[i] = true;
                permutation.add(i+1);
                helperPermutation(N, visited, permutation);

                // 다시 빼줌
                visited[i] = false;
                permutation.removeLast();
            }
        }

    }

    public static <T> void printList(LinkedList<T> list) {
        int size = list.size();
        for (int i=0; i<size; i++) {

            System.out.print(list.get(i));
            System.out.print(' ');
        }
        System.out.println();
    }
}
