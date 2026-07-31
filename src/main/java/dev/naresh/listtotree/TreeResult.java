package dev.naresh.listtotree;

import java.util.List;

public class TreeResult {
    private Node root;
    private List<String> headers;

    public TreeResult(Node root, List<String> headers) {
        this.root = root;
        this.headers = headers;
    }

    public Node getRoot() {
        return root;
    }

    public List<String> getHeaders() {
        return headers;
    }
}
