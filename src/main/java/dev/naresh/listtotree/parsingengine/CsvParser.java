package dev.naresh.listtotree.parsingengine;

import com.opencsv.CSVReader;
import dev.naresh.listtotree.decisionengine.DecisionTree;
import dev.naresh.listtotree.decisionengine.ListToTree;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvParser {
    public static DecisionModel getDecisionTree(InputStream inputStream) {

        List<List<String>> decisionMatrix = new ArrayList<>();

        try (CSVReader reader =
                     new CSVReader(new InputStreamReader(inputStream))) {

            List<String[]> rows = reader.readAll();

            for (String[] row : rows) {
                decisionMatrix.add(Arrays.asList(row));
            }

        } catch (Exception e) {
            throw new RuntimeException("Failed to parse CSV to List<List<String>>", e);
        }
        DecisionTree decisionTree = ListToTree.getDecisionTree(decisionMatrix);
        List<String> headers = decisionMatrix.get(0);
        DecisionModel decisionModel = new DecisionModel(decisionTree,headers);
        return decisionModel;
    }
}
