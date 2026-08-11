package dev.naresh.listtotree.parsingengine;

import dev.naresh.listtotree.decisionengine.DecisionTree;

import java.util.List;

public class DecisionModel {
    private DecisionTree decisionTree;
    private List<String> requestHeaders;

    public DecisionModel(DecisionTree decisionTree, List<String> requestHeaders) {
        this.decisionTree = decisionTree;
        this.requestHeaders = requestHeaders;
    }

    public DecisionTree getDecisionTree() {
        return decisionTree;
    }

    public void setDecisionTree(DecisionTree decisionTree) {
        this.decisionTree = decisionTree;
    }



}
