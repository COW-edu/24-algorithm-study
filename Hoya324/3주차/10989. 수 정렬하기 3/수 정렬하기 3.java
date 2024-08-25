import java.io.*;




public class Main{

    
	public static void main(String[] args) throws IOException{

        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(scan.readLine());
        int [] arr = new int [10001];
        
        for (int i = 0; i < N; i++) {
            arr[Integer.parseInt(scan.readLine())]++;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < 10001; i++) {
 
            while (arr[i] > 0) {
                sb.append(i).append("\n");
                arr[i]--;
            }
        }
        
        System.out.print(sb.toString());
        bw.flush();
        bw.close();
    }
}   