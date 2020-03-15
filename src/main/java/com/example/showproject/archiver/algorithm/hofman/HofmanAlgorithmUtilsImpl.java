package com.example.showproject.archiver.algorithm.hofman;

import com.example.showproject.archiver.algorithm.bean.CharacterByteCode;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Component
public class HofmanAlgorithmUtilsImpl implements HofmanAlgorithmUtils{

    @Override
    public Map<Character, Integer> findCharactersFrequency(String originalContent) {
        Map<Character, Integer> charactersFrequency = new HashMap<>();
        originalContent.chars()
                .forEach(character -> charactersFrequency.compute(
                        (char) character,
                        (c, frequency) -> (frequency == null) ? 1 : frequency + 1)
                );
        return charactersFrequency;
    }

    @Override
    public void buildNodeTreeBasedOnFrequency(SortedNodeList nodes) {
        while (nodes.size() != 1) {
            Node node1 = nodes.get(0);
            Node node2 = nodes.get(1);
            nodes.add(new Node(node1, node2));
            nodes.remove(node1);
            nodes.remove(node2);
        }
    }

    @Override
    public Map<Character, CharacterByteCode> calculateByteCodeForCharacters(List<Node> originalCharacterNodes) {
        Map<Character, CharacterByteCode> characterByteCodeMap = new HashMap<>();
        originalCharacterNodes.forEach(node -> characterByteCodeMap.put(node.getCharacter(), buildByteCode(node)));
        return characterByteCodeMap;
    }

    @Override
    public SortedNodeList initNodeList(Map<Character, Integer> charactersFrequency) {
        SortedNodeList nodes = new SortedNodeList();
        charactersFrequency.forEach((key, value) -> nodes.add(new Node(key, value)));
        return nodes;
    }

    private CharacterByteCode buildByteCode(Node node) {
        CharacterByteCode byteCode = new CharacterByteCode();

        byteCode.add(node.getPositionStatus());
        Node currentNode = node.getParent();
        while (currentNodeNotRoot(currentNode)) {
            byteCode.add(currentNode.getPositionStatus());
            currentNode = currentNode.getParent();
        }
        return byteCode;
    }

    private boolean currentNodeNotRoot(Node currentNode) {
        return Objects.nonNull(currentNode) && currentNode.getPositionStatus() != null;
    }
}
