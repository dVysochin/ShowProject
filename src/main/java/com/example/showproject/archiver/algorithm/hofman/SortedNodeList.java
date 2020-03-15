package com.example.showproject.archiver.algorithm.hofman;

import java.util.*;

public class SortedNodeList {

    private ArrayList<Node> list = new ArrayList<>();

    public int size() {
        return list.size();
    }

    public void add(Node node) {
        list.add(node);
        list.sort(Comparator.comparing(Node::getWeight));
    }

    public void remove(Node node) {
        list.remove(node);
    }

    public Node get(int i) {
        return list.get(i);
    }

    public List<Node> getNodes() {
        return new ArrayList<>(list);
    }
}
