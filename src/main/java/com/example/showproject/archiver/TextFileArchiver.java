package com.example.showproject.archiver;

import com.example.showproject.archiver.algorithm.ArchiveAlgorithm;
import com.example.showproject.archiver.algorithm.bean.ArchivedFile;
import com.example.showproject.archiver.algorithm.bean.CharacterByteCode;
import com.example.showproject.archiver.algorithm.bean.OriginalFile;
import com.example.showproject.archiver.component.ArchiverContentManager;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Map;

import static java.nio.charset.StandardCharsets.UTF_8;

@Component
public class TextFileArchiver implements FileArchiver {

    private static final String ORIGINAL_TXT_EXTENSION_REGEXP = "\\.txt";

    private ArchiveAlgorithm archiveAlgorithm;
    private ArchiverContentManager archiverContentManager;

    public TextFileArchiver(ArchiveAlgorithm archiveAlgorithm,
                            ArchiverContentManager archiverContentManager) {
        this.archiveAlgorithm = archiveAlgorithm;
        this.archiverContentManager = archiverContentManager;
    }

    @Override
    public ArchivedFile archive(OriginalFile originalFile) throws IOException {
        String originalContent = getContent(originalFile);
        Map<Character, CharacterByteCode> alphabet = archiveAlgorithm.getAlphabet(originalContent);

        return new ArchivedFile(
                generateNameForArchivedFile(originalFile),
                archiverContentManager.createArchivedContentStream(originalContent, alphabet)
        );
    }

    private String getContent(OriginalFile originalFile) throws IOException {
        return IOUtils.toString(originalFile.getInputStream(), UTF_8);
    }

    private String generateNameForArchivedFile(OriginalFile originalFile) {
        return originalFile.getName().replaceAll(ORIGINAL_TXT_EXTENSION_REGEXP, archiveAlgorithm.getExtension());
    }
}
