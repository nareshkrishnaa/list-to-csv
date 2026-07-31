package dev.naresh.listtotree;

import java.util.LinkedList;
import java.util.List;

public class ListToTree {
    public static TreeResult twoDimensionListToTree(List<List<String>> rows) {

        if(rows == null || rows.isEmpty()) {
            throw new IllegalArgumentException("Input cannot be null or empty");
        }

        List<String> headers = new LinkedList<>(rows.get(0));

        Node root = new Node("root");

        for(int rowIndex = 1; rowIndex < rows.size(); rowIndex++) {

            List<String> row = rows.get(rowIndex);

            Node current = root;

            for(String value : row) {

                current.getChildren().putIfAbsent(
                        value,
                        new Node(value)
                );

                current = current.getChildren().get(value);
            }
        }

        return new TreeResult(root, headers);
    }

}
