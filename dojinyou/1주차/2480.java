import java.io.*;

public class Main {

    static class Input {
        int num1;
        int num2;
        int num3;

        Input(int num1, int num2, int num3) {
            this.num1 = num1;
            this.num2 = num2;
            this.num3 = num3;
        }
    }

    static class Output {
        int reward;

        Output(int reward) {
            this.reward = reward;
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
            String[] str = br.readLine().split(" ");
            input = new Input(Integer.parseInt(str[0]), Integer.parseInt(str[1]), Integer.parseInt(str[2]));
        }
        return input;
    }

    private static void resolve(Output output) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(String.valueOf(output.reward));
        }
    }

    private static Output solve(Input input) {
        int reward;
        if (input.num1 == input.num2 && input.num2 == input.num3) {
            reward = input.num1 * 1000 + 10000;
        } else if (input.num1 != input.num2 && input.num1 != input.num3 && input.num2 != input.num3) {
            int max = Math.max(Math.max(input.num1, input.num2), input.num3);
            reward = max * 100;
        } else {
            int sameNum;
            if (input.num1 == input.num2 || input.num1 == input.num3) {
                sameNum = input.num1;
            } else {
                sameNum = input.num2;
            }
            reward = sameNum * 100 + 1000;
        }
        return new Output(reward);
    }
}
