import java.io.*;

public class Main {

    static class Input {
        String word;


        Input(String word) {
            this.word = word;
        }
    }

    static class Output {
        int isPalindrome;

        Output(Boolean isPalindrome) {
            this.isPalindrome = isPalindrome ? 1 : 0;
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
            bw.write(String.valueOf(output.isPalindrome));
        }
    }

    private static Output solve(Input input) {
        boolean isPalindrome = true;
        for (int i = 0; i < input.word.length() / 2; i++) {
            if (input.word.charAt(i) != input.word.charAt(input.word.length() - 1 - i)) {
                isPalindrome = false;
                break;
            }
        }

        return new Output(isPalindrome);
    }

}
