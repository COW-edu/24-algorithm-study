import java.io.*;

public class Main {

    static class Input {
        int[] numberCounts;

        Input(int[] numberCounts) {
            this.numberCounts = numberCounts;
        }
    }

    static class Output {
        String sortedNumberLines;

        Output(String sortedNumberLines) {
            this.sortedNumberLines = sortedNumberLines;
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
            int[] numberCounts = new int[10001];
            int size = Integer.parseInt(br.readLine());
            for (int i = 0; i < size; i++) {
                numberCounts[Integer.parseInt(br.readLine())]++;
            }
            input = new Input(numberCounts);
        }
        return input;
    }

    private static void resolve(Output output) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(output.sortedNumberLines);
        }
    }

    private static Output solve(Input input) {
        StringBuilder sb = new StringBuilder();
        for (int number = 0; number < input.numberCounts.length; number++) {
            int count = input.numberCounts[number];
            if (count == 0) {
                continue;
            }
            sb.append(String.format("%d\n", number).repeat(count));
        }
        return new Output(sb.toString());
    }

}
