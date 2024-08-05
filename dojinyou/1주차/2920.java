import java.io.*;
import java.util.Arrays;

public class Main {

    static class Input {
        String nums;

        Input(String nums) {
            this.nums = nums;
        }
    }

    static class Output {
        String direction;

        Output(String direction) {
            this.direction = direction;
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
            bw.write(output.direction);
        }
    }

    private static Output solve(Input input) {
        switch (input.nums) {
            case "1 2 3 4 5 6 7 8":
                return new Output("ascending");
            case "8 7 6 5 4 3 2 1":
                return new Output("descending");
            default:
                return new Output("mixed");
        }
    }

}
