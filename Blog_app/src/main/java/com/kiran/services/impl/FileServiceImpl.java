package com.kiran.services.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kiran.services.FileService;

@Service
public class FileServiceImpl implements FileService {

    @Override
    public String uploadImage(String path, MultipartFile file) throws IOException {
        // Get the file name
        String fileName = file.getOriginalFilename();

        // Construct the file path
        String filePath = path + File.separator + fileName;

        // Create the directory if it does not exist
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        // Save the file
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            fos.write(file.getBytes());
        }

        return fileName;
    }

    @Override
    public InputStream getResources(String path, String fileName) throws FileNotFoundException {
        // Construct the file path
        String filePath = path + File.separator + fileName;

        // Create an InputStream to read the file
        return new FileInputStream(filePath);
    }
}
