package com.example.showproject.archiver.algorithm.hofman;

import com.example.showproject.archiver.algorithm.bean.CharacterByteCode;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

public class HofmanAlgorithmTest {

    @Mock
    private HofmanAlgorithmUtilsImpl hofmanAlgorithmUtils;

    private HofmanAlgorithm hofmanAlgorithm;

    private final String originalContent = "Test content";
    private Map<Character, Integer> charactersFrequency;
    private SortedNodeList nodeList;
    private Map<Character, CharacterByteCode> characterByteCodeMap;

    @BeforeMethod
    public void init() {
        MockitoAnnotations.initMocks(this);
        hofmanAlgorithm = new HofmanAlgorithm(hofmanAlgorithmUtils);
        refreshTestData();
    }

    @Test
    public void getExtension_Should_ReturnHafExtension() {
        assertEquals(hofmanAlgorithm.getExtension(), ".haf");
    }

    @Test
    public void getAlphabet_Should_BuildNodeTreeBasedOnFrequency() {
        when(hofmanAlgorithmUtils.findCharactersFrequency(originalContent)).thenReturn(charactersFrequency);
        when(hofmanAlgorithmUtils.initNodeList(charactersFrequency)).thenReturn(nodeList);

        hofmanAlgorithm.getAlphabet(originalContent);
        verify(hofmanAlgorithmUtils).buildNodeTreeBasedOnFrequency(nodeList);
    }

    @Test
    public void getAlphabet_Should_ReturnByteCodeForCharactersMap() {
        when(hofmanAlgorithmUtils.findCharactersFrequency(originalContent)).thenReturn(charactersFrequency);
        when(hofmanAlgorithmUtils.initNodeList(charactersFrequency)).thenReturn(nodeList);
        when(hofmanAlgorithmUtils.calculateByteCodeForCharacters(nodeList.getNodes())).thenReturn(characterByteCodeMap);

        Map<Character, CharacterByteCode> actualMap = hofmanAlgorithm.getAlphabet(originalContent);
        assertEquals(actualMap, characterByteCodeMap);
    }

    private void refreshTestData() {
        Node node = new Node('a', 1);
        charactersFrequency = Map.of('a', 1);
        nodeList = new SortedNodeList();
        nodeList.add(node);

        CharacterByteCode characterByteCode = new CharacterByteCode();
        characterByteCode.add(Byte.valueOf("1"));
        characterByteCode.add(Byte.valueOf("0"));
        characterByteCodeMap = Map.of('a', characterByteCode);
    }
}
