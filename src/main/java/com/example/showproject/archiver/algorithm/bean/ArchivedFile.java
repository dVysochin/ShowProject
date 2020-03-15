package com.example.showproject.archiver.algorithm.bean;

import java.io.ByteArrayOutputStream;

public class ArchivedFile {

    private String name;
    private ByteArrayOutputStream outputStream;

    public ArchivedFile(String name, ByteArrayOutputStream outputStream) {
        this.name = name;
        this.outputStream = outputStream;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ByteArrayOutputStream getOutputStream() {
        return outputStream;
    }

    public void setOutputStream(ByteArrayOutputStream outputStream) {
        this.outputStream = outputStream;
    }
}
