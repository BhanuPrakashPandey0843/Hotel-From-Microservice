// src\main\java\com\example\rest_api\model\Media.java

package com.example.rest_api.model;



import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "media")
public class Media {
    @Id
    private String id;
    private String hotelId; // Reference to the hotel
    private String fileType; // "image" or "video"
    private String fileName; // Stored file name
    private String filePath; // Path to the file in the system
    private String uploadTime; // Timestamp of upload
}
