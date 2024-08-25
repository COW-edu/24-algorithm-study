import java.io.*;
import java.util.Arrays;

public class Main {

    static class Input {
        int[] dayOfFullyGrownById;

        Input(int[] dayOfFullyGrownById) {
            this.dayOfFullyGrownById = dayOfFullyGrownById;
        }
    }

    static class Output {
        int maxDays;

        Output(int maxDays) {
            this.maxDays = maxDays;
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
            br.readLine();
            int[] dayOfFullyGrownById = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            input = new Input(dayOfFullyGrownById);
        }
        return input;
    }

    private static void resolve(Output output) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(String.valueOf(output.maxDays));
        }
    }

    private static Output solve(Input input) {
        int[] sortedDayOfFullyGrown = Arrays.stream(input.dayOfFullyGrownById).sorted().toArray();

        int maxDays = 0;
        for (int i = 1; i <= sortedDayOfFullyGrown.length; i++) {
            int dayOfFullyGrown = sortedDayOfFullyGrown[sortedDayOfFullyGrown.length - i];
            maxDays = Math.max(maxDays, dayOfFullyGrown + i);
        }

        return new Output(maxDays + 1);
    }

}
