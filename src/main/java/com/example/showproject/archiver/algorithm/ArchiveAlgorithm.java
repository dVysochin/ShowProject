package com.example.showproject.archiver.algorithm;

import com.example.showproject.archiver.algorithm.bean.CharacterByteCode;

import java.util.Map;

public interface ArchiveAlgorithm {

    Map<Character, CharacterByteCode> getAlphabet(String content);

    String getExtension();
}
