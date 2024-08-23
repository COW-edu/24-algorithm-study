import java.io.*;
import java.util.Arrays;

public class Main {

    static class Input {
        int[][] initCountOfCandyByTestCase;

        Input(int[][] initCountOfCandyByTestCase) {
            this.initCountOfCandyByTestCase = initCountOfCandyByTestCase;
        }
    }

    static class Output {
        int[] countOfCircularByTestCase;

        Output(int[] countOfCircularByTestCase) {
            this.countOfCircularByTestCase = countOfCircularByTestCase;
        }
    }

    public static void main(String[] args) throws IOException {
        Input input = getInput();
        Output output = solve(input);
        resolve(output);
    }

    private static Input getInput() throws IOException {
        Input input;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int testCase = Integer.parseInt(br.readLine());
            int[][] initCountOfCandyByTestCase = new int[testCase][];
            for (int i = 0; i < testCase; i++) {
                br.readLine();
                initCountOfCandyByTestCase[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
            input = new Input(initCountOfCandyByTestCase);
        }
        return input;
    }

    private static void resolve(Output output) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            for (int countOfCircular : output.countOfCircularByTestCase) {
                bw.write(countOfCircular + "\n");
            }
        }
    }

    private static Output solve(Input input) {
        int[][] inputCountOfCandyByTestCase = input.initCountOfCandyByTestCase;
        int[] countOfCircularByTestCase = new int[inputCountOfCandyByTestCase.length];

        for (int i = 0; i < countOfCircularByTestCase.length; i++) {
            countOfCircularByTestCase[i] = localSolve(inputCountOfCandyByTestCase[i]);
        }

        return new Output(countOfCircularByTestCase);
    }

    private static int localSolve(int[] initCountOfCandy) {
        // 짝수로 초기화
        int[] countOfCandy = Arrays.copyOf(initCountOfCandy, initCountOfCandy.length);
        oddToEven(countOfCandy);

        int countOfCircular = 0;
        while (!checkAllSameCandys(countOfCandy)) {
            countOfCircular++;
            countOfCandy = giveHalfToRight(countOfCandy);
            oddToEven(countOfCandy);

            if (countOfCircular > 30) {
                break;
            }
        }

        return countOfCircular;
    }

    private static boolean checkAllSameCandys(int[] countOfCandy) {
        int firstValue = countOfCandy[0];
        for (int i = 1; i < countOfCandy.length; i++) {
            if (firstValue != countOfCandy[i]) {
                return false;
            }
        }
        return true;
    }

    private static int[] giveHalfToRight(int[] countOfCandy) {
        int[] newCountOfCandy = new int[countOfCandy.length];
        for (int i = 0; i < countOfCandy.length; i++) {
            int nextIdx = (i + 1) % countOfCandy.length;
            newCountOfCandy[i] = (countOfCandy[i] + countOfCandy[nextIdx]) / 2;
        }
        return newCountOfCandy;
    }

    private static void oddToEven(int[] countOfCandy) {
        for (int i = 0; i < countOfCandy.length; i++) {
            if (countOfCandy[i] % 2 != 0) {
                countOfCandy[i]++;
            }
        }
    }

}
