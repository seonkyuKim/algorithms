import java.io.File;
import java.util.Scanner;

public class BOOGLE {

    /*
    메모제이션으로 수정 필요
     */
    static char[][] board = new char[5][5];
    static int[] dx = new int[]{-1, 0, 1, 1, 1, 0, -1, -1};
    static int[] dy = new int[]{1, 1, 1, 0, -1, -1, -1, 0};

    public static void main(String[] args) throws Exception {
//        Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(new File("BOOGLE/input.txt"));
        int T = sc.nextInt();

        for (int test_case = 0; test_case < T; test_case++) {
            // board 초기화
            for (int i = 0; i < 5; i++) {
                String letters = sc.next();
                for (int j = 0; j < 5; j++) {
                    board[i][j] = letters.charAt(j);
                }
            }


            int N = sc.nextInt();
            String[] words = new String[N];
            for (int i = 0; i < N; i++) {
                words[i] = sc.next();
            }

            // 각각의 단어에 대하여 실행
            for (String word : words) {
                // 해당 단어를 갖고 있는지 여부를 나타내는
                boolean hasWord = false;
                // (0, 0) 부터 (5, 5)까지 iterate
                for (int i = 0; i < 5; i++) {
                    for (int j =0; j < 5; j++) {
                        hasWord = hasWord(i, j, word);
                        if (hasWord) break;
                    }
                    if (hasWord) break;
                }

                // 단어를 갖고 있을 경우 YES 출력
                System.out.printf("%s ", word);
                if (hasWord) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }

            }

        }

    }


    public static boolean hasWord(int y, int x, String word) {
        // 보드 판을 넘어갔을 경우 false
        if (y < 0 || y > 4 || x < 0 || x > 4) return false;

        // 첫 글자가 다를 경우 false
        if (board[y][x] != (word.charAt(0))) return false;

        // 남은 글자 수가 한 자리이고 첫 글자가 같을 경우 true
        if (word.length() == 1 && board[y][x] == (word.charAt(0))) return true;

        // 남은 글자 수가 한 자리이고 첫 글자가 다를

        boolean flag = false;
        // 8 방향으로 다음 칸으로 이동
        for (int i = 0; i < 8; i++) {
            // 맨 앞 글자를 제외한 글자 입력
            flag = flag || hasWord(y + dy[i], x + dx[i], word.substring(1));
        }

        return flag;

    }

}
