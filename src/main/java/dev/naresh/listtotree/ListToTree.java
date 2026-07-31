package dev.naresh.listtotree;

import java.util.List;

public class ListToTree {
    public static Node twoDimensionListToTree(List<List<String>> paths){
        Node root = new Node("root");
        for(List<String> path : paths){
            Node current = root;
            for(int i=0;i<path.size();i++){
                current.getChildren().putIfAbsent(path.get(i),new Node(path.get(i)));
                current = current.getChildren().get(path.get(i));
            }
        }
        return root;
    }
}
