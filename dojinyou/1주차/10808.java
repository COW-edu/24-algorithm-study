import java.io.*;
import java.util.Arrays;

public class Main {

    static class Input {
        String word;

        Input(String word) {
            this.word = word;
        }
    }

    static class Output {
        int[] alphabetCount;

        Output(int[] alphabetCount) {
            this.alphabetCount = alphabetCount;
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
            input = new Input(br.readLine());
        }
        return input;
    }

    private static void resolve(Output output) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(String.join(" ", Arrays.stream(output.alphabetCount).mapToObj(String::valueOf).toArray(String[]::new)));
        }
    }

    private static Output solve(Input input) {
        int[] alphabetCount = new int[26];
        for (char c : input.word.toCharArray()) {
            int idx = c - 'a';
            alphabetCount[idx]++;
        }
        return new Output(alphabetCount);
    }

}
