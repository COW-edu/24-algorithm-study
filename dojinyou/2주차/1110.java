import java.io.*;

public class Main {

    static class Input {
        int num;


        Input(int num) {
            this.num = num;
        }
    }

    static class Output {
        int circleSize;

        Output(int circleSize) {
            this.circleSize = circleSize;
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
            int num = Integer.parseInt(br.readLine());
            input = new Input(num);
        }
        return input;
    }

    private static void resolve(Output output) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(String.valueOf(output.circleSize));
        }
    }

    private static Output solve(Input input) {
        int origin = input.num;

        int circleSize = 1;
        int operatedNum = operate(origin);

        while (origin != operatedNum) {
            operatedNum = operate(operatedNum);
            circleSize++;
        }

        return new Output(circleSize);
    }

    private static int operate(int prevNum) {
        return (prevNum % 10) * 10 + (prevNum % 10 + prevNum / 10) % 10;
    }

}
