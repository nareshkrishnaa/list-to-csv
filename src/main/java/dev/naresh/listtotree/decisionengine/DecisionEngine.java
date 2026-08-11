package dev.naresh.listtotree.decisionengine;

import dev.naresh.listtotree.internal.Utility;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;

public class DecisionEngine {
    public static Map<String,String> getDecision(DecisionTree decisionTree, ArrayList<Double> request, int outputColumnsCount){
        return Utility.evaluate(decisionTree,outputColumnsCount,request);
    }
}
