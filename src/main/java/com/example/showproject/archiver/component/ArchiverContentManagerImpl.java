package com.example.showproject.archiver.component;

import com.example.showproject.archiver.algorithm.bean.CharacterByteCode;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

import static java.nio.charset.StandardCharsets.UTF_8;

@Component
public class ArchiverContentManagerImpl implements ArchiverContentManager {

    private final static String CONTENT_SEPARATOR = "---###$$$Content_separator$$$###---";
    private final static String CHARACTER_MAP_SEPARATOR = "->";
    private final static String BYTE_SPLITTER_REGEXP = "(?<=\\G.{7})";

    @Override
    public ByteArrayOutputStream createArchivedContentStream(String originalContent, Map<Character, CharacterByteCode> alphabet) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        writeHeaderMetaInfo(alphabet, outputStream);
        writeArchivedContent(originalContent, alphabet, outputStream);
        return outputStream;
    }

    private void writeHeaderMetaInfo(Map<Character, CharacterByteCode> alphabet, OutputStream outputStream) throws IOException {
        alphabet.forEach((character, byteCode) -> tryWriteCharacterMapping(character, byteCode, outputStream));
        outputStream.write(CONTENT_SEPARATOR.getBytes(UTF_8));
    }

    private void writeArchivedContent(String originalContent, Map<Character, CharacterByteCode> alphabet, OutputStream outputStream) throws IOException {
        String stringOfArchiveBits = createStringOfArchiveBits(originalContent, alphabet);
        for (String byteString: stringOfArchiveBits.split(BYTE_SPLITTER_REGEXP)) {
            outputStream.write(Byte.parseByte(byteString, 2));
        }
    }

    private String createStringOfArchiveBits(String originalContent, Map<Character, CharacterByteCode> alphabet) {
        StringBuilder stringBuilder = new StringBuilder();
        originalContent.chars().forEach(character -> stringBuilder.append(alphabet.get((char) character).toString()));
        return stringBuilder.toString();
    }

    private void tryWriteCharacterMapping(Character character, CharacterByteCode characterByteCode, OutputStream outputStream) {
        String characterMappingLine = character + CHARACTER_MAP_SEPARATOR + characterByteCode;
        try {
            outputStream.write(characterMappingLine.getBytes(UTF_8));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
