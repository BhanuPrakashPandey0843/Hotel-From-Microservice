// src\main\java\com\example\rest_api\model\Location.java
package com.example.rest_api.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "locations")
public class Location {
    @Id
    private String id;
    private String hotelId;
    private GMapLocation gmapLocation;
    private String pinCode;
    private String address;
    private String landmark;

    @Data
    public static class GMapLocation {
        private Double latitude;
        private Double longitude;

        public GMapLocation(Double latitude, Double longitude) {
            this.latitude = latitude;
            this.longitude = longitude;
        }
    }
}

