import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;


public class PICNIC {

    static int N;   // 학생의 수
    static int M;   // 친구 쌍의
    static int Answer;


    /*
    풀이: 친구 쌍의 수를 모두 조합하면서 가능한 경우의 수를 다 센다.
     */
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("PICNIC/input.txt"));

        int T = sc.nextInt();


        for (int test_case = 0; test_case < T; test_case++) {
            Answer = 0;     // 정답 초기화
            N = sc.nextInt();   // 학생의 수
            M = sc.nextInt();   // 친구 쌍의 수

            // 친구 쌍을 초기화
            ArrayList<Pair> friendList = new ArrayList<>();

            for (int friends_count = 0; friends_count < M; friends_count++) {
                int first = sc.nextInt();
                int second = sc.nextInt();
                friendList.add(new Pair(first, second));
            }

            count(friendList);

            System.out.println(Answer);
        }

    }

    public static void count(ArrayList<Pair> friendList) {

        countHelper(friendList, new boolean[M], 0, M, N/2);

    }

    // 친구 목록, 뽑힌 친구 쌍의 index, 깊이, 뽑을 수 있는 친구 쌍의 수(M), 뽑아야 하는 친구 쌍 수(r = /2) 이 주어질 때
    // 조합 처럼 친구 목록 중 r 쌍을 뽑는 식으로 간다
    private static void countHelper(ArrayList friendList, boolean[] picked, int depth, int M, int r) {

        // 안 되는 친구들이 뽑혀왔을 경우 return
        if (!isPossible(friendList, picked)) return;

        // 다 뽑았을 경우
        if (r == 0) {
            Answer++;
            return;
        }

        // 깊이가 초과했을 경우
        if (depth == M) return;


        // 친구 쌍을 뽑을 경우
        picked[depth] = true;
        countHelper(friendList, picked, depth+1, M, r-1);

        // 친구 쌍을 안 뽑을 경우
        picked[depth] = false;
        countHelper(friendList, picked, depth+1, M, r);


        return;
    }

    // 모든 학생들이 짝이 지어졌을 경우 반환
    public static boolean matchesAll(int[] students) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] != 1) return false;
        }

        return true;
    }

    public static boolean isPossible(ArrayList<Pair> friendList, boolean[] picked) {

        boolean[] students = new boolean[N];

        for(int i = 0; i < picked.length; i++) {
            // 뽑힌 친구쌍의 경우
            if (picked[i]) {
                int first = friendList.get(i).first;
                int second = friendList.get(i).second;

                // 이미 뽑힌 경우 불가능. false 반환
                if (students[first]) return false;
                if (students[second]) return false;

                // 아닐 경우 true 로 바꾸고 for loop 계속 진행
                students[first] = true;
                students[second] = true;
            }
        }

        return true;

    }
}

class Pair {
    int first;
    int second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
