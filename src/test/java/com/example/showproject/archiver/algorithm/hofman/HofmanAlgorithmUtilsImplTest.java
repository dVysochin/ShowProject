package com.example.showproject.archiver.algorithm.hofman;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

import static org.testng.Assert.assertEquals;

public class HofmanAlgorithmUtilsImplTest {

    private HofmanAlgorithmUtilsImpl hofmanAlgorithmUtils;

    @BeforeMethod
    public void init() {
        hofmanAlgorithmUtils = new HofmanAlgorithmUtilsImpl();
    }

    @Test
    public void findCharactersFrequency_Should_ReturnMapOfCharactersFrequency() {
        String originalContent = "aAaAAbc1";
        Map<Character, Integer> expectedMap = Map.of(
                'a', 2,
                'A', 3,
                'b', 1,
                'c', 1,
                '1', 1
                );
        Map<Character, Integer> actualMap = hofmanAlgorithmUtils.findCharactersFrequency(originalContent);
        assertEquals(actualMap, expectedMap);
    }

    @Test
    public void buildNodeTreeBasedOnFrequency_Should_CreateNodeTreeFromNodes() {
        SortedNodeList nodes = new SortedNodeList();
        nodes.add(new Node('a', 1));
        nodes.add(new Node('b', 2));
        nodes.add(new Node('d', 5));

        hofmanAlgorithmUtils.buildNodeTreeBasedOnFrequency(nodes);

        assertEquals(nodes.size(), 1);
        assertValidNodeTree(nodes.get(0));
    }

    private void assertValidNodeTree(Node rootNode) {
        assertEquals(rootNode.getChild1().getWeight(), Integer.valueOf(3));
        assertEquals(rootNode.getChild1().getPositionStatus(), Byte.valueOf("0"));
        assertEquals(rootNode.getChild1().getChild1().getCharacter(), 'a');
        assertEquals(rootNode.getChild1().getChild1().getPositionStatus(), Byte.valueOf("0"));
        assertEquals(rootNode.getChild1().getChild2().getCharacter(), 'b');
        assertEquals(rootNode.getChild1().getChild2().getPositionStatus(), Byte.valueOf("1"));
        assertEquals(rootNode.getChild2().getCharacter(), 'd');
        assertEquals(rootNode.getChild2().getPositionStatus(), Byte.valueOf("1"));
    }
}
