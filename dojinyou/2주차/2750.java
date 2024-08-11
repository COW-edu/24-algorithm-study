import java.io.*;
import java.util.Arrays;

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
            int numOFNumbers = Integer.parseInt(br.readLine());
            int[] numbers = new int[numOFNumbers];
            for (int i = 0; i < numOFNumbers; i++) {
                numbers[i] = Integer.parseInt(br.readLine());
            }
            input = new Input(numbers);
        }
        return input;
    }

    private static void resolve(Output output) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            for (int number : output.sortedNumbers) {
                bw.write(number + "\n");
            }
        }
    }

    private static Output solve(Input input) {
        int[] sortedNumbers = Arrays.stream(input.numbers).sorted().toArray();
        return new Output(sortedNumbers);
    }
}
