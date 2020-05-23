package bj_5557;


import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        String path = bj_5557.Main.class.getResource("").getPath();
        Scanner sc = new Scanner(new File(path + "./input.txt"));
//        Scanner sc = new Scanner(System.in);


        int N = sc.nextInt();
        int[] input = new int[N-1];
        for(int i=0; i<N-1; i++) {
            input[i] = sc.nextInt();
        }

        int expect = sc.nextInt();
        System.out.println(count(input, 0, input[0], expect));


    }

    // Return: 등식의 개수
    // input: 주어진 숫자의 배열, index: input 배열에서 계산을 완료한 위치, nowResult: 현재 값, result: 기대하는 결과값
    public static int count(int[] input, int index, int nowResult, int expect) {

        if (nowResult < 0 || nowResult > 20) {
            return 0;
        }

        int inputSize = input.length;
        int nextIndex = index + 1;

        // Base Case
        if (inputSize-1 == index) {
            if (nowResult == expect) {
                return 1;
            } else {
                return 0;
            }
        }


        int plusCount = count(input, nextIndex, nowResult+input[nextIndex], expect);    // + 실행
        int minusCount = count(input, nextIndex, nowResult-input[nextIndex], expect);   // - 실행

        return plusCount + minusCount;
    }
}
