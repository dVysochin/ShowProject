package com.example.showproject.archiver.service;

import com.example.showproject.archiver.algorithm.bean.ArchivedFile;
import com.example.showproject.archiver.algorithm.bean.OriginalFile;

import java.io.IOException;

public interface ArchiverService {

    ArchivedFile archiveTextFile(OriginalFile originalFile) throws IOException;
}
