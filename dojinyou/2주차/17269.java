import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {

    static class Input {
        String name1;
        String name2;


        Input(String name1, String name2) {
            this.name1 = name1;
            this.name2 = name2;
        }
    }

    static class Output {
        int percent;

        Output(int percent) {
            this.percent = percent;
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
            String[] names = br.readLine().split(" ");
            input = new Input(names[0], names[1]);
        }
        return input;
    }

    private static void resolve(Output output) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(output.percent + "%");
        }
    }


    private static final Map<Character, Integer> alphabetToNumber = new HashMap<>() {{
        put('A', 3);
        put('B', 2);
        put('C', 1);
        put('D', 2);
        put('E', 4);
        put('F', 3);
        put('G', 1);
        put('H', 3);
        put('I', 1);
        put('J', 1);
        put('K', 3);
        put('L', 1);
        put('M', 3);
        put('N', 2);
        put('O', 1);
        put('P', 2);
        put('Q', 2);
        put('R', 2);
        put('S', 1);
        put('T', 2);
        put('U', 1);
        put('V', 1);
        put('W', 1);
        put('X', 2);
        put('Y', 2);
        put('Z', 1);
    }};

    private static Output solve(Input input) {
        int[] scores = getScores(input);
        while (scores.length > 2) {
            scores = getNextScores(scores);
        }
        int percent = scores[0] * 10 + scores[1];
        return new Output(percent);
    }

    private static int[] getNextScores(int[] scores) {
        int[] nextScores = new int[scores.length - 1];
        for (int i = 0; i < nextScores.length; i++) {
            nextScores[i] = (scores[i] + scores[i + 1]) % 10;
        }
        return nextScores;
    }

    private static int[] getScores(Input input) {
        int totalLength = input.name1.length() + input.name2.length();
        int[] scores = new int[totalLength];
        int l = 0, r = 0;
        for (int i = 0; i < totalLength; i++) {
            if (i % 2 == 0 && l < input.name1.length() || r >= input.name2.length()) {
                scores[i] = alphabetToNumber.get(input.name1.charAt(l++));
            } else {
                scores[i] = alphabetToNumber.get(input.name2.charAt(r++));
            }
        }
        return scores;
    }
}
