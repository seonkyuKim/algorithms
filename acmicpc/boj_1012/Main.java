package boj_1012;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int M, N, K;
    static Queue<Point> points;

    public static void main(String[] args) throws Exception {
        String path = boj_1012.Main.class.getResource("").getPath();
        Scanner sc = new Scanner(new File(path + "/input.txt"));
//        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int testCase=0; testCase<T; testCase++) {
            M = sc.nextInt();
            N = sc.nextInt();
            K = sc.nextInt();
            int[][] field = new int[M][N];
            int[][] visited = new int[M][N];
            points = new LinkedList<>();

            for(int i=0; i<K; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                field[x][y] = 1;
                points.add(new Point(x, y));
            }


            System.out.println(countMinWorm(field, visited));

        }
    }

    public static int countMinWorm(int[][] field, int[][] visited) {
        int count = 0;

        while(points.size() != 0) {
            Point p = points.poll();
            // 방문했던 곳이라면 continue;
            if(visited[p.x][p.y] == 1) continue;
            search(field, visited, p.x, p.y);
            count++;
        }

        return count;
    }

    // 현재 위치를 받아서 주변 배추들의 visited 를 1로 변경
    private static void search(int[][] field, int[][] visited, int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        visited[x][y] = 1;

        while(q.size() != 0) {
            Point p = q.poll();
            x = p.x;
            y = p.y;

            // 방문 표시 !!!방문표시는 뺄 때가 아니라 넣을 때 해야 중복이 없어짐!!!
            // 상하좌우 이동
            if (x-1 >= 0 && field[x-1][y] == 1 && visited[x-1][y] == 0) {
                q.add(new Point(x-1, y));
                visited[x-1][y] = 1;
            }
            if (y-1 >= 0 && field[x][y-1] == 1 && visited[x][y-1] == 0) {
                q.add(new Point(x, y-1));
                visited[x][y-1] = 1;
            }
            if (x+1 < M && field[x+1][y] == 1 && visited[x+1][y] == 0) {
                q.add(new Point(x+1, y));
                visited[x+1][y] = 1;
            }
            if (y+1 < N && field[x][y+1] == 1 && visited[x][y+1] == 0) {
                q.add(new Point(x, y+1));
                visited[x][y+1] = 1;
            }
        }
    }
}

class Point {
    public int x;
    public int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
