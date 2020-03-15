package com.example.showproject.archiver.algorithm.hofman;

import com.example.showproject.archiver.algorithm.bean.CharacterByteCode;

import java.util.List;
import java.util.Map;

public interface HofmanAlgorithmUtils {

    Map<Character, Integer> findCharactersFrequency(String originalContent);

    void buildNodeTreeBasedOnFrequency(SortedNodeList nodes);

    Map<Character, CharacterByteCode> calculateByteCodeForCharacters(List<Node> originalCharacterNodes);

    SortedNodeList initNodeList(Map<Character, Integer> charactersFrequency);
}
