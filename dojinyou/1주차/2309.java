import java.io.*;
import java.util.Arrays;

public class Main {

    static class Input {
        int[] heights;

        Input(int[] heights) {
            this.heights = heights;
        }
    }

    static class Output {
        int[] sortedCorrectHeights;

        Output(int[] sortedCorrectHeights) {
            this.sortedCorrectHeights = sortedCorrectHeights;
        }
    }

    public static void main(String[] args) throws IOException {
        Input input = getInput();
        Output output = solve(input);
        resolve(output);
    }

    private static Input getInput() throws IOException {
        Input input = new Input(new int[9]);
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            for (int i = 0; i < 9; i++) {
                input.heights[i] = Integer.parseInt(br.readLine());
            }
        }
        return input;
    }

    private static void resolve(Output output) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(String.join("\n", Arrays.stream(output.sortedCorrectHeights).mapToObj(String::valueOf).toArray(String[]::new)));
        }
    }

    private static Output solve(Input input) {
        int diff = -100;
        int[] sortedCorrectHeights = new int[7];
        for (int height : input.heights) {
            diff += height;
        }

        for (int i = 0; i < 9; i++) {
            for (int j = i+1; j < 9; j++) {
                if (diff == input.heights[i] + input.heights[j]) {
                    int idx = 0;
                    for (int k = 0; k < 9; k++) {
                        if (k == i || k == j) {
                            continue;
                        }
                        sortedCorrectHeights[idx++] = input.heights[k];
                    }
                }
            }
        }

        Arrays.sort(sortedCorrectHeights);
        return new Output(sortedCorrectHeights);
    }

}
