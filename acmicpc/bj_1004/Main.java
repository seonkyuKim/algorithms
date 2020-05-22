package bj_1004;

import java.io.*;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws Exception {
        String path = bj_1004.Main.class.getResource("").getPath();
        BufferedReader br = new BufferedReader(new FileReader(path + "./input.txt"));

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int testCase = 0; testCase < T; testCase++) {
            int answer = 0;
            int x1, y1, x2, y2;

            String[] input = br.readLine().split(" ");

            x1 = Integer.parseInt(input[0]);
            y1 = Integer.parseInt(input[1]);
            x2 = Integer.parseInt(input[2]);
            y2 = Integer.parseInt(input[3]);

            int N = Integer.parseInt(br.readLine());

            while(N-- > 0) {
                String[] circle = br.readLine().split(" ");
                int Cx, Cy, r;
                Cx = Integer.parseInt(circle[0]);
                Cy = Integer.parseInt(circle[1]);
                r = Integer.parseInt(circle[2]);

                // 둘 다 같은 원 안에 있는 경우는 제외
                // 각각 하나의 원 안에만 있을 경우 answer++
                boolean isP1Inside = isInside(x1, y1, Cx, Cy, r);
                boolean isP2Inside = isInside(x2, y2, Cx, Cy, r);

                if (isP1Inside && isP2Inside) {
                    continue;
                } else if(isP1Inside || isP2Inside) {
                    answer++;
                }
            }
            System.out.println(answer);
        }
    }

    // x, y가 (Cx, Cy, r) 안에 있는지 확인
    private static boolean isInside(int x, int y, int Cx, int Cy, int r) {
        return (Cx - x) * (Cx - x) + (Cy - y) * (Cy - y) < r * r;

    }
}
