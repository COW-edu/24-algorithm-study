import java.io.*;
import java.util.Arrays;

public class Main {

    static class Input {
        int numOfInteger;
        int[] averages;

        Input(int numOfInteger, int[] averages) {
            this.numOfInteger = numOfInteger;
            this.averages = averages;
        }
    }

    static class Output {
        int[] integers;

        Output(int[] integers) {
            this.integers = integers;
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
            String str = br.readLine();
            int numOfIntegers = Integer.parseInt(str);
            int[] averages = Arrays
                    .stream(br.readLine().split(" "))
                    .mapToInt(Integer::valueOf)
                    .toArray();
            input = new Input(numOfIntegers, averages);
        }
        return input;
    }

    private static void resolve(Output output) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            for (int i = 0; i < output.integers.length; i++) {
                int integer = output.integers[i];
                bw.write(String.valueOf(integer));
                if (i < output.integers.length - 1) {
                    bw.write(" ");
                }
            }
        }
    }

    private static Output solve(Input input) {
        int prevSum = 0;
        int[] integers = new int[input.numOfInteger];
        for (int i = 0; i < input.numOfInteger; i++) {
            int sum = input.averages[i] * (i + 1);
            integers[i] = sum - prevSum;
            prevSum = sum;
        }
        return new Output(integers);
    }

}
