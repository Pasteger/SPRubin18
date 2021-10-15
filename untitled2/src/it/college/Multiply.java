package it.college;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Multiply {

    public int multiply() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(
                "D:\\Programs\\JavaProject\\untitled2\\src\\it\\college\\txt.txt"));
        String line;
        StringBuilder text = new StringBuilder();
        String ls = System.getProperty("line.separator");
        while ((line = reader.readLine()) != null) {
            text.append(line);
            text.append(ls);
        }
        text.deleteCharAt(text.length() - 1);

        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(text);

        int indexMultiplierOne0 = 0;
        int indexMultiplierOne1 = 0;
        int indexMultiplierTwo0 = 0;
        int indexMultiplierTwo1 = 0;
        boolean iteration = true;
        while (matcher.find()) {
            if (iteration) {
                indexMultiplierOne0 = matcher.start();
                indexMultiplierOne1 = matcher.end();
                iteration = false;
                continue;
            }
            indexMultiplierTwo0 = matcher.start();
            indexMultiplierTwo1 = matcher.end();
        }
        double multiplier0 = Double.parseDouble(text.substring(indexMultiplierOne0, indexMultiplierOne1));
        double multiplier1 = Double.parseDouble(text.substring(indexMultiplierTwo0, indexMultiplierTwo1));
        return (int) ((int) multiplier0/(1/multiplier1));
    }
}
