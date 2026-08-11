package dev.naresh.listtotree.decisionengine;

import dev.naresh.listtotree.internal.Node;

import java.util.List;

public class DecisionTree {
    private Node root;
    private List<String> headers;

    public DecisionTree(Node root, List<String> headers) {
        this.root = root;
        this.headers = headers;
    }

    public Node getRoot() {
        return root;
    }

    public List<String> getHeaders() {
        return headers;
    }

    public void  printDecisionTree(){
        Node.printTree(root);
    }
}
