package dev.naresh.listtotree;

import dev.naresh.listtotree.decisionengine.ListToTree;
import dev.naresh.listtotree.internal.Node;
import dev.naresh.listtotree.decisionengine.DecisionTree;
import dev.naresh.listtotree.internal.Utility;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MyTest {

    public static void main(String[] args) {
        List<List<String>> data = List.of(
                List.of("a", "b", "c", "d", "e", "offer", "rate", "tenure"),

                List.of("[0,4]", "[0,4]", "[0,5]", "[0,3]", "[0,2]", "5000", "18.99", "24"),
                List.of("[0,4]", "[0,4]", "[0,5]", "[0,3]", "(2,5]", "10000", "16.99", "36"),
                List.of("[0,4]", "[0,4]", "(5,10]", "[0,6]", "[0,5]", "15000", "15.99", "36"),

                List.of("[0,4]", "(4,10]", "[0,5]", "[0,3]", "[0,2]", "20000", "14.99", "36"),
                List.of("[0,4]", "(4,10]", "[0,5]", "(3,7]", "(2,5]", "25000", "13.99", "48"),
                List.of("[0,4]", "(4,10]", "(5,10]", "(7,10]", "(5,10]", "30000", "12.99", "48"),

                List.of("(4,7]", "[0,7]", "[0,4]", "[0,5]", "[0,3]", "35000", "11.99", "48"),
                List.of("(4,7]", "[0,7]", "[0,4]", "(5,10]", "(3,6]", "40000", "10.99", "60"),
                List.of("(4,7]", "[0,7]", "(4,10]", "[0,5]", "(6,10]", "45000", "10.49", "60"),

                List.of("(4,7]", "(7,10]", "[0,5]", "[0,4]", "[0,4]", "50000", "9.99", "60"),
                List.of("(4,7]", "(7,10]", "[0,5]", "(4,8]", "(4,8]", "55000", "9.49", "72"),
                List.of("(4,7]", "(7,10]", "(5,10]", "(8,10]", "(8,10]", "60000", "8.99", "72"),

                List.of("(7,10]", "[0,8]", "[0,5]", "[0,5]", "[0,5]", "65000", "8.49", "72"),
                List.of("(7,10]", "[0,8]", "[0,5]", "(5,10]", "(5,10]", "70000", "7.99", "72"),
                List.of("(7,10]", "[0,8]", "(5,10]", "[0,5]", "(5,10]", "75000", "7.49", "84"),

                List.of("(7,10]", "(8,10]", "[0,5]", "[0,5]", "[0,5]", "80000", "6.99", "84"),
                List.of("(7,10]", "(8,10]", "[0,5]", "(5,10]", "(5,10]", "90000", "6.49", "96"),
                List.of("(7,10]", "(8,10]", "(5,10]", "(5,10]", "(5,10]", "100000", "5.99", "96")
        );

        DecisionTree decisionTree = ListToTree.getDecisionTree(data);
        System.out.println(decisionTree.getHeaders());
        Node.printTree(decisionTree.getRoot());

        ArrayList<Double> request = new ArrayList<>(
                List.of(
                        5.0, // a -> (4,7]
                        5.0, // b -> [0,7]
                        3.0, // c -> [0,4]
                        2.0, // d -> [0,5]
                        2.0  // e -> [0,3]
                )
        );

        Map<String, String> result = Utility.evaluate(decisionTree,3,request);
        System.out.println(result);
    }
}
