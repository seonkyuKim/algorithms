import java.util.Scanner;
import java.io.File;

public class BOARDCOVER {

    static int H;
    static int W;
    static int Answer;


    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("BOARDCOVER/input.txt"));
//        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 0; test_case < T; test_case++) {
            Answer = 0;     // 답변 초기화
            H = sc.nextInt();   // Height
            W = sc.nextInt();   // Width

            char[][] board = new char[H][W];

            // 보드 초기화
            for (int y = 0; y < H; y++) {
                String boardLine = sc.next();
                for (int x = 0; x < W; x++) {
                    board[y][x] = boardLine.charAt(x);
                }
            }

            countCompleteBoard(board);

            System.out.println(Answer);
        }
    }

    /*
    L 자 모양의 블럭은 다음과 같이 네 가지 경우가 존재한다.
    A  | B  | C  | D
    ## | ## | .# | #.
    #. | .# | ## | ##

    이 때 (y, x)를 기준으로 이를 좌표로 나타낸다면
    A                   | B
    (y, x) (y, x+1)     | (y, x) (y, x+1)
    (y+1, x)            |      (y+1, x+1)

    C                   | D
                 (y, x) | (y, x)
    (y+1, x-1) (y+1, x) | (y+1, x) (y+1, x+1)
    */
    public static void countCompleteBoard(char[][] board) {
        // 시작 Index 찾기
        int[] startIndex = findStartIndex(board);

        // 보드가 다 채워져 시작 index 가 없는 경우 true 반환
        if (startIndex == null) {
            Answer++;
            return;
        }

        // A 타입 대입
        // 안될 경우 pass
        // 될 경우 재귀 함수 호출
        char[][] boardWithA = makeBoardWithA(deepCopy(board), startIndex[0], startIndex[1]);
        if (boardWithA != null) {
            countCompleteBoard(boardWithA);
        }

        // B 타입 대입
        char[][] boardWithB = makeBoardWithB(deepCopy(board), startIndex[0], startIndex[1]);
        if (boardWithB != null) {
            countCompleteBoard(boardWithB);
        }

        // C 타입 대입
        char[][] boardWithC = makeBoardWithC(deepCopy(board), startIndex[0], startIndex[1]);
        if (boardWithC != null) {
            countCompleteBoard(boardWithC);
        }
        // D 타입 대입
        char[][] boardWithD = makeBoardWithD(deepCopy(board), startIndex[0], startIndex[1]);
        if (boardWithD != null) {
            countCompleteBoard(boardWithD);
        }

        // A, B, C, D 타입 모두 안될 경우 false 반환
        return;
    }

    // D
    // (y, x)
    // (y+1, x) (y+1, x+1)
    private static char[][] makeBoardWithD(char[][] board, int y, int x) {
        // 보드 밖을 나갈 경우
        if ( x+1 >= W || y+1 >= H ) return null;

        // 채울 수 없는 경우
        if ( board[y+1][x] == '#' || board[y+1][x+1] == '#' ) return null;

        board[y][x] = '#';
        board[y+1][x] = '#';
        board[y+1][x+1] = '#';

        return board;
    }

    // C
    //              (y, x)
    // (y+1, x-1) (y+1, x)
    private static char[][] makeBoardWithC(char[][] board, int y, int x) {
        // 보드 밖을 나갈 경우
        if ( x-1 < 0 || y+1 >= H ) return null;

        // 채울 수 없는 경우
        if ( board[y+1][x-1] == '#' || board[y+1][x] == '#' ) return null;

        board[y][x] = '#';
        board[y+1][x-1] = '#';
        board[y+1][x] = '#';

        return board;
    }

    // B
    // (y, x) (y, x+1)
    //      (y+1, x+1)
    private static char[][] makeBoardWithB(char[][] board, int y, int x) {
        // 보드 밖을 나갈 경우
        if ( x+1 >= W || y+1 >= H ) return null;

        // 채울 수 없는 경우
        if ( board[y][x+1] == '#' || board[y+1][x+1] == '#' ) return null;

        board[y][x] = '#';
        board[y][x+1] = '#';
        board[y+1][x+1] = '#';

        return board;
    }

    //   A
    //  (y, x) (y, x+1)
    //  (y+1, x)
    private static char[][] makeBoardWithA(char[][] board, int y, int x) {
        // 보드 밖을 나갈 경우
        if ( x+1 >= W || y+1 >= H ) return null;

        // 채울 수 없는 경우
        if ( board[y][x+1] == '#' || board[y+1][x] == '#' ) return null;

        board[y][x] = '#';
        board[y][x+1] = '#';
        board[y+1][x] = '#';

        return board;
    }

    // Input: Board
    // Output: 처음으로 빈 칸이 나오는 [y, x]
    private static int[] findStartIndex(char[][] board) {
        for (int y = 0; y < H; y++) {
            for (int x = 0; x < W; x++) {
                if (board[y][x] == '.') return new int[]{ y, x };
            }
        }

        // 빈 칸이 없을 경
        return null;
    }

    private static char[][] deepCopy(char[][] original) {
        if (original == null) {
            return null;
        }

        int y = original.length;
        int x = original[0].length;
        char[][] result = new char[y][x];
        for (int i = 0; i < original.length; i++) {
            System.arraycopy(original[i], 0, result[i], 0, original[i].length);
        }
        return result;
    }

}
