package bj_1062;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws Exception {
        String path = bj_1062.Main.class.getResource("").getPath();
        //Scanner sc = new Scanner(new File(path + "/input.txt"));
        BufferedReader br = new BufferedReader(new FileReader(path + "/input.txt"));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        int N = Integer.parseInt(s[0]);   // number of words
        int K = Integer.parseInt(s[1]);   // number of letters teacher can teach



        if (K < 5) {
            // MUST_HAVE 글자도 가르치지 못하면 단어를 읽을 수 없음
            System.out.println(0);
            return;
        } else if (K == 26) {
            // 다 배울 경우 모두 읽을 수 있음
            System.out.println(N);
        }

        String[] words = new String[N];
        for (int i=0; i<N; i++) {
            String word = br.readLine();
            words[i] = word.replaceAll("[antic]", "");
        }

        int answer = maxReadableWords(words, K);
        System.out.println(answer);

    }

    // a b c d e
    // f g h i j
    // k l m n o
    // p q r s t
    // u v w x y
    // z
    public static int maxReadableWords(String[] words, int K) {
        boolean[] learned = new boolean[26];
        learned[0] = true;  // a
        learned[13] = true; // n
        learned[19] = true; // t
        learned[8] = true;  // i
        learned[2] = true;  // c

        return helperMaxReadableWords(words, K, learned, 5, 0);

    }

    // K = 배울 수 있는 단어 수
    // count = 배운 단어 수
    // start = 다음 재귀를 시작할 index
    private static int helperMaxReadableWords(String[] words, int K, boolean[] learned, int count, int start) {
        if (count == K) {
            return countWords(words, learned);
        }

        int max = -1;

        for(int i = start; i < 26; i++) {
            // 안 배웠을 경우 그 단어를 배우고 재귀
            if(!learned[i]) {
                learned[i] = true;
                count++;
                max = Math.max(helperMaxReadableWords(words, K, learned, count, start+1), max);

                learned[i] = false;
                count--;
            }
        }

        return max;

    }

    private static int countWords(String[] words, boolean[] learned) {
        int count = 0;
        // 각각의 단어에 대해
        for(String word : words) {
            boolean canRead = true;
            // 각각의 글자에 대해
            for(char c : word.toCharArray()) {

                // 안 배웠을 경우 못 읽고 다음 단어
                if (!learned[c - 97]) {
                    canRead = false;
                    break;
                }
            }
            if (canRead) count++;
        }

        return count;
    }
}
