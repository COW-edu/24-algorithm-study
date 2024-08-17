import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static class Input {
        String word;


        Input(String word) {
            this.word = word;
        }
    }

    static class Output {
        String encryptedWord;

        Output(String encryptedWord) {
            this.encryptedWord = encryptedWord;
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
            bw.write(output.encryptedWord);
        }
    }

    private static Output solve(Input input) {
        char[] encryptedWord = input.word.toCharArray();

        for (int i = 0; i < encryptedWord.length; i++) {
            char c = encryptedWord[i];
            if (Character.isLetter(c)) {
                int base = Character.isUpperCase(c) ? 'A' : 'a';
                encryptedWord[i] = (char) ((c - base + 13) % 26 + base);
            }
        }
        return new Output(String.valueOf(encryptedWord));
    }

}
