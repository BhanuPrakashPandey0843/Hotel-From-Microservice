// src\main\java\com\example\rest_api\service\MediaService.java
package com.example.rest_api.service;

import com.example.rest_api.dto.MediaDTO;
import com.example.rest_api.model.Media;
import com.example.rest_api.repository.MediaRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MediaService {
    private final MediaRepository mediaRepository;

    private static final String IMAGE_DIR = "uploads/images/";
    private static final String VIDEO_DIR = "uploads/videos/";

    public Media saveMedia(MediaDTO mediaDTO) throws IOException {
        MultipartFile file = mediaDTO.getFile();

        // Validate file
        validateFile(file);

        // Determine file type and directory
        String fileType = determineFileType(file);
        String directory = fileType.equals("image") ? IMAGE_DIR : VIDEO_DIR;

        // Ensure the directory exists
        Files.createDirectories(Paths.get(directory));

        // Generate unique file name
        String originalFileName = file.getOriginalFilename();
        String fileExtension = FilenameUtils.getExtension(originalFileName);
        String uniqueFileName = UUID.randomUUID() + "." + fileExtension;

        // Save file to disk
        String filePath = directory + uniqueFileName;
        file.transferTo(new File(filePath));

        // Save metadata to MongoDB
        Media media = new Media();
        media.setHotelId(mediaDTO.getHotelId());
        media.setFileType(fileType);
        media.setFileName(originalFileName);
        media.setFilePath(filePath);
        media.setUploadTime(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));

        return mediaRepository.save(media);
    }

    private void validateFile(MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            throw new IllegalArgumentException("File is empty.");
        }

        String contentType = file.getContentType();
        if (contentType == null || (!contentType.startsWith("image/") && !contentType.startsWith("video/"))) {
            throw new IllegalArgumentException("Unsupported file type. Only images and videos are allowed.");
        }

        if (file.getSize() > 50 * 1024 * 1024) { // Example: Limit file size to 50MB
            throw new IllegalArgumentException("File size exceeds the maximum allowed limit of 50MB.");
        }
    }

    private String determineFileType(MultipartFile file) {
        String contentType = file.getContentType();
        return contentType != null && contentType.startsWith("image/") ? "image" : "video";
    }
}
