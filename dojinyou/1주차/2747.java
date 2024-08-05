import java.io.*;

public class Main {

    static class Input {
        int n;

        Input(int n) {
            this.n = n;
        }
    }

    static class Output {
        int fiboNum;

        Output(int fiboNum) {
            this.fiboNum = fiboNum;
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
            input = new Input(n);
        }
        return input;
    }

    private static void resolve(Output output) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(String.valueOf(output.fiboNum));
        }
    }

    private static Output solve(Input input) {
        int[] fiboNums = new int[input.n + 1];
        fiboNums[0] = 0;
        fiboNums[1] = 1;

        for (int i = 2; i < fiboNums.length; i++) {
            fiboNums[i] = fiboNums[i - 1] + fiboNums[i - 2];
        }

        return new Output(fiboNums[input.n]);
    }

}
