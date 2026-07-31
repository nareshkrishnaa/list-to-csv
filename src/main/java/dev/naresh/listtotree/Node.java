package dev.naresh.listtotree;


import java.util.LinkedHashMap;
import java.util.Map;

public class Node {
    private String value;
    private Map<String,Node> children = new LinkedHashMap<>();

    public static void printTree(Node node) {
        printTree(node, "",true);
    }

    public static void printTree(Node node, String prefix, boolean isLast) {
        if (node == null) {
            return;
        }

        System.out.println(
                prefix + (isLast ? "└── " : "├── ") + node.getValue()
        );

        int size = node.getChildren().size();
        int index = 0;

        for (Node child : node.getChildren().values()) {
            index++;
            printTree(
                    child,
                    prefix + (isLast ? "    " : "│   "),
                    index == size
            );
        }
    }

    public Node(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public Map<String, Node> getChildren() {
        return children;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setChildren(Map<String, Node> children) {
        this.children = children;
    }
}
