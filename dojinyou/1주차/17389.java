import java.io.*;

public class Main {

    static class Input {
        int numOfProblems;
        String results;

        Input(int numOfProblems, String results) {
            this.numOfProblems = numOfProblems;
            this.results = results;
        }
    }

    static class Output {
        int score;

        Output(int score) {
            this.score = score;
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
            int n = Integer.parseInt(br.readLine());
            String results = br.readLine();
            input = new Input(n, results);
        }
        return input;
    }

    private static void resolve(Output output) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(String.valueOf(output.score));
        }
    }

    private static Output solve(Input input) {
        int score = 0;
        int bonus = 0;

        for (int i = 0; i < input.numOfProblems; i++) {
            if (input.results.charAt(i) == 'O') {
                score += i + 1;
                score += bonus;
                bonus++;
            } else {
                bonus = 0;
            }
        }

        return new Output(score);
    }

}
