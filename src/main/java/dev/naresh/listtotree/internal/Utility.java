package dev.naresh.listtotree.internal;

import dev.naresh.listtotree.decisionengine.DecisionTree;

import java.util.*;

public class Utility {
    public static boolean fitsInRange(String range, Double input) {

        if (range == null || input == null) {
            return false;
        }

        range = range.trim();

        boolean lowerInclusive = range.startsWith("[");
        boolean upperInclusive = range.endsWith("]");

        String values = range.substring(1, range.length() - 1);
        String[] parts = values.split(",");

        if (parts.length != 2) {
            throw new IllegalArgumentException("Invalid range: " + range);
        }

        double lower = Double.parseDouble(parts[0].trim());
        double upper = Double.parseDouble(parts[1].trim());

        boolean lowerMatch = lowerInclusive
                ? input >= lower
                : input > lower;

        boolean upperMatch = upperInclusive
                ? input <= upper
                : input < upper;

        return lowerMatch && upperMatch;
    }

    public static Map<String, String> evaluate(
            DecisionTree decisionTree,
            int outputColumns,
            ArrayList<Double> request
    ) {

        if (decisionTree == null) {
            throw new IllegalArgumentException("TreeResult cannot be null");
        }

        if (request == null) {
            throw new IllegalArgumentException("Request cannot be null");
        }

        List<String> headers = decisionTree.getHeaders();

        int expectedInputs = headers.size() - outputColumns;

        if (request.size() != expectedInputs) {
            throw new IllegalArgumentException(
                    String.format(
                            "Expected %d inputs but received %d",
                            expectedInputs,
                            request.size()
                    )
            );
        }

        Node current = decisionTree.getRoot();

        for (Double input : request) {

            Node matchingChild = null;

            for (Node child : current.getChildren().values()) {

                if (Utility.fitsInRange(child.getValue(), input)) {
                    matchingChild = child;
                    break;
                }
            }

            if (matchingChild == null) {
                throw new IllegalArgumentException(
                        "No matching range found for input: " + input
                );
            }

            current = matchingChild;
        }

        if (current.getChildren().isEmpty()) {
            throw new IllegalStateException(
                    "No output values found for matching rule"
            );
        }

        Map<String, String> result = new LinkedHashMap<>();

        int outputHeaderStartIndex =
                headers.size() - outputColumns;

        Node outputNode = current.getChildren()
                .values()
                .iterator()
                .next();

        for (int i = outputHeaderStartIndex;
             i < headers.size();
             i++) {

            if (outputNode == null) {
                throw new IllegalStateException(
                        "Tree structure does not contain enough output values"
                );
            }

            result.put(
                    headers.get(i),
                    outputNode.getValue()
            );

            if (!outputNode.getChildren().isEmpty()) {
                outputNode = outputNode.getChildren()
                        .values()
                        .iterator()
                        .next();
            } else {
                outputNode = null;
            }
        }

        return result;
    }
}
