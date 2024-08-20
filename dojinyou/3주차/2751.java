import java.io.*;
import java.util.LinkedList;
import java.util.SortedSet;
import java.util.TreeSet;

public class Main {

    static class Input {
        SortedSet<Integer> sortedNumber;

        Input(SortedSet<Integer> sortedNumber) {
            this.sortedNumber = sortedNumber;
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
            SortedSet<Integer> sortedNumber = new TreeSet<>();
            int size = Integer.parseInt(br.readLine());
            for (int i = 0; i < size; i++) {
                sortedNumber.add(Integer.parseInt(br.readLine()));
            }
            input = new Input(sortedNumber);
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
        for (Integer number : input.sortedNumber) {
            sb.append(number).append("\n");
        }
        return new Output(sb.toString());
    }

}
