package ExamPreparation.Exam24July2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Trains {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        double[] arrivals = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .sorted().toArray();
        double[] departures = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .sorted().toArray();

        int platforms = 0;
        int maxPlatforms = 0;

        for (int i = 0, j = 0; i < arrivals.length; ) {
            if (arrivals[i] < departures[j]) {
                platforms++;
                i++;
                if (platforms > maxPlatforms) {
                    maxPlatforms = platforms;
                }
            } else {
                platforms--;
                j++;
            }
        }

        System.out.println(maxPlatforms);
    }
}
