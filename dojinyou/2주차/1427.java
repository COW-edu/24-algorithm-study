import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    static class Input {
        int[] numbers;


        Input(int[] numbers) {
            this.numbers = numbers;
        }
    }

    static class Output {
        int[] sortedNumbers;

        Output(int[] sortedNumbers) {
            this.sortedNumbers = sortedNumbers;
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
            String numbersString = br.readLine();
            int[] numbers = new int[numbersString.length()];
            for (int i = 0; i < numbersString.length(); i++) {
                numbers[i] = Integer.parseInt(numbersString.charAt(i) + "");
            }
            input = new Input(numbers);
        }
        return input;
    }

    private static void resolve(Output output) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            for (int number : output.sortedNumbers) {
                bw.write(String.valueOf(number));
            }
        }
    }

    private static Output solve(Input input) {
        int[] sortedNumbers = Arrays.stream(input.numbers)
                .boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();
        return new Output(sortedNumbers);
    }

}
