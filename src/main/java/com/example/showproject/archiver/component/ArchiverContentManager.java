package com.example.showproject.archiver.component;

import com.example.showproject.archiver.algorithm.bean.CharacterByteCode;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

public interface ArchiverContentManager {

    ByteArrayOutputStream createArchivedContentStream(String originalContent, Map<Character, CharacterByteCode> alphabet) throws IOException;
}
