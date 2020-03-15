package com.example.showproject.archiver.algorithm.hofman;

import com.example.showproject.archiver.algorithm.ArchiveAlgorithm;
import com.example.showproject.archiver.algorithm.bean.CharacterByteCode;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class HofmanAlgorithm implements ArchiveAlgorithm {

    private HofmanAlgorithmUtilsImpl hofmanAlgorithmUtils;

    public HofmanAlgorithm(HofmanAlgorithmUtilsImpl hofmanAlgorithmUtils) {
        this.hofmanAlgorithmUtils = hofmanAlgorithmUtils;
    }

    @Override
    public Map<Character, CharacterByteCode> getAlphabet(String content) {
        Map<Character, Integer> charactersFrequency = hofmanAlgorithmUtils.findCharactersFrequency(content);
        SortedNodeList nodes = hofmanAlgorithmUtils.initNodeList(charactersFrequency);
        List<Node> characterNodes = nodes.getNodes();

        hofmanAlgorithmUtils.buildNodeTreeBasedOnFrequency(nodes);
        return hofmanAlgorithmUtils.calculateByteCodeForCharacters(characterNodes);
    }

    @Override
    public String getExtension() {
        return ".haf";
    }
}
