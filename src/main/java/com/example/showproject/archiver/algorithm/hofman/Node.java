package com.example.showproject.archiver.algorithm.hofman;

public class Node {

    private Character character;
    private Integer weight;
    private Byte positionStatus;
    private Node child1;
    private Node child2;
    private Node parent;

    public Node(char character, int weight) {
        this.character = character;
        this.weight = weight;
    }

    public Node(Node node1, Node node2) {
        this.child1 = node1;
        this.child2 = node2;

        if (node1.getWeight() < node2.getWeight()) {
            this.getChild1().setPositionStatus((byte) 0);
            this.getChild2().setPositionStatus((byte) 1);
        } else {
            this.getChild1().setPositionStatus((byte) 1);
            this.getChild2().setPositionStatus((byte) 0);
        }
        this.getChild1().setParent(this);
        this.getChild2().setParent(this);
        this.weight = this.getChild1().getWeight() + this.getChild2().getWeight();
    }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Node getChild1() {
        return child1;
    }

    public void setChild1(Node child1) {
        this.child1 = child1;
    }

    public Node getChild2() {
        return child2;
    }

    public void setChild2(Node child2) {
        this.child2 = child2;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Byte getPositionStatus() {
        return positionStatus;
    }

    public void setPositionStatus(Byte positionStatus) {
        this.positionStatus = positionStatus;
    }

    @Override
    public String toString() {
        return character + "";
    }
}
