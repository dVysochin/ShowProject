package com.example.showproject.archiver.algorithm.bean;

import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class CharacterByteCode {

    private Deque<Byte> bytes = new LinkedList<>();

    public void add(Byte b) {
        bytes.add(b);
    }

    @Override
    public String toString() {
        return bytes.stream()
                .map(Object::toString)
                .collect(Collectors.joining(""));
    }
}
