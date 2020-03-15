package com.example.showproject.archiver;

import com.example.showproject.archiver.algorithm.bean.ArchivedFile;
import com.example.showproject.archiver.algorithm.bean.OriginalFile;

import java.io.IOException;

public interface FileArchiver {

    ArchivedFile archive(OriginalFile originalFile) throws IOException;
}
