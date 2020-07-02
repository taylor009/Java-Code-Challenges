package problem.solving;

import java.io.*;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class BirthdayChocolate {
    // Complete the birthday function below.
    static int birthday(List<Integer> s, int d, int m) {
        int[] sums = new int[s.size() + 1];
        int count = 0;

        for(int i = 0; i < s.size(); i++) {

            int sumsIndex = i + 1;
            sums[sumsIndex] = sums[sumsIndex - 1] + s.get(i);

            if (sumsIndex >= m && (sums[sumsIndex] - sums[sumsIndex - m]) == d)
                count++;
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        String[] dm = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int d = Integer.parseInt(dm[0]);

        int m = Integer.parseInt(dm[1]);

        int result = birthday(s, d, m);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
