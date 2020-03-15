package com.example.showproject.archiver.controller;

import com.example.showproject.archiver.algorithm.bean.ArchivedFile;
import com.example.showproject.archiver.algorithm.bean.OriginalFile;
import com.example.showproject.archiver.service.ArchiverService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Controller
public class ArchiverController {

    private ArchiverService archiverService;

    public ArchiverController(ArchiverService archiverService) {
        this.archiverService = archiverService;
    }

    @GetMapping("/")
    public String getArchiverPage() {
        return "archiver";
    }

    @PostMapping("/archive")
    public void archiveFile(@RequestParam("file") MultipartFile multipartFile, HttpServletResponse response) throws IOException {
        OriginalFile originalFile = new OriginalFile(multipartFile.getOriginalFilename(), multipartFile.getInputStream());
        ArchivedFile archivedFile = archiverService.archiveTextFile(originalFile);

        response.setContentType("application/x-msdownload");
        response.setHeader("Content-Disposition", "attachment; filename=" + archivedFile.getName());
        IOUtils.copy(new ByteArrayInputStream(archivedFile.getOutputStream().toByteArray()), response.getOutputStream());
        response.flushBuffer();
    }
}
