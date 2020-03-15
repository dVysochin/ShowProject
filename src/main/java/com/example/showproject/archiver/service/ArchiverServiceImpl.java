package com.example.showproject.archiver.service;

import com.example.showproject.archiver.FileArchiver;
import com.example.showproject.archiver.algorithm.bean.ArchivedFile;
import com.example.showproject.archiver.algorithm.bean.OriginalFile;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ArchiverServiceImpl implements ArchiverService {

    private FileArchiver textFileArchiver;

    public ArchiverServiceImpl(FileArchiver textFileArchiver) {
        this.textFileArchiver = textFileArchiver;
    }

    @Override
    public ArchivedFile archiveTextFile(OriginalFile originalFile) throws IOException {
        return textFileArchiver.archive(originalFile);
    }
}
