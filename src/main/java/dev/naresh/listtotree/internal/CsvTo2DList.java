package dev.naresh.listtotree.internal;

import com.opencsv.CSVReader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvTo2DList {

    public static List<List<String>> parse(InputStream inputStream) {

        List<List<String>> result = new ArrayList<>();

        try (CSVReader reader =
                     new CSVReader(new InputStreamReader(inputStream))) {

            List<String[]> rows = reader.readAll();

            for (String[] row : rows) {
                result.add(Arrays.asList(row));
            }

        } catch (Exception e) {
            throw new RuntimeException("Failed to parse CSV", e);
        }

        return result;
    }
}

