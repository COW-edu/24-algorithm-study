import java.io.*;
import java.util.Arrays;

public class Main {

    static class Input {
        int numOfStudents;
        int[] scores;

        Input(int numOfStudents, int[] scores) {
            this.numOfStudents = numOfStudents;
            this.scores = scores;
        }
    }

    static class Output {
        int maxScoreDiff;

        Output(int maxScoreDiff) {
            this.maxScoreDiff = maxScoreDiff;
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
            int n = Integer.parseInt(str);
            int[] scores = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            input = new Input(n, scores);
        }
        return input;
    }

    private static void resolve(Output output) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(String.valueOf(output.maxScoreDiff));
        }
    }

    private static Output solve(Input input) {
        int maxScore = 0;
        int minScore = 1000;

        for(int score : input.scores) {
            if(score > maxScore) {
                maxScore = score;
            }
            if(score < minScore) {
                minScore = score;
            }
        }

        return new Output(maxScore - minScore);
    }

}
