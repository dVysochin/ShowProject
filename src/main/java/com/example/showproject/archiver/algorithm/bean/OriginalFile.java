package com.example.showproject.archiver.algorithm.bean;

import java.io.InputStream;

public class OriginalFile {

    private String name;
    private InputStream inputStream;

    public OriginalFile(String name, InputStream inputStream) {
        this.name = name;
        this.inputStream = inputStream;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }
}
